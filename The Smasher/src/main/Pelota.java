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
	
	private Vector2f speed = new Vector2f (1,-1);
	private Raqueta r;
	private List<Bloque> listaBloques;
	private MainWindow mainWinwindow;
	private Window ventanita;
	
	
	public Pelota(Raqueta r, List<Bloque> listaBloques, MainWindow w, Window ventanita){
		Image img = ImageLoader.loadImage("Images/pelota.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		Point2f pos = r.getPosition();
		setPosition(pos.x + (r.getWidth()/2 - getWidth()/ 2), pos.y-getHeight());
		this.r = r;
		this.listaBloques = listaBloques;
		this.mainWinwindow = w;
		this.ventanita = ventanita; 
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		if (r.checkCollision(this)){
			speed.y = -1;
			
		}
		for(Bloque b : listaBloques){
			if (b.checkCollision(this) && !b.isDead()){
				speed.y = +1;
				b.onColision(this);
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
			//speed.y = speed.y *-1;
			gameOver();

		}
		getPosition().add(speed);


	}

	private void gameOver() {
		mainWinwindow.removeWindow(ventanita);
		mainWinwindow.addWindow(new GameOver());
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}

}
