
public class Player<E> extends Hand<E>{
	private int numCards = 26;

	public Player() {}
	
	public int getNumCards() {
		return numCards;
	}
	
	public E playCard() {
		numCards--;
		return get();
	}
	
	public void addCard(Board<E> board) {
		put(board.get());
		numCards++;
	}
	
	public void addAllCards(Board<E> board) {
		int size = board.size();
		for (int i = 0; i < size; i++) {
			put(board.get());
			numCards++;
		}
	}
	
	
}
