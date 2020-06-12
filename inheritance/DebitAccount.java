package inheritance;

public class DebitAccount extends AbstractAccount {
	
//	super() refererer til objektene fra superklassen.
	public DebitAccount() {
		super();
	}

//	metoden tar inn et bel�p
//	om kontobalansen fra superklassen er mindre enn uttaksbel�pet
//	utl�ses det en illegalStateException
	@Override
	void internalWithdraw(double amount) {
		if (super.getBalance() < amount) {
			throw new IllegalStateException("Not enough balance.");
		}
	}

}
