package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class MenuPrincipal extends Window {

	private Game game;

	public MenuPrincipal(Game game) {
		this.game = game;
		Image fondo = ImageLoader.loadImage("img/backgroundMainMenu.png").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(fondo);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
	}
	
	
	@Override
	public void onKeyPress(int keyCode) {
		// TODO Auto-generated method stub
		super.onKeyPress(keyCode);
		if (keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}

	
	
}
