public class BlackjackHand extends Hand {
	private int handValue;
	private boolean soft;
	
	BlackjackHand() {
		handValue=0;
		soft=false;
	}
	
	public void addCard(PlayingCard newCard) {
		super.addCard(newCard);
		computeValue();
	}
	
	private void computeValue() {
		handValue=0;
		boolean aces=false;
		soft=false;
		PlayingCard aCard;
		for (int counter=0; counter<numberOfCards(); counter++) {
			aCard=nthCard(counter);
			if ((aCard.getValue()==PlayingCard.JACK) || (aCard.getValue()==PlayingCard.QUEEN) || (aCard.getValue()==PlayingCard.KING)) {
				handValue+=10;
			}
			else {
				handValue+=aCard.getValue();
			}
			if (aCard.getValue()==PlayingCard.ACE) {
				aces=true;
			}
		}
		if (aces && (handValue<12)) {
			handValue+=10;
			soft=true;
		}
	}
	
	public int handValue() {
		return handValue;
	}
	
	public boolean soft() {
		return soft;
	}
}