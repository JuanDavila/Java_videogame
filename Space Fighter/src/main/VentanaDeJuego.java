package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class VentanaDeJuego extends Window{

	private long tiempoAnterior;



	private Game game;
	private Nave naveAliada;
	private int intervaloEnemigos = 1500;
	
	public VentanaDeJuego(Game game, int dificultad) {
		this.game = game;
		Image img = null;
		if (dificultad == 0){
			img = ImageLoader.loadImage("img/backgraunds/background_facil.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		}
		if (dificultad == 1){
			img = ImageLoader.loadImage("img/backgraunds/background_medio.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		}
		if (dificultad == 2){
			img = ImageLoader.loadImage("img/backgraunds/background_dificil.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		}
		if (dificultad == 3){
			img = ImageLoader.loadImage("img/backgraunds/background_imposible.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		}
		
		
		naveAliada = new Nave(this);
		addSprite(naveAliada);
		
		setBackgroundImage(img);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		
	}

	@Override
	public void onKeyPress(int keyCode) {
		if (keyCode == KeyEvent.VK_ESCAPE){
			game.mostrarMenu();
		}
		super.onKeyPress(keyCode);
	}

	@Override
	protected void act() {
		super.act();
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
			if (tiempoAnterior == 0){
				tiempoAnterior = tiempoActual;
				return;
			}
			
			if(tiempoTranscurrido > intervaloEnemigos){
				Enemigo e = new Enemigo1(this);
				addSprite(e);
				
				float y = (float) Math.random(); 
				e.setPosition(Game.WIDTH, y * (Game.HEIGHT - e.getHeight()));
				
				tiempoAnterior = tiempoActual;
			}
			
	}


}
