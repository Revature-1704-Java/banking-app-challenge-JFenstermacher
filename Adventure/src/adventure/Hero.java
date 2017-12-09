package adventure;

public class Hero {
	private int posR;
	private int posC;
	private boolean hasPhone;
	private boolean isDizzy;
	
	public Hero() {}
	
	public Hero(int row, int col){
		posR = row;
		posC = col;
		isDizzy = false;
	}
	
	public int getPosR() {
		return posR;
	}
	
	public int getPosC() {
		return posC;
	}
	
	public boolean getDizzyState() {
		return isDizzy;
	}
	
	public boolean moveUp(Map m, Room[] rooms){
		int locInfo = m.checkUp(posR, posC);
		if (locInfo == 1){
			System.out.println("You moved up one square up in porty-potty maze");
			posR--;
		} else {
			m.updateVisited(posR - 1, posC);
			if (locInfo == 3) {
				System.out.println(rooms[locInfo].getMoveDesc());
				isDizzy = true;
			}
			else if (locInfo == 4){
				System.out.println(rooms[locInfo].getMoveDesc());
				posR = 4;
				posC = 1;
			} else if (locInfo == 5) {
				System.out.println(rooms[locInfo].getMoveDesc());
				hasPhone = true;
			} else if (locInfo == 6) {
				if (hasPhone == true) {
					System.out.println(rooms[locInfo].getMoveDesc());
					return true;
				} else {
					System.out.println("You forgot your phone! You can't leave yet. (Unless you type QUIT)");
				}
			} else {
				System.out.println(rooms[locInfo].getMoveDesc());
			}
		}
		
		m.updateVisited(posR, posC);
		
		return false;
	}
	
	public boolean moveDown(Map m, Room[] rooms){
		int locInfo = m.checkDown(posR, posC);
		if (locInfo == 1){
			System.out.println("You moved down one square up in porty-potty maze");
			posR++;
		} else {
			m.updateVisited(posR + 1, posC);
			if (locInfo == 3) {
				System.out.println(rooms[locInfo].getMoveDesc());
				isDizzy = true;
			}
			else if (locInfo == 4){
				System.out.println(rooms[locInfo].getMoveDesc());
				posR = 4;
				posC = 1;
			} else if (locInfo == 5) {
				System.out.println(rooms[locInfo].getMoveDesc());
				hasPhone = true;
			} else if (locInfo == 6) {
				if (hasPhone == true) {
					System.out.println(rooms[locInfo].getMoveDesc());
					return true;
				} else {
					System.out.println("You forgot your phone! You can't leave yet. (Unless you type QUIT)");
				}
			} else {
				System.out.println(rooms[locInfo].getMoveDesc());
			}
		}
		
		m.updateVisited(posR, posC);
		
		return false;
	}
	
	public boolean moveLeft(Map m, Room[] rooms){
		int locInfo = m.checkLeft(posR, posC);
		if (locInfo == 1){
			System.out.println("You moved left one square up in porty-potty maze");
			posC--;
		} else {
			m.updateVisited(posR, posC - 1);
			if (locInfo == 3) {
				System.out.println(rooms[locInfo].getMoveDesc());
				isDizzy = true;
			}
			else if (locInfo == 4){
				System.out.println(rooms[locInfo].getMoveDesc());
				posR = 4;
				posC = 1;
			} else if (locInfo == 5) {
				System.out.println(rooms[locInfo].getMoveDesc());
				hasPhone = true;
			} else if (locInfo == 6) {
				if (hasPhone == true) {
					System.out.println(rooms[locInfo].getMoveDesc());
					return true;
				} else {
					System.out.println("You forgot your phone! You can't leave yet. (Unless you type QUIT)");
				}
			} else {
				System.out.println(rooms[locInfo].getMoveDesc());
			}
		}
		
		m.updateVisited(posR, posC);
		
		return false;
	}
	
	public boolean moveRight(Map m, Room[] rooms){
		int locInfo = m.checkRight(posR, posC);
		if (locInfo == 1){
			System.out.println("You moved right one square up in porty-potty maze");
			posC++;
		} else {
			m.updateVisited(posR, posC + 1);
			if (locInfo == 3) {
				System.out.println(rooms[locInfo].getMoveDesc());
				isDizzy = true;
			}
			else if (locInfo == 4){
				System.out.println(rooms[locInfo].getMoveDesc());
				posR = 4;
				posC = 1;
			} else if (locInfo == 5) {
				System.out.println(rooms[locInfo].getMoveDesc());
				hasPhone = true;
			} else if (locInfo == 6) {
				if (hasPhone == true) {
					System.out.println(rooms[locInfo].getMoveDesc());
					return true;
				} else {
					System.out.println("You forgot your phone! You can't leave yet. (Unless you type QUIT)");
				}
			} else {
				System.out.println(rooms[locInfo].getMoveDesc());
			}
		}
		
		m.updateVisited(posR, posC);
		
		return false;
	}
	
	public void lookUp(Map m, Room[] rooms){
		int locInfo = m.checkUp(posR, posC);
		m.updateVisited(posR - 1, posC);
		System.out.println(rooms[locInfo].getLookDesc());
	}
	
	public void lookDown(Map m, Room[] rooms){
		int locInfo = m.checkDown(posR, posC);
		m.updateVisited(posR + 1, posC);
		System.out.println(rooms[locInfo].getLookDesc());
	}
	
	public void lookLeft(Map m, Room[] rooms){
		int locInfo = m.checkLeft(posR, posC);
		m.updateVisited(posR, posC - 1);
		System.out.println(rooms[locInfo].getLookDesc());
	}
	
	public void lookRight(Map m, Room[] rooms){
		int locInfo = m.checkRight(posR, posC);
		m.updateVisited(posR, posC + 1);
		System.out.println(rooms[locInfo].getLookDesc());
	}
}
