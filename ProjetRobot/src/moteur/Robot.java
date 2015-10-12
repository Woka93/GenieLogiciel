package moteur;

import java.util.List;

public class Robot extends PionOriente{

	private int Health;
	private int Stamina;
	private boolean Shield;
	
//=======================================================
	
	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getStamina() {
		return Stamina;
	}

	public void setStamina(int stamina) {
		Stamina = stamina;
	}

	public boolean isShield() {
		return Shield;
	}

	public void setShield(boolean shield) {
		Shield = shield;
	}

//============================================================
	
	public Robot(int pPositionX, int pPositionY, boolean pDestructible,char pOriente,int pHealth, int pStamina, boolean pShield) {
		super(pPositionX, pPositionY, pDestructible, pOriente);
		// TODO Auto-generated constructor stub
		Health = pHealth;
		Stamina = pStamina;
		Shield = pShield;
	}
	
	/**
	 * Permet de généraliser la création des robots et ainsi en avoir 2 ou plus sur la grille
	 * @param Robot
	 * @param ListeRobot 
	 * @return La liste des robots compléte 
	 */
	public List<Robot> AjouterListeRobot(Robot Robot, List<Robot> ListeRobot){
		
		ListeRobot.add(Robot);
		
		return ListeRobot;
	}
	
	/**
	 * Méthode qui active le bouclier du robot
	 */
	public void UpShield(){
		
		this.Shield = true;
		PerteStamina();
		
	}
	
	/**
	 * Méthode pour désactiver le bouclier du robot
	 */
	public void DeUpShield(){
		this.Shield = false;
	}
	
	/**
	 * Méthode pour retirer un point de Stamina
	 */
	public void PerteStamina(){
		this.Stamina--;
	}
	
	/**
	 * Méthode pour ajouter un point de Stamina
	 */
	public void RegenStamina(){
		this.Stamina++;
	}
	
	/**
	 * Méthode qui vérifie si  le robot est bien dans la grille
	 * @param Hauteur
	 * @param Longueur
	 */
	public void VerificationPositionRobot(int Hauteur, int Longueur){
		
		if(this.getPositionX() < 0){
			this.setPositionX(0);
		}else if(this.getPositionX() >= Longueur){
			this.setPositionX(Longueur - 1);
		}
		
		if(this.getPositionY() < 0){
			this.setPositionY(0);
		}else if(this.getPositionY() >= Hauteur){
			this.setPositionY(Hauteur - 1);
		}
	}
	
	public void DeplacementAR(){
		
		switch (this.getOriente()){
		//haut
		case 'h' :	
					this.setPositionY(getPositionY() + 1);
					break;
		//droite			
		case 'd' :	
					this.setPositionX(getPositionX() - 1);
					break;
		//bas			
		case 'b' :
					this.setPositionY(getPositionY() - 1);
					break;
		//gauche			
		case 'g' :	
					this.setPositionX(getPositionX() + 1);
					break;
			}
	}
	
	/**
	 * Mise à jour du robot (Perte de stamina et verification de position). Effectué à la fin de chaque tour
	 * @param Grille
	 */
	public void MAJ(Grille Grille){
		VerificationPositionRobot(Grille.Hauteur, Grille.Longueur);
		PerteStamina();
	}
	
	public List<Robot> GestionRobot(List<Robot> ListeRobot){
		
		for(int i = 0; i < ListeRobot.size(); i++){
			RemoveRobot(ListeRobot, i);
		}
		
		return ListeRobot;
	}
	
	public void ChangerOrientationRobot(Robot Robot, int nouvelleOrientation){
		final char TabOrientation[] = {'h','d','b','g'};
		int valeur = 0;
			
		for(int i = 0 ; i < TabOrientation.length; i++){
			if(Robot.getOriente() == TabOrientation[i]){
				valeur = i;
			}
		}
		if(valeur == 0 && nouvelleOrientation == -1){
			Robot.setOriente(TabOrientation[3]);
		}else{
			Robot.setOriente(TabOrientation[(valeur+nouvelleOrientation)%TabOrientation.length]);
		}
	}
	
	public void RemoveRobot(List<Robot> ListeRobot, int Curseur){
		
		if(ListeRobot.get(Curseur).isDestructible()){
			ListeRobot.remove(Curseur);
		}	
	}
}
