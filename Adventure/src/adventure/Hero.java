package adventure;

import java.io.Serializable;

public class Hero implements Serializable{
	private static final long serialVersionUID = 1L;
	private short row;
	private short col;
	private boolean hasPhone, isDizzy, isConfused;
	
	public Hero() {}
	
	public Hero(short row, short col){
		this.row = row;
		this.col = col;
	}
	
	public short getRow() {
		return row;
	}
	
	public short getCol() {
		return col;
	}
	
	public boolean getDizzyState() {
		return isDizzy;
	}
	
	public boolean getPhoneState() {
		return hasPhone;
	}
	
	public boolean isConfused() {
		return isConfused;
	}
	
	public boolean moveUp(short locInfo, Room room){
		boolean winFlag = false;
		if (locInfo == 1){
			System.out.println("You moved up one square up in porty-potty maze");
			this.row--;
		} else {
			winFlag = interactRoom(locInfo, room);
		}
		
		return winFlag;
	}
	
	public boolean moveDown(short locInfo, Room room){
		boolean winFlag = false;
		if (locInfo == 1){
			System.out.println("You moved down one square up in porty-potty maze");
			this.row++;
		} else {
			winFlag = interactRoom(locInfo, room);
		}
		
		return winFlag;
	}
	
	public boolean moveLeft(short locInfo, Room room){
		boolean winFlag = false;
		if (locInfo == 1){
			System.out.println("You moved left one square up in porty-potty maze");
			this.col--;
		} else {
			winFlag = interactRoom(locInfo, room);
		}
		
		return winFlag;
	}
	
	public boolean moveRight(short locInfo, Room room){
		boolean winFlag = false;
		if (locInfo == 1){
			System.out.println("You moved right one square up in porty-potty maze");
			this.col++;
		} else {
			winFlag = interactRoom(locInfo, room);
		}
		
		return winFlag;
	}
	
	public void look(short locInfo, Room room){
		System.out.println(room.getLookDesc());
	}
	
	private boolean interactRoom(short locInfo, Room room) {
		boolean winFlag = false;
		switch (locInfo) {
			case 3 : 
				this.isDizzy = true;
				System.out.println(room.getMoveDesc());
				break;
			case 4 :
				this.row = 4;
				this.col = 1;
				System.out.println(room.getMoveDesc());
				break;
			case 5 :
				this.hasPhone = true;
				System.out.println(room.getMoveDesc());
				break;
			case 6 :
				if (getPhoneState()) {
					winFlag = true;
					System.out.println(room.getMoveDesc());
				} else {
					System.out.println("You forgot your phone! You can't leave yet. (Unless you type QUIT)");
				}
				break;
			default :
				System.out.println(room.getMoveDesc());
		}
		
		return winFlag;
	}
}
