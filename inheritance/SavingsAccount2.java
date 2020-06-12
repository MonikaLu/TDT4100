package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	public int withdrawalLimit, takenWithdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawalLimit, double fee) {
		super();
		this.withdrawalLimit = withdrawalLimit;
		this.fee = fee;
	}
	
//	om uttaksbeløpet er større enn kontobalansen, eller hvis balansen er mindre enn summen av uttaksbeløpet og gebyret
//	utløses illegalStateException
//	om antall resterende uttak er mindre er antall lovlige uttak ==> trekker både gebyret og uttaksbeløpet fra kontoen
//	ellers er uttaket gyldig.
//	fikk en error i testen og forstår ikke helt hva som er feil.
	@Override
	public void internalWithdraw(double amount) {
		if (amount > super.getBalance() || this.balance < amount + fee) {		//if the balance is lower than withdraw.
			throw new IllegalStateException("Not enough money!");
		}
		else if (takenWithdrawals >= withdrawalLimit) {		//if the limit is exceeded
			System.out.println("Charging fee from balance.");
			this.balance -= amount + fee;
		}
		else {									
			this.balance -= amount;
			this.takenWithdrawals -= 1;
			super.withdraw(amount);
		}
	}

}
