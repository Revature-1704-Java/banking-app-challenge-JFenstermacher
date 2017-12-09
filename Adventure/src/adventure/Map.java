package adventure;

public class Map {
	private int[][] map;
	private boolean[][] visited = new boolean[7][5];
	private int startRow = 4;
	private int startCol = 1;
	
	public Map(){
		visited[4][1] = true;
		
		int[][] arr = { {0,0,0,6,0}, {0,0,0,1,4}, {0,2,0,1,0}, {3,1,1,1,0}, {0,1,0,1,0}, 
						{0,0,0,1,0}, {0,0,0,5,0} };
		
		map = arr;
		
		/*Scanner sc = new Scanner("map1.txt");
		
		String nL = "";
		
		for (int i = 0; sc.hasNextLine() == true; i++){
			nL = sc.nextLine();
			
			for (int j = 0; j < nL.length(); j++){
				int roomVal = nL.charAt(j) - '0';
				map[i][j] = roomVal;
			}
		}
		
		sc.close();*/
	}
	
	public int checkLeft(int r, int c){
		return map[r][c - 1];
	}
	
	public int checkRight(int r, int c){
		return map[r][c + 1];
	}
	
	public int checkUp(int r, int c){
		return map[r - 1][c];
	}
	
	public int checkDown(int r, int c){
		return map[r + 1][c];
	}
	
	public void updateVisited(int r, int c){
		visited[r][c] = true;
	}
	
	public void printMap(){
		for (int i = 0; i < 7; i++){
			for (int j = 0; j < 5; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printVisited(int currRow, int currCol){
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == false) System.out.print("? ");
				else if (i == currRow && j == currCol) System.out.print("C ");
				else if (i == startRow && j == startCol) System.out.print("S ");
				else System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}
