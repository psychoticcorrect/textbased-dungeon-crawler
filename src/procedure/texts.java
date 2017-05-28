package procedure;

public class texts {
	
	//Variablen
	
	//Konstruktoren
	public texts(){
		
	}

	//Methoden
	public static void welcome(){
		System.out.printf("+-------------------------------------------------------+%n");
		System.out.printf("+Hallo Spieler                                          +%n");
		System.out.printf("+Willkommen zu \"The World\"                              +%n");
		System.out.printf("+Fuer neues Spiel \"neu\" eintippen                       +%n");
		System.out.printf("+oder \"weiter\" um einen bisherigen Spielstand zu laden  +%n");
		System.out.printf("+-------------------------------------------------------+%n");

	}
	public static void choose(){
		System.out.printf("+-------------------------------------------------------+%n");
		System.out.printf("+Bitte waehle eine Klasse                               +%n");
		System.out.printf("+Fuer Krieger \"1\" tippen                                +%n");
		System.out.printf("+Fuer Magier \"2\" tippen                                 +%n");
		System.out.printf("+Fuer Bogenschuetze \"3\" tippen                          +%n");
		System.out.printf("+-------------------------------------------------------+%n");
	}
}
