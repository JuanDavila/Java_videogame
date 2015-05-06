package main;

import java.awt.Image;


import java.rmi.Remote;
import java.util.List;

import es.techtalents.ttgdl.geom.Point2f;
import es.techtalents.ttgdl.geom.Vector2f;
import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Bala extends Sprite {

	private Vector2f speed = new Vector2f (0,-3);
	private Window ventanita;
	private List<Bloque> listaBloques;


	public Bala(Raqueta r, Window ventanita,  List<Bloque> listaBloques){
		Point2f pos = r.getPosition();
		Image img = ImageLoader.loadImage("Images/bullet.png");
		setImage(img.getScaledInstance(MainWindow.WIDTH/25, MainWindow.WIDTH/25, Image.SCALE_SMOOTH));
		setPosition(pos.x + (r.getWidth()/2 - getWidth()/ 2), pos.y-getHeight());
		setVisible(true);
		this.ventanita = ventanita;
		this.listaBloques = listaBloques;
	}

	@Override
	public void act() {
		getPosition().add(speed);
		if(this.getPosition().y < - getHeight()){
			ventanita.removeSprite(this);
		}
		//TODO check colition
		for(Bloque b : listaBloques){
			if (b.checkCollision(this) && !b.isDead()){
				b.onColision(this);
			}
		}
		//TODO si choca eliminar de la ventana 
		//TODO eliminar bala quando sube
		//TODO llamar al metodo on colision del ladrillo
	}

}
