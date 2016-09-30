public class Account {

	private int accountNumber;
	private double balance = 0.0;
	public double amount;

	public Account (int accountNumber, double balance) {
	//Do something
	}
	
	public Account (int accountNumber) {
	//Do something
	}

	public int getAccountNumber () {
		return accountNumber;
	}

	public double getBalance () {
		return balance;
	}

	public void setBalance (double balance) {
	if(balance < 0){
			throw new IllegalArgumentException("Invalid Balance!");

		} 
		this.balance = balance;
	}

	public void credit (double amount) {
		this.balance = balance + amount;
	}

	public void debit (double amount) {
		if (balance >= amount) {
			this.balance = balance - amount;
		} else {
			System.out.println("amount withdrawn exceeds the current balance!");
		}
	}

	public String toString() {
		return String.format("A/C no:%02d, Balance = $ %02d", accountNumber, balance);
	}

}