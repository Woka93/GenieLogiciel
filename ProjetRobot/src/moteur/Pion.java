package moteur;

public abstract class Pion {

	int PositionX;
	int PositionY;
	boolean Destructible;
	
	public Pion(int pPositionX, int pPositionY, boolean pDestructible){
		PositionX = pPositionX;
		PositionY = pPositionY;
		Destructible = pDestructible;
	}
}
