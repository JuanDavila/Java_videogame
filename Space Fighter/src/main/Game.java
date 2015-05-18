package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

	private Window mainMenu = new MenuPrincipal(this);
	private Window tienda = new Tienda(this);
	private Window nivel;

	public Game(){
		mostrarMenu();
	}
	
	public void mostrarMenu(){
		addWindow(mainMenu);
		mainMenu.setVisible(true);
		removeWindow(tienda);
	}
	
	public void mostrarNivel(int dificultad){
		nivel = new VentanaDeJuego(this, dificultad);
		addWindow(nivel);
		nivel.setVisible(true);
		removeWindow(tienda);
		removeWindow(mainMenu);
	}

	public void MostrarTienda() {
		removeWindow(mainMenu);
		addWindow(tienda );
		tienda.setVisible(true);
	}
}
