package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class VentanaDeJuego extends Window{

	private long tiempoAnterior;
	private List<Enemigo> enemigos = new ArrayList<>();


	private Game game;
	private Nave naveAliada;
	private int intervaloEnemigos = 1000;
	private int limiteDeEnemigos = 0;
	private int enemigosCreados = 0;

	public VentanaDeJuego(Game game, int dificultad) {
		this.game = game;
		Image img = null;
		if (dificultad == 0){
			img = ImageLoader.loadImage("img/backgraunds/background_facil.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			limiteDeEnemigos = 25;
		}
		if (dificultad == 1){
			img = ImageLoader.loadImage("img/backgraunds/background_medio.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			limiteDeEnemigos = 50;
		}
		if (dificultad == 2){
			img = ImageLoader.loadImage("img/backgraunds/background_dificil.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			limiteDeEnemigos = 100;
		}
		if (dificultad == 3){
			img = ImageLoader.loadImage("img/backgraunds/background_imposible.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
			limiteDeEnemigos = 2147483647;
		}


		naveAliada = new Nave(this);
		addSprite(naveAliada);

		setBackgroundImage(img);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		
		intervaloEnemigos = 1000 - dificultad*250;
		
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

		comprobarCollisiones();

		super.act();
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - tiempoAnterior;

		if (tiempoAnterior == 0){
			tiempoAnterior = tiempoActual;
			return;
		}

		if(tiempoTranscurrido > intervaloEnemigos && enemigosCreados < limiteDeEnemigos){
			Enemigo e = new Enemigo1(this);
			addSprite(e);
			enemigosCreados ++ ;

			float y = (float) Math.random(); 
			e.setPosition(Game.WIDTH, y * (Game.HEIGHT - e.getHeight()));
			enemigos.add(e);
			tiempoAnterior = tiempoActual;


		}

	}

	private void comprobarCollisiones() {
		if(naveAliada != null)
			for(Enemigo e : enemigos){
				if (e.checkCollision(naveAliada)){
					Point2f pos = new Point2f(naveAliada.getPosition());
					Sprite explosion = new Explosion(this, pos.add(naveAliada.getWidth()/2, naveAliada.getHeight()/2));
					addSprite(explosion);
					removeSprite(naveAliada);
					naveAliada = null;
					return;	

				}
			}
	}

	public List<Enemigo> getEnemigos(){
		return enemigos;
	}

	public void removeEnemy(Enemigo enemigo){
		enemigos.remove(enemigo);
		removeSprite(enemigo);
	}

}
