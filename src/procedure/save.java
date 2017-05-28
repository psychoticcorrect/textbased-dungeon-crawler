package procedure;

import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import creatures.*;

public class save {
	//TODO Items speichern
	//Variablen
	//FileWriter fw = new FileWriter("ausgabe.txt");
    //BufferedWriter bw = new BufferedWriter(fw);
	//Konstruktoren
		
	//Methoden
	public static void toFile(Player player){
		
		PrintWriter pWriter = null;
		
		try { 
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("test.txt"))); 
            pWriter.println(player.getName());
            pWriter.println(player.getWay());
            pWriter.println(player.getLevel());
            pWriter.println(player.getStrength());
            pWriter.println(player.getEndurance());
            pWriter.println(player.getExperience());
            pWriter.println(player.getPlayerEtage());
            pWriter.println(player.getGold());
            if(player.getPlayerWeapon() != null)
            {

            	pWriter.println(player.getPlayerWeapon().getTyp());
            	pWriter.println(player.getPlayerWeapon().getName());
            	pWriter.println(player.getPlayerWeapon().getWorth());
            	pWriter.println(player.getPlayerWeapon().getRequiredLevel());
            	pWriter.println(player.getPlayerWeapon().getWayTyp());
            	pWriter.println(player.getPlayerWeapon().getAmount());
            	pWriter.println(player.getPlayerWeapon().getDurability());
            	pWriter.println(player.getPlayerWeapon().getStrength());
            	pWriter.println(player.getPlayerWeapon().getEndurance());
            }
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } finally { 
            if (pWriter != null){ 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        }
	}

}
