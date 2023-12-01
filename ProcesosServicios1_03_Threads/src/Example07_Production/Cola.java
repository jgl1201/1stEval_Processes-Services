package Example07_Production;

public class Cola {

	private int number;
	private boolean disponible = false;

	public synchronized int get() {
		// If there's no product to consume, wait until one is available to consume it
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		disponible = false;
		notifyAll();
		return number;
	}

	public synchronized void put(int value) {
		// If there's a product to consume, wait until there's none to produce
		// anotherone
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		number = value;
		disponible = true;
		notifyAll();
	}

	@Override
	public String toString() {
		return "Cola [number=" + number + ", disponible=" + disponible + "]";
	}

}
