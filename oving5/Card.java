package objectstructures;

import java.util.Arrays;
import java.util.List;

public class Card {
	
	private char suit; 	//kortfargen
	private int face;	//tallverdien mellom 1 og 13
	
	
	//konstruktøren tar inn suit og face som parametre.
	//tar inn to sjekkemetoder
	public Card(char suit, int face) {
		this.suit = checkSuit(suit);
		this.face = checkFace(face);
	}
	
	//en getter som returnerer tallverdien
	public int getFace() {
		return face;
	}
	
	//en getter som returnerer kortfargen
	public char getSuit() {
		return suit;
	}
	
	//Lager ei liste av alle tilgjengelige muligheter av suit.
	//.contains sjekker om lista inneholder suit-parameteren. Skal printe ut feilmelding hvis lista ikke inneholder bokstaven
	//skal ellers returnere det som er skrevet inn.
	private char checkSuit(char suit) {
		List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');
		
		if (!suits.contains(suit)) {
			throw new IllegalArgumentException("That is not a suit.");
		}
		else {
			return suit;
		}
		
	}
	
	//tar inn en number som parameter.
	//tallet er ugyldig hvis det er mindre enn 1 eller større enn 13.
	//skal ellers returnere nummeret som er skrevet inn
	private int checkFace(int number) {
		if (number < 1 || number > 13) {
			throw new IllegalArgumentException("This is not a valid number");
			}
		else {
			return number;
		}
	}
	
	//Skal sette sammen Kortfargen og tallverdien, og for ulike datatypes skyld bruker jeg String.valueOf for å fikse dette istedenfor å simply returne dem
	@Override
	public String toString() {
		return String.valueOf(suit) + face;
	}
}
