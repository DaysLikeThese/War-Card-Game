import java.util.LinkedList;

public class Prize<E> extends LinkedList<E> {
	public Prize() {}
	
	public void put(E o) {
		addFirst(o);
	}
	
	public E get() {
		if (!this.isEmpty()) {
			return removeFirst();
		} else {
			System.err.println("You can\'t do that!");
			return null;
		} 
	}
	
	public E peek() {
		return getFirst();
	}
}