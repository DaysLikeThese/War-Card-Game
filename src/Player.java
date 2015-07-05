
public class Player<E> extends Queue<E>{
	private int numCards = 26;

	public Player() {}
	
	public int getNumCards() {
		return numCards;
	}
	
	public E playCard() {
		numCards--;
		return get();
	}
	
	public void addCard(Queue<E> queue) {
		put(queue.get());
		numCards++;
	}
	
	public void addAllCards(Queue<E> queue) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			put(queue.get());
			numCards++;
		}
	}
	
	
}
