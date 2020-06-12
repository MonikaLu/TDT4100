package inheritance;

//TESTEN FUNKER P� DENNE

public class SavingsAccount implements Account {
	
	private double balance, interestRate;
	
//	Konstrukt�ren som tar inn rentefoten. �pningsbalansen er 0.
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		this.balance = 0; 		
	}
	
//	deposit metoden som throws IllegalArgumentException n�r innsettingsbel�pet er mindre enn null.
//	ellers kan bel�pet adderes til balansen.
	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("The amount needs to be positive.");
		}
		else {
			this.balance += amount;
		}
	}

//	hvis innsettingsbel�pet er mindre eller lik null, throws en illegalArgumentException
//	hvis innsettingsbel�pet er st�rre enn kontobalansen ==> throws illegalStateException
//	ellers trekke bel�pet fra kontobalansen.
	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("The amount needs to be positive!");
		}
		else if (amount > this.balance) {
			throw new IllegalStateException("You don't have enough money in the account.");
		}
		else {
			this.balance -= amount;
		}
		
	}

//	returnerer balansen. metoden brukes i subklassene for � hente inn balansen.
	@Override
	public double getBalance() {
		return this.balance;
	}
	
//	adderer rentebel�pet til balansen.
	protected void endYearUpdate() {
		this.balance += this.interestRate * this.balance;
	}

}
