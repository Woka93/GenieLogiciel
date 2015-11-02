package plateau;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import moteur.Missile;
import moteur.Robot;

import javax.swing.JComboBox;
import javax.swing.JLabel;




public class Fenetre extends JFrame {
	
	//D�claration des JPanel
	private JPanel grilleJeu=new JPanel();
	private JPanel conteneur=new JPanel();
	
	//D�claration des boutons
	private JButton boutonStart=new JButton("Lancer");
	private JButton boutonPause=new JButton("Pause");
	
	//D�claration des zones de texte
	private JTextField texte=new JTextField("Zone de texte");
	
	//D�claration des ComboBox
	private JComboBox<String> combo=new JComboBox<String>();
	
	//D�claration des Labels
	private JLabel labelRobot1=new JLabel("Robot 1");
	
	//Taille du plateau de jeu
	private int taille=5;
	
	//D�claration du GridLayout
	GridLayout gridLayout=new GridLayout(taille, taille, 0, 0);
	
	
	
	//Constructeur de la fen�tre
	public Fenetre(){
		
		//Mettre un titre
		setTitle("Robot Destrcution Party");
		//Taille de la fen�tre
		setSize(1000, 800);
		//Emp�cher l'utilisateur de modifier la taille de la fen�tre
		setResizable(false);
		//Provoquer la fermeture de la fen�tre lors d'un clic sur la croix rouge
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Centrer la fen�tre � l'�cran
		setLocationRelativeTo(null);
		//D�claration des images 
		//Image du carr� pour la grille
		Icon carre = new ImageIcon("carre.png");
		

		

		//Ajout du panel de la grille
		conteneur.add(grilleJeu);
		
		//Ajout du bouton de lancement sur le conteneur
		conteneur.add(boutonStart);
		//Ajout du bouton de pause sur le conteneur
		conteneur.add(boutonPause);

		//Ajout d'une zone de texte
		conteneur.add(texte);
		
		//Ajout des choix de strat�gie du robot 1 dans la combobox
		combo.addItem("Strat�gie offensive");
		combo.addItem("Strat�gie d�fensive");
		combo.addItem("Strat�gie yolo");
		//Ajout de la combobox
		conteneur.add(combo);
		//ajouter le label du Robot 1
		conteneur.add(labelRobot1);
		
		//Affecter le GridLayout au Jlabel grilleJeu
		grilleJeu.setLayout(gridLayout);
		
		//Tracer la grille vide
		int i=0;
		int j=0;
		for (i=0; i<taille; i++){
			for (j=0; j<taille; j++){
				grilleJeu.add(new JLabel(carre));
			}
		}
		

		
		
		
		

		
		
		setContentPane(conteneur);
		
		
	}
	
	
	
	public void rafraichissement(int taille, List<Robot> ListeRobot, List<Missile> ListeMissile){
		
		System.out.println("pop");
		String[][] liste=new String[taille][taille];
		int i;
		int j;
		for(i=0; i<taille; i++){
			for(j=0; j<taille; j++){
				liste[i][j]="carre.png";
			}
		}

		//Position des robots
		int x;
		int y;
		char orientation;
		x=ListeRobot.get(0).getPositionX();
		y=ListeRobot.get(0).getPositionY();
		orientation=ListeRobot.get(0).getOriente();
		liste[x][y]="robot1"+orientation+".png";
		System.out.println(ListeRobot.get(0).getPositionX()+ListeRobot.get(0).getPositionY()+ListeRobot.get(0).getOriente());
		
		x=ListeRobot.get(1).getPositionX();
		y=ListeRobot.get(1).getPositionY();
		orientation=ListeRobot.get(1).getOriente();
		liste[x][y]="robot2"+orientation+".png";
		
		//Position des missiles
		if (ListeMissile.size()!=0){
			
		for(int k=0;k<ListeMissile.size(); k++){
				x=ListeMissile.get(k).getPositionX();
				y=ListeMissile.get(k).getPositionY();
				orientation=ListeMissile.get(k).getOriente();
				if(ListeMissile.get(k).getPlayerRobot()==0){
					liste[x][y]="Missile1"+orientation+".png";
				}
				else{
					liste[x][y]="Missile2"+orientation+".png";
				}
		}
		}
		
		this.rafraichir(liste);
		
		
	}
	
	public void rafraichir(String[][] liste){
		grilleJeu.removeAll();
		int i=0;
		int j=0;
		for (i=0; i<taille; i++){
			for (j=0; j<taille; j++){
				grilleJeu.add(new JLabel(new ImageIcon(liste[i][j])));
			}
		}
		setContentPane(conteneur);
		
	}
	
	
}

