package procedure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import creatures.*;


public class newGame{
	//Variablen
	static Scanner scanner = new Scanner(System.in);
	static boolean charSelect = false;
	static int classSelect = 0;
	static String start = scanner.nextLine();
	static Player a = new Player();
	
	
	//Konstruktoren
	public newGame(){
		
	}
	
	
	//Methoden
	public static Player charSelect() throws FileNotFoundException, IOException{
	
		while(charSelect == false){
			if(start.toLowerCase().equals("neu")){
				texts.choose();
				start = scanner.nextLine();
				classSelect = Integer.parseInt(start);
				if(classSelect == 1 || classSelect == 2 || classSelect == 3){
					charSelect = true;
				}
			}
			else if(start.toLowerCase().equals("weiter")){
				if(new File ("test.txt").isFile())
				{
					a = read.fromFile();
					charSelect = true;
					classSelect = 4;
				}
				else
				{
					System.out.printf("+-------------------------------------------------------+%n");
					System.out.printf("+Kein Speicher gefunden                                 +%n");
					System.out.printf("+Bitte neuen Spielstand erstellen                         +%n");
					System.out.printf("+-------------------------------------------------------+%n");
					start = "neu";
					
				}
				
			}
			else{
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Ihre Eingabe konnte nicht verarbeitet werden           +%n");
				System.out.printf("+Fuer neues Spiel \"neu\" eintippe                        +%n");
				System.out.printf("+-------------------------------------------------------+%n");
				start = scanner.nextLine();
				continue;
				
			}
		}
		
		switch(classSelect){
		case 1:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Krieger ausgewaehlt                                    +%n");
			System.out.printf("+Namen für Helden eingeben:                             +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			String n = scanner.nextLine();
			a = new Player(n,"Krieger",1,3,4,0);
			//scanner.close();
			break;
		case 2:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Magier ausgewaehlt                                     +%n");
			System.out.printf("+Namen für Helden eingeben:                             +%n");
			System.out.printf("+-------------------------------------------------------+%n");
//			System.out.printf("Magier ausgewaehlt%n");
//			System.out.printf("Namen für Helden eingeben: %n");
			String n1 = scanner.nextLine();
			a = new Player(n1,"Magier",1,5,2,0);
			//scanner.close();
			break;
		case 3:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Bogenschuetze ausgewaehlt                              +%n");
			System.out.printf("+Namen für Helden eingeben:                             +%n");
			System.out.printf("+-------------------------------------------------------+%n");
//			System.out.printf("Bogenschuetze ausgewaehlt%n");
//			System.out.printf("Namen für Helden eingeben: %n");
			String n2 = scanner.nextLine();
			a = new Player(n2,"Bogenschuetze",1,4,3,0);
			//scanner.close();
			break;
		case 4:
			if(a.getPlayerWeapon() != null)
			{
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Spieler namens: %s geladen.                            +%n", a.getName());
				System.out.printf("+Folgende werte wurden Übernommen                       +%n");
				System.out.printf("+Klasse: %s%nLevel: %d Staerke: %d Ausdauer: %d         +%n", a.getWay(),
						a.getLevel(), a.getStrength(), a.getEndurance());
				System.out.printf("+Erfahrungspunkte: %d Waffe: %s                         +%n", a.getExperience(),
						a.getPlayerWeapon().getName());
				System.out.printf("+-------------------------------------------------------+%n");
//				System.out.printf("+-------------------------------------------------------+%n");
//				System.out.printf("+Krieger ausgewaehlt                                    +%n");
//				System.out.printf("+Namen für Helden eingeben:                               +%n");
//				System.out.printf("+-------------------------------------------------------+%n");
//				System.out.printf("Spieler namens: %s geladen.%n", a.getName());
//				System.out.printf("Folgende werte wurden Übernommen%n" +
//				"Klasse: %s%nLevel: %d Staerke: %d Ausdauer: %d Erfahrungspunkte: %d%n"
//				+ "Waffe: %s%n", 
//				a.getWay(),a.getLevel(),a.getStrength(),a.getEndurance(),a.getExperience(), a.getPlayerWeapon().getName());
				break;
			}
			else
			{
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Spieler namens: %s geladen.                            +%n", a.getName());
				System.out.printf("+Folgende werte wurden Übernommen                       +%n");
				System.out.printf("+Klasse: %s%nLevel: %d Staerke: %d Ausdauer: %d         +%n", a.getWay(),
						a.getLevel(), a.getStrength(), a.getEndurance());
				System.out.printf("+Erfahrungspunkte: %d                                   +%n", a.getExperience());
				System.out.printf("+-------------------------------------------------------+%n");
//				System.out.printf("Spieler namens: %s geladen.%n", a.getName());
//				System.out.printf("Folgende werte wurden Übernommen%n" +
//				"Klasse: %s%nLevel: %d Staerke: %d Ausdauer: %d Erfahrungspunkte: %d%n", 
//				a.getWay(),a.getLevel(),a.getStrength(),a.getEndurance(),a.getExperience());
				break;
			}
		default:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Ihre Eingabe konnte nicht verarbeitet werden           +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			break;
		}
		//scanner.close();
		return(a);
		
	}
	 
	
}
