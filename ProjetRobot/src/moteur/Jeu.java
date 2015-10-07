package moteur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Robot Robot = new Robot(0, 0, false, 'h', 0, 0, false);
		//Missile Missile = new Missile(0, 0, false, 'h', 0);
		
		StartGame();
		
		/*ListeRobot = Robot.DeplacementAR(ListeRobot, Player, Grille.Hauteur, Grille.Longueur); 
		//ListeMissile = Missile.LancerMissile(ListeMissile, ListeRobot, Player);		
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		System.out.println(ListeRobot.get(0).PositionX);*/
	}
	
	
	private static void StartGame() {

		List<Missile> ListeMissile = new ArrayList<Missile>();
		List<Robot> ListeRobot = new ArrayList<Robot>();
		Grille Grille = new Grille(5, 5);
		Missile Missile = new Missile(0, 0, false, 'h', 0);
		
		int Player = 0;
			
		ListeRobot = Initialisation();
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		ListeMissile = Missile.LancerMissile(ListeMissile, ListeRobot.get(Player), Player, Grille);
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		ListeRobot.get(1).UpShield();
		Grille.GestionTour(ListeMissile, ListeRobot, 1, Grille);

		Grille.GestionTour(ListeMissile, ListeRobot, Player, Grille);
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		Grille.GestionTour(ListeMissile, ListeRobot, Player, Grille);
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
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
		
		//sc.close();
		return ListeRobot;
	}
	
	public static Robot AjoutdesRobots(int PosX, int PosY, char Oriente){
		
		Robot Robot = new Robot(PosX, PosY, false, Oriente, 1, 5, false);
		
		return Robot;
	}
	
	public static List<Robot> Initialisation(){
		int nbPlayer;
		List<Robot> ListeRobot = new ArrayList<Robot>();		
		
		System.out.println("Nombre Player:");
		Scanner sc = new Scanner(System.in);
		nbPlayer = sc.nextInt();
	
		for(int i = 0; i < nbPlayer; i++){
			ListeRobot = InfoRobot(ListeRobot);
		}
		
		//sc.close();
		return ListeRobot;
	}
}
