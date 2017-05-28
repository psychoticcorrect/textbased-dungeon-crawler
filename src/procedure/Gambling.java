package procedure;
import java.util.Random;
import java.util.Scanner;

import creatures.Player;

public class Gambling {
	//Variablen
	private static int slotOne;
	private static int slotTwo;
	private static int slotThree;
	private static int field;
	private static String color;
	private static Random rnd = new Random();
	private static Scanner s = new Scanner(System.in);
	
	
	
	
	//Konstruktoren
	
	//Methoden
	public static void slot(Player player)
	{
		int playerExperience = player.getExperience();
		System.out.printf("+-------------------------------------------------------+%n");
		System.out.printf("+Du hast %d an Erfahrungspunkten                       +%n", playerExperience);
		System.out.printf("+Wie viel möchtest du setzen?                           +%n");
		System.out.printf("+-------------------------------------------------------+%n");
		String bet = s.nextLine();
		int b = Integer.parseInt(bet);
		slotOne = rnd.nextInt(6) + 1;
		slotTwo = rnd.nextInt(6) + 1;
		slotThree = rnd.nextInt(6) + 1;
		if(slotOne == slotTwo && slotTwo == slotThree)
		{
			int gain = b * 3;
			player.setExperience(playerExperience + gain);
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Jackpot                                                +%n");
			System.out.printf("+Du hast %d Erfahrungspunkte gewonnen                  +%n", gain);
			System.out.printf("+Slot Eins: %d Slot Zwei: %d Slot Drei: %d%n            +%n", slotOne, slotTwo, slotThree);
			System.out.printf("+-------------------------------------------------------+%n");
		}
		else if(slotOne == slotTwo || slotOne == slotThree || slotTwo == slotThree)
		{
			int gain = b * 2;
			player.setExperience(playerExperience + gain);
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Zwei von Drei                                          +%n");
			System.out.printf("+Du hast %d Erfahrungspunkte gewonnen                  +%n", gain);
			System.out.printf("+Slot Eins: %d Slot Zwei: %d Slot Drei: %d%n            +%n", slotOne, slotTwo, slotThree);
			System.out.printf("+-------------------------------------------------------+%n");
		}
		else
		{
			player.setExperience(playerExperience - b);
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Schade                                                 +%n");
			System.out.printf("+Slot Eins: %d Slot Zwei: %d Slot Drei: %d%n            +%n", slotOne, slotTwo, slotThree);
			System.out.printf("+-------------------------------------------------------+%n");
		}
		
	}
	public static void roulette(Player player)
	{
		int playerExperience = player.getExperience();
		String playerColor = "";
		int playerNumber = 0;
		int temp;
		int b = 0;
		String bet = "";
		System.out.printf("+-------------------------------------------------------+%n");
		System.out.printf("+Auf was moechstest du Wetten?                          +%n");
		System.out.printf("+1.Farbe         2.Zahl                                 +%n");
		System.out.printf("+Bitte Zahl eingeben                                    +%n");
		System.out.printf("+-------------------------------------------------------+%n");
		bet = s.nextLine();
		int c = Integer.parseInt(bet);
		switch(c)
		{
		case 1:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Auf welche Farbe moechtest du Wetten                   +%n");
			System.out.printf("+1.Rot         2.Schwarz                                +%n");
			System.out.printf("+Bitte Zahl eingeben                                    +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			bet = s.nextLine();
			temp = Integer.parseInt(bet);
			if(temp == 1)
			{
				playerColor = "Rot";
			}
			else if(temp == 2)
			{
				playerColor = "Schwarz";
			}
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Du hast %d an Erfahrungspunkten                        +%n", playerExperience);
			System.out.printf("+wie viel möchtest du setzen?                           +%n");
			System.out.printf("+Bitte Zahl eingeben                                    +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			bet = s.nextLine();
			b = Integer.parseInt(bet);
			break;
		case 2:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Auf welche Zahl moechtest du Wetten                    +%n");
			System.out.printf("+0 bis 36                                               +%n");
			System.out.printf("+Bitte Zahl eingeben                                    +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			bet = s.nextLine();
			playerNumber = Integer.parseInt(bet);
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Du hast %d an Erfahrungspunkten                        +%n", playerExperience);
			System.out.printf("+wie viel möchtest du setzen?                           +%n");
			System.out.printf("+Bitte Zahl eingeben                                    +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			bet = s.nextLine();
			b = Integer.parseInt(bet);
			break;
		default:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Das habe ich nicht verstanden                          +%n");
			System.out.printf("+-------------------------------------------------------+%n");
				break;
		}
		field = rnd.nextInt(37);
		switch(field)
		{
		case 32:
		case 19:
		case 21:
		case 25:
		case 34:
		case 27:
		case 36:
		case 30:
		case 23:
		case 5:
		case 16:
		case 1:
		case 14:
		case 9:
		case 18:
		case 7:
		case 12:
		case 3:
			color = "Rot";
			break;
		case 0:
			color = "Gruen";
			break;
		default:
			color = "Schwarz";
			break;
		}
		System.out.printf("+-------------------------------------------------------+%n");
		System.out.printf("+Die Kugel blieb auf Feld %d mit der Farbe %s stehen    +%n", field, color);
		System.out.printf("+-------------------------------------------------------+%n");
		switch(c)
		{
		case 1:
			if(playerColor == color)
			{
				b = b * 2;
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Du gewinnst %d Erfahrungspunkte                        +%n", b);
				System.out.printf("+-------------------------------------------------------+%n");
				player.setExperience(playerExperience + b);
			}
			else
			{
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Die Bank gewinnt                                       +%n");
				System.out.printf("+-------------------------------------------------------+%n");
				player.setExperience(playerExperience - b);
			}
			break;
		case 2:
			if(playerNumber == field)
			{
				b = b * 35;
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Du gewinnst %d Erfahrungspunkte                        +%n", b);
				System.out.printf("+-------------------------------------------------------+%n");
				player.setExperience(playerExperience + b);
			}
			else
			{
				System.out.printf("+-------------------------------------------------------+%n");
				System.out.printf("+Die Bank gewinnt                                       +%n");
				System.out.printf("+-------------------------------------------------------+%n");
				player.setExperience(playerExperience - b);
			}
			break;
		default:
			System.out.printf("+-------------------------------------------------------+%n");
			System.out.printf("+Das haette nicht passieren duerfen                     +%n");
			System.out.printf("+-------------------------------------------------------+%n");
			break;
		}
	}

}
