package objectstructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Hensikt: lese hvor mange og hvilke kort, og skal ha en metode for å endre tilstand

public class CardDeck {
	List<Card> deck = new ArrayList<Card>();
	
	public CardDeck(int cardNum) {
		
		//lager en forloop for alle ulike mulighetene for suit.
		for (int i = 1; i < cardNum + 1; i++) {
			deck.add(new Card('S', i));
		}
		
		for (int i = 1; i < cardNum + 1; i++) {
			deck.add(new Card('H', i));
		}
		
		for (int i = 1; i < cardNum + 1; i++) {
			deck.add(new Card('D', i));
		}
		
		for (int i = 1; i < cardNum + 1; i++) {
			deck.add(new Card('C', i));
		}
	}
	
	
	//returnerer hvor mange Card-objekter som CardDeck-objetet inneholder
	//.size gir oss antall elementer i deck-lista
	public int getCardCount() {
		return this.deck.size();
	}
	
	//returnerer kort nr.n eller utløser et IllegalArgumentException hvis n ikke er gyldig. 0 er første kortet
	public Card getCard(int n) {
		if (n < 0 || n > this.deck.size()) {
			throw new IllegalArgumentException("Nummeret er ikke gyldig.");
		} else {
			return this.deck.get(n);
		}
		
	}
	
	//stokker kortet. Deler kortsokken i to og shuffler dem
	//lager en array 
	public void shufflePerfectly() {
		Card[] newArray = new Card[this.deck.size()];
		
		for (int i = 0; i < this.deck.size() / 2; i++) {
			newArray[i*2] = this.deck.get(i);
			
			newArray[i*2 + 1] = this.deck.get(this.deck.size() / 2 + i);
		}
		
		this.deck = Arrays.asList(newArray);
	}
	
	//skal flytte n kort fra kortstokken til korthånda ved å ta ett og ett kort med høyeste gyldige indeks, fjerne det fra CardDeck-objektet.
	public void deal(CardHand hand, int n) {
		if (n > this.getCardCount()) {
			throw new IllegalArgumentException("Det er ikke nok kort!");
		}
		
		for (int i = 0; i < n; i++) {
			Card cardDeal = this.getCard(this.getCardCount() - 1);
			this.deck.remove(cardDeal);
			hand.addCard(cardDeal);
		}
	}
	
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck(10);
		CardHand cardHand = new CardHand();
		cardDeck.deal(cardHand,  10);
		cardHand.play(10);
	}
}
