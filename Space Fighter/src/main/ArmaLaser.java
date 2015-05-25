package main;

import es.techtalents.ttgdl.gui.window.Window;
//import es.techtalents.ttgdl.sound.Sound;

public class ArmaLaser extends Arma{

	private Window ventanaDeJuego;
	private Nave nave;
	//private static final Sound sound = new Sound("sound/laser1.wav", 30);
	
	public ArmaLaser(Nave nave, VentanaDeJuego ventanaDeJuego) {
		this.ventanaDeJuego = ventanaDeJuego;
		this.nave = nave;
	}

	@Override
	public void shoot() {
		//sound.start();
		Laser l = new Laser(nave, ventanaDeJuego); //,listaEnemigos);
		ventanaDeJuego.addSprite(l);
	}

}
