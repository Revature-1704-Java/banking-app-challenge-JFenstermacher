package src;

public interface Accounts {
	
	public void setAccountOwner(String name);
	public String getAccountOwner();
	public void setMoneys(double moneys);
	public double getMoneys();
	public boolean depositMoneys(double moneys);
	public boolean withdrawMoneys(double moneys);
}
