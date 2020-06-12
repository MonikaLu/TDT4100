package inheritance;

//TESTEN FUNKER P� DENNE
public class BSU extends SavingsAccount {
	
	private double limitedAmount, depositsLastYear;

//	tar inn rentefoten og innsettingsbegrensningen.
	public BSU(double interestRate, double  limitedAmount) {
		super(interestRate);		//inherits interestRate from its superclass
		this.limitedAmount = limitedAmount;
	}
	
//	henter inn deposit() fra superklassen
//	hvis kontobalansen fra ifjor pluss innsettingsbel�pet er mindre enn det begrensede bel�pet
//	legger da til bel�pet i  balansen.
//	utl�ser ellers en IllegalStateException
	public void deposit(double amount) {
		if (this.depositsLastYear + amount <= this.limitedAmount) {
			super.deposit(amount);	//inherits deposit() from superclass, for taking in the amount already given in.
			depositsLastYear += amount;
		}
		else {
			throw new IllegalStateException("You have exceeded the limited amount!");
		}
	}
	
//	henter inn withdraw() fra superklassen
//	om uttaksbel�pet er mindre enn kontobalansen fra ifjor, trekkes uttaksbel�pet fra kontoen
//	utl�ser ellers IllegalStateException
	public void withdraw(double amount) {
		if (amount < this.depositsLastYear) {
			this.depositsLastYear -= amount;
			super.withdraw(amount); 	//using the withdraw method to withdraw instead of writing a new one.
		}
		else {
			throw new IllegalStateException("You can not withdraw deposits from last year.");
		}
	}
	
//	henter inn endYearUpdate() fra superklassen
//	bruker getTacDeduction i endYearUpdate
	public void endYearUpdate() {
		super.endYearUpdate();		//inherits endYearUpdate() to update the deposit.
		getTaxDeduction();				
	}
	
//	20% skattefradrag
//	gj�r depositsLastYear til 0.
//	returnerer skattefradraget
	public double getTaxDeduction() {
		double taxDeduction = this.depositsLastYear * 0.20;
		this.depositsLastYear = 0;
		return taxDeduction;
	}
 	
}
