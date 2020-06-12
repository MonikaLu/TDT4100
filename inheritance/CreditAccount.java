package inheritance;

public class CreditAccount extends AbstractAccount {
	
	private double creditLine;
	
// tar inn kredittlinjen
//	om kredittlinjen er negativt, utløses en illegalArgumentException
//	setter ellers kredittlinjen til limit som blir tatt inn som parameter
	public CreditAccount(double limit) {
		super();
		if (limit < 0 ) {
			throw new IllegalArgumentException("The credit line must be positive!");
		}
		else {
			this.creditLine = limit;
		}
	}
	
//	om beløpet er større enn summen av kredittlinjen og kontobalansen, utløses en illegalStateException
//	uttaket er ellers gyldig
	@Override
	void internalWithdraw(double amount) {
		if (amount > (this.creditLine + super.getBalance()) ) {
			throw new IllegalStateException("Not enough money!");
		}
		else {
			super.withdraw(amount);
		}
	}
	
//	setter kredittlinjen
//	kredittlinjen må være positiv
//	kan heller ikke være mindre enn den negative kontobalansen
//	ellers er kredittlinjen gyldig
	public void setCreditLine(double creditLine) {
		if (creditLine < 0) {
			throw new IllegalArgumentException("The credit line must be positive!");
		}
		else if (creditLine < super.getBalance()*-1) {
			throw new IllegalStateException("Can't set lower limit than the current credit!");
		}
		else {
			this.creditLine = creditLine;
		}
	}
	
	public double getCreditLine() {
		return this.creditLine;
	}

}
