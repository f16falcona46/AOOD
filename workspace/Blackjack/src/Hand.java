import java.util.ArrayList;

public class Hand {
	private ArrayList<PlayingCard> cardsInHand;
	
	Hand() {
		cardsInHand = new ArrayList<PlayingCard>();
	}
	
	public int numberOfCards() {
		return cardsInHand.size();
	}
	
	public PlayingCard nthCard(int x) {
		return cardsInHand.get(x);
	}
	
	public void print() {
		for (PlayingCard card : cardsInHand) {
			System.out.println(card);
		}
	}
	
	public void addCard(PlayingCard newCard) {
		cardsInHand.add(newCard);
	}
}