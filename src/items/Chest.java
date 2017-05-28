package items;

public class Chest extends Item {

	
	//Variablen
	
	//Konstruktoren
	public Chest(Chests chests, String name, String typ, String wayTyp,
			int worth, int requiredLevel, int durability, int strength, int endurance)
	{
	
	}
	//Methoden
	public enum Chests
	{
		Defragmentationsstab("Defragmentationsstab", "Stab", "Magier",
				1_000, 1, 100, 99, 99);
		
		String name, typ, wayTyp;
		int worth, requiredLevel;
		Chests(String name, String typ, String wayTyp,
				int worth, int requiredLevel, int durability, int strength, int endurance)
		{
			this.name = name;
			this.typ = typ;
			this.wayTyp = wayTyp;
			this.worth = worth;
			this.requiredLevel = requiredLevel;
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
	}

}
