package inheritance;

public class ForeldreSpar extends SavingsAccount {
	
//	antall uttak, og antall uttak igjen.
	private int withdrawals, remainingWithdrawals;

//	konstrukt�ren tar inn rentefoten og antall lovlige uttak per �r
	public ForeldreSpar(double interestRate, int withdrawals) {
		super(interestRate);
		this.withdrawals = withdrawals;
		this.remainingWithdrawals = this.withdrawals;
	}
	
//	om resterende antall uttak er st�rre enn null, skal uttaket v�re gyldig
//	trekker samtidig 1 uttak fra resterende uttak
//	utl�ser ellers en illegalStateException
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
//	resetter antall resterende uttak ved � gj�re det likt som antall lovlige uttak.
	public void endYearUpdate() {
		super.endYearUpdate();
		this.remainingWithdrawals = this.withdrawals;
	}
	
//	returnerer antall resterende uttak.
	public int getRemainingWithdrawals() {
		return this.remainingWithdrawals;
	}

}
