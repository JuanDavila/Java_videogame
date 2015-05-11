package main;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;

public class Game extends MainWindow{

	private Window mainMenu = new MenuPrincipal(this);

	public Game(){
		mostrarMenu();
	}
	
	public void mostrarMenu(){
		addWindow(mainMenu);
		mainMenu.setVisible(true);
	}
}
