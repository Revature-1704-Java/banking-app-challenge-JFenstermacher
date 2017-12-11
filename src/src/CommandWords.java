package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandWords {
	private static Set<String> validCommands = new HashSet<>(Arrays.asList("view", "open", "close", "deposit", "withdraw", 
																			"add", "exit", "balance", "help", "remove"));

	public CommandWords() { }
	
	public boolean isCommand(String aString) {
		return validCommands.contains(aString);
	}
	
	public void showAllCommands() {
		System.out.print("Valid commands : ");
		System.out.println(validCommands);
	}
}
