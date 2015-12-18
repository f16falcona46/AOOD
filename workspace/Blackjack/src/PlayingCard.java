//Jason Li

import java.util.Scanner;

public class PlayingCard {
	private int suit;
	private int value;

	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;

	public static final int SPADES = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;
	public static final int HEARTS = 4;

	private static boolean random = true;

	PlayingCard(int newSuit, int newValue) {
		suit = newSuit;
		value = newValue;
	}

	PlayingCard() {
		if (random) {
			value=(int)(Math.random()*13+1);
			suit=(int)(Math.random()*4+1);
		}
		else {
			boolean cardIsACard = true;
			do {
				System.out.print("Suit? Full name please. ");
				String suitString = inputString().toLowerCase();
				System.out.print("Card value? Letter for face card. ");
				String valueString = inputString();
				try {
					value=Integer.parseInt(valueString);
					cardIsACard=true;
				}
				catch (java.lang.NumberFormatException e) {
					valueString=valueString.toLowerCase();
					if (valueString.equals("a")) {
						value=1;
						cardIsACard=true;
					}
					else if (valueString.equals("j")) {
						value=11;
						cardIsACard=true;
					}
					else if (valueString.equals("q")) {
						value=12;
						cardIsACard=true;
					}
					else if (valueString.equals("k")) {
						value=13;
						cardIsACard=true;
					}
					else {
						System.out.println("That isn't a legal card value! Enter another card.");
						cardIsACard=false;
					}
				}
				if (suitString.equals("spades")) {
					suit=SPADES;
					cardIsACard=true;
				}
				else if (suitString.equals("diamonds")) {
					suit=DIAMONDS;
					cardIsACard=true;
				}
				else if (suitString.equals("clubs")) {
					suit=CLUBS;
					cardIsACard=true;
				}
				else if (suitString.equals("hearts")) {
					suit=HEARTS;
					cardIsACard=true;
				}
				else {
					System.out.println("That isn't a suit! Enter another card.");
					cardIsACard=false;
				}
			} while (!cardIsACard);
		}
	}

	public String toString() {
		String cardString = "";
		if (value<11 && value>1) {
			cardString += value;
		}
		else {
			if (value == JACK) {
				cardString += "J";
			}
			else if (value == QUEEN) {
				cardString += "Q";
			}
			else if (value == KING) {
				cardString += "K";
			}
			else if (value == ACE) {
				cardString += "A";
			}
			else {
				return "This isn't a card!";
			}
		}
		cardString += " of ";
		if (suit == SPADES) {
			cardString += "Spades";
		}
		else if (suit == DIAMONDS) {
			cardString += "Diamonds";
		}
		else if (suit == CLUBS) {
			cardString += "Clubs";
		}
		else if (suit == HEARTS) {
			cardString += "Hearts";
		}
		else {
			return "This isn't a card!";
		}
		return cardString;
	}

	public static void setRandom(boolean newRandomStatus) {
		random = newRandomStatus;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}

	private static String inputString() {
		Scanner sc = new Scanner(System.in);
		String inputLine = sc.nextLine();
		return inputLine;
	}
}