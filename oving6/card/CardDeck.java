package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Hensikt: lese hvor mange og hvilke kort, og skal ha en metode for � endre tilstand

public class CardDeck implements CardContainer {
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
	
	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}
	
	
	//returnerer hvor mange Card-objekter som CardDeck-objetet inneholder
	//.size gir oss antall elementer i deck-lista
	@Override
	public int getCardCount() {
		return this.deck.size();
	}
	
	//returnerer kort nr.n eller utl�ser et IllegalArgumentException hvis n ikke er gyldig. 0 er f�rste kortet
	@Override
	public Card getCard(int n) {
		if (n < 0 || n > this.deck.size()) {
			throw new IllegalArgumentException("Nummeret er ikke gyldig.");
		} else {
			return this.deck.get(n);
		}
		
	}
	
	public List<Card> getDeck() {
		return this.deck;
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
	
	//skal flytte n kort fra kortstokken til korth�nda ved � ta ett og ett kort med h�yeste gyldige indeks, fjerne det fra CardDeck-objektet.
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
	
	public boolean hadCard(Predicate<Card> p) {
		for (Card card : this.deck) {
			if (p.test(card)) {
				return true;
			}
		}
		return false;
	}
	
	public int getCardCount(Predicate<Card> p) {
		int count = 0;
		for (Card card : this.deck) {
			if (p.test(card)) {
				count++;
			}
		}
		return count;
	}
	
	public List<Card> getCards(Predicate<Card> p) {
		  return this.deck
		      .stream()
		      .filter(p)
		      .collect(Collectors.toList());
		}
	
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck(10);
		CardHand cardHand = new CardHand();
		cardDeck.deal(cardHand,  5);
		cardHand.play(5);
	}
}

