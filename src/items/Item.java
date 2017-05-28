package items;

public class Item {
//	TODO !!! ENUM !!!
	//Variablen
	private String name;
	private String typ;
	private int worth;
	private int requiredLevel;
	private String wayTyp = "";
	//TODO Menge des selben Items
	private int amount = 1;
	//Konstruktoren
	public Item(String name, String typ, String wayTyp,  int worth, int requiredLevel)
	{
		this.name = name;
		this.typ = typ;
		this.requiredLevel = requiredLevel;
		this.worth = worth;
		this.wayTyp = wayTyp;
	}
	public Item()
	{
		
	}
	//Methoden
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	public void setName(String name){
		if(name instanceof String)
			this.name = name;
	}
	public void setTyp(String typ){
		if(typ instanceof String)
			this.typ = typ;
	}
	public void setWorth(int worth)
	{
		this.worth = worth;
	}
	public void setRequiredLevel(int requiredLevel)
	{
		this.requiredLevel = requiredLevel;
	}
	public void setWayTyp(String wayTyp)
	{
		this.wayTyp = wayTyp;
	}
	public int getAmount()
	{
		return (amount);
	}
	public String getName()
	{
		return (name);
	}
	public String getTyp()
	{
		return (typ);
	}
	public int getWorth()
	{
		return (worth);
	}
	public int getRequiredLevel()
	{
		return (requiredLevel);
	}
	public String getWayTyp()
	{
		return (wayTyp);
	}
	
	
}
