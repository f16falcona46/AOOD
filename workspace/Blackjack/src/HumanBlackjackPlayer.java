import java.util.Scanner;

public class HumanBlackjackPlayer extends BlackjackPlayer {
	public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("Your hand is:");
		playerHand.print();
		System.out.println("The dealer's hand is:");
		dealerHand.print();
		while (true) {
			System.out.print("Would you like to hit? ");
			String choice=inputString();
			choice=choice.toLowerCase();
			if (choice.equals("yes") || choice.equals("y")) {
				System.out.println("You hit.");
				return true;
			}
			else if (choice.equals("no") || choice.equals("n")) {
				System.out.println("You stood pat.");
				return false;
			}
			else {
				System.out.println("Type \"yes\" or \"no\", please.");
			}
		}
	}

	public void dealerHit(BlackjackHand dealerHand) {
		System.out.println("The dealer hit.");
		System.out.println("New dealer hand:");
		dealerHand.print();
	}

	public void playerBusts(BlackjackHand playerHand) {
		System.out.println("You busted.");
		System.out.println("You ended with a hand of:");
		playerHand.print();
	}

	public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("You tied the dealer.");
		System.out.println("You ended with a hand of:");
		playerHand.print();
		System.out.println("The dealer ended with a hand of:");
		dealerHand.print();
	}

	public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand) {
		System.out.println("You beat the dealer.");
		System.out.println("You ended with a hand of:");
		playerHand.print();
		System.out.println("The dealer ended with a hand of:");
		dealerHand.print();
	}

	public void dealerBusts(BlackjackHand dealerHand) {
		System.out.println("The dealer busted.");
		System.out.println("The dealer ended with a hand of:");
		dealerHand.print();
	}

	public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand) {
		System.out.println("The dealer beat you.");
		System.out.println("You ended with a hand of:");
		playerHand.print();
		System.out.println("The dealer ended with a hand of:");
		dealerHand.print();
	}
	
	private static String inputString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}