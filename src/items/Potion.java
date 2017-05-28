package items;

public class Potion extends Item {
	
	public Potion()
	{
		
	}

	public enum Potions
	{
		//TODO Wirkung
		Trank("Einhornblut", "Trank", "",
				1_000_000, 1);
		
		String name, typ, wayTyp;
		int worth, requiredLevel;
		Potions(String name, String typ, String wayTyp,
				int worth, int requiredLevel)
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
