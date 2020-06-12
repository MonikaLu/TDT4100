package stateandbehavior;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		this.balance = balance;
		if (balance < 0) {
			throw new IllegalArgumentException("Startbeløpet må være positivt.\n" + balance + " er derfor ikke gyldig!");
		}
		this.interestRate = interestRate;
		if (interestRate < 0) {
			throw new IllegalArgumentException("Renten kan ikke være negativ");
		}
		}
	
	public void deposit(double innskudd) {
		if (innskudd < 0) {
			throw new IllegalArgumentException("Tallet må være positivt, fikk istedenfor: " + innskudd);
		}
		else {
			this.balance += innskudd;
		}
	}
	
	public void setInterestRate(double newRate) {
		this.interestRate = newRate;
	}
	
	public void addInterest() {
		double renteinnskudd = (this.interestRate/100) * this.balance;
		this.balance += renteinnskudd;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void withdraw(double uttak) {
		if (uttak >= 0) {
			this.balance -= uttak;
		}
		else {
			throw new IllegalArgumentException("Du må skrive inn et positivt tall!");
		}
	}
	
	@Override
	public String toString() {
		String l1 = "\nBalance: " + this.balance;
		String l2 = "\nInterestRate: " + this.interestRate + "%";
		return l1 + l2;
	}
	
	public static void main(String[] args) {
		Account test1 = new Account();
		test1.deposit(5000);
		test1.setInterestRate(20.5);
		test1.addInterest();
		test1.withdraw(250.6);
		System.out.println(test1);
	}
}
