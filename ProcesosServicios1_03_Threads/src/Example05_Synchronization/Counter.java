package Example05_Synchronization;

public class Counter {

	private int c = 0;

	Counter(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Counter [c=" + c + "]";
	}

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int getValue() {
		return c;
	}

}
