package inheritance;

//TESTEN FUNKER PÅ DENNE

public class SavingsAccount implements Account {
	
	private double balance, interestRate;
	
//	Konstruktøren som tar inn rentefoten. åpningsbalansen er 0.
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		this.balance = 0; 		
	}
	
//	deposit metoden som throws IllegalArgumentException når innsettingsbeløpet er mindre enn null.
//	ellers kan beløpet adderes til balansen.
	@Override
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("The amount needs to be positive.");
		}
		else {
			this.balance += amount;
		}
	}

//	hvis innsettingsbeløpet er mindre eller lik null, throws en illegalArgumentException
//	hvis innsettingsbeløpet er større enn kontobalansen ==> throws illegalStateException
//	ellers trekke beløpet fra kontobalansen.
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

//	returnerer balansen. metoden brukes i subklassene for å hente inn balansen.
	@Override
	public double getBalance() {
		return this.balance;
	}
	
//	adderer rentebeløpet til balansen.
	protected void endYearUpdate() {
		this.balance += this.interestRate * this.balance;
	}

}
