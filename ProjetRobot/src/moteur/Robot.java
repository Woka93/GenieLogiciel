package moteur;

import java.util.List;

public class Robot extends PionOriente{

	int Health;
	int Stamina;
	boolean Shield;
	
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

	public void UpShield(){
		
		this.Shield = true;
		PerteStamina();
		
	}

	public void DeUpShield(){
		this.Shield = false;
	}
	
	public void PerteStamina(){
		this.Stamina--;
	}
	
	public void RegenStamina(){
		this.Stamina++;
	}
	
	public void VerificationPositionRobot(int Hauteur, int Longueur){
		
		if(this.PositionX < 0){
			this.PositionX = 0;
		}else if(this.PositionX >= Longueur){
			this.PositionX = Longueur - 1;
		}
		
		if(this.PositionY < 0){
			this.PositionY = 0;
		}else if(this.PositionY >= Hauteur){
			this.PositionY = Hauteur - 1;
		}
	}
	
	public void DeplacementAR(){
		
		switch (this.Oriente){
		//haut
		case 'h' :	
					this.PositionY++;
					break;
		//droite			
		case 'd' :	
					this.PositionX--;
					break;
		//bas			
		case 'b' :
					this.PositionY--;
					break;
		//gauche			
		case 'g' :	
					this.PositionX++;
					break;
			}
	}
	
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
	
	public void RemoveRobot(List<Robot> ListeRobot, int Curseur){
		
		if(ListeRobot.get(Curseur).Destructible == true){
			ListeRobot.remove(Curseur);
		}	
	}
}
