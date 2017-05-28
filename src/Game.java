import procedure.*;
import creatures.Player;
import java.io.FileNotFoundException;
import java.io.IOException;

import areas.DungeonArray;



public class Game {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Console clearen um vergangene Ausgaben verschwinden zu lassen
		// TODO Anpassung der Map durch hoehe und tiefe
		// TODO Use Traenke etc im Kampf
		// TODO Uebertragung von Gold zwischen Monster und Player
		// TODO Fenster erstellen mit ausgabe des Consolen textes 
		// TODO Fenster gibt bild aus
		// TODO fenster gibt mehrere Bilder aus Tilemap
		// TODO Bewegen des Spielers über die Tilemap
		texts.welcome();
		Player test = newGame.charSelect();
		tavern.inSide(test);
		
		
	}
}
