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
			
			GrilledeJeu[ListeRobot.get(i).PositionY][ListeRobot.get(i).PositionX] = ListeRobot.get(i);
			
		}
		
		for(int i = 0; i < ListeMissile.size(); i++){
			
			GrilledeJeu[ListeMissile.get(i).PositionY][ListeMissile.get(i).PositionX] = ListeMissile.get(i);
			
		}
		
		Affichage(Hauteur, Longueur, GrilledeJeu);
		
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
			System.out.println();
		}
	}
}
