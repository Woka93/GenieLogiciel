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
	public void VerificationPositionMissile(int Curseur, int Hauteur, int Longueur){
		
			if(this.PositionX < 0 || this.PositionX >= Longueur){
				this.Destructible = true;
			}else if(this.PositionY < 0 || this.PositionY >= Hauteur){
				this.Destructible = true;
			}	
	}
	
	public List<Missile> GestionMissile(List<Missile> ListeMissile, int Player, Grille Grille){
		
		for(int i = 0; i < ListeMissile.size(); i++){
			if(ListeMissile.get(i).PlayerRobot == Player){
				ListeMissile.get(i).DeplacementAV();
				ListeMissile.get(i).VerificationPositionMissile(i, Grille.Hauteur, Grille.Longueur);
			}
			RemoveMissile(ListeMissile, i);
		}
		
		return ListeMissile;
	}
	
	public List<Missile> LancerMissile(List<Missile> ListeMissile,Robot Robot, int Player, Grille Grille){
		
		Missile Missile;
		
		switch (Robot.Oriente){
		//haut
		case 'h' :
					Missile = new Missile(Robot.PositionX, Robot.PositionY+1, false, Robot.Oriente, Player);
					ListeMissile.add(Missile);
					break;
		//droite			
		case 'd' :	
					Missile = new Missile(Robot.PositionX+1, Robot.PositionY, false, Robot.Oriente, Player);
					ListeMissile.add(Missile);
					break;
		//bas			
		case 'b' :
					Missile = new Missile(Robot.PositionX, Robot.PositionY-1, false, Robot.Oriente, Player);
					ListeMissile.add(Missile);
					break;
		//gauche			
		case 'g' :	
					Missile = new Missile(Robot.PositionX-1, Robot.PositionY, false, Robot.Oriente, Player);
					ListeMissile.add(Missile);
					break;
			}
		
		ListeMissile.get(ListeMissile.size()-1).PlayerRobot = Player;
		
		ListeMissile.get(ListeMissile.size()-1).VerificationPositionMissile(ListeMissile.size()-1, Grille.Hauteur, Grille.Longueur);
		Robot.PerteStamina();
		RemoveMissile(ListeMissile, ListeMissile.size()-1);
		
		return ListeMissile;
	}
	
	public List<Missile> VerificationMissileToucheRobot(List<Missile> ListeMissile, List<Robot> ListeRobot){
		
		for( int Curseur = 0; Curseur < ListeMissile.size(); Curseur++){
			for(int i = 0 ; i < ListeRobot.size(); i++){
				if (ListeMissile.get(Curseur).PositionX == ListeRobot.get(i).PositionX && ListeMissile.get(Curseur).PositionY == ListeRobot.get(i).PositionY){
					if(ListeRobot.get(i).Shield == false){
						ListeRobot.get(i).Destructible = true;
						ListeMissile.get(Curseur).Destructible = true;
					}else{
						ListeMissile.get(Curseur).Destructible = true;
					}
				} 
				RemoveMissile(ListeMissile, Curseur);
			}
		}
		return ListeMissile;
	}
	
	public void RemoveMissile(List<Missile> ListeMissile, int Curseur){
		
		if(ListeMissile.get(Curseur).Destructible == true){
			ListeMissile.remove(Curseur);
		}	
	}
}
