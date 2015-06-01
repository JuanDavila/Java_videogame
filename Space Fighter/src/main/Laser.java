package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Laser extends Sprite{

	private Vector2f speed = new Vector2f (15,0);
	private long tiempoAnterior;
	private Window ventanaDeJuego;

	public Laser(Nave nave, Window ventanaDeJuego) {
		Image img = ImageLoader.loadImage("img/armas/bala_aliada1.png");
		img = img.getScaledInstance(Game.WIDTH/50, Game.HEIGHT/50, Image.SCALE_SMOOTH);
		setImage(img);
		Point2f pos = nave.getPosition();
		this.ventanaDeJuego = ventanaDeJuego;
		setVisible(true);
		setPosition(pos.x + (nave.getWidth()/2 + getWidth()*2), pos.y + (nave.getHeight()/2 - getHeight()/2));
	}

	@Override
	public void act() {
		checkCollisions();
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		if(tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}
		tiempoAnterior = tiempoActual;

		float tiempoEnSec = tiempoTranscurrido/1000.0f; 
		speed.x = 1500;
		getPosition().add(speed.mul(tiempoEnSec));

		if(this.getPosition().x > Game.WIDTH){
			ventanaDeJuego.removeSprite(this);
		}
	}

	private void checkCollisions() {
		List<Enemigo> enemigos = ((VentanaDeJuego) ventanaDeJuego).getEnemigos();
		for(int i = enemigos.size()-1; i >= 0; i--){
			Enemigo enemigo = enemigos.get(i);
			if(enemigo.checkCollision(this)){
				enemigo.onColision(this);
				ventanaDeJuego.removeSprite(this);
				return;
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {

		super.draw(g);
	}

}
