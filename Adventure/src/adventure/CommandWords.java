package adventure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandWords {
	
	private static final Set<String> validCommands = new HashSet<>(Arrays.asList("move", "look", "quit", "help", "print"));
	private static final Set<String> validDirections = new HashSet<>(Arrays.asList("up", "down", "left", "right"));
	
	public CommandWords() { }
	
	public boolean isCommand(String aString) {
		return validCommands.contains(aString);
	}
	
	public boolean isDirection(String bString) {
		return validDirections.contains(bString);
	}
	
	public void showAllCommands() {
		System.out.print("Valid commands : ");
		System.out.println(validCommands);
	}
	
	public void showAllDirections() {
		System.out.print("Valid directions : ");
		System.out.println(validDirections);
	}
}
