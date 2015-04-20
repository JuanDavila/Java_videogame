package main;

import java.awt.Color;

import es.techtalents.techlib.gui.MainWindow;
import es.techtalents.techlib.gui.window.Window;
import es.techtalents.techlib.image.ImageLoader;

public class Main {
	
	public static void main(String[] args) throws InterruptedException{
		MainWindow w = new MainWindow();
		
		Window ventanita = new Window();
		ventanita.setHeight(MainWindow.HEIGHT);
		ventanita.setWidth(MainWindow.WIDTH);
		ventanita.setBgColor(Color.BLACK);
		ventanita.setVisible(true);
		ventanita.setEnabled(true);
		Thread.sleep(200);
		w.addWindow(ventanita);
		
		Raqueta r = new Raqueta();
		r.setImage(ImageLoader.loadImage("Images/raqueta_roja.png"));
		r.setVisible(true);
		r.setPosition(MainWindow.WIDTH/2- r.getWidth()/2, MainWindow.HEIGHT-100);
		ventanita.addSprite(r);
	}
	
}
