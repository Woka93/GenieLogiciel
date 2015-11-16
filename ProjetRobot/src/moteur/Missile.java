package moteur;

import java.util.List;

public class Missile extends PionOriente{

	int PlayerRobot;
	
	public Missile(int pPositionX, int pPositionY, boolean pDestructible, char pOriente, int pPlayerRobot) {
		super(pPositionX, pPositionY, pDestructible, pOriente);
		
		PlayerRobot = pPlayerRobot;
	}
	
	public int getPlayerRobot(){
		return PlayerRobot;
	}

	/**
	 * Savoir si un missile sort du plateau
	 * @param ListeMissile Liste de l'ensemble des missiles sur la grille
	 * @param Curseur Le num�ro du missile dans la liste (Position dans la liste)
	 * @param Hauteur
	 * @param Longueur
	 * @return Retourne la nouvelle liste de missile
	 */
	public void VerificationPositionMissile(int Curseur, int Hauteur, int Longueur){
		
			if(this.getPositionX() < 0 || this.getPositionX() >= Longueur){
				this.setDestructible(true);
			}else if(this.getPositionY() < 0 || this.getPositionY() >= Hauteur){
				this.setDestructible(true);
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
		
		switch (Robot.getOriente()){
		//haut
		case 'h' :
					Missile = new Missile(Robot.getPositionX(), Robot.getPositionY(), false, Robot.getOriente(), Player);
					ListeMissile.add(Missile);
					break;
		//droite			
		case 'd' :	
					Missile = new Missile(Robot.getPositionX() , Robot.getPositionY(), false, Robot.getOriente(), Player);
					ListeMissile.add(Missile);
					break;
		//bas			
		case 'b' :
					Missile = new Missile(Robot.getPositionX(), Robot.getPositionY(), false, Robot.getOriente(), Player);
					ListeMissile.add(Missile);
					break;
		//gauche			
		case 'g' :	
					Missile = new Missile(Robot.getPositionX() , Robot.getPositionY(), false, Robot.getOriente(), Player);
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
				if (ListeMissile.get(Curseur).getPositionX() == ListeRobot.get(i).getPositionX() && ListeMissile.get(Curseur).getPositionY() == ListeRobot.get(i).getPositionY()){
					if(!ListeRobot.get(i).isShield()){
						ListeRobot.get(i).setDestructible(true);
						ListeMissile.get(Curseur).setDestructible(true);
					}else{
						ListeMissile.get(Curseur).setDestructible(true);
					}
				} 
				RemoveMissile(ListeMissile, Curseur);
			}
		}
		return ListeMissile;
	}
	
	public void RemoveMissile(List<Missile> ListeMissile, int Curseur){
		
		if(ListeMissile.get(Curseur).isDestructible()){
			ListeMissile.remove(Curseur);
		}	
	}
}