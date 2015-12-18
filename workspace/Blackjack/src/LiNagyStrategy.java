public class LiNagyStrategy extends BlackjackStrategy {
	
	public boolean hit(int handValue, int dealerHandValue, boolean soft) {
		if ((handValue<16) || (handValue<18 && soft)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String author() {
		return "Jason Li and David Nagy";
	}
	
	public String playerName() {
		return "Jason Li and David Nagy's Strategy";
	}
}