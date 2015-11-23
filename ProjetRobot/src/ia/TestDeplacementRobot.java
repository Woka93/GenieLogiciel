package ia;

import java.util.List;

import moteur.*;

public class TestDeplacementRobot {
	
	private int player;
	private int action_memo = 0;
	
	private List<Robot> ListeRobot = null;
	private List<Missile> ListeMissile = null;
	
	private Robot player1;
	private Robot player2;
	
	Grille grille;
	
	Calcul calcul;
	
	
	public TestDeplacementRobot (int player) {
		
		this.player = player;
		
		/*this.ListeRobot= ListeRobot;
		this.ListeMissile = ListeMissile;
		
		this.player1 = this.ListeRobot.get(player);
		if (player == 0) {
			this.player2 = this.ListeRobot.get(1);
		} else {
			this.player2 = this.ListeRobot.get(0);
		}
		
		calcul = new Calcul(ListeMissile, this.player1, this.player2);
		
		this.grille = grille;
		
		ArbreDecision();*/
	}
	
	public List<Missile> JouerIA (List<Robot> ListeRobot, List<Missile> ListeMissile, Grille grille) {

		this.ListeRobot= ListeRobot;
		this.ListeMissile = ListeMissile;
		
		this.player1 = this.ListeRobot.get(player);
		if (player == 0) {
			this.player2 = this.ListeRobot.get(1);
		} else {
			this.player2 = this.ListeRobot.get(0);
		}
		
		calcul = new Calcul(ListeMissile, this.player1, this.player2);
		
		this.grille = grille;
		
		return ArbreDecision();
	}
	
	public List<Missile> ArbreDecision () {
		
		int m = 0;
		
		if(this.player1.getStamina() == 0) {
			// Regen Stamina
			player1.RegenStamina();
		} else if ((m = calcul.Danger(player, player1, ListeMissile)) != -1) {
			GestionDanger(m);
		} else if (action_memo > 0) {
			GestionActionMemo();
		} else if (!calcul.Aligner(player1, player2)){
			GestionDeplacement(player, this.ListeRobot.get(player), this.player2);
		} else if (!calcul.estOrienteVersPion(player1, player2)){
			calcul.OrienteVersPion(player1, player2);
		} else {
			ListeMissile = lancerMissile(ListeMissile, player1, player, grille);
			action_memo = 1;
		}
		return ListeMissile;
	}
	
	private void GestionActionMemo() {
		
		switch(action_memo) {
		case 1 : 	player1.DeplacementAV();
					action_memo = 0;
					break;
		}
	}

	private List<Missile> lancerMissile (List<Missile> ListeMissile, Robot player1, int player, Grille grille) {
		
		Missile missile = new Missile (0,0,false,'h',0);
		ListeMissile = missile.LancerMissile(ListeMissile, player1, player, grille);
		
		return ListeMissile;
	}

	private void GestionDanger(int Missile) {
		//System.out.println("coucou");
		
		if (player1.getOriente() == calcul.OpposeOriente(ListeMissile.get(Missile).getOriente())) {
			player1.ChangerOrientationRobot(player1, 1);
		}
		else if (player1.getOriente() == ListeMissile.get(Missile).getOriente()) {
			player1.ChangerOrientationRobot(player1, 1);
		}
		else {
			player1.DeplacementAV();
		}
		action_memo = 0;
	}
	
	private void GestionDeplacement(int player, Robot player1, Robot player2) {
			
		if (calcul.ProcheLignesouColonnes(player1, player2)) {
			calcul.OrienteVersLignes(player1, player2);
		} else {
			calcul.OrienteVersColonnes(player1, player2);
		}
	}
}
