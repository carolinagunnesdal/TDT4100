package oving1;

public class Account {
	double balance;
	double interestRate;
	
	public Account(){
		this.balance=0;
		this.interestRate=10;
	}
	
	public void deposit(double belop){
		if(belop>0){
			balance+=belop;
		}
	}
	public void addInterest(){
		this.balance*=(1+interestRate/100);
	}
	
	public String toString(){
		return "Balance = "+this.balance+", interestRate = "+this.interestRate;
	}
	
	public static void main(String[] args){
		Account acc = new Account();
		acc.deposit(500);
		System.out.println(acc);
		acc.addInterest();
		System.out.println(acc);
	}
}
