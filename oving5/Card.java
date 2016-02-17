package oving5;

public class Card {
	int verdi;
	char drakt;
	char[] gyldige = {'S','H','D','C'};
	public Card(char a, int b){
		String tmp = a+"";
		if(!String.valueOf(gyldige).contains(tmp)){
			throw new IllegalArgumentException("Nah brah");
		}
		if(b>13 || b<1){
			throw new IllegalArgumentException("Det går ikke.");
		}
		this.verdi = b;
		this.drakt = a;
	}
	
	public char getSuit(){
		return this.drakt;
	}
	
	public int getFace(){
		return this.verdi;
	}
	
	@Override
	public String toString(){
		return ""+this.drakt+this.verdi;
	}
}
