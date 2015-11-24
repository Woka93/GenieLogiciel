package ia;

import java.util.List;
import java.util.Random;

import moteur.Grille;
import moteur.Missile;
import moteur.Robot;

public class StrategieRandom implements StrategieAbstraite {
	
	@Override
	public String nom() {
		return "Stratégie Aléatoire";
	}

	@Override
	public List<Missile> jouer (List<Missile> ListeMissile, List<Robot> ListeRobot, int player, Grille grille) {
		
		Robot player1 = ListeRobot.get(player);
		int nbActions = 7;
		Random rand = new Random();
		int choix = rand.nextInt();
		
		switch (choix%(nbActions-1)) {
		
		case 0 : if (player1.getOriente() == 'h' && player1.getPositionX() == 0 || player1.getOriente() == 'b' && player1.getPositionX() == grille.Hauteur || 
				 player1.getOriente() == 'g' && player1.getPositionY() == 0 || player1.getOriente() == 'd' && player1.getPositionY() == grille.Longueur) {
					 player1.DeplacementAR();
				 } else {
					 player1.DeplacementAV();
				 }
				 break;

		case 1 : player1.ChangerOrientationRobot(player1, 0);
		 		 break;
		
		case 2 : if (player1.getOriente() == 'h' && player1.getPositionX() == grille.Hauteur || player1.getOriente() == 'b' && player1.getPositionX() == 0 || 
				 player1.getOriente() == 'g' && player1.getPositionY() == grille.Longueur || player1.getOriente() == 'd' && player1.getPositionY() == 0) {
					 player1.DeplacementAV();
				 } else {
					 player1.DeplacementAR();
				 }
				 break;
		
		case 3 : player1.ChangerOrientationRobot(player1, 1);
				 break;
		
		case 4 : ListeMissile = Missile.LancerMissile(ListeMissile, player1, player, grille);
				 break;
		
		case 5 : player1.RegenStamina();
				 break;
		
		case 6 : player1.UpShield();
				 break;
		}
		
		return ListeMissile;
	}
}
