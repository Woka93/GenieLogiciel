package ia;

import java.util.List;

import moteur.*;

public class Calcul {

	public Calcul (List<Missile> ListeMissile, Robot player1, Robot player2) {
		
	}
	
	public boolean Aligner(Robot player1, Robot player2) {
		
		if (player1.getPositionY() == player2.getPositionY() || player1.getPositionX() == player2.getPositionX()) {
			return true;
		}
		return false;
	}
	
	public boolean estOrienteVersPion (PionOriente pion1, PionOriente pion2) {
		
		boolean oriente = false;
		
		if ((pion1.getOriente() == 'h') && (pion1.getPositionX() > pion2.getPositionX())) {
			oriente = true;
		}
		if ((pion1.getOriente() == 'b') && (pion1.getPositionX() < pion2.getPositionX())) {
			oriente = true;
		}
		if ((pion1.getOriente() == 'g') && (pion1.getPositionY() > pion2.getPositionY())) {
			oriente = true;
		}
		if ((pion1.getOriente() == 'd') && (pion1.getPositionY() < pion2.getPositionY())) {
			oriente = true;
		}
		return oriente;
	}

	public int Danger (int player, Robot player1, List<Missile> ListeMissile) {
		
		//int dist = 0;
		
		//dist = Math.abs(player1.getPositionX()-player2.getPositionX()) + Math.abs(player1.getPositionY()-player2.getPositionY());
		
		for (int i = 0; i < ListeMissile.size(); i++) {
			if (player1.getPositionX() == ListeMissile.get(i).getPositionX()) {
				if (Math.abs(player1.getPositionY() - ListeMissile.get(i).getPositionY()) <= 2) {
					if (player != ListeMissile.get(i).getPlayerRobot()) {
						return i;
					}
				}
			}

			if (player1.getPositionY() == ListeMissile.get(i).getPositionY()) {
				if (Math.abs(player1.getPositionX() - ListeMissile.get(i).getPositionX()) <= 2) {
					if (player != ListeMissile.get(i).getPlayerRobot()) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public char OpposeOriente (char oriente) {
		
		final char TabOrientation[] = {'h','d','b','g'};
		
		for (int i = 0; i < TabOrientation.length; i++) {
			if (TabOrientation[i] == oriente) {
				return TabOrientation[(i+2)%TabOrientation.length];
			}
		}
		return oriente;
	}
	
	public boolean ProcheLignesouColonnes (Robot player1, Robot player2) {
		
		if (Math.abs(player1.getPositionY()-player2.getPositionY()) > Math.abs(player1.getPositionY()-player2.getPositionY())) {
			return true; 		// proche des lignes
		} else if (Math.abs(player1.getPositionY()-player2.getPositionY()) == Math.abs(player1.getPositionY()-player2.getPositionY())) {
			if (player1.getOriente() == 'h' || player1.getOriente() == 'b') {
				return true;	// on garde la direction actuelle
			}
		}
		return false;			// proche des colonnes
	}
	
	public void OrienteVersLignes (Robot player1, Robot player2) {
		
		switch(player1.getOriente()) {
		case 'g' :
		case 'd' : 	player1.ChangerOrientationRobot(player1, 1);
					break;
		case 'h' :	if (player1.getPositionX() > player2.getPositionX()) {
						player1.DeplacementAV();
					} else {
						player1.DeplacementAR();
					}
					break;
		case 'b' : 	if (player1.getPositionX() > player2.getPositionX()) {
						player1.DeplacementAR();
					} else {
						player1.DeplacementAV();
					}
					break;
		}
	}
	
	public void OrienteVersColonnes (Robot player1, Robot player2) {
		
		switch(player1.getOriente()) {
		case 'h' :
		case 'b' : 	player1.ChangerOrientationRobot(player1, 1);
					break;
		case 'g' :	if (player1.getPositionY() > player2.getPositionY()) {
						player1.DeplacementAV();
					} else {
						player1.DeplacementAR();
					}
					break;
		case 'd' : 	if (player1.getPositionY() > player2.getPositionY()) {
						player1.DeplacementAR();
					} else {
						player1.DeplacementAV();
					}
					break;
		}
	}
	
	public int DirectiondeEnnemi (Robot player1, Robot player2) {
		
		if (player1.getPositionX() > player2.getPositionX()) {
			return 0; //haut
		}
		if (player1.getPositionX() < player2.getPositionX()) {
			return 1; //bas
		}
		if (player1.getPositionY() > player2.getPositionY()) {
			return 2; //gauche
		}
		if (player1.getPositionY() < player2.getPositionY()) {
			return 3; //droite
		}
		return -1;
	}

	public void OrienteVersPion(Robot player1, Robot player2) {
		
		switch(DirectiondeEnnemi(player1, player2)) {
		case 0 : 	if (player1.getOriente() == 'g') {player1.ChangerOrientationRobot(player1, 1);}
					if (player1.getOriente() == 'd') {player1.ChangerOrientationRobot(player1, -1);}
					break;
		
		case 1 : 	if (player1.getOriente() == 'g') {player1.ChangerOrientationRobot(player1, -1);}
					if (player1.getOriente() == 'd') {player1.ChangerOrientationRobot(player1, 1);}
					break;
					
		case 2 : 	if (player1.getOriente() == 'h') {player1.ChangerOrientationRobot(player1, -1);}
					if (player1.getOriente() == 'b') {player1.ChangerOrientationRobot(player1, 1);}
					break;
					
		case 3 : 	if (player1.getOriente() == 'h') {player1.ChangerOrientationRobot(player1, 1);}
					if (player1.getOriente() == 'b') {player1.ChangerOrientationRobot(player1, -1);}
					break;
					
		default : System.out.println("coucou");
		}
	}
}