package inheritance;

public abstract class AbstractAccount {
	
	public double balance;
	
//	konstruktøren setter balansen til 0
	public AbstractAccount() {
		this.balance = 0;
	}
	
//	deposit() tar inn et beløp.
//	hvis beløpet er positivt, er innsettingsbeløpet gyldig
//	utløser ellers en illegalArgumentException
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
		else {
			throw new IllegalArgumentException("The amount needs to be positive.");
		}
	}
	
//	withdraw() tar inn et uttaksbeløp
//	om beløpet er negativt, utløses en IllegalArgumentException
//	ellers trekkes beløpet fra kontobalansen.
//	bruker internalWithdraw() som er individuelt for hver subklasse
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Illegal amount!");
		}
		else {
			internalWithdraw(amount);
			this.balance -= amount;
		}
	}
	
//	lager en abstrakt metode.
//	abstrak metode = metoden som skal implementeres i subklassen.
	abstract void internalWithdraw(double amount);
	
//	returnerer balansen slik at subklassene har tilgang til balansens nåværende tilstand.
	public double getBalance() {
		return this.balance;
	}
}
