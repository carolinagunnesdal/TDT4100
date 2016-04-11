package oving9;
public class DebitAccount extends AbstractAccount {

    public DebitAccount() {
        super();
    }

    protected void internalWithdraw(double amount) {
        if (super.getBalance()<amount)
            throw new IllegalStateException("Ikke nok pæng.");
    }
}