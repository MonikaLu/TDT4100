package inheritance;

public class CreditAccount extends AbstractAccount {
	
	private double creditLine;
	
// tar inn kredittlinjen
//	om kredittlinjen er negativt, utl�ses en illegalArgumentException
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
	
//	om bel�pet er st�rre enn summen av kredittlinjen og kontobalansen, utl�ses en illegalStateException
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
//	kredittlinjen m� v�re positiv
//	kan heller ikke v�re mindre enn den negative kontobalansen
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
