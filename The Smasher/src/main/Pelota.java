package main;

import java.awt.Image;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Pelota extends Sprite {
	private Vector2f speed = new Vector2f (1,-1);
	private Raqueta r;
	
	public Pelota(Raqueta r){
		Image img = ImageLoader.loadImage("Images/pelota.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/30, MainWindow.WIDTH/30, Image.SCALE_SMOOTH));
		Point2f pos = r.getPosition();
		setPosition(pos.x + (r.getWidth()/2 - getWidth()/ 2), pos.y-getHeight());
		this.r = r;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
		if (r.checkCollision(this)){
			speed.y = -1;

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
			System.exit(0);

		}
		getPosition().add(speed);


	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}

}
