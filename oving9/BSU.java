package oving9;


public class BSU extends SavingsAccount{
	
	
    protected double maks, innsattifjor;

    public BSU(double rentesats, double max) {
        super(rentesats);
        this.maks = max;
    }

    public void deposit(double amount) {
        if (this.innsattifjor + amount <= this.maks) {
            super.deposit(amount);
            innsattifjor += amount;
        }
        else {
            throw new IllegalStateException("You have deposited too much.");
        }
    }

    public void withdraw(double amount) {
        if (amount < this.innsattifjor) {
            this.innsattifjor-= amount;
            super.withdraw(amount);
        }
        else {
            throw new IllegalStateException("Det får du ikke lov til.");
        }
    }

    public void endYearUpdate() {
        super.endYearUpdate();
        getTaxDeduction();
    }

    public double getTaxDeduction() {
        double gratispæng = this.innsattifjor * 0.20;
        this.innsattifjor = 0;
        return gratispæng;
    }
}