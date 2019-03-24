package application;

public class Account {

	private String accountNumber = "1234";
	private double balance= 0.0;
	
	public Account( int accountNumber ) {
		
		this.accountNumber = Integer.toString(accountNumber);
		
	}
 public Account() {
	
}
	public Account( int accountNumber, double balance ) {
		
		this.accountNumber = Integer.toString(accountNumber);
		this.balance = balance;	
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	 public String toString() {
	    return String.format("Balance=%.2f", balance);

	}
	 public void deposit(double amount){	balance+=amount;
		
	 } 

	public void withdraw(double amount) {
	 
	       balance -= amount;
	    }
	 
}
