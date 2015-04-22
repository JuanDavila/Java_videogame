package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite {

	public Pelota(Raqueta r){
		Image img = ImageLoader.loadImage("Images/pelota.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		Point2f pos = r.getPosition();
		setPosition(pos.x + (r.getWidth()/2 - getWidth()/ 2), pos.y-getHeight());
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
