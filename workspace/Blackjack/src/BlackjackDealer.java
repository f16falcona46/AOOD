public class BlackjackDealer {
	public double playBlackjack(BlackjackPlayer player, int numGames) {
		double gamesWon=0.0;
		for(int counter=1; counter<=numGames; counter++) {
			BlackjackHand dealerHand=new BlackjackHand();
			BlackjackHand playerHand=new BlackjackHand();
			
			dealerHand.addCard(new PlayingCard());
			playerHand.addCard(new PlayingCard());
			playerHand.addCard(new PlayingCard());
			
			while ((playerHand.handValue()<=21) && player.hit(dealerHand, playerHand)) {
				playerHand.addCard(new PlayingCard());
				if (playerHand.handValue()>21) {
					player.playerBusts(playerHand);
				}
			}
			
			if (playerHand.handValue()<22) {
				dealerHand.addCard(new PlayingCard());
				while (dealerHand.handValue()<17) {
					dealerHand.addCard(new PlayingCard());
					player.dealerHit(dealerHand);
					if (dealerHand.handValue()>21) {
						player.dealerBusts(dealerHand);
						gamesWon+=1;
					}
				}
			}
			if (dealerHand.handValue()>playerHand.handValue() && dealerHand.handValue()<22) {
				player.dealerWins(dealerHand, playerHand);
			}
			else if (dealerHand.handValue()<playerHand.handValue() && playerHand.handValue()<22) {
				player.playerWins(playerHand, dealerHand);
				gamesWon+=1;
			}
			else {
				if (playerHand.handValue()<22 && dealerHand.handValue()<22) {
					player.playerTies(playerHand, dealerHand);
					gamesWon+=0.5;
				}
			}
		}
		return gamesWon/((double)numGames);
	}
}