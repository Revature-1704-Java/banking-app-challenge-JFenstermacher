package adventure;

public class Game {
	private Parser parser;
	private Room[] rooms = new Room[7];
	private Map map = new Map();
	private Hero you;
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.play();
	}
	
	public Game() {
		createRooms();
		parser = new Parser();
		you = new Hero(4, 1);
	}
	
	public void play(){
		printWelcome();
		System.out.println();
		
		boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
		
	}
	
	private void printWelcome(){
		System.out.println("Welcome to Jonathan's shitty text adventure!");
		System.out.println("You'll be navigating your way through a porty-potty maze in search of your phone, and then the exit.");
		System.out.println("Good luck adventurer!");
	}
	
	private void createRooms(){
		for (int i = 0; i < 7; i++) {
			rooms[i] = new Room();
		}
		rooms[0].setMoveDesc("You bump into a locked porty-potty. Maybe you should look before you move next time...");
		rooms[0].setLookDesc("Looks to be a locked porty-potty.");
		
		rooms[1].setMoveDesc("You moved into an empty hallway square.");
		rooms[1].setLookDesc("Looks to be an empty hallway square (the sort you can move into).");
		
		rooms[2].setMoveDesc("Porty-potties are usually for one. Would you really want do this, wierdo?");
		rooms[2].setLookDesc("The porty-potty door is open. There's a man passed out in a rabbit costume.");
		
		rooms[3].setMoveDesc("You stumble back out of the porty-potty. The putrid smell has made you dizzy.");
		rooms[3].setLookDesc("You open the door of the porty-potty before you. Every bare surface of this porty-potty is covered in feces.");
		
		rooms[4].setMoveDesc("You open the door and attempt to step inside the porty potty with her. She cases you away, and you're returned back to where you started. Well deserved, pervert.");
		rooms[4].setLookDesc("You open the door of the porty-potty before you. Angry eyes and a quick handed coverup greet you, there's a woman in the stall. You quickly close the door.");
		
		rooms[5].setMoveDesc("You retrieve your phone, and step back out.");
		rooms[5].setLookDesc("You open the door to the porty-potty before you. Before you lies the object of your desire, your phone!");
		
		rooms[6].setMoveDesc("FREEDOM!");
		rooms[6].setLookDesc("The exit from this smelly land lies before you");
	}
	
	private boolean processCommand (Command command) {
		boolean winFlag = false;
		
		if (command.isUnknown()) {
			System.out.println("English, do you speak it?");
			return false;
		}
		
		String commandWord = command.getCommandWord();
		
		if (commandWord.equals("move")) {
			String dir = command.getSecondWord();
			if (dir.equals("up")) winFlag = you.getDizzyState() ? you.moveDown(map, rooms) : you.moveUp(map, rooms);
			else if (dir.equals("down")) winFlag = you.getDizzyState() ? you.moveUp(map, rooms) : you.moveDown(map,  rooms);
			else if (dir.equals("left")) winFlag = you.getDizzyState() ? you.moveRight(map, rooms) : you.moveLeft(map, rooms);
			else if (dir.equals("right")) winFlag = you.getDizzyState() ? you.moveLeft(map, rooms) : you.moveRight(map, rooms);
			else System.out.println("You went nowhere, that wasn't an appropriate direction.");
			
		} else if (commandWord.equals("look")) {
			String dir = command.getSecondWord();
			if (dir.equals("up")) you.lookUp(map, rooms);
			else if (dir.equals("down")) you.lookDown(map,  rooms);
			else if (dir.equals("left")) you.lookLeft(map, rooms);
			else if (dir.equals("right")) you.lookRight(map, rooms);
			else System.out.println("I don't know what that means boss.");
		} else if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("print")) {
			map.printVisited(you.getPosR(), you.getPosC());
		} else return true;
		
		return winFlag ? true : false;
	}
	
	private void printHelp() {
		System.out.println("You look to the sky in desperation.");
		System.out.println("The clouds begin to move, and they arrange themselves in a set of words.");
		System.out.println();
		parser.showCommands();
		parser.showDirections();
	}
}
