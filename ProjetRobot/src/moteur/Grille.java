package moteur;


import java.util.List;

import plateau.*;

public class Grille {
	
	public int Longueur;
	public int Hauteur;
	
	//Instancier une JFrame
	public static Fenetre fenetreJeu=new Fenetre();
	
	public static void lancementVue(){
		//Afficher la JFrame
		fenetreJeu.setVisible(true);
	}
	
	public Grille(int pLongueur, int pHauteur){
		
		Longueur = pLongueur;
		Hauteur = pHauteur;
		this.lancementVue();
		
	}
	
	/**
	 * Remplir la Grille de jeu a un instant t
	 * @param Longueur
	 * @param Hauteur
	 * @param ListeRobot
	 */
	public void RemplirGrille(int Longueur, int Hauteur, List<Robot> ListeRobot, List<Missile> ListeMissile){
		
		
		fenetreJeu.rafraichissement(Hauteur, ListeRobot, ListeMissile);
		
	}
	
	public void GestionTour(List<Missile> ListeMissile, List<Robot> ListeRobot, int Player, Grille Grille){
		Missile Missile = new Missile(0, 0, false, 'h', 0);


		ListeMissile = Missile.GestionMissile(ListeMissile, Player, Grille);
		ListeMissile = Missile.VerificationMissileToucheRobot(ListeMissile, ListeRobot);
		ListeRobot = ListeRobot.get(Player).GestionRobot(ListeRobot);
		ListeRobot.get(Player).DeUpShield();
		
	}
}