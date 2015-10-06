package moteur;

import java.util.List;

public class Missile extends PionOriente{

	int PlayerRobot;
	
	public Missile(int pPositionX, int pPositionY, boolean pDestructible, char pOriente, int pPlayerRobot) {
		super(pPositionX, pPositionY, pDestructible, pOriente);
		
		PlayerRobot = pPlayerRobot;
	}

	/**
	 * Savoir si un missile sort du plateau
	 * @param ListeMissile Liste de l'ensemble des missiles sur la grille
	 * @param Curseur Le numéro du missile dans la liste (Position dans la liste)
	 * @param Hauteur
	 * @param Longueur
	 * @return Retourne la nouvelle liste de missile
	 */
	public static List<Missile> VerificationPositionMissile(List<Missile> ListeMissile, int Curseur, int Hauteur, int Longueur){
		
		if(ListeMissile.get(Curseur).PositionX < 0 || ListeMissile.get(Curseur).PositionX >= Longueur){
			ListeMissile.get(Curseur).Destructible = true;
		}else if(ListeMissile.get(Curseur).PositionY < 0 || ListeMissile.get(Curseur).PositionY >= Hauteur){
			ListeMissile.get(Curseur).Destructible = true;
		}
		return ListeMissile;
	}
	
	
	public List<Missile> LancerMissile(List<Missile> ListeMissile, List<Robot> ListeRobot, int Player){
		
		switch (ListeRobot.get(Player).Oriente){
		//haut
		case 'h' :
					Missile Missileh = new Missile(ListeRobot.get(Player).PositionX, ListeRobot.get(Player).PositionY++, false, ListeRobot.get(Player).Oriente, Player);
					ListeMissile.add(Missileh);
					break;
		//droite			
		case 'd' :	
					Missile Missiled = new Missile(ListeRobot.get(Player).PositionX--, ListeRobot.get(Player).PositionY, false, ListeRobot.get(Player).Oriente, Player);
					ListeMissile.add(Missiled);
					break;
		//bas			
		case 'b' :
					Missile Missileb = new Missile(ListeRobot.get(Player).PositionX, ListeRobot.get(Player).PositionY--, false, ListeRobot.get(Player).Oriente, Player);
					ListeMissile.add(Missileb);
					break;
		//gauche			
		case 'g' :	
					Missile Missileg = new Missile(ListeRobot.get(Player).PositionX++, ListeRobot.get(Player).PositionY, false, ListeRobot.get(Player).Oriente, Player);
					ListeMissile.add(Missileg);
					break;
			}
		
		return ListeMissile;
	}
	
	public static List<Missile> VerificationMissileToucheRobot(List<Missile> ListeMissile, List<Robot> ListeRobot, int Curseur){
		
		for(int i = 0 ; i < ListeRobot.size(); i++){
			if (ListeMissile.get(Curseur).PositionX == ListeRobot.get(i).PositionX && ListeMissile.get(Curseur).PositionY == ListeRobot.get(i).PositionY){
				ListeRobot.get(i).Destructible = true;
				ListeMissile.get(Curseur).Destructible = true;
			}
		}
		return ListeMissile;
	}
	
}
