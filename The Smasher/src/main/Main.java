package main;

import java.awt.Color;
import java.awt.Image;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		MainWindow w = new MainWindow();

		Window ventanita = new Window();
		ventanita.setHeight(MainWindow.HEIGHT);
		ventanita.setWidth(MainWindow.WIDTH);
		Image img=ImageLoader.loadImage("Images/Mural-de-ladrillo-blanco.jpg").getScaledInstance(MainWindow.WIDTH, MainWindow.HEIGHT, Image.SCALE_SMOOTH);
		ventanita.setBackgroundImage(img);
		ventanita.setVisible(true);
		ventanita.setEnabled(true);
		Thread.sleep(200);
		w.addWindow(ventanita);

		Raqueta r = new Raqueta();
		r.setVisible(true);

		Bloque b = new Bloque();
		b.setVisible(true);

		ventanita.addSprite(r);
		Pelota p = new Pelota(r,b);
		ventanita.addSprite(p);
		ventanita.addSprite(b);
		p.setVisible(true);


	}

}
