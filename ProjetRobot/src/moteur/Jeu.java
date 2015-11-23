package moteur;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import ia.*;


public class Jeu {
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Robot Robot = new Robot(0, 0, false, 'h', 0, 0, false);
		//Missile Missile = new Missile(0, 0, false, 'h', 0);
		
		StartGame();
		
		/*
		ListeRobot = Robot.DeplacementAR(ListeRobot, Player, Grille.Hauteur, Grille.Longueur); 
		ListeMissile = Missile.LancerMissile(ListeMissile, ListeRobot, Player);		
		Grille.RemplirGrille(Grille.Longueur, Grille.Hauteur, ListeRobot, ListeMissile);
		
		System.out.println(ListeRobot.get(0).PositionX);*/
	}
	
	
	private static void StartGame() throws InterruptedException {
		
		int taille=5;

		List<Missile> ListeMissile = new ArrayList<Missile>();
		List<Robot> ListeRobot = new ArrayList<Robot>();
		Grille Grille = new Grille(5, 5);
		
		int Player = 0;
			
		ListeRobot = Initialisation();
		Grille.RemplirGrille(taille, taille, ListeRobot, ListeMissile);
		
		TestDeplacementRobot tdr1 = new TestDeplacementRobot(Player);
		Player = Player + 1;
		TestDeplacementRobot tdr2 = new TestDeplacementRobot(Player);
		
		int i = 0;
		while (i < 5) {
			System.out.println("Tour J1");
			Player = 0;
			ListeMissile = tdr1.JouerIA(ListeRobot, ListeMissile, Grille);
			Grille.GestionTour(ListeMissile, ListeRobot, Player, Grille);
			Grille.RemplirGrille(taille, taille, ListeRobot, ListeMissile);

			System.out.println("Tour J2");
			Player = 1;
			ListeMissile = tdr2.JouerIA(ListeRobot, ListeMissile, Grille);
			Grille.GestionTour(ListeMissile, ListeRobot, Player, Grille);
			Grille.RemplirGrille(taille, taille, ListeRobot, ListeMissile);
			i++;
			Thread.sleep(2000);
		}
		
		
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