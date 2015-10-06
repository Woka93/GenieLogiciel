package moteur;

import java.util.List;

public abstract class Pion {

	int PositionX;
	int PositionY;
	boolean Destructible;
	
	public Pion(int pPositionX, int pPositionY, boolean pDestructible){
		PositionX = pPositionX;
		PositionY = pPositionY;
		Destructible = pDestructible;
	}
	
	public List<Pion> RemovePion(List<Pion> Liste, int Curseur){
		
		if(Liste.get(Curseur).Destructible == true){
			Liste.remove(Curseur);
		}
		
		return Liste;	
	}
}
