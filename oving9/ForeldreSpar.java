package oving9;

public class ForeldreSpar extends SavingsAccount{

	protected int maks, uttakigjen;
	
	ForeldreSpar(double rente, int uttakstak) {
		super(rente);
		this.maks = uttakstak;
		this.uttakigjen = uttakstak;
	}

	public void withdraw(double amount){
		if(uttakigjen>0){
			super.withdraw(amount);
			uttakigjen--;
		}
		else {
			throw new IllegalStateException("Ikke lov til � ta ut mer i �r.");
		}
	}
	
	public void endYearUpdate(){
		super.endYearUpdate();
		this.uttakigjen = this.maks;
	}
	
	public int getRemainingWithdrawals(){
		return this.uttakigjen;
	}
}
