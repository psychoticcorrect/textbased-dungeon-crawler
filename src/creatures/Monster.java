package creatures;

public class Monster extends Creature{
	//Variablen
	private int expByWin = 0;
	//Konstruktoren
	public Monster(Monsters monsters, String name, String way, int level, 
			int strength, int endurance, int expByWin, int gold){
		super(name, way, level, strength, endurance, gold);
		this.expByWin = expByWin;
	}
	public Monster(String name, String way)
	{
		
	}
	public Monster(Monsters monsters, String name, String way) {
		this.name = name;
		this.way = way;
	}
	//Methoden
	public void setExp(int expByWin)
	{
		if(expByWin == 0)
			this.expByWin = (10 + (getLevel() / 2));
		this.expByWin = expByWin;
	}
	
	
	public int getExpByWin()
	{
		return(expByWin);
	}
	
	public int getExp(int expByWin, int level)
	{
		int c = expByWin / level ;
		return c;
	}
	public enum Monsters
	{
		Raufbold("Raufbold", "Dieb"),
		Ratten("Ratten", "Dieb"),
		Wuermer("Wuermer", "Magier"),
		Kraehen("Kraehen", "Dieb"),
		SchwarmFliegen("Schwarm Fliegen", "Dieb");
		
		
		String name,way;
		
		Monsters(String name, String way)
		{
			this.name = name;
			this.way = way;
		}
		public String getWay()
		{
			return (way);
		}
		
		public String getName()
		{
			return(name);
		}
	}
	
}
