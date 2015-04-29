package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class GameOver extends Window{
	
	public GameOver(){
		Image img = ImageLoader.loadImage("Images/game_over.png").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(img);
		setVisible(true);
		setWidth(MainWindow.WIDTH);
		setHeight(MainWindow.HEIGHT);
		
	}

	@Override
	public void onKeyPress(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		super.onKeyPress(keyCode);
	}

	
	
	
}
