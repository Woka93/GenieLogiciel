package moteur;

import java.util.List;

public class Grille {
	
	public int Longueur;
	public int Hauteur;
	
	public Grille(int pLongueur, int pHauteur){
		
		Longueur = pLongueur;
		Hauteur = pHauteur;
		
	}
	
	/**
	 * Remplir la Grille de jeu a un instant t
	 * @param Longueur
	 * @param Hauteur
	 * @param ListeRobot
	 */
	public void RemplirGrille(int Longueur, int Hauteur, List<Robot> ListeRobot, List<Missile> ListeMissile){
		
		Object[][] GrilledeJeu = new Object[Hauteur][Longueur];
		
		for(int i = 0; i < ListeRobot.size(); i++){
			
			//System.out.println(i);
			
			GrilledeJeu[ListeRobot.get(i).getPositionY()][ListeRobot.get(i).getPositionX()] = 'R';
			
		}
		
		for(int i = 0; i < ListeMissile.size(); i++){
			
			GrilledeJeu[ListeMissile.get(i).getPositionY()][ListeMissile.get(i).getPositionX()] = '-';
			
		}
		
		Affichage(Hauteur, Longueur, GrilledeJeu);
		
	}
	
	public void GestionTour(List<Missile> ListeMissile, List<Robot> ListeRobot, int Player, Grille Grille){
		Missile Missile = new Missile(0, 0, false, 'h', 0);

		ListeMissile = Missile.GestionMissile(ListeMissile, Player, Grille);
		ListeMissile = Missile.VerificationMissileToucheRobot(ListeMissile, ListeRobot);
		ListeRobot = ListeRobot.get(Player).GestionRobot(ListeRobot);
		ListeRobot.get(Player).DeUpShield();
	}
	
	/**
	 * Permet l'affichage de la grille a l'instant t
	 * @param Hauteur
	 * @param Longueur
	 * @param GrilledeJeu Le PLateau avec l'ensemble des pions
	 */
	public void Affichage(int Hauteur, int Longueur, Object[][] GrilledeJeu){
			
		for(int i = 0; i < Hauteur; i++){
			System.out.print("|");
			for(int j = 0; j < Longueur; j++){
				System.out.print(GrilledeJeu[i][j] + "|");
			}
			System.out.println("");
		}
		System.out.println("=============================");
	}
}
