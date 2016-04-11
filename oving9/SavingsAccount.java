package oving9;

public class SavingsAccount implements Account{
	
	protected double penger, rentesats;
	
	SavingsAccount(double rente){
		this.penger = 0;
		this.rentesats = rente;
	}
	
	@Override
	public void deposit(double amount) {
		if(amount<=0){
			throw new IllegalArgumentException("Kan ikke sette inn verdier under eller lik 0.");
		}
		this.penger+=amount;
	}

	@Override
	public void withdraw(double amount) {
		if(amount<=0){
			throw new IllegalArgumentException("Kan ikke ta ut verdier under eller lik 0.");
		}
		else if(amount>this.penger){
			throw new IllegalStateException("Du har ikke nok pæng.");
		}
		this.penger-=amount;
	}

	@Override
	public double getBalance() {
		return this.penger;
	}
	
	public void endYearUpdate(){
		this.penger*=(1+this.rentesats);
	}
	
}
