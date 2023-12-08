package com.mathmaurer.jeu;

import javax.swing.JFrame;

public class Main {
	public static Scene scene; //on peut y acceder de tout les calsse
	public static void main(String[] args) {
		JFrame fenetre  = new JFrame("Jeu style Mario");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fermer le programe X
		fenetre.setSize(700,360); //taille fenetre
		fenetre.setLocationRelativeTo(null);//centrer sur l'ecran
		fenetre.setResizable(false); //on peut pas modifier la taille
		fenetre.setAlwaysOnTop(true);//toujour au dessu de tous les fenetre
		
		
		scene = new Scene();//instanciation de l'objet scene
		fenetre.setContentPane(scene);//associer le panel scene au fenetre
		fenetre.setVisible(true);
	}
}
