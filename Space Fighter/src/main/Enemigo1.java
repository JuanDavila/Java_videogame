package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Enemigo1 extends Enemigo{

	private Window window;
	private long tiempoAnterior;
	private Vector2f speed;

	public Enemigo1(Window window){
		this.window = window;
		Image img = ImageLoader.loadImage("img/naves + meteoritos/NaveEnemiga.png ");
		img = img.getScaledInstance(Game.WIDTH/10, Game.HEIGHT/10, Image.SCALE_SMOOTH);
		setImage(img);
		setVisible(true);
		setSpeed(new Vector2f(-800,0));
	}

	@Override
	public void move() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		if (tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}
		tiempoAnterior = tiempoActual;
		float tiempoEnSec = tiempoTranscurrido/1000.0f;
		Vector2f speed = new Vector2f(getSpeed().x, getSpeed().y).mul(tiempoEnSec);
		getPosition().add(speed);
		
		if(getPosition().x < 0 - getWidth()){		
			setPosition(Game.WIDTH, getPosition().y);
		}

	}

}
