package src;

import java.io.Serializable;

public class Account implements Serializable, Accounts{
	private static final long serialVersionUID = 1L;
	private String accountOwner;
	private double moneys;
	
	public Account() {}
	
	public Account(String accountOwner) {
		this.accountOwner = accountOwner;
		this.moneys = 0;
	}
	
	public Account(String accountOwner, double moneys) {
		this.accountOwner = accountOwner;
		this.moneys = moneys;
	}
	
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	
	public String getAccountOwner() {
		return accountOwner;
	}
	
	public void setMoneys(double moneys) {
		this.moneys = moneys;
	}
	
	public double getMoneys() {
		return moneys;
	}
	
	public boolean depositMoneys(double moneys) {
		if (moneys < 0) 
			return false;
		
		this.moneys += moneys;
		
		return true;
	}
	
	public boolean withdrawMoneys(double moneys) {
		if (this.moneys < moneys || moneys < 0)
			return false;
		else
			moneys -= moneys;
		
		return true;
	}
}
