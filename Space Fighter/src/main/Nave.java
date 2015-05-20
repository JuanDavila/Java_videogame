package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Nave extends Sprite{

	private VentanaDeJuego ventanaDeJuego;
	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private float vx = 750;
	private float vy = 750;
	private long tiempoAnterior;
	private Arma arma;
	private boolean shooting;
	
	public Nave (VentanaDeJuego ventanaDeJuego){
		arma=  new ArmaLaser(this, ventanaDeJuego);
		arma.setTiempoDeRecarga(250);
		this.ventanaDeJuego = ventanaDeJuego;
		Image img = ImageLoader.loadImage("img/naves + meteoritos/nave.png");
		img = img.getScaledInstance(Game.WIDTH/10, Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);

		setPosition(0, Game.HEIGHT/2 - getHeight()/2);

	}

	@Override
	public void onKeyPress(int keyCode) {
		if (keyCode == KeyEvent.VK_LEFT){
			moveLeft = true;

		}

		if (keyCode == KeyEvent.VK_RIGHT){
			moveRight = true;

		}
		if (keyCode == KeyEvent.VK_UP){
			moveUp = true;

		}

		if (keyCode == KeyEvent.VK_DOWN){
			moveDown = true;

		}
		if (keyCode == KeyEvent.VK_SPACE){
			shooting = true;

		}
	}
	
	private void shoot() {
		if(arma.canShoot()){
			arma.shoot();
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
		if (keyCode == KeyEvent.VK_UP){
			moveUp = false;

		}

		if (keyCode == KeyEvent.VK_DOWN){
			moveDown = false;

		}
		if (keyCode == KeyEvent.VK_SPACE){
			shooting = false;

		}
	}

	@Override
	public void act() {
		if(shooting){
			shoot();
		}
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;
		
		float tiempoEnSec = tiempoTranscurrido/1000.0f; 

		
		if (moveLeft == true && getPosition().x >0){
			Point2f pos = super.getPosition();
			pos.add(-vx*tiempoEnSec, 0);
		}

		if (moveRight == true && getPosition().x < MainWindow.WIDTH - getWidth()){
			Point2f pos = super.getPosition();
			pos.add(vx*tiempoEnSec , 0);
		}
		if (moveUp == true && getPosition().y >0){
			Point2f pos = super.getPosition();
			pos.add(0, -vy*tiempoEnSec );
		}

		if (moveDown == true && getPosition().y < MainWindow.HEIGHT - getHeight()){
			Point2f pos = super.getPosition();
			pos.add(0 , vy*tiempoEnSec);
		}
	}

}
