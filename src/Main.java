
public class Main {
	public static boolean peace = true;
	private static boolean noWin = true;
	
	private static Player[] hands = new Player[2];
	private static Board[] prize = new Board[2];
	private static Board<Card> B0 = new Board<Card>();
	private static Board<Card> B1 = new Board<Card>();
	private static Deck deck = new Deck();
	private static Player<Card> P0 = new Player<Card>();
	private static Player<Card> P1 = new Player<Card>();
	private static int round = 0;

	public static void main(String[] args) {	
		hands[0] = P0;
		hands[1] = P1;
		prize[0] = B0;
		prize[1] = B1;

		playWar();
	}

	public static void deal() {
		for (int i = 0; i < 26; i++) {
			P0.put(deck.getCard());
			P1.put(deck.getCard());
		}
	}

	public static void playRound() {

		if (P0.getNumCards() > 0) {
			B0.put(P0.playCard());
		}
		
		if (P1.getNumCards() > 0) {
			B1.put(P1.playCard());
		}

		Card card0 = B0.peek();
		Card card1 = B1.peek();

		System.out.println(card0 + " vs. " + card1);

		if (peace) {
			if (card0.getRank() == 2 || card1.getRank() == 2 
					|| card0.equals(card1)) {
				peace = false;
				war();
			} else if (card0.getRank() == 8) {
				P0.addCard(B1);
				P0.addCard(B0);
			} else if (card1.getRank() == 8 || card0.compareTo(card1) < 0) {
				P1.addCard(B0);
				P1.addCard(B1);
			} else {
				P0.addCard(B1);
				P0.addCard(B0);
			}
		} else {
			if (card0.equals(card1)) {
				war();
			} else if (card0.getRank() == 8) { 
				P0.addAllCards(B0);
				P0.addAllCards(B1);
			} else if (card1.getRank() == 8 || card0.compareTo(card1) < 0) {
				P1.addAllCards(B0);
				P1.addAllCards(B1);
			} else {
				P0.addAllCards(B0);
				P0.addAllCards(B1);
			}
			peace = true;
		}

		if (P0.getNumCards() == 0 || P1.getNumCards() == 0) {
			noWin = false;
		}
	}

	public static void war() {
		System.out.println("WAR!");
		System.out.print("Down cards: P0: ");
		B0.addWarCards(P0);
		
		System.out.print("P1: ");
		B1.addWarCards(P1);
		
		System.out.println();
		playRound();
	}

	public static void playWar() {
		deal();
		while(noWin) {
			playRound();
			round++;
			System.out.println("Player 0: " + P0.getNumCards() + " cards, " 
					+ "Player 1: " + P1.getNumCards() + " cards");
			if (P0.getNumCards() == 0) {
				noWin = false;
				System.out.println("Player 1 wins in " + round + " rounds!");
			} else if (P1.getNumCards() == 0) {
				noWin = false;
				System.out.println("Player 0 wins in " + round + " rounds!");
			}
		}

	}
	
}
