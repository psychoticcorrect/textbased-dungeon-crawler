package monsterAppears;
import java.util.*;


import	creatures.*;
public class fighting {
	//Variablen
	static Random zufall = new Random();
	//Konstruktoren
		
	//Methoden
	//TODO Test entfernen und übersichtlicher gestalten
	//TODO Aktionen innerhalb eines Kampfes Kampf ,Tasche ,Flucht
	//TODO Inofs am anfang entfernen oder nützlicher bzw informativer gestalten
	public static int fight(Player player, Monster monster){
		double actHeroHealth = Creature.live(player.getEndurance());
//		System.out.println(actHeroHealth);
		double actMonsterHealth = Creature.live(monster.getEndurance());
//		System.out.println(actMonsterHealth);
		double heroAttack = Creature.attack(player.getStrength());
//		System.out.println(heroAttack);
		double monsterAttack = Creature.attack(monster.getStrength());
//		System.out.println(monsterAttack);
		int change = 1;
		int round = 1;
		int win = 1;
		String s;
		Scanner scanner = new Scanner(System.in);
//		if(player.getPlayerWeapon() != null)
//		{
//			heroAttack += player.getPlayerWeapon().getStrength();
//			actHeroHealth = Creature.live(player.getEndurance() + player.getPlayerWeapon().getEndurance());
////			System.out.printf("Du hast %s ausgeruestet + %d auf Staerke , + %d auf Ausdauer%n",
////					player.getPlayerWeapon().getName(), player.getPlayerWeapon().getStrength(),
////					player.getPlayerWeapon().getEndurance());	
//		}
		
		
		do{
			
			System.out.printf("+--------------------+%n");
			System.out.printf("+Angriff        Items+%n");
			System.out.printf("+Zauber       Fliehen+%n");
			System.out.printf("+--------------------+%n");
			s = scanner.nextLine();
			switch(s.toLowerCase())
			{
			
			case "angriff":
				//TODO Kampfablauf anders gestalten
				//TODO Angriff mit Equip
				//TODO Angriffswert random
				attack:
				switch (round)
				{
				
					case 1:
						
							
						System.out.printf("Runde: %d%n",change);
						System.out.printf("Das Monster hat: %.0f Leben%n",actMonsterHealth);
						heroAttack = Creature.attack(player.getStrength());
						if(player.getPlayerWeapon() != null)
						{
							heroAttack += player.getPlayerWeapon().getStrength();
							actHeroHealth = Creature.live(player.getEndurance() + player.getPlayerWeapon().getEndurance());
						}
						actMonsterHealth = Creature.defense(actMonsterHealth
								,heroAttack);
						System.out.printf("Das Monster erleidet: %.0f Schaden%n"
								, heroAttack);
						System.out.printf("Das Monster hat: %.0f Leben%n",actMonsterHealth);
						if(actMonsterHealth <= 0)
							break;
						else
							change++;
							round++;
							break;
					
					case 2:
					
					
							System.out.printf("Runde: %d%n",change);
							System.out.printf("Der Held hat: %.0f Leben%n",actHeroHealth);
							monsterAttack = Creature.attack(monster.getStrength());
							actHeroHealth = Creature.defense(actHeroHealth
									,monsterAttack);
							System.out.printf("Der Held erleidet: %.0f Schaden%n"
									, monsterAttack);
							System.out.printf("Der Held hat: %.0f Leben%n",actHeroHealth);
							if(actHeroHealth <= 0)
								break;
							else
								change++;
								round--;
								break;
					default:
							System.out.print("Fehler: Das hätte nicht passieren dürfen%n");
							break;
					
				}
				break;
			case "items":
//				TODO Zeige nur Traenke 
				
				break;
			case "zauber":
				break;
			case "fliehen":
				int flee;
				flee = zufall.nextInt(6) + 1;
				switch(flee)
				{
				case 1:
				case 3:
				case 5:
					System.out.printf("Du bist nicht entkommen%n");
					System.out.printf("Runde: %d%n",change);
					System.out.printf("Der Held hat: %.0f Leben%n",actHeroHealth);
					actHeroHealth = Creature.defense(actHeroHealth
							,monsterAttack);
					System.out.printf("Der Held erleidet: %.0f Schaden%n"
							, monsterAttack);
					System.out.printf("Der Held hat: %.0f Leben%n",actHeroHealth);
					if(actHeroHealth <= 0)
						break;
					else
						change++;
						round--;
					break;
				case 2:
				case 4:
				case 6:
					win = 3;
					return(win);
					
				default:
					System.out.printf("Fehler: Unglaublich es wurde eine 7 geworfen%n");
					break;
					
						
				}
				break;
			default:
				System.out.printf("Fehler: Ups besser jetzt als Spaeter...%n" );
				break;
			}
			
				
		}while(actHeroHealth > 0 && actMonsterHealth > 0);
		
		//Gewonnen oder Verloren
		if(actHeroHealth <= 0){
			System.out.printf("Der Held hat verloren !%n" );
			win = 2;
			return win;
		}
		else{
			System.out.printf("Der Held hat gewonnen%n" );
			System.out.printf("Der Held hat %d Erfahrung erhalten%n",
					monster.getExp(monster.getExpByWin(),player.getLevel()));
			player.setExperience(player.getExperience() + monster.getExp(monster.getExpByWin(),player.getLevel()));
			System.out.printf("Der Held hat %d Erfahrung%n",
					player.getExperience());
			return win;
		}
		
	}
}
