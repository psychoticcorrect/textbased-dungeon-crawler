package procedure;

import java.util.Scanner;

import creatures.Player;

public class equip 
{
	 //Variablen
	
	static int amount;
	static Scanner scanner = new Scanner(System.in);
	static String s;
	
	
	//Konstruktoren
	
	//Methoden
	//TODO Items wieder zurück in die tasche bei naderem Item 
	public static void inventoryCheck(Player player)
	{
		if(player.getPlayerInventorySize() == 0 )
		{
			System.out.printf("Du hast keine Gegenstaende in deiner Tasche");
		}
		else
		{
			toEquip(player);
		}
	}
	
	
	public static void toEquip(Player player)
	{
		int place = 0;
		// Schleife um alle Items in der Tasche zu erfassen
		for(int i = 0; i< player.getPlayerInventorySize();i++)
		{
			System.out.printf("%d Name: %s Anzahl: %d %n", place, 
					player.getPlayerInventory(i).getName(), player.getPlayerInventory(i).getAmount());
			place++;
		}
		// Ausgabe des momentan ausgeruesteten Items
		if(player.getPlayerWeapon() != null)
		{
			System.out.printf("Du hast momentan %s ausgeruestet%n", player.getPlayerWeapon().getName());
		}
		System.out.printf("Welches Item möchtest du Ausruesten?%nNummer: ");
		s = scanner.nextLine();
		place = Integer.parseInt(s);
		amount = player.getPlayerInventory(place).getAmount();
		System.out.printf("Du hast %s ausgewaehlt%n", 
				player.getPlayerInventory(place).getName());
		// ausgewaehltes Item an Waffenslot 
		if(player.getPlayerWeapon() != null)
		{
			// Bei gleichen Items wird nichts ausgeruestet
			if(player.getPlayerInventory(place).getName().equals(player.getPlayerWeapon().getName()) )
				System.out.printf("%s ist bereits ausgeruestet%n", player.getPlayerWeapon().getName());
			// Bei verschiedenen Items wird das neue ausgeruestet
			else
			{
				player.setPlayerWeapon(player.getPlayerInventory(place));
				if(amount >= 2)
				{
					player.getPlayerInventory(place).setAmount(--amount);
				}
				else
				{
					player.removeItem(place);
				}
				System.out.printf("Du hast jetzt %s als Waffe ausgeruestet", player.getPlayerWeapon().getName());
			}
		}
		else if(player.getWay().equals(player.getPlayerInventory(place).getWayTyp()))
		{
			if(player.getLevel() == player.getPlayerInventory(place).getRequiredLevel())
			{
				switch(player.getWay())
				{
				case "Magier":
					switch(player.getPlayerInventory(place).getTyp())
					{
					case "Stab":
						player.setPlayerWeapon(player.getPlayerInventory(place));
						System.out.printf("Du hast %s als Waffe ausgeruestet", player.getPlayerWeapon().getName());
						break;
					case "Brust":
						player.setPlayerChest(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Brust ausgeruestet", player.getPlayerChest().getName());
						break;
					case "Helm":
						player.setPlayerHelm(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Helm ausgeruestet", player.getPlayerHelm().getName());
						break;
					default:
						System.out.printf("Error \"Mage\" Das haette nicht passieren duerfen");
						break;
					}
					break;
				case "Krieger":
					switch(player.getPlayerInventory(place).getTyp())
					{
					case "Schwert":
						player.setPlayerWeapon(player.getPlayerInventory(place));
						System.out.printf("Du hast %s als Waffe ausgeruestet", player.getPlayerWeapon().getName());
						break;
					case "Brust":
						player.setPlayerChest(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Brust ausgeruestet", player.getPlayerChest().getName());
						break;
					case "Helm":
						player.setPlayerHelm(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Helm ausgeruestet", player.getPlayerHelm().getName());
						break;
					default:
						System.out.printf("Error \"Warrior\" Das haette nicht passieren duerfen");
						break;
					}
					break;
				case "Bogenschuetze":
					switch(player.getPlayerInventory(place).getTyp())
					{
					case "Bogen":
						player.setPlayerWeapon(player.getPlayerInventory(place));
						System.out.printf("Du hast %s als Waffe ausgeruestet", player.getPlayerWeapon().getName());
						break;
					case "Brust":
						player.setPlayerChest(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Brust ausgeruestet", player.getPlayerChest().getName());
						break;
					case "Helm":
						player.setPlayerHelm(player.getPlayerInventory(place));
						System.out.printf("Di hast %s als Helm ausgeruestet", player.getPlayerHelm().getName());
						break;
					default:
						System.out.printf("Error \"Scout\" Das haette nicht passieren duerfen");
						break;
					}
					break;
				default:
					System.out.printf("Error \"Level\" Das haette nicht passieren duerfen");
					break;
				}
			}
		}
		else
		{
			System.out.printf("Ausruesten nicht moeglich");
		}
	}

}
