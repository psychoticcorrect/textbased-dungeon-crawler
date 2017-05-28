package procedure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import areas.DungeonArray;
import creatures.Monster;
import creatures.Monster.Monsters;
import creatures.Player;
import items.Weapon;
import items.Weapon.Weapons;
import monsterAppears.fighting;

public class Dungeon
{
	// TODO bei hoeheren leveln stimmt die anzahl der monster und Schaetze nicht mit den angezeigten Entitäten ueberein
	//Variablen
	static Random zufall = new Random();
	private static int monsterCounter = 0;
	private static int treasureCounter = 0;
	final static ArrayList<Monsters> allM = new ArrayList<Monsters>();
	final static ArrayList<Weapons> allW = new ArrayList<Weapons>();
	//Konstruktoren
	
	//Methoden
	public static void setMonsterCounter(int monsterCounter)
	{
		Dungeon.monsterCounter = monsterCounter;
	}
	public static void setTreasureCounter(int treasureCounter)
	{
		Dungeon.treasureCounter = treasureCounter;
	}
	public static int getMonsterCounter()
	{
		return (monsterCounter);
	}
	public static int getTreasureCounter()
	{
		return (treasureCounter);
	}
	public static int inDungeon(Player player)
	{
		ArrayList<Integer> dungeonList = new ArrayList<Integer>();
		boolean inDungeon = true;
		int i = 0;
		int xAchse = 2;
		int yAchse = 2;
		int etageModulo = 3;
		int etage = player.getPlayerEtage();
		int[][] dungeon = DungeonArray.map(player.getPlayerEtage());
		Scanner scanner = new Scanner(System.in);
		String s;
		
		
		for(int p = 1; p<player.getPlayerEtage(); p++)
		{
			xAchse++;
			yAchse++;
			etageModulo++;
		}
		
		dungeonList = test(dungeonList, dungeon, xAchse, yAchse);
		dungeonCardIssue(dungeonList, i, xAchse, yAchse, etageModulo, dungeon, player);
		//Wie viele Monster & Schaetze sind im Dungeon
		int colTreasure = Collections.frequency(dungeonList, 1);
		int colMonster = Collections.frequency(dungeonList, 2);
		setTreasureCounter(colTreasure);
		setMonsterCounter(colMonster);
		System.out.printf("Es sind %d Monster & %d Schaetze im Dungeon%n", getMonsterCounter(), getTreasureCounter());
		
		move:
			while(inDungeon)
			{
				int abrot = checkField(player, dungeon, player.getPlayerEtage());
				if(abrot == 0)
				{
					player.setPlayerEtage(etage++);
					break move;
				}
				
				System.out.printf("+--------------------+%n");
				System.out.printf("+Hoch          Runter+%n");
				System.out.printf("+Links         Rechts+%n");
				System.out.printf("+Karte               +%n");
				System.out.printf("+--------------------+%n");
				s = scanner.nextLine();
				s.toLowerCase();
				switch(s)
				{
				case "hoch":
					int minusY = player.getPosY();
					if(minusY == 0)
					{
						System.out.printf("Da ist leider eine Wand%n");
					}
					else
					{
						minusY--;
						player.setPosY(minusY);
						System.out.printf("Der Spieler steht auf X: %d Y: %d%n",
								player.getPosX(), player.getPosY());
						abrot = checkField(player, dungeon, player.getPlayerEtage());
						if(abrot == 0)
							break move;
					}
					break;
				case "runter":
					int plusY = player.getPosY();
					if(plusY == yAchse)
					{
						System.out.printf("Da ist leider eine Wand%n");
					}
					else
					{
						plusY++;
						player.setPosY(plusY);
						System.out.printf("Der Spieler steht auf X: %d Y: %d%n",
								player.getPosX(), player.getPosY());
						abrot = checkField(player, dungeon, player.getPlayerEtage());
						if(abrot == 0)
							break move;
					}
					break;
				case "links":
					int minusX = player.getPosX();
					if(minusX == 0)
					{
						System.out.printf("Da ist leider eine Wand%n");
					}
					else
					{
						minusX--;
						player.setPosX(minusX);
						System.out.printf("Der Spieler steht auf X: %d Y: %d%n",
								player.getPosX(), player.getPosY());
						abrot = checkField(player, dungeon, player.getPlayerEtage());
						if(abrot == 0)
							break move;
					}
					break;
				case "rechts":
					int plusX = player.getPosX();
					if(plusX == xAchse)
					{
						System.out.printf("Da ist leider eine Wand%n");
					}
					else
					{
						plusX++;
						player.setPosX(plusX);
						System.out.printf("Der Spieler steht auf X: %d Y: %d%n",
								player.getPosX(), player.getPosY());
						abrot = checkField(player, dungeon, player.getPlayerEtage());
						if(abrot == 0)
							break move;
					}
					break;
				case "karte":
					//Karte wird erneut ausgegeben
					dungeonCardIssue(dungeonList, i, xAchse, yAchse, etageModulo, dungeon, player);
					break;
				default:
					System.out.printf("Error: Eingabe nicht verstanden....Abbruch%n");
					inDungeon = false;
					break;
				}
			}
		// PLatzhalter
		return etage;
	}
	public static void dungeonCardIssue(ArrayList<Integer> dungeonList, int i, int xAchse, int yAchse, int etageModulo,
			int[][] dungeon, Player player)
	{
		//DungeonKarte wird ausgegeben
		dungeon[player.getPosX()][player.getPosY()] = 3;
		for(int spalte0=0;spalte0<=xAchse;spalte0++)
			for(int zeile0=0;zeile0<=yAchse;zeile0++)
			{
				
				if(i%etageModulo==0)
				{
					System.out.printf("%n");
					System.out.print(dungeon[zeile0][spalte0]);
					i++;
				}
				else
				{
					System.out.print(dungeon[zeile0][spalte0]);
					i++;
				}
			}
		dungeon[player.getPosX()][player.getPosY()] = 0;
		System.out.printf("%n%n");
	}
	public static ArrayList<Integer> test(ArrayList<Integer> dungeonList, int[][] dungeon, int xAchse, int yAchse)
	{
		for(int spalte0=0;spalte0<=xAchse;spalte0++)
			for(int zeile0=0;zeile0<=yAchse;zeile0++)
			{
				dungeonList.add(dungeon[zeile0][spalte0]);
			}
		return dungeonList;
	}
	public static int checkField(Player player, int[][] dungeon, int etage)
	{
		//Variablen
		int win;
		int abort = 0;
		int monsterSelect = zufall.nextInt(4 )+ 1;
		int monsterLevel = (int) (zufall.nextInt(6) + 1) * etage;
		// TODO Dropliste fuer Monster erstellen
		int weaponSelect = 0;
		double d = Math.random() * 100;
		if ((d -= 48) < 0) 
		{
			weaponSelect = 1;
		}
		else if ((d -= 52) < 0)
		{
			weaponSelect = 0;
		}
		//Monster gefunden
		if(dungeon[player.getPosX()][player.getPosY()]==2)
		{
			if(getMonsterCounter() >0)
			{
				//TODO Monster Random auswahl vereinfachen
				//TODO Fliehen sinnvoll
				//TODO Monster Level an ebene anpassen
				
				System.out.printf("Ein Monster erscheint%n");
				for(Monsters m : Monsters.values())
				{
					allM.add(m);
				}
				Monster test = new Monster
						(allM.get(monsterSelect), allM.get(monsterSelect).getName(), allM.get(monsterSelect).getWay(),
								monsterLevel, monsterLevel/2, 80, 100, 1000);
				System.out.printf("Ein Monster namens: %s erscheint%n"
						+ "Das Monster wuerde %d Erfahrung bringen%n"
						+ "Das Monster wuerde %d Gold bringen%n", test.getName(), test.getExpByWin(), test.getGold());
				win = fighting.fight(player,test);
				if(win==1)
				{
					int i = getMonsterCounter();
					setMonsterCounter(--i);
					dungeon[player.getPosX()][player.getPosY()] = 0;
				}
				else if(win==3)
				{
					int i = getMonsterCounter();
					setMonsterCounter(--i);
					dungeon[player.getPosX()][player.getPosY()] = 0;
					System.out.printf("Du bist geflohen%n");
				}
				else
					return abort;
			}
		}
		//Schatz gefunden
		else if(dungeon[player.getPosX()][player.getPosY()]==1)
		{
			for(Weapons w : Weapons.values())
			{
				allW.add(w);
			}
			Weapon waffe = new Weapon(allW.get(weaponSelect), allW.get(weaponSelect).getName(),
					allW.get(weaponSelect).getTyp(), allW.get(weaponSelect).getWayTyp(),
					allW.get(weaponSelect).getWorth(), allW.get(weaponSelect).getRequiredLevel(), 
					allW.get(weaponSelect).getDurability(), allW.get(weaponSelect).getStrength(),
					allW.get(weaponSelect).getEndurance());
			
			System.out.printf("%s mit folgenden werten erstellt: Klasse: %s%n"
					+ "Wert: %d      Benoetigtes Level: %d%n"
					+ "Haltbarkeit: %d%n"
					+ "Staerke: %d%n"
					+ "Ausdauer: %d%n", waffe.getName(), waffe.getWayTyp(), waffe.getWorth(), 
					waffe.getRequiredLevel(), waffe.getDurability(), waffe.getStrength(), waffe.getEndurance());
			if(getTreasureCounter () >0)
			{
				if (player.getPlayerInventorySize() == 0)
				{
					player.setPlayerInventory(waffe);
//					x.getPlayerInventory(0).setWayTyp("Magier");
					System.out.printf("Du hast %s erhalten%n", player.getPlayerInventory(0).getName());
					int i = getTreasureCounter();
					setTreasureCounter(--i);
					dungeon[player.getPosX()][player.getPosY()] = 0;
				}
				else
				{
					for(int i = 0; i<player.getPlayerInventorySize(); i++)
					{
						if(player.getPlayerInventory(i).getName().equals(waffe.getName()))
						{
							int amount = player.getPlayerInventory(i).getAmount();
							if(amount == 99)
							{
								dungeon[player.getPosX()][player.getPosY()] = 0;
								int o = getTreasureCounter();
								setTreasureCounter(--o);
								System.out.printf("Du kannst nicht mehr von diesem Item tragen%n");
								
							}
							else
							{
								player.getPlayerInventory(i).setAmount(++amount);
								dungeon[player.getPosX()][player.getPosY()] = 0;
								int o = getTreasureCounter();
								setTreasureCounter(--o);
								System.out.printf("%s wurde deiner Tasche hinzugefuegt%n", 
										player.getPlayerInventory(i).getName());
							}
						}
						else
						{
							player.setPlayerInventory(waffe);
						}		
					}
				}
			}
		}
		//TODO naechste Etage hinzufuegen
		//Neachste Etage
		else if(getTreasureCounter() == 0 && getMonsterCounter() == 0)
		{
			if(dungeon[player.getPosX()][player.getPosY()]==0)
			{
				System.out.printf("Naechste Etage freigeschaltet%n");
				return abort;
			}
		}
		abort = 1;
		return abort;
	
	}
}