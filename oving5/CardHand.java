package oving5;

import java.util.ArrayList;

import oving5.Card;

public class CardHand {
	
	ArrayList<Card> haanda = new ArrayList<Card>();
	
	public void addCard(Card kortet){
		this.haanda.add(kortet);
	}
	
	public Card play(int n){
		Card spilt = this.haanda.get(n);
		this.haanda.remove(n);
		return spilt;
	}
	
	public int getCardCount(){
		return this.haanda.size();
	}
	
	public Card getCard(int n){
		if(n>getCardCount() || n<0){
			throw new IllegalArgumentException("Nope");
		}
		return this.haanda.get(n);
	}
	
}
