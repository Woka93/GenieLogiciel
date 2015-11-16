package moteur;

public class PionOriente extends Pion{

	private char Oriente;
	
	public char getOriente() {
		return Oriente;
	}

//===============================================

	public void setOriente(char oriente) {
		Oriente = oriente;
	}

//===============================================
	
	public PionOriente(int pPositionX, int pPositionY, boolean pDestructible, char pOriente) {
		super(pPositionX, pPositionY, pDestructible);
		
		Oriente = pOriente;
	}

	
	/**
	 * Permet au robot d'effectuer des d�placements vers l'avant
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
					this.setPositionX(getPositionX() - 1);
					break;
		
		//droite			
		case 'd' :	
					this.setPositionY(getPositionY() + 1);
					break;
		
		//bas			
		case 'b' :	
					this.setPositionX(getPositionX() + 1);
					break;
		
		//gauche			
		case 'g' :
					this.setPositionY(getPositionY() - 1);
					break;
		}
		
	}
}