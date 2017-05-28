package procedure;

import java.awt.*;

import javax.swing.*;

import areas.DungeonArray;
import creatures.Player;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Container dieses Frames
	Container c;
	//	Label, das im Frame erscheinen soll
	JLabel lab;
	//	Array fuer Dungeon
	int[][] cave;

	//	Variablen
	
	//	Konstruktoren
public Window(Player player,int cave[][]){
	//	Container bestimmen
		c = getContentPane();
		// Layout setzen
		c.setLayout(new GridLayout(cave[0].length, cave[1].length));
		
		//	Bildobjekt erzeugen
			Icon floor = new ImageIcon("0.png");
			Icon treasure = new ImageIcon("1.png");
			Icon monster = new ImageIcon("2.png");
			Icon hero = new ImageIcon("mage.png");
		//	Titel des Fensters
		setTitle("The Quest");
		
		/*	Das JFrame so einstellen, dass das
		 * 	Programm beim Schließen des JFrames
		 * 	beendet wird
		 */
		setDefaultCloseOperation
		(JFrame.EXIT_ON_CLOSE);
		
		
		// Label für Bild
		//	lab = new JLabel( JLabel.CENTER);
		//	Fuege das Label dem Frame hinzu
		//  c.add(lab);
		//	Groesse wird automatisch angepasst
		pack();
		//	Groesse wird auf 200 mal 200 festegelegt
		setSize(300,200);
		//	Die Position einstellen
		setLocation(50, 50);
		// Das JFrame anzeigen
		setVisible(true);
		// TODO von Array zu Map 
		int xAxis = cave[0].length;
		int yAxis = cave[1].length;
		int i = 0;
		JLabel labels[][] = new JLabel[cave[0].length ][cave[1].length];
		
		for(int spalte0=0;spalte0<xAxis;spalte0++)
			for(int zeile0=0;zeile0<yAxis;zeile0++)
			{
				
				
				
					
					if(cave[spalte0][zeile0] == 0)
					{
					labels[spalte0][zeile0] = new JLabel(floor, JLayeredPane.DEFAULT_LAYER);
					c.add(labels[spalte0][zeile0]);
					}
					else if(cave[spalte0][zeile0] == 1)
					{
						labels[spalte0][zeile0] = new JLabel(treasure, JLayeredPane.DEFAULT_LAYER);
						c.add(labels[spalte0][zeile0]);	
					}
					else
					{
						labels[spalte0][zeile0] = new JLabel(monster, JLayeredPane.DEFAULT_LAYER);
						c.add(labels[spalte0][zeile0]);
					}
			}
		entrance:
			for(int spalte0=0;spalte0<=xAxis;spalte0++)
				for(int zeile0=0;zeile0<=yAxis;zeile0++)
				{
					if(cave[spalte0][zeile0]==0)
					{
						player.setPosX(spalte0);
						player.setPosY(zeile0);
						System.out.printf("Der Spieler steht auf X: %d Y: %d%n",
								player.getPosX(), player.getPosY());
						labels[spalte0][zeile0] = new JLabel(hero, JLayeredPane.PALETTE_LAYER);
						labels[spalte0][zeile0].setHorizontalAlignment(JLabel.CENTER);
						c.add(labels[spalte0][zeile0]);
						break entrance;
					}
					
				}
		
	}
	//	Methoden
	
}
