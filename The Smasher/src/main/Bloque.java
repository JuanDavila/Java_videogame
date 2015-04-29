package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;
 
public class Bloque extends Sprite{
	Vector2f speed = new Vector2f(0,0);
	private int vida = 1;
	
	public Bloque(){
		Image img = ImageLoader.loadImage("Images/bloque_azul.png");
		setImage(img);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		getPosition().add(speed); 
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof Pelota){
			speed.y = 1;
			vida--;
		}
	}

	public boolean isDead() {
		if (vida <= 0){
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
