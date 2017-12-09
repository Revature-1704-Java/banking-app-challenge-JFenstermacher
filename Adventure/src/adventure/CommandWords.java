package adventure;

public class CommandWords {
	private static final String[] validCommands = { "move", "look", "quit", "help", "print" };
	

	private static final String[] validDirections = { "up", "down", "left", "right" };
	
	public CommandWords() { }
	
	public boolean isCommand(String aString) {
		for (int i = 0 ; i < validCommands.length; i++) {
			if (validCommands[i].equals(aString)) return true;
		}
		
		return false;
	}
	
	public boolean isDirection(String bString) {
		for (int i = 0; i < validDirections.length; i++) {
			if (validDirections[i].equals(bString)) return true;
		}
		
		return false;
	}
	
	public void showAll() {
		System.out.print("Valid commands : ");
		for (String command : validCommands) {
			System.out.print(command + " ");
		}
		
		System.out.println();
	}
	
	public void showAllDirections() {
		System.out.print("Valid directions : ");
		for (String dir : validDirections) {
			System.out.print(dir + " ");
		}
		
		System.out.println();
	}
} //This is bummed from Mehrab
