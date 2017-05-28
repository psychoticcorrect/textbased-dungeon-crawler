package procedure;

import java.io.*;
import creatures.*;
import items.Weapon;


public class read {
	
	

	//Variablen
	
	//Konstruktoren
			
	//Methoden
	
	public static Player fromFile()throws IOException, FileNotFoundException{
		//TODO Auswahl aus savegames
		
		//TODO Exception bei savegame ohne Item
//		Exception in thread "main" java.lang.NullPointerException
//        at procedure.read.fromFile(read.java:41)
//        at procedure.newGame.charSelect(newGame.java:38)
//        at Game.main(Game.java:15)
		
		FileReader fr = new FileReader("test.txt");
	    BufferedReader br = new BufferedReader(fr);
	    Player player = new Player();
	    Weapon playerWeapon = new Weapon();
	    
	    
	    
	    try{
	    	String zeile1 = br.readLine();
		    player.setName(zeile1);
		    String zeile2 = br.readLine();
		    player.setWay(zeile2);
		    String zeile3 = br.readLine();
		    player.setLevel(Integer.parseInt(zeile3));
		    String zeile4 = br.readLine();
		    player.setStrength(Integer.parseInt(zeile4));
		    String zeile5 = br.readLine();
		    player.setEndurance(Integer.parseInt(zeile5));
		    String zeile6 = br.readLine();
		    player.setExperience(Integer.parseInt(zeile6));
		    String zeile7 = br.readLine();
		    player.setPlayerEtage(Integer.parseInt(zeile7));
		    String zeile8 = br.readLine();
		    player.setGold(Integer.parseInt(zeile8));
		    if(checkRows() > 8)
		    {
		    	String zeile9 = br.readLine();
		    	if(zeile9.equals("Schwert") || zeile9.equals("Stab") || zeile9.equals("Bogen"))
			    {
			    	
			    	
			    	playerWeapon.setTyp(zeile9);
			    	String zeile10 = br.readLine();
			    	playerWeapon.setName(zeile10);
			    	String zeile11 = br.readLine();
			    	playerWeapon.setWorth(Integer.parseInt(zeile11));
			    	String zeile12 = br.readLine();
			    	playerWeapon.setRequiredLevel(Integer.parseInt(zeile12));
			    	String zeile13 = br.readLine();
			    	playerWeapon.setWayTyp(zeile13);
			    	String zeile14 = br.readLine();
			    	playerWeapon.setAmount(Integer.parseInt(zeile14));
			    	String zeile15 = br.readLine();
			    	playerWeapon.setDurability(Integer.parseInt(zeile15));
			    	String zeile16 = br.readLine();
			    	playerWeapon.setStrength(Integer.parseInt(zeile16));
			    	String zeile17 = br.readLine();
			    	playerWeapon.setEndurance(Integer.parseInt(zeile17));
			    	player.setPlayerWeapon(playerWeapon);
			    }
		    }
		    
		    else
		    {
		    	br.close();
			    return (player);
		    }
	    }catch(FileNotFoundException ex){
			System.out.println("Diese Datei existiert nicht!");
		}
	    catch(IOException ex){
			System.out.println("Fehler beim Lesen: "+ex.getMessage());
		}
	    

	    br.close();
	    return (player);
	}
	
	public static int checkRows()
	{
		int count = 0;
		try
		{
			FileReader fr = new FileReader("test.txt");
		    BufferedReader br = new BufferedReader(fr);
			
		    
		    while( br.readLine() != null)
		    {
		    	count++;
		    }
		    br.close();
			
		}catch(FileNotFoundException ex){
			System.out.println("Diese Datei existiert nicht!");
		}
	    catch(IOException ex){
			System.out.println("Fehler beim Lesen: "+ex.getMessage());
		}
		
		return count;
		
	}
	
	
}