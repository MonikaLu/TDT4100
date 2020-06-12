package inheritance;

public class DebitAccount extends AbstractAccount {
	
//	super() refererer til objektene fra superklassen.
	public DebitAccount() {
		super();
	}

//	metoden tar inn et beløp
//	om kontobalansen fra superklassen er mindre enn uttaksbeløpet
//	utløses det en illegalStateException
	@Override
	void internalWithdraw(double amount) {
		if (super.getBalance() < amount) {
			throw new IllegalStateException("Not enough balance.");
		}
	}

}
