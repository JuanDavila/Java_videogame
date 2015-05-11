package main;

import java.awt.Image;

import es.techtalents.ttgdl.sprite.Sprite;

public abstract class Boton extends Sprite {
	
	private Image img;
	private Image imgHover;

	public Boton(Image img, Image imgHover){
		this.img = img;
		this.imgHover = imgHover;
		setImage(img);
	}

	@Override
	public void act() {
		
	}

	@Override
	public boolean onClick(float x, float y) {
		clicked();
		return super.onClick(x, y);
	}

	public abstract void clicked();

	@Override
	public void onMouseEntered() {
		// TODO Auto-generated method stub
		setImage(imgHover);
		super.onMouseEntered();
	}

	@Override
	public void onMouseExited() {
		// TODO Auto-generated method stub
		setImage(img);
		super.onMouseExited();
	}
	
	

}
