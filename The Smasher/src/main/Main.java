package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

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
		List<Bloque> listaBloque = new ArrayList<Bloque>();

		for(int i = 0; i < 9; i++){
			Bloque b = new Bloque();
			listaBloque.add(b);
			b.setPosition(i*214, 0 );
			b.setVisible(true);
			ventanita.addSprite(b);
		}
		
		for(int i = 0; i < 9; i++){
			Bloque b = new Bloque();
			listaBloque.add(b);
			b.setPosition(i*214, 80 );
			b.setVisible(true);
			ventanita.addSprite(b);
		}

		for(int i = 0; i < 9; i++){
			Bloque b = new Bloque();
			listaBloque.add(b);
			b.setPosition(i*214, 160 );
			b.setVisible(true);
			ventanita.addSprite(b);
		}
		
		ventanita.addSprite(r);
		Pelota p = new Pelota(r,listaBloque);
		ventanita.addSprite(p);

		p.setVisible(true);


	}

}
