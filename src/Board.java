
public class Board<E> extends Stack<E>{

	public void addWarCards(Player<E> player) {
		if (player.getNumCards() > 3) {
			for (int i = 0; i < 3; i++) {
				put(player.playCard());
				System.out.print(peek() + " ");
			}
		} else if (player.getNumCards() > 1) {
			for (int i = 0; i < player.getNumCards() - 1; i++ ) {
				put(player.playCard());
				System.out.print(peek() + " ");
			}
		}
	}
}
