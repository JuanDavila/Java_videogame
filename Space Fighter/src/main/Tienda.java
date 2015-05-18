package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Tienda extends Window{

	private Game game;

	public Tienda(Game game){
		Image img = ImageLoader.loadImage("img/backgraunds/background_shop.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(img);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		this.game = game;
	}

	@Override
	public void onKeyPress(int keyCode) {
		if (keyCode == KeyEvent.VK_ESCAPE){
			game.mostrarMenu();
		}
			
	}
	
	

}
