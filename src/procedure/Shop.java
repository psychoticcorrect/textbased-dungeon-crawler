package procedure;

import java.util.Scanner;

import creatures.Player;

public class Shop {
	//Variablen
	static Scanner s = new Scanner(System.in);
	
	
	//Konstruktoren
	
	//Methoden
	public static void shopping(Player player)
	{
		
		System.out.printf("+--------------------+%n");
		System.out.printf("+Einkaufen           +%n");
		System.out.printf("+Verkaufen           +%n");
		System.out.printf("+--------------------+%n");
		String str = s.nextLine();
		str.toLowerCase();
		if(str == "")
		{
			str = s.nextLine();
			str.toLowerCase();
		}
		switch(str)
		{
		case "buy":
			buy(player);
			break;
		case "sell":
			inventoryCheck(player);
			break;
		default:
			System.out.printf("str = %s%n", str);
			System.out.printf("Das hab ich leider nicht verstanden%n");
			break;
		}
		
	}
	public static void buy(Player player)
	{
		
		
	}
	public static void sell(Player player)
	{
		int amount;
		int place = 0;
		int toSellAmount;
		int refund;
		// Schleife um alle Items in der Tasche zu erfassen
		for(int i = 0; i< player.getPlayerInventorySize();i++)
		{
			System.out.printf("%d Name: %s Anzahl: %d %n", place, 
					player.getPlayerInventory(i).getName(), player.getPlayerInventory(i).getAmount());
			place++;
		}
		System.out.printf("Welches Item möchtest du Verkaufen?%nNummer: ");
		place = s.nextInt();
		
		amount = player.getPlayerInventory(place).getAmount();
		System.out.printf("Du hast %s ausgewaehlt%n", 
				player.getPlayerInventory(place).getName());
		System.out.printf("Du hast %d Stueck davon%n"
				+ "Wie viele moechtest du verkaufen?%n", amount);
		toSellAmount = s.nextInt();
		if(toSellAmount > amount)
		{
			System.out.printf("So viel hast du davon gar nicht%n");
		}
		else
		{
			refund = toSellAmount * player.getPlayerInventory(place).getWorth();
			player.setGold(player.getGold() + refund);
			player.getPlayerInventory(place).setAmount(player.getPlayerInventory(place).getAmount() - toSellAmount);
			System.out.printf("Du hast %d Gold erhalten%n", refund);
		}
		
	}
	public static void inventoryCheck(Player player)
	{
		if(player.getPlayerInventorySize() == 0 )
		{
			System.out.printf("Du hast keine Gegenstaende in deiner Tasche%n");
		}
		else
		{
			sell(player);
		}
	}
	
	
}
