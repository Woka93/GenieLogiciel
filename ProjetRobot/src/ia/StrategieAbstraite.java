package ia;

import java.util.List;

import moteur.Grille;
import moteur.Missile;
import moteur.Robot;

public interface StrategieAbstraite {
	
	public abstract String nom();
	public abstract List<Missile> jouer(List<Missile> ListeMissile, List<Robot> ListeRobot, int player, Grille grille);	
}
