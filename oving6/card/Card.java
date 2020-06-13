package interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
	
	private char suit; 	//kortfargen
	private int face;	//tallverdien mellom 1 og 13
	private static Map<Character, Integer> SUIT_RANK = new HashMap<>() {{
		
		put('S', 1);
	    put('H', 2);
	    put('D', 3);
	    put('C', 4);
		}};
	
	
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
	
	@Override
	public int compareThem(Card otherCard) {
		int rank = SUIT_RANK.get(this.getSuit()) - SUIT_RANK.get(otherCard.getSuit());
		
		if (rank != 0) {
			return Math.max(-1,  Math.min(1,  rank));
		}
		
		return Integer.compare(getFace(), otherCard.getFace());
	}
	
	public static void main(String[] args) {
		// Skriv testkode som sorterer kort i en liste vha. Collections.sort og Comparable-logikken, så dere ser at det virker som forventet.
		List<Card> l = new ArrayList<>();
		l.add(new Card('H', 10));
		l.add(new Card('H', 13));
		l.add(new Card('S', 1));
		l.add(new Card('D', 13));
		l.add(new Card('C', 3));

		Collections.sort(l);

		System.out.println(l);
	
}}
