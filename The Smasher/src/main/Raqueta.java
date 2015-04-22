package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Raqueta extends Sprite{

	private boolean moveLeft;
	private boolean moveRight;
	private float vx = 2;

	public Raqueta(){
		Image img = ImageLoader.loadImage("Images/raqueta_roja.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/7, MainWindow.WIDTH/28, Image.SCALE_SMOOTH));
		setPosition(MainWindow.WIDTH/2- getWidth()/2, MainWindow.HEIGHT- getHeight()/3);
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
	}

	@Override
	public void onColision(Sprite arg0) {
		// TODO Auto-generated method stub

	}

}
