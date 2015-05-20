package main;

import es.techtalents.ttgdl.sound.Sound;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
		
		
		Sound s = new Sound("sound/Ready_Aim_Fire.wav", 1);
		s.start();
				
	}

}
