package moteur;

public abstract class Pion {

	private int PositionX;
	private int PositionY;
	private boolean Destructible;
	
//=======================================================
	
	public int getPositionX() {
		return PositionX;
	}

	public void setPositionX(int positionX) {
		PositionX = positionX;
	}

	public int getPositionY() {
		return PositionY;
	}

	public void setPositionY(int positionY) {
		PositionY = positionY;
	}

	public boolean isDestructible() {
		return Destructible;
	}

	public void setDestructible(boolean destructible) {
		Destructible = destructible;
	}

//====================================================================
	
	public Pion(int pPositionX, int pPositionY, boolean pDestructible){
		PositionX = pPositionX;
		PositionY = pPositionY;
		Destructible = pDestructible;
	}
}