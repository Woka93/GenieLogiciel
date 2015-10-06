package moteur;

import java.util.ArrayList;
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
	
	/**
	 * Ajout du bouclier pour protéger le robot pendant 1 tour
	 * @param ListeRobot Liste de tout les Robot sur la grille
	 * @param Player Pour savoir l'ordre des joueurs
	 * @return
	 */
	public List<Robot> UpShield(List<Robot> ListeRobot, int Player){
		
		ListeRobot.get(Player).Shield = true;
		ListeRobot.get(Player).Stamina--;
		
		return ListeRobot; 
	}
	
	/**
	 * Si le robot choisit de ne rien faire pendant 1 tour, il régénère 1 point de stamina
	 * @param ListeRobot 
	 * @param Player 
	 * @return
	 */
	public List<Robot> RegenStamina(List<Robot> ListeRobot, int Player){
		
		ListeRobot.get(Player).Stamina++;
		
		return ListeRobot;	
	}
	
	public static List<Robot> VerificationPositionRobot(List<Robot> ListeRobot, int Player, int Hauteur, int Longueur){
		
		if(ListeRobot.get(Player).PositionX < 0){
			ListeRobot.get(Player).PositionX = 0;
			ListeRobot.get(Player).Stamina--;
		}else if(ListeRobot.get(Player).PositionX >= Longueur){
			ListeRobot.get(Player).PositionX = Longueur - 1;
			ListeRobot.get(Player).Stamina--;
		}
		
		if(ListeRobot.get(Player).PositionY < 0){
			ListeRobot.get(Player).PositionY = 0;
			ListeRobot.get(Player).Stamina--;
		}else if(ListeRobot.get(Player).PositionY >= Hauteur){
			ListeRobot.get(Player).PositionY = Hauteur - 1;
			ListeRobot.get(Player).Stamina--;
		}
		
		return ListeRobot;
	}
	
	public List<Robot> DeplacementAR(List<Robot> ListeRobot, int Player, int Hauteur, int Longueur){
		
		switch (ListeRobot.get(Player).Oriente){
		//haut
		case 'h' :
					ListeRobot.get(Player).PositionY++;
					break;
		//droite			
		case 'd' :	
					ListeRobot.get(Player).PositionX--;
					break;
		//bas			
		case 'b' :
					ListeRobot.get(Player).PositionY--;
					break;
		//gauche			
		case 'g' :	
					ListeRobot.get(Player).PositionX++;
					break;
			}
		
		return ListeRobot;
	}
	
}
