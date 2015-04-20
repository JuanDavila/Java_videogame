package main;

import java.awt.event.KeyEvent;

import es.techtalents.techlib.geom.Point2f;
import es.techtalents.techlib.gui.MainWindow;
import es.techtalents.techlib.sprite.Sprite;

public class Raqueta extends Sprite{

	@Override
	public boolean onClick(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onKeyPress(int keyCode) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.VK_LEFT && getPosition().x >0){
			Point2f pos = super.getPosition();
			pos.add(-20, 0);
			
		}
		
		if (keyCode == KeyEvent.VK_RIGHT && getPosition().x < MainWindow.WIDTH - getWidth()){
			Point2f pos = super.getPosition();
			pos.add(20, 0);
			
		}
		
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
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
