package Example05_Synchronization;

public class ThreadIncrement extends Thread {

	private Counter counter;

	ThreadIncrement(String name, Counter counter) {
		setName(name);
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (counter) {
			for (int i = 0; i < 300; i++) {
				counter.increment();
				// System.out.println(getName() + " contador vale " + counter.getValue());
				try {
					sleep(100);
				} catch (InterruptedException e) {

				}
			}
			System.out.println(getName() + " contador vale " + counter.getValue());
		}
	}

}
