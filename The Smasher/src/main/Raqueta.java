package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{

	private boolean moveLeft;
	private boolean moveRight;
	private float vx = 2;
	private int tamaño = 7;
	private List<Bloque> listaBloques;

	public Raqueta(List<Bloque> listaBloques){
		Image img = ImageLoader.loadImage("Images/raqueta_roja.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/tamaño, MainWindow.WIDTH/28, Image.SCALE_SMOOTH));
		setPosition(MainWindow.WIDTH/2- getWidth()/2, MainWindow.HEIGHT- getHeight()/3);
		this.listaBloques = listaBloques;
	}

	@Override
	public boolean onClick(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onKeyPress(int keyCode) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.VK_LEFT){
			moveLeft = true;

		}

		if (keyCode == KeyEvent.VK_RIGHT){
			moveRight = true;

		}

		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}



	@Override
	public void onKeyReleased(int keyCode) {
		if (keyCode == KeyEvent.VK_LEFT){
			moveLeft = false;

		}

		if (keyCode == KeyEvent.VK_RIGHT){
			moveRight = false;

		}
	}

	@Override
	public void act() {
		if (moveLeft == true && getPosition().x >0){
			Point2f pos = super.getPosition();
			pos.add(-vx, 0);
		}

		if (moveRight == true && getPosition().x < MainWindow.WIDTH - getWidth()){
			Point2f pos = super.getPosition();
			pos.add(vx , 0);
		}
		
		//comprobar collision con todos los ladrillos
		for(int i=0;i<listaBloques.size();i++){
			Bloque b = listaBloques.get(i);
			if (b.checkCollision(this) && b.isDead()){
				elegirPowerup();
				
				listaBloques.remove(i);
			}
		}
	}
	

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}
	
	private void elegirPowerup(){
		double chooser = Math.random();
		if(chooser < 0.1){
			raquetaMasGrande();
		}
		
		if(chooser > 0.1 && chooser < 0.2){
			raquetaMasPequeña();
		}
		if(chooser > 0.2 && chooser < 0.3){
			pelotaMasLenta();
		}
		if(chooser > 0.2 && chooser < 0.3){
			pelotaMasRapida();
		}
		if(chooser > 0.3 && chooser < 0.4){
			pelotaMasLenta();
		}
			
	}
	
	private void raquetaMasGrande(){
		Image img = ImageLoader.loadImage("Images/raqueta_roja.png");
		tamaño = 4;
		setImage(img.getScaledInstance(MainWindow.WIDTH/tamaño, MainWindow.WIDTH/28, Image.SCALE_SMOOTH));
	}
	
	private void raquetaMasPequeña(){
		Image img = ImageLoader.loadImage("Images/raqueta_roja.png");
		tamaño = 9;
		setImage(img.getScaledInstance(MainWindow.WIDTH/tamaño, MainWindow.WIDTH/28, Image.SCALE_SMOOTH));
	}
	
	private void pelotaMasLenta(){
		Main.pelota.irLento();
	}
	
	private void pelotaMasRapida(){
		Main.pelota.irRapido();
	}
}
