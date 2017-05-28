package creatures;

import java.util.LinkedList;

import items.*;

public class Player extends Creature
{
	//Variablen
	private Weapon playerWeapon;
	private Item playerChest;
	private Item playerHelm;
	private int posX,posY = 0;
	private int etage = 1;
	private LinkedList<Item> playerInventory = new LinkedList<Item>();
//	private LinkedList<Item> playerEquipment = new LinkedList<Item>(); 
	//Konstruktoren
	public Player()
	{
		
	}
	public Player(String name)
	{
		super(name);
	}
	public Player(String name, String way, int level, 
			int strength, int endurance, int gold)
	{
		super(name, way, level, strength, endurance, gold);
	}
	//Getter & Setter
	//TODO Sortieren fuer besser Uebersicht
	public void setPlayerEtage(int etage)
	{
		this.etage = etage;
	}
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	public void setPlayerWeapon(Item weapon)
	{
		this.playerWeapon = (Weapon) weapon;
	}
	public void setPlayerChest(Item chest)
	{
		this.playerChest = chest;
	}
	public void setPlayerHelm(Item helm)
	{
		this.playerHelm = helm;
	}
	public void setPlayerInventory(Item x)
	{
		playerInventory.add(x);
	}
	public int getPlayerEtage()
	{
		return (etage);
	}
	public Weapon getPlayerWeapon()
	{
		return (playerWeapon);
	}
	public Item getPlayerChest()
	{
		return (playerChest);
	}
	public Item getPlayerHelm()
	{
		return (playerHelm);
	}
	public int getPosX()
	{
		return (posX);
	}
	public int getPosY()
	{
		return (posY);
	}
	public int getPlayerInventorySize()
	{
		return(playerInventory.size());
	}
	public Item getPlayerInventory(int i)
	{
		return (playerInventory.get(i));
	}
	public void removeItem(int i)
	{
		playerInventory.remove(i);
	}
//	public void addEquipment(Item x)
//	{
//		playerEquipment.add(x);
//	}
//	public int getPlayerEquipmentSize()
//	{
//		return (playerEquipment.size());
//	}
//	public Item getPlayerEquipment(int i)
//	{
//		return (playerEquipment.get(i));
//	}
	
	//Methoden
	public void levelUp()
	{
		int x = 0;
		int z = 50;
		for(int i=1; i<=getLevel(); i++)
		{
			x += z;
		}
		if(getExperience() > x)
		{
			setExperience(getExperience()- x);
			int lvl = getLevel();
			int strength = getStrength();
			int endurance = getEndurance();
			switch(getWay())
			{
			case "Krieger":
				strength = (int) (getStrength() * 1.5);
				if(strength%2 != 0)
					strength = (int) Math.round(endurance);
				endurance = (int) (getEndurance() * 1.3);
				if(endurance%2 != 0)
					endurance = (int) Math.round(endurance);
				break;
			case "Magier":
				strength = (int) (getStrength() * 1.2);
				if(strength%2 != 0)
					strength = (int)  Math.round(strength);
				endurance = (int) (getEndurance() * 1.5);
				if(endurance%2 != 0)
					endurance = (int) (endurance + 0.5);
				break;
			case "Bogenschuetze":
				strength = (int) (getStrength() * 1.3);
				if(strength%2 != 0)
					strength = (int) Math.round(strength);
				endurance = (int) (getEndurance() * 1.3);
				if(endurance%2 != 0)
					endurance = (int) Math.round(endurance);
				break;	
			}
			setLevel(++lvl);
			setStrength(strength);
			setEndurance(endurance);
		}
		
	}
	public int levelUpCosts()
	{
		int x = 0;
		int z = 50;
		for(int i=1; i<=getLevel(); i++)
		{
			x += z;
		}
		return x;
		
	}
	
	
}