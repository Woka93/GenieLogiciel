package moteur;

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
	public void DeplacementAV(){
		
		switch (this.Oriente){
		//haut
		case 'h' :	
					this.PositionY--;
					break;
		
		//droite			
		case 'd' :	
					this.PositionX++;;
					break;
		
		//bas			
		case 'b' :	
					this.PositionY++;;
					break;
		
		//gauche			
		case 'g' :
					this.PositionX--;;
					break;
		}
		
	}
}
