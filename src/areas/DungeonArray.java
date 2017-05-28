package areas;

import java.util.*;

public class DungeonArray 
{
	public static int[][] map(int etage)
	{
	// Liste für die Inhalte der Map
	List<Integer> createMap = new ArrayList<Integer>();
	// Ausgangsgroeße der Map
	int x = 3, y = 3;
	int count = 0;
	// Fuer jede neu erreichte etage wird die Ausgangsgroeße erhöht
	for(int d = 1; d < etage; d++)
	{
		x++;
		y++;
	}
	// 
	int fields = x*y;
	int empty;
	int monster;
	int treasure;
	double ratio = fields / 9;
	empty = 5 * (int) ratio;
	monster = 2 * (int) ratio;
	treasure = 2 * (int) ratio; 
	int[] createMapArray = new int[fields];
	int[][] cave = new int[x][y];
	for(int a =0; a<empty; a++)
		createMap.add(0);
	for(int b =0; b<treasure; b++)
		createMap.add(1);
	for(int c=0;c<monster;c++)
		createMap.add(2);
	
	Collections.shuffle(createMap);
	
	for(int i=0;i<createMap.size();i++)
	{
		createMapArray[i] = createMap.get(i);
	}
	
	for(int i=0;i<x;i++)
	{
		for(int j=0;j<y;j++)
		{
			if(count==fields)
				break;
			cave[i][j]=createMapArray[count];
			count++;
		}
	}
	return cave;
	}
}





