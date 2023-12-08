package com.mathmaurer.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mathmaurer.objets.Bloc;
import com.mathmaurer.objets.TuyauRouge;
import com.mathmaurer.personnages.Mario;

public class Scene extends JPanel{ //contenir toute la partie graphic
	private ImageIcon icoFond; 
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx; //depplacer l'ecran horizontallement
	
	private int xPos; //reperer les elements du jeu en x
	
	private int ySol; //hauteur courante de sol
	private int hauteurPlafond; //hauteur du plafond
	
	public Mario mario;
	public TuyauRouge tuyauRouge1;
	public Bloc bloc1;
	public Scene() {
		super(); //appeler le constructeur de la classe maire
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx=0;
		this.xPos = -1;
		
		this.ySol=293;
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1=this.icoFond.getImage();
		this.imgFond2=this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
		this.imgChateau1 = this.icoChateau1.getImage();
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300,245);
		tuyauRouge1 = new TuyauRouge(600, 230);
		bloc1 = new Bloc(400,180);
		//relier classe clavier a notre classe scene
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		
	}
	
	////*****GETTERS******///
	public int getDx() { return dx; }
	
	public int getxPos() { return xPos; }

	public int getySol() { return ySol; }

	public int getHauteurPlafond() { return hauteurPlafond; }

	////******SETTERS*****///
	public void setDx(int dx) { this.dx = dx; }

	public void setxPos(int xPos) { this.xPos = xPos; }
	
	public void setxFond1(int xFond1) { this.xFond1 = xFond1; }

	public void setxFond2(int xFond2) { this.xFond2 = xFond2; }

	
	
	////*****METHODES*****///
	public void deplacementFond() { 
		if(this.xPos>=0) {
			//mise a jour des positions des elements du jeu lord du deplacement de mario
			this.xPos = this.xPos +this.dx;
			this.xFond1 = this.xFond1-this.dx;
			this.xFond2 = this.xFond2-this.dx;
					
		}
		
		//Permanence du fond d'ecran
		if(this.xFond1==-800) { this.xFond1=800; }
		else if(this.xFond2== -800) { this.xFond2 = 800; }
		else if(this.xFond1== 800) { this.xFond1 = -800; }
		else if(this.xFond2== 800) { this.xFond2 = -800; }
	}
	
	//methode pour dessigner dans java
	public void paintComponent(Graphics g) { //dessin de tout les image visible a l'ecran
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;//permet d'avoir une meilleur rendu graphic
		//detection contact
		if(this.mario.contactAvant(tuyauRouge1)==true) {
			this.mario.setMarche(false);
			this.dx=0;
		}
		
		this.deplacementFond();
		this.tuyauRouge1.deplacement();
		
		//dessigne les image
		g2.drawImage(this.imgFond1,this.xFond1,0,null); //x,y
		g2.drawImage(this.imgFond2,this.xFond2,0,null);
		
		g2.drawImage(imgChateau1,10 - this.xPos,95,null);
		g2.drawImage(imgDepart,220 - this.xPos,234,null);
		g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX(),this.tuyauRouge1.getY(),null);
		g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX() - this.xPos,this.bloc1.getY(),null);
		
		if(this.mario.isSaut()) { g2.drawImage(this.mario.saute(),this.mario.getX(),this.mario.getY(),null); }
		else { g2.drawImage(this.mario.marche("mario",25), this.mario.getX(),this.mario.getY(),null); }
	}
}
