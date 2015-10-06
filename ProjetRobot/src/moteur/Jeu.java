package moteur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot Robot = new Robot(0, 0, false, 'h', 0, 0, false);
		Missile Missile = new Missile(0, 0, false, 'h', 0);
		Grille Grille = new Grille(5, 5);
		
		int Player = 0;
		int nbPlayer;
		List<Robot> ListeRobot = new ArrayList<Robot>();
		List<Missile> ListeMissile = new ArrayList<Missile>();
		
		Scanner sc = new Scanner(System.in);
		nbPlayer = sc.nextInt();
		
		for(int i = 0; i < nbPlayer; i++){
			ListeRobot = InfoRobot(ListeRobot);
		}
		
		ListeRobot = Robot.DeplacementAR(ListeRobot, Player, Grille.Hauteur, Grille.Longueur); 
		ListeMissile = Missile.LancerMissile(ListeMissile, ListeRobot, Player);		
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		System.out.println(ListeRobot.get(0).PositionX);
	}
	
	public static List<Robot> InfoRobot(List<Robot> ListeRobot){
		int PosX;
		int PosY;
		char Oriente;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1) Position X, 2) Position Y, 3) Orientation");
		PosX = sc.nextInt();
		PosY = sc.nextInt();
		sc.nextLine();
		Oriente = sc.nextLine().charAt(0);
		
		ListeRobot = AjoutdesRobots(PosX, PosY, Oriente).AjouterListeRobot(AjoutdesRobots(PosX, PosY, Oriente), ListeRobot);
		
		return ListeRobot;
	}
	
	public static Robot AjoutdesRobots(int PosX, int PosY, char Oriente){
		
		Robot Robot = new Robot(PosX, PosY, true, Oriente, 1, 5, false);
		
		return Robot;
	}
}
