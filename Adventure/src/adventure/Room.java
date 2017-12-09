package adventure;

public class Room {
	private String moveDesc;
	private String lookDesc;
	
	public Room(){
		moveDesc = "Dunno";
		lookDesc = "Huh?";
	}
	
	public void setMoveDesc(String moveDesc){
		this.moveDesc = moveDesc;
	}
	
	public String getMoveDesc(){
		return moveDesc;
	}
	
	public void setLookDesc(String lookDesc){
		this.lookDesc = lookDesc;
	}
	
	public String getLookDesc(){
		return lookDesc;
	}
}
