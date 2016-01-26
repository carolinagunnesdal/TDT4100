package oving2;

public class Account {
	double verdi, rente;
	
	Account(double initialverdi, double initialrente){
		if(initialverdi<0 || initialrente<0){
			throw new IllegalArgumentException("Ugyldig initialiseringsverdi(er)");
		}
		this.verdi = initialverdi;
		this.rente = initialrente;
	}
	
	double getBalance(){
		return this.verdi;
	}
	
	double getInterestRate(){
		return this.rente;
	}
	
	void setInterestRate(double nyrate){
		if(nyrate<0){
			throw new IllegalArgumentException("Ugyldig renteverdi!");
		}
		
		this.rente=nyrate;
	}
	
	void deposit(double verdien){
		if(verdien<0){
			throw new IllegalArgumentException("Ugyldig verdi");
		}
		this.verdi+=verdien;
	}
	
	void withdraw(double verdien){
		if(verdien<0){
			throw new IllegalArgumentException("Kan ikke ta ut noe negativt");
		}
		else if(this.verdi-verdien<0){
			throw new IllegalStateException("Beløp under 0!");
		}
		this.verdi-=verdien;
	}
	
	
	public static void main(String[] args){
		Account ole = new Account(100,50);
	}
}
