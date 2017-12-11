package src;

import java.util.ArrayList;

public class App {
	private Bank bank;
	private Parser parser;
	private Account currAcc;
	
	public App() {
		bank = new Bank();
		parser = new Parser();
		bank.loadAccounts();
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		app.runApp();
	}
	
	public void runApp() {
		
		boolean exitFlag = false;
		
		 while (!exitFlag) {
	            Command command = parser.getCommand();
	            exitFlag = processCommand(command);
	     }
		 
		 System.out.println("Thank you for stopping by.");
		 
		 bank.saveAccounts();
	}
	
	private boolean processCommand (Command command) {
		boolean exitFlag = false;
		
		if (command.isUnknown()) {
			System.out.println("Do not recognize command. Please try again.");
			return false;
		}
		
		String commandWord = command.getCommandWord();
		
		switch(commandWord) {
			case "view" :
				bank.printAccounts();
				break;
			case "open" :
				currAcc = bank.openAccount(parser.getScanner());
				break;
			case "close" :
				System.out.println("Closed " + currAcc.getAccountOwner() + "'s account. No account is currently open");
				currAcc = null;
				break;
			case "deposit" :
				if (currAcc != null)
					bank.depositMoney(currAcc);
				else
					System.out.println("Please open an account before attempting to deposit");
				break;
			case "withdraw" :
				if (currAcc != null)
					bank.withdrawMoney(currAcc);
				else
					System.out.println("Please open an account before attempting to withdraw");
				break;
			case "add" :
				if (command.hasSecondWord()) {
					currAcc = bank.addAccount(command.getSecondWord().trim());
				} else {
					String name = parser.getName();
					currAcc = bank.addAccount(name);
				}
				System.out.println(currAcc.getAccountOwner() + "'s account has been added");
				break;
			case "delete" :
				bank.printAccounts();
				bank.deleteAccount(parser.getScanner());
			case "balance" :
				if (currAcc != null)
					System.out.printf( "%s's current balance is %.2f.\n", currAcc.getAccountOwner(), currAcc.getMoneys());
				else
					System.out.println("Open an account to view the balance.");
				break;
			case "help" :
				parser.showCommands();
				break;
			case "exit" :
				exitFlag = true;
				break;
			default :
				System.out.println("Something's wrong");
		}
		
		return exitFlag;
	} 
	
	
}
