package creatures;

import java.util.Random;

public class Creature {

	//Variablen
	protected String name;
	protected String way;
	
	private int level;
	private int experience;
	private int strength;
	private int endurance;
	private int gold = 0;
	
	//Konstruktoren
	public Creature(String name, String way, int level, 
			int strength, int endurance, int gold){
		this.name = name;
		this.way = way;
		this.level = level;
		this.strength = strength;
		this.endurance = endurance;
		this.gold = gold;
	}
	public Creature()
	{
		
	}
	public Creature(String name)
	{
		
	}
	public Creature(String name, String way)
	{
		
	}
	//Methoden
	public void setName(String name){
		if(name instanceof String)
			this.name = name;
	}
	public void setWay(String way){
		this.way = way;
	}
	public void setLevel(int level){
		if(level < 1)
			this.level = 1;
		else if(level > 100)
			this.level = 100;
		else
			this.level = level;
	}
	public void setExperience(int experience){
		this.experience = experience;
	}
	public void setStrength(int strength){
		this.strength = strength;
	}
	public void setEndurance(int endurance){
		this.endurance = endurance;
	}
	public void setGold(int gold)
	{
		this.gold = gold;
	}
	
	public String getName(){
		return (name);
	}
	public String getWay(){
		return(way);
	}
	public int getLevel(){
		return(level);
	}
	public int getExperience(){
		return(experience);
	}
	public int getStrength(){
		return(strength);
	}
	public int getEndurance(){
		return(endurance);
	}
	public int getGold()
	{
		return (gold);
	}
	
	//TODO return Krit
	public static int attack(int strength){
		Random zufall = new Random();
		int krit = zufall.nextInt(6) + 1;
		int b = (strength + krit);
		if(krit == 6)
		{
			b= b * 2;
			System.out.printf("Kritischer Angriff!%n");
		}
			
		return b;
	}
	public static double live(int endurance){
		double b = endurance * 1.5;
		return b;
	}
	public static double defense(double live, double attack){
		double c = live - attack;
		return c;
	}
	
}
