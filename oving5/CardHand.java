package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class CardHand {

	private List<Card> hand = new ArrayList<Card>();
	
	public Card getCard(int pos) {
		if (pos < 0 || pos > this.hand.size()) {
			throw new IllegalArgumentException("The card is not in the range.");
		} else {
			return this.hand.get(pos);
		}
	}
	
	public int getCardCount() {
		return this.hand.size();
	}
	
	public void addCard(Card c) {
		this.hand.add(c);
	}
	
	public Card play(int n) {
		Card cardDeal = this.getCard(n);
		this.hand.remove(n);
		
		return cardDeal;
	}
}
