package items;



public class Weapon extends Item{
	//Variablen
	private int durability;
	private int strength;
	private int endurance;
	
	//Konstruktoren
	public Weapon(String name, String typ, String wayTyp, int worth,
			int requiredLevel, int durability, int strength, int endurance)
	{
		super(name, typ, wayTyp, worth, requiredLevel);
		this.durability = durability;
		this.strength = strength;
		this.endurance = endurance;
	}
	public Weapon() {
		
	}
	public Weapon(Weapons weapons, String name, String typ, String wayTyp,
			int worth, int requiredLevel, int durability, int strength, int endurance)
	{
		super(name, typ, wayTyp, worth, requiredLevel);
		this.durability = durability;
		this.strength = strength;
		this.endurance = endurance;
	}
	//Getter & Setter
	public void setDurability(int durability){
		this.durability = durability;
	}
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	public void setEndurance(int endurance)
	{
		this.endurance = endurance;
	}
	
	public int getDurability()
	{
		return (durability);
	}
	public int getStrength()
	{
		return(strength);
	}
	public int getEndurance()
	{
		return (endurance);
	}
	
	//Methoden
	public enum Weapons
	{
		Defragmentationsstab("Defragmentationsstab", "Stab", "Magier",
				1_000, 1, 100, 99, 99),
		Feuergrimm("Feuergrimm", "Schwert", "Krieger", 1_000, 1, 100, 99, 99);
		
		String name, typ, wayTyp;
		int worth, requiredLevel, durability, strength, endurance;
		Weapons(String name, String typ, String wayTyp,
				int worth, int requiredLevel, int durability, int strength, int endurance)
		{
			this.name = name;
			this.typ = typ;
			this.wayTyp = wayTyp;
			this.worth = worth;
			this.requiredLevel = requiredLevel;
			this.durability = durability;
			this.strength = strength;
			this.endurance = endurance;
		}
		public String getName()
		{
			return (name);
		}
		public String getTyp()
		{
			return (typ);
		}
		public String getWayTyp()
		{
			return (wayTyp);
		}
		public int getWorth()
		{
			return (worth);
		}
		public int getRequiredLevel()
		{
			return (requiredLevel);
		}
		public int getDurability()
		{
			return (durability);
		}
		public int getStrength()
		{
			return(strength);
		}
		public int getEndurance()
		{
			return (endurance);
		}
	}



}
