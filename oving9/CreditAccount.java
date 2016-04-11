package oving9;
public class CreditAccount extends AbstractAccount {
    private double kredittgrense;

    public CreditAccount(double limit) {
        super();
        if (limit < 0)
            throw new IllegalArgumentException("Kan'ke ha kreditt under 0 vet du vel.");
        else
            this.kredittgrense = limit;
    }

    public double getCreditLine() {
        return kredittgrense;
    }

    public void setCreditLine(double creditLine) {
        if (creditLine < 0)
            throw new IllegalArgumentException("Vil du ha negativ kreditt? Erru g�rn?");
        else if (creditLine < super.getBalance()*-1)
            throw new IllegalStateException("Grense lavere enn det den er n�? Funk�r itj det sj�.");
        else
            this.kredittgrense = creditLine;
    }

    protected void internalWithdraw(double amount) {
        if (amount > (this.kredittgrense + super.getBalance()))
            throw new IllegalStateException("Ikke nok p�ng igjen man.");
    }
}