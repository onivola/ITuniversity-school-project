package com.mathmaurer.jeu;

public class Chrono implements Runnable{

	private final int PAUSE = 3; //temps d'attente entre 2 tour de boucle
	@Override
	public void run() {//l'oeuil humain 24 image/seconde
		// TODO Auto-generated method stub
		while(true) { //250image/seconde
			Main.scene.repaint();
			try {
				Thread.sleep(PAUSE);//arret de 3 millisecond 
			} catch (InterruptedException e) { } //oeuil humain 24 image par seconde
		}
	}

}
