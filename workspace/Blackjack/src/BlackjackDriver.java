public class BlackjackDriver {
	public static void main(String[] args) {
		testBlackjack6();
	}
	public static void testBlackjack1() { 
		//Blackjack 1
		
		print("Random On");
		
		PlayingCard.setRandom(true);
		
		PlayingCard testCard1 = new PlayingCard();
		PlayingCard testCard2 = new PlayingCard();
		System.out.println("Test Card 1 is: "+testCard1);
		System.out.println("Test Card 2 is: "+testCard2);
		
		PlayingCard.setRandom(false);
		
		print("Random Off");
		
		PlayingCard testCard3 = new PlayingCard();
		PlayingCard testCard4 = new PlayingCard();
		System.out.println("Test Card 3 is: "+testCard3);
		System.out.println("Test Card 4 is: "+testCard4);
		
		PlayingCard.setRandom(true);
		
		print("Random On");
		
		PlayingCard testCard5 = new PlayingCard();
		PlayingCard testCard6 = new PlayingCard();
		System.out.println("Test Card 5 is: "+testCard5);
		System.out.println("Test Card 6 is: "+testCard6);
		
		print("Premade Cards");
		PlayingCard testCardP1 = new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE);
		PlayingCard testCardP2 = new PlayingCard(PlayingCard.DIAMONDS,2);
		PlayingCard testCardP3 = new PlayingCard(PlayingCard.CLUBS,3);
		PlayingCard testCardP4 = new PlayingCard(PlayingCard.HEARTS,4);
		PlayingCard testCardP5 = new PlayingCard(PlayingCard.SPADES,5);
		PlayingCard testCardP6 = new PlayingCard(PlayingCard.DIAMONDS,6);
		PlayingCard testCardP7 = new PlayingCard(PlayingCard.CLUBS,7);
		PlayingCard testCardP8 = new PlayingCard(PlayingCard.HEARTS,8);
		PlayingCard testCardP9 = new PlayingCard(PlayingCard.SPADES,9);
		PlayingCard testCardP10 = new PlayingCard(PlayingCard.DIAMONDS,10);
		PlayingCard testCardP11 = new PlayingCard(PlayingCard.CLUBS,PlayingCard.JACK);
		PlayingCard testCardP12 = new PlayingCard(PlayingCard.HEARTS,PlayingCard.QUEEN);
		PlayingCard testCardP13 = new PlayingCard(PlayingCard.SPADES,PlayingCard.KING);
		
		print(testCardP1);
		print(testCardP2);
		print(testCardP3);
		print(testCardP4);
		print(testCardP5);
		print(testCardP6);
		print(testCardP7);
		print(testCardP8);
		print(testCardP9);
		print(testCardP10);
		print(testCardP11);
		print(testCardP12);
		print(testCardP13);
	}
	
	public static void testBlackjack2() {
		//Blackjack 2
		
		PlayingCard.setRandom(true);
		
		Hand testHand1 = new Hand();
		//no cards
		print("No cards");
		testHand1.print();
		print(testHand1.numberOfCards());
		
		//one card
		print("\n"+"One card");
		testHand1.addCard(new PlayingCard());
		testHand1.print();
		print(testHand1.numberOfCards());
		print(testHand1.nthCard(0));
		
		//two cards
		print("\n"+"Two cards");
		testHand1.addCard(new PlayingCard());
		testHand1.print();
		print(testHand1.numberOfCards());
		print(testHand1.nthCard(0));
		print(testHand1.nthCard(1));
		
		//three cards
		print("\n"+"Three cards");
		testHand1.addCard(new PlayingCard());
		testHand1.print();
		print(testHand1.numberOfCards());
		print(testHand1.nthCard(0));
		print(testHand1.nthCard(1));
		print(testHand1.nthCard(2));
	}
	
	public static void testBlackjack3() {
		//Blackjack 3
		print("Test 1");
		BlackjackHand testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.JACK));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 2");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.QUEEN));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 3");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.KING));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 4");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 5");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 6");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,2));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,10));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 7");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,2));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,3));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 8");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,10));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,3));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,7));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,3));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,4));
		testHand1.addCard(new PlayingCard(PlayingCard.DIAMONDS,5));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 9");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.JACK));
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 10");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,PlayingCard.JACK));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,9));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 11");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,3));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 12");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,PlayingCard.JACK));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,9));
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 13");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,3));
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 14");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,3));
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,4));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
		
		print("Test 15");
		testHand1 = new BlackjackHand();
		testHand1.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.ACE));
		testHand1.addCard(new PlayingCard(PlayingCard.HEARTS,PlayingCard.KING));
		testHand1.addCard(new PlayingCard(PlayingCard.SPADES,2));
		testHand1.print();
		print(testHand1.handValue());
		pHardSoft(testHand1);
	}
	
	public static void testBlackjack4() {
		//Blackjack4
		PlayingCard.setRandom(true);
		
		print("hit");
		BlackjackPlayer testPlayer = new HumanBlackjackPlayer();
		BlackjackHand dealerHand = new BlackjackHand();
		BlackjackHand playerHand = new BlackjackHand();
		dealerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard());
		print(testPlayer.hit(dealerHand, playerHand));
		
		print("playerBusts");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		dealerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.JACK));
		playerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.JACK));
		playerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.JACK));
		testPlayer.playerBusts(playerHand);
		
		print("dealerBusts");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		playerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard());
		dealerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.JACK));
		dealerHand.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.KING));
		dealerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		testPlayer.dealerBusts(dealerHand);
		
		print("dealerHit");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		playerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard());
		dealerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		dealerHand.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		dealerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		testPlayer.dealerHit(dealerHand);
		
		print("playerWins");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		playerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		playerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		dealerHand.addCard(new PlayingCard());
		testPlayer.playerWins(playerHand,dealerHand);
		
		print("dealerWins");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		playerHand.addCard(new PlayingCard());
		playerHand.addCard(new PlayingCard());
		dealerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		dealerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		testPlayer.dealerWins(playerHand,dealerHand);
		
		print("playerTies");
		dealerHand = new BlackjackHand();
		playerHand = new BlackjackHand();
		playerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		playerHand.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		playerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		dealerHand.addCard(new PlayingCard(PlayingCard.SPADES,PlayingCard.ACE));
		dealerHand.addCard(new PlayingCard(PlayingCard.DIAMONDS,PlayingCard.ACE));
		dealerHand.addCard(new PlayingCard(PlayingCard.CLUBS,PlayingCard.QUEEN));
		testPlayer.playerTies(playerHand,dealerHand);
	}
	
	public static void testBlackjack5() {
		//Blackjack 5
		
		PlayingCard.setRandom(true);
		BlackjackDealer testDealer = new BlackjackDealer();
		//print("Wins per hand: "+testDealer.playBlackjack(new NopeParty(), 5000000));
		
		//PlayingCard.setRandom(false);
		print("Wins per hand: "+testDealer.playBlackjack(new ComputerBlackjackPlayer(new MySimpleStrategy()), 1000));
	}
	
	public static void testBlackjack6() {
		//Blackjack 6
		
		PlayingCard.setRandom(true);
		BlackjackDealer testDealer = new BlackjackDealer();
		BlackjackStrategy testStrategy = new MySimpleStrategy();
		/*
		print(testStrategy.hit(17,1,false));
		print(testStrategy.hit(1,11,false));
		print(testStrategy.hit(1,1,true));
		print(testStrategy.hit(21,11,false));
		print(testStrategy.hit(21,1,false));
		print(testStrategy.hit(16,1,false));
		print(testStrategy.hit(17,1,false));
		print(testStrategy.hit(21,21,true));
		*/
		
		print(testStrategy.hit(15,11,true));
		print(testStrategy.hit(15,11,false));
		print(testStrategy.hit(11,10,false));
		print(testStrategy.hit(17,7,false));
		print(testStrategy.hit(16,6,false));
		print(testStrategy.hit(17,2,true));
		print("Wins per hand: "+testDealer.playBlackjack(new 
				ComputerBlackjackPlayer(new MySimpleStrategy()), 1000));
	}
	
	private static void print(Object stuffToPrint) {
		System.out.println(stuffToPrint);
	}
	
	private static void pHardSoft(BlackjackHand hand) {
		if (hand.soft()) {
			print("soft");
		}
		else {
			print("hard");
		}
	}
}