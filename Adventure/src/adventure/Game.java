package adventure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Parser parser;
	private ArrayList<Room> rooms;
	private Map map;
	private Hero hero;
	
	public static void main(String[] args) {
		Game game = new Game();
		
		
		//game.readRoomsFromFile();
		//game.saveRooms();
		game.loadRooms();
		//game.printRooms();
		//game.saveHero();
		//game.saveMap();
		//game.loadMap();
		//game.loadHero();
		
		game.play();
	}
	
	public Game() {
		rooms = new ArrayList<>();
		parser = new Parser();
		hero = new Hero((short) 4, (short) 1);
		map = new Map();
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
	
	private void readRoomsFromFile(){
		try {
			Scanner sc = new Scanner(new FileReader("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\rooms.txt"));
			int roomCount = sc.nextInt();
			
			for (int i = 0; i < roomCount; i++) {
				Room tmp = new Room();
				int descCount = sc.nextInt();
				sc.nextLine();
				for (int j = 0; j < descCount; j++) {
					String desc = sc.nextLine();
					tmp.addMoveDesc(desc);
				}
				descCount = sc.nextInt();
				sc.nextLine();
				for (int j = 0; j < descCount; j++) {
					String desc = sc.nextLine();
					tmp.addLookDesc(desc);
				}
				
				rooms.add(tmp);
			}
			
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void printFile() {
		try {
			Scanner sc = new Scanner(new FileReader("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\rooms.txt"));
			
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			//System.out.println("Hello");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void printRooms() {
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i).getLookDesc());
			System.out.println(rooms.get(i).getMoveDesc());
		}
	}
	
	private void saveRooms() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\roomObjs.txt"))){
			for (int i = 0; i < rooms.size(); i++) oos.writeObject(rooms.get(i));
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void loadRooms() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\roomObjs.txt"))){
			while (true) { 
				Room room = (Room) ois.readObject();
				rooms.add(room);
			}
		}catch (Exception ex){
			//ex.printStackTrace();
		}
	}
	
	private void saveMap() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\mapObj.txt"))){
			oos.writeObject(map);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void loadMap() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\mapObj.txt"))){
			map = (Map) ois.readObject();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void saveHero() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\heroObj.txt"))){
			oos.writeObject(hero);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void loadHero() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\JFens\\Programs\\Core\\Adventure\\src\\read\\heroObj.txt"))){
			hero = (Hero) ois.readObject();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	private boolean processCommand (Command command) {
		boolean winFlag = false;
		
		if (command.isUnknown()) {
			System.out.println("English, do you speak it?");
			return false;
		}
		
		String commandWord = command.getCommandWord();
		
		short heroRow = hero.getRow(), heroCol = hero.getCol();

		if (commandWord.equals("move")) {
			String direction = command.getSecondWord();
			switch (direction) {
				case "up" :
					if (hero.getDizzyState()) {
						short down = map.checkDown(heroRow, heroCol);
						winFlag = hero.moveDown(down, rooms.get(down));
					} else {
						short up = map.checkUp(heroRow, heroCol);
						winFlag = hero.moveUp(up, rooms.get(up));
					}
					break;
				case "down" :
					if (hero.getDizzyState()) {
						short up = map.checkUp(heroRow, heroCol);
						winFlag = hero.moveUp(up, rooms.get(up));
					} else {
						short down = map.checkDown(heroRow, heroCol);
						winFlag = hero.moveDown(down, rooms.get(down));
					}
					break;
				case "left" :
					if (hero.getDizzyState()) {
						short right = map.checkRight(heroRow, heroCol);
						winFlag = hero.moveRight(right, rooms.get(right));
					} else {
						short left = map.checkLeft(heroRow, heroCol);
						winFlag = hero.moveLeft(left, rooms.get(left));
					}
					break;
				case "right" :
					if (hero.getDizzyState()) {
						short left = map.checkLeft(heroRow, heroCol);
						winFlag = hero.moveLeft(left, rooms.get(left));
					} else {
						short right = map.checkRight(heroRow, heroCol);
						winFlag = hero.moveRight(right, rooms.get(right));
					}
					break;
				default :
					System.out.println("You moved which way?");
					break;
			}
			
		} else if (commandWord.equals("look")) {
			String direction = command.getSecondWord();
			switch (direction) {
				case "up" :
					if (hero.getDizzyState()) { 
						short down = map.checkDown(heroRow, heroCol);
						hero.look(down, rooms.get(down));
					} else { 
						short up = map.checkUp(heroRow, heroCol);
						hero.look(up, rooms.get(up));
					}
					break;
				case "down" :
					if (hero.getDizzyState()) {
						short up = map.checkUp(heroRow, heroCol);
						hero.look(up, rooms.get(up));
					} else {
						short down = map.checkDown(heroRow, heroCol);
						hero.look(down, rooms.get(down));
					}
					break;
				case "left" :
					if (hero.getDizzyState()) {
						short right = map.checkRight(heroRow, heroCol);
						hero.look(right, rooms.get(right)); 
					} else { 
						short left = map.checkLeft(heroRow, heroCol);
						hero.look(left, rooms.get(left));
					}
					break;
				case "right" :
					if (hero.getDizzyState()) { 
						short left = map.checkLeft(heroRow, heroCol);
						hero.look(left, rooms.get(left));
					} else{
						short right = map.checkRight(heroRow, heroCol);
						hero.look(right, rooms.get(right));
					}
					break;
				default : 
					System.out.println("You looked where?");
			}
		} else if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("print")) {
			map.printVisited(hero.getRow(), hero.getCol());
		} else return true;
		
		return winFlag ? true : false;
	}
	
	private void printHelp() {
		System.out.println("You look to the sky in desperation.");
		System.out.println("The clouds begin to move, and they arrange themselves in a set of words.");
		System.out.println();
		parser.showCommands();
	}
}
