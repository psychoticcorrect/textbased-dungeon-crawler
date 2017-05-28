package procedure;

import java.util.Scanner;

import creatures.Player;

public class LevelUp {

	static String s;
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void lvlUp(Player x)
	{
		System.out.printf("Du hast auflevelen gewaehlt%n");
		System.out.printf("Dein aktuelles Level betraegt: %d%n", x.getLevel());
		int costs = x.levelUpCosts();
		System.out.printf("Das naechste Level kostet dich %d Erfahrungspunkte.%n"
				+ "Du hast %d Erfahrungspunkte.%n"
				+ "%nSicher !?%n 1. Ja     2. Nein%n", costs, x.getExperience());
		s = scanner.nextLine();
		String S = s.toLowerCase();
		switch(S)
		{
		case "ja":
			x.levelUp();
			System.out.printf("Du hast level %d erreicht%n"
					+ "Deine Staerke ist auf %d gestiegen%n"
					+ "Deine Ausdauer ist auf %d gestiegen%n", x.getLevel(), x.getStrength(), x.getEndurance());
			break;
		case "nein":
			System.out.printf("Schade die Erfahrungspunkte"
					+ " haette ich gut gebrauchen koennen%n");
			break;
		default:
			System.out.print("ich hab dich leider nicht verstanden...%n");
			break;

		}		

		
	}
}
