package main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;

public class Main {

	public static Pelota pelota;

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

		
		List<Bloque> listaBloque = new ArrayList<Bloque>();

		for (int j = 0; j < 4; j++){
			for(int i = 0; i < 9; i++){
				Bloque b = new Bloque(1);
				listaBloque.add(b);
				b.setPosition(i*214, j*80);
				b.setVisible(true);
				ventanita.addSprite(b);
			}
		}
		Raqueta r = new Raqueta(listaBloque, ventanita);
		
		r.setVisible(true);
		ventanita.addSprite(r);
		Pelota p = new Pelota(r,listaBloque, w, ventanita);
		pelota = p;
		ventanita.addSprite(p);
		
		p.setVisible(true);

		
		
		
		
	}

}
