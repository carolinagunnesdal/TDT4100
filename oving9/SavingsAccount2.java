package oving9;

public class SavingsAccount2 extends AbstractAccount {

	protected int uttakstak, nauttak;
	protected double avgift;
	
	public SavingsAccount2(int grensa, double avgiften){
		super();
		this.uttakstak = grensa;
		this.avgift = avgiften;
		this.nauttak = 0;
	}
	
	@Override
	void internalWithdraw(double amount) {
		if  ( amount > super.getBalance()){
			throw new IllegalStateException("Du ha itj pæng sjø!");
		}
		else if (this.nauttak >= uttakstak && super.getBalance()-amount>=this.avgift){
			super.penger-= amount;
			super.penger-=this.avgift;
			this.nauttak++;
		}
		else if (this.nauttak < uttakstak && super.getBalance()>=amount){
			super.penger -= amount;
			this.nauttak++;
		}
		else {
			throw new IllegalStateException("ostefæn");
		}
	}

}
