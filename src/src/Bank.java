package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	ArrayList<Account> accounts;
	
	public Bank() {
		accounts = new ArrayList<>();
	}
	
	public void loadAccounts() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\loadFiles\\accounts.txt"))){
			while (true) accounts.add((Account) ois.readObject());
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
	}
	
	public void saveAccounts() {
		
		/*Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);*/
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\loadFiles\\accounts.txt"))){
			for (int i = 0; i < accounts.size(); i++) 
				oos.writeObject(accounts.get(i));
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void printAccounts() {
		if (accounts.size() == 0) 
			System.out.println("There are no accounts currently available");
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println((i + 1) +". " + accounts.get(i).getAccountOwner());
		}
	}
	
	public Account addAccount(String name) {
		
		Account tmp = new Account(name);
		accounts.add(tmp);
		
		return tmp;
	}
	
	public void withdrawMoney(Account acc) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How much would you like to withdraw? ");
		double money = 0;
		try {
			money = sc.nextDouble();
		} catch (Exception ex) {
			System.out.println("That wasn't an approrpiate amount of moneys.");
		}
		if (!acc.withdrawMoneys(money))
			System.out.println("You can't withdraw that amount of money");
	}
	
	public void depositMoney(Account acc) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How much would you like to deposit? ");
		double money = 0;
		try {
			money = sc.nextDouble();
		} catch (Exception ex) {
			System.out.println("That wasn't an appropriate amount of moneys.");
		}
		if (!acc.depositMoneys(money))
			System.out.println("Are you trying to bankrupt yourself?");
	}
	
	public Account openAccount(Scanner reader) {
		Account tmp = null;
		printAccounts();
		System.out.print("Which account number would you like to open? ");
		try {
			tmp = accounts.get(reader.nextInt() - 1);
			reader.nextLine();
		} catch (Exception ex) {
			System.out.println("That's an invalid number.");
		}
		
		if (tmp != null)
			System.out.println(tmp.getAccountOwner() + "'s account is now open.");
		
		return tmp;
	}
	
	public void deleteAccount(Scanner reader) {
		Account tmp = null;
		printAccounts();
		System.out.print("Which account number would you like to delete?");
		try {
			tmp = accounts.remove(reader.nextInt() - 1);
			reader.nextLine();
		} catch (Exception ex) {
			System.out.println("That's not a valid account number.");
		}
		
		if (tmp != null)
			System.out.println(tmp.getAccountOwner() + "'s account has been removed.");
	}
}
