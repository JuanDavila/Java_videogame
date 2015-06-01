package main;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.sprite.Sprite;

public abstract class Enemigo extends Sprite{

	private Vector2f speed = new Vector2f(0,0); 
	private int puntosDeVida = 1;
	
	
	@Override
	public void act() {
		move();
		
	}
	
	public abstract void move();

	public Vector2f getSpeed() {
		return speed;
	}

	public void setSpeed(Vector2f speed) {
		this.speed = speed;
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public void setPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}
	
	public boolean isDead(){
		if(getPuntosDeVida() <= 0){
			return true;
		}else{
			return false;
		}
	}
}
