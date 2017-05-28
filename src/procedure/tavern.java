package procedure;

import java.util.*;

//import areas.DungeonArray;
import creatures.*;


public class tavern 
{
	//Variablen
	static String s;
	static Scanner scanner = new Scanner(System.in);
	static boolean selectionSelect = false;
	static int etage = 1;
	//Konstruktoren
	
	//Methoden
	public static void inSide(Player x)
	{
		
		while(!selectionSelect)
		{
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Du bist in der Taverne was moechtest du tun?           +%n");
			System.out.printf("+1. Auflevelen       2. Shoppen                         +%n");
			System.out.printf("+3. Gluecksspiel     4. Dungeon                         +%n");
			System.out.printf("+5. Speichern        6. Exit                            +%n");
			System.out.printf("+7. Ausruestung                                         +%n");
			System.out.printf("+-------------------------------------------------------+%n");
//			System.out.printf("%nDu bist in der Taverne was moechtest du tun?%n");
//			System.out.printf("1. Auflevelen       2. Shoppen%n"
//					+ "3. Gluecksspiel     4. Dungeon%n"
//					+ "5. Speichern        6. Exit%n"
//					+ "7. Ausruestung%n");
			
			s = scanner.nextLine();
			switch (s.toLowerCase())
			{
			case "auflevelen":
				LevelUp.lvlUp(x);
				break;
			case "shoppen":
				System.out.printf("Du hast Shoppen gewaehlt%n");
				//TODO Gold gegen Items eintauschen
				Shop.shopping(x);
				break;
			case "gluecksspiel":
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Du hast Gluecksspiel gewaehlt                          +%n");
				System.out.printf("+Welches Spiel moechtest du Spielen?                    +%n");
				System.out.printf("+1.Slot          2.Roulette                             +%n");
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("Du hast Gluecksspiel gewaehlt%n");
				s = scanner.nextLine();
				switch(s.toLowerCase())
				{
				case "slot":
					Gambling.slot(x);
					break;
				case "roulette":
					Gambling.roulette(x);
					break;
				default:
					System.out.printf("Ihre Eingabe konnte nicht verarbeitet werden%n");
					break;
						
				}
				break;
			case "dungeon":
				//TODO nach verlassen rückkehr ins Dungeon ermöglichen
				System.out.printf("Du hast Dungeon gewaehlt%n");
//				DungeonArray dungeonTest = new DungeonArray();
//				Window fenster = new Window(x, dungeonTest.map(1));
				x.setPlayerEtage(Dungeon.inDungeon(x));
				
				break;
			case "speichern":
				System.out.printf("Spiel gespeichert%n");
				save.toFile(x);
				break;
			case "exit":
				System.out.printf("System wird beendet%n");
				selectionSelect = true;
				break;
			case "ausruestung":
				//TODO Ausruestung zwischen Inventory und Equipment verschieben
				//TODO Ausruestung verbessern durch Pro level 2 x das Item
				equip.inventoryCheck(x);
				break;
			default:
				System.out.printf("Ihre Eingabe konnte nicht verarbeitet werden%n");
				break;
			}
			
		}
		System.out.printf("%nTest abgeschlossen");
		scanner.close();
		
	}
	
	

}