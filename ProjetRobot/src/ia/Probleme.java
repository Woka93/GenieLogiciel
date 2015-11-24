package ia;

import java.util.List;

import moteur.Grille;
import moteur.Missile;
import moteur.Robot;

public class Probleme {
	
	protected int Player;
	protected StrategieAbstraite strategie;
	
	public Probleme (int Player, StrategieAbstraite strategie) {
		this.Player = Player;
		this.strategie = strategie;
	}

	protected StrategieAbstraite lireStrategie() {
		return strategie;
	}

	public void ecrireStrategie (StrategieAbstraite strategie) {
		this.strategie = strategie;
	}
	
	public int lirePlayer() {
		return Player;
	}
	
	public List<Missile> Jouer (List<Missile> ListeMissile, List<Robot> ListeRobot, Grille grille) {
		return strategie.jouer(ListeMissile, ListeRobot, Player, grille);
	}
}
