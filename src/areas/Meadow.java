package areas;

import creatures.*;

import monsterAppears.fighting;

public class Meadow extends Area{
	//Variablen
	static int monsterLevel = zufall.nextInt(6)+1;
	//Konstruktoren
	public Meadow(){
		
	}
	//Methoden
	public static void warten(Player player){
		do{
			int cubeWorld = 3; //zufall.nextInt(5)+1;
			switch(cubeWorld){
			case 1:
				System.out.printf("Es wurde eine %d gewuerfelt%n", cubeWorld);
				break;
			case 2:
				System.out.printf("Es wurde eine %d gewuerfelt%n", cubeWorld);
				System.out.printf("Es passiert nichts%n");
				day++;
				count++;
				break;
			case 4:
				System.out.printf("Es wurde eine %d gewuerfelt%n", cubeWorld);
				System.out.printf("Es passiert nichts%n");
				day++;
				count++;
				break;
			case 5:
				System.out.printf("Es wurde eine %d gewuerfelt%n", cubeWorld);
				break;
			case 3:
			case 6:
				System.out.printf("Es wurde eine %d gewuerfelt%n", cubeWorld);
				//Monster random angepasst an das jeweilige Gebiet
				System.out.printf("Ein Monster erscheint%n");
				Monster Test = new Monster("Raufbold","Dieb",monsterLevel,1+(monsterLevel/2),1+(monsterLevel/2));
				Test.setExp(10);
				System.out.printf("Ein Monster namens: %s erscheint%n"
						+ "Das Monster wuerde %d Erfahrung bringen%n", Test.getName(),Test.getExpByWin());
				fighting.fight(player,Test);
				day++;
				count = 0;
				break;
			default:
				break;
			}
			if(count == 3){
				//Fee oder Truhe Methode 
			}
		}while(day < 3);
		System.out.print("Es ist spaet geworden Zeit nach Hause zu gehen.");
	}
}
