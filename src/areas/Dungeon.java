package areas;

import creatures.*;
import java.util.*;

public class Dungeon {
	
	//Variablen
	Random zufall = new Random();
	static Scanner scanner = new Scanner(System.in);
	static String direction = "vorne";
	//Konstruktoren
	
	//Methoden
	public static void goInIt(Player x){
		/*	    Der Spieler betritt das Dungeon und kann eine richtung auswaehlen,
		 * 		er kann entweder Links, Rechts,oder geradeaus gehen.
		 * 		Das dungeon soll bei jeder Richtung einen raum per zufall generieren,
		 * 		Der Raum ist entweder leer, hat ein Monster, einen Schatz, eine Falle,
		 * 		oder nach einigen Raeumen den Ausgang.
		 */
		double playerHp = Creature.live(x.getEndurance());
		boolean exitFound = false;
		x.setPosX(1);
		x.setPosY(1);
		int playerPosX = x.getPosX();
		int playerPosY = x.getPosY();
		System.out.printf("Du gehst in die Hoehle und nach deinen ersten Schritten%n"
				+ "hoerst du hinter dir wie der Eingang einstuerzt%n"
				+ "Finde einen Ausweg!%n");
		while(playerHp > 0 || !exitFound){
			System.out.println(direction);
			if(playerPosX == 1){
				System.out.printf("1. Vorne%n2. Links%n");
				direction = scanner.nextLine();
				System.out.println(direction);
				scanner.close();
				if(direction.toLowerCase().equals("vorne")){
					playerPosY += 1;
				}
				else if(direction.toLowerCase().equals("links")){
					playerPosX += 1;
				}
			}
			else if(playerPosY == 1){
				System.out.printf("1. Vorne%n2. Links%n");
				direction = scanner.nextLine();
				scanner.close();
				if(direction.toLowerCase().equals("vorne")){
					playerPosY += 1;
				}
				else if(direction.toLowerCase().equals("links")){
					playerPosX += 1;
				}
					
			}
			
			//System.out.print("Du hast 3 Richtungen zur Auswahl%n"
					//+ "1. Links%n2. Rechts%n3. Nach vorne");
			//String direction = leser.nextLine();
			//switch
			
			
			//System.out.printf("Die Hp vom Spieler betragen: %.2f%n",playerHp);
			exitFound = true;
			playerHp = 0;
			//System.out.printf("Die Hp vom Spieler betragen: %.2f%n",playerHp);

			
		}
		
		
	}

}
