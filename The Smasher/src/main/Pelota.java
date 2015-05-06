package main;

import java.awt.Image;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite {

	private static final boolean DEBUG = true;
	private Vector2f speed = new Vector2f (1,-1);
	private Raqueta r;
	private List<Bloque> listaBloques;
	private MainWindow mainWinwindow;
	private Window ventanita;
	private int nBloques;


	public Pelota(Raqueta r, List<Bloque> listaBloques, MainWindow w, Window ventanita){
		Image img = ImageLoader.loadImage("Images/pelota.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		Point2f pos = r.getPosition();
		setPosition(pos.x + (r.getWidth()/2 - getWidth()/ 2), pos.y-getHeight());
		this.r = r;
		this.listaBloques = listaBloques;
		this.mainWinwindow = w;
		this.ventanita = ventanita;
		nBloques = listaBloques.size();
	}

	@Override
	public void act() {

		if(nBloques <= 0){
			youWin();
		}

		if (r.checkCollision(this)){
			speed.y *= 1.01;
			if(speed.y>0){
				speed.y *= -1;
			}
			float ran = (float) (Math.random()*10-5);
			speed.rotate(ran);
		}

		for(Bloque b : listaBloques){
			if (b.checkCollision(this) && !b.isDead()){
				speed.y *= -1;
				b.onColision(this);
				float ran = (float) (Math.random()*10-5);
				speed.rotate(ran);
				if (b.isDead()){
					nBloques = nBloques - 1;
				}
			}
		}



		if (getPosition().x> MainWindow.WIDTH - getWidth()){
			speed.x = speed.x *-1;

		}

		if (getPosition().y< 0){
			speed.y = speed.y *-1;

		}

		if (getPosition().x< 0){
			speed.x = speed.x *-1;

		}

		if (getPosition().y> MainWindow.HEIGHT - getHeight()){
			if(DEBUG){
				speed.y = speed.y *-1;
			}else{
				gameOver();
			}

		}
		getPosition().add(speed);


	}

	private void gameOver() {
		mainWinwindow.removeWindow(ventanita);
		mainWinwindow.addWindow(new GameOver());
	}

	private void youWin(){
		mainWinwindow.removeWindow(ventanita);
		mainWinwindow.addWindow(new YouWin());
	}



	@Override
	public void onColision(Sprite arg0) {

	}

	public void irLento() {
		speed.x *= 0.5f;
		if(speed.x > 0 && speed.x < 0.4){
			speed.x = 0.4f;
		}
		if(speed.x < 0 && speed.x > -0.4){
			speed.x = -0.4f;
		}


		speed.y *= 0.5f;
		if(speed.y > 0 && speed.y < 0.4){
			speed.y = 0.4f;
		}
		if(speed.y < 0 && speed.y > -0.4){
			speed.y = -0.4f;
		}

	}

	public void irRapido() {
		speed.x *= 1.5f;
		if(speed.x > 2){
			speed.x = 2;
		}
		if(speed.x < -2){
			speed.x = -2;
		}


		speed.y *= 1.5;
		if(speed.y > 2){
			speed.y = 2;
		}
		if(speed.y < -2){
			speed.y = -2;
		}
	}

}
