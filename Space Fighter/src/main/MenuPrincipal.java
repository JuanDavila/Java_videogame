package main;

import java.awt.Image;
import java.awt.event.KeyEvent;

import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class MenuPrincipal extends Window {

	private Game game;

	public MenuPrincipal(Game game) {
		this.game = game;
		Image fondo = ImageLoader.loadImage("img/backgraunds/mainmenu_background.jpg").getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
		setBackgroundImage(fondo);
		setWidth(Game.WIDTH);
		setHeight(Game.HEIGHT);
		crearBotones();
	}


	private void crearBotones() {

		int EspacioEntreBotones = 20;
		
		//boton facil
		Image imgBtfacil = ImageLoader.loadImage("img/buttons/facilButton.png");
		Image imgBtfacilh = ImageLoader.loadImage("img/buttons/facilButtonMouseover.png");
		Boton facilButton = new Boton(imgBtfacil, imgBtfacilh){

			@Override
			public void clicked() {
				System.exit(0);	
			}

		};
		float y = Game.HEIGHT/2- (facilButton.getHeight()*6+5*EspacioEntreBotones)/2;
		float x = Game.WIDTH/2 - facilButton.getWidth()/2;
		float incrementoY = facilButton.getHeight() + EspacioEntreBotones;
		facilButton.setPosition(x, y);
		y += incrementoY;
		addSprite(facilButton);
		facilButton.setVisible(true);
		facilButton.setEnabled(true);

		//boton normal
		Image imgBtnormal = ImageLoader.loadImage("img/buttons/normalButton.png");
		Image imgBtnormalh = ImageLoader.loadImage("img/buttons/normalButtonMouseover.png");
		Boton normalButton = new Boton(imgBtnormal, imgBtnormalh){

			@Override
			public void clicked() {
				System.exit(0);	
			}

		};

		normalButton.setPosition(x, y);
		y+=incrementoY;
		addSprite(normalButton);
		normalButton.setVisible(true);
		normalButton.setEnabled(true);

		//boton dificil
		
		Image imgBtdificil = ImageLoader.loadImage("img/buttons/dificilButton.png");
		Image imgBtdificilh = ImageLoader.loadImage("img/buttons/dificilButtonMouseover.png");
		Boton dificilButton = new Boton(imgBtdificil, imgBtdificilh){

			@Override
			public void clicked() {
				System.exit(0);	
			}

		};

		dificilButton.setPosition(x, y);
		y+=incrementoY;
		
		addSprite(dificilButton);
		dificilButton.setVisible(true);
		dificilButton.setEnabled(true);
		
		//boton imposible
		
				Image imgBtimposible = ImageLoader.loadImage("img/buttons/imposibleButton.png");
				Image imgBtimposibleh = ImageLoader.loadImage("img/buttons/imposibleButtonMouseover.png");
				Boton imposibleButton = new Boton(imgBtimposible, imgBtimposibleh){

					@Override
					public void clicked() {
						System.exit(0);	
					}

				};

				imposibleButton.setPosition(x, y);
				y+=incrementoY;
				
				addSprite(imposibleButton);
				imposibleButton.setVisible(true);
				imposibleButton.setEnabled(true);
		
				//boton tienda
				
				Image imgBttienda = ImageLoader.loadImage("img/buttons/tiendaButton.png");
				Image imgBttiendah = ImageLoader.loadImage("img/buttons/tiendaButtonMouseover.png");
				Boton tiendaButton = new Boton(imgBttienda, imgBttiendah){

					@Override
					public void clicked() {
						System.exit(0);	
					}

				};

				tiendaButton.setPosition(x, y);
				y+=incrementoY;
				
				addSprite(tiendaButton);
				tiendaButton.setVisible(true);
				tiendaButton.setEnabled(true);
				
		//boton exit
		Image imgBtExit = ImageLoader.loadImage("img/buttons/exitButton.png");
		Image imgBtExith = ImageLoader.loadImage("img/buttons/exitButtonMouseover.png");
		Boton exitButton = new Boton(imgBtExit, imgBtExith){

			@Override
			public void clicked() {
				System.exit(0);	
			}

		};
		
		exitButton.setPosition(x, y);
		
		addSprite(exitButton);
		exitButton.setVisible(true);
		exitButton.setEnabled(true);
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
