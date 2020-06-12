package inheritance;

public class ForeldreSpar extends SavingsAccount {
	
//	antall uttak, og antall uttak igjen.
	private int withdrawals, remainingWithdrawals;

//	konstruktøren tar inn rentefoten og antall lovlige uttak per år
	public ForeldreSpar(double interestRate, int withdrawals) {
		super(interestRate);
		this.withdrawals = withdrawals;
		this.remainingWithdrawals = this.withdrawals;
	}
	
//	om resterende antall uttak er større enn null, skal uttaket være gyldig
//	trekker samtidig 1 uttak fra resterende uttak
//	utløser ellers en illegalStateException
	public void withdraw(double amount) {
		if (remainingWithdrawals > 0) {
			super.withdraw(amount);
			remainingWithdrawals--;
		}
		else {
			throw new IllegalStateException("No more remaining withdrawals");
		}
		
	}
	
//	metoden fra superklassen
//	resetter antall resterende uttak ved å gjøre det likt som antall lovlige uttak.
	public void endYearUpdate() {
		super.endYearUpdate();
		this.remainingWithdrawals = this.withdrawals;
	}
	
//	returnerer antall resterende uttak.
	public int getRemainingWithdrawals() {
		return this.remainingWithdrawals;
	}

}
