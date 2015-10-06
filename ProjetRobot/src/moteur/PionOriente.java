package moteur;

import java.util.List;

public class PionOriente extends Pion{

	char Oriente;
	
	public PionOriente(int pPositionX, int pPositionY, boolean pDestructible, char pOriente) {
		super(pPositionX, pPositionY, pDestructible);
		
		Oriente = pOriente;
	}

	
	/**
	 * Permet au robot d'effectuer des déplacements vers l'avant
	 * @param ListeRobot
	 * @param Curseur
	 * @param Hauteur La hauteur da le grille
	 * @param Longueur La longueur de la grille
	 * @return La liste des robots avec les nouvelles positions
	 */
	public List<PionOriente> DeplacementAV(List<PionOriente> Liste, int Curseur){
		
		switch (Liste.get(Curseur).Oriente){
		//haut
		case 'h' :	
					Liste.get(Curseur).PositionY--;
					break;
		
		//droite			
		case 'd' :	
					Liste.get(Curseur).PositionX++;;
					break;
		
		//bas			
		case 'b' :	
					Liste.get(Curseur).PositionY++;;
					break;
		
		//gauche			
		case 'g' :
					Liste.get(Curseur).PositionX--;;
					break;
		}
		
		return Liste;
	}
	
	public static List<PionOriente> Destruction(List<PionOriente> ListePion, int Curseur){
		
		ListePion.get(Curseur).Destructible = true;
		
		return ListePion;
		
	}
}
