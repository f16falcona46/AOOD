public class MySimpleStrategy extends BlackjackStrategy {
	boolean hit(int handValue, int dealerHandValue, boolean soft) {
		return (soft || (dealerHandValue==11 && handValue<21) || handValue<17);
	}
}