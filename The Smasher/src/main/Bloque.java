package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Bloque extends Sprite{
	
	Vector2f speed = new Vector2f(0,1);
	private int vida = 3;
	
	Image img3 = ImageLoader.loadImage("Images/bloque_dorado.png");
	Image img2 = ImageLoader.loadImage("Images/bloque_morada.png");
	Image img = ImageLoader.loadImage("Images/bloque_azul.png");
	
	public Bloque(){

		setImage(img3);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if (isDead()){
			getPosition().add(speed); 
		}
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof Pelota){
			vida--;

			if (vida == 3){
				setImage(img3);
			}

			if (vida == 2){
				setImage(img2);
			}
			if (vida <= 1){
				setImage(img);
			}
		}

	}

	public boolean isDead() {
		return vida <= 0;
	}


}
