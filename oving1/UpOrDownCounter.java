package oving1;

public class UpOrDownCounter {
	int counter;
	int start;
	int slutt;
	boolean opp;
	public UpOrDownCounter(int start, int end){
		this.counter=start;
		this.start=start;
		this.slutt = end;
		
		if(start<end){
			opp=true;
		}
		else if(start==end){
			throw new IllegalArgumentException("Start kan ikke være lik slutt");
		}
		else{
			opp=false;
		}
		
	}
	public int getCounter(){
		return this.counter;
	}
	public boolean count(){
		 if(this.opp && (counter < this.slutt)){
	            counter++;
		 }
	     if(!this.opp && (counter > this.slutt)){
	            counter--;
	     }
	        return !(counter==this.slutt);
	}
	
	public String toString(){
		return "Start: "+this.start+" Slutt: "+this.slutt+" Nåværende teller: "+this.counter;
	}
	
	public static void main(String[] args){
		UpOrDownCounter teller = new UpOrDownCounter(1,10);
		System.out.println(teller);
		teller.count();
		System.out.println(teller);
	}
}