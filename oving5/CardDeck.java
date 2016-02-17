package oving5;

import oving5.Card;
import java.util.*;

public class CardDeck {
	
	ArrayList<Card> kort;
	char drakter[] = {'S','H','D','C'};
	public CardDeck(int n){
		kort = new ArrayList<Card>();
		for(int i = 0;i<this.drakter.length;i++){
			for(int j = 1;j<n+1;j++){
				this.kort.add(new Card(this.drakter[i],j));
			}
		}
		
		
	}
	
	public int getCardCount(){
		return kort.size();
	}
	
	public Card getCard(int n){
		if(n>getCardCount() || n<0){
			throw new IllegalArgumentException("Nope");
		}
		return kort.get(n);
	}
	
	public void deal(CardHand haand, int n){
		for(int i = 0; i<n;i++){
			haand.addCard(kort.remove(getCardCount()-1));
		}
	}
	
	public void shufflePerfectly(){
		ArrayList<Card> temp = new ArrayList<Card>();
		temp.addAll(this.kort.subList(0, getCardCount()/2));
		ArrayList<Card> temp2 = new ArrayList<Card>();
		temp2.addAll(this.kort.subList(getCardCount()/2, getCardCount()));
		
		this.kort.clear();
		
		for(int i = 0; i<temp.size();i++){
			kort.add(temp.get(i));
			kort.add(temp2.get(i));
		}	
	}
	
	
}
