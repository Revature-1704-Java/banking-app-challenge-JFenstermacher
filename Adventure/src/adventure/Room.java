package adventure;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> moveDescriptions;
	private ArrayList<String> lookDescriptions;
	
	public Room(){
		moveDescriptions = new ArrayList<>();
		lookDescriptions = new ArrayList<>();
	}
	
	public void addMoveDesc(String moveDesc){
		this.moveDescriptions.add(moveDesc);
	}
	
	public String getMoveDesc(){
		int randomIndex = (int) (Math.random() * moveDescriptions.size());
		return moveDescriptions.get(randomIndex);
	}
	
	public String getMoveDesc(int index) {
		return index < moveDescriptions.size() ? moveDescriptions.get(index) : "Index not available";
	}
	
	public void addLookDesc(String lookDesc){
		this.lookDescriptions.add(lookDesc);
	}
	
	public String getLookDesc(){
		int randomIndex = (int) (Math.random() * moveDescriptions.size());
		return lookDescriptions.get(randomIndex);
	}
	
	public String getLookDesc(int index) {
		return index < lookDescriptions.size() ? lookDescriptions.get(index) : "Index not available";
	}
	
}
