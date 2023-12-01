package Example07_Production;

public class Producer extends Thread {

	private Cola cola;
	private int n;

	public Producer(Cola C, int n) {
		cola = C;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			System.out.println(i + " => Producer: " + n + " produces: " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
