package oving9;

public abstract class AbstractAccount {
	
	protected double penger;
	
	AbstractAccount(){
		this.penger = 0;
	}
	
	public void deposit(double amount){
		if(amount>0){
			this.penger += amount;
		}
		else {
			throw new IllegalArgumentException("Ugyldig mengde pæng.");
		}
	}
	
	public void withdraw(double amount){
		if(amount < 0 ){
			throw new IllegalArgumentException("Ugyldig mængd pæng");
		}
		else{
			internalWithdraw(amount);
			//this.penger -= amount;
		}
	}
	
	abstract void internalWithdraw(double amount);
	
	public double getBalance(){
		return this.penger;
	}
	
	
}
