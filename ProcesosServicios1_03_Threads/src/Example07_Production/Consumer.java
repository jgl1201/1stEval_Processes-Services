package Example07_Production;

public class Consumer extends Thread {

	private Cola cola;
	private int n;
	
	public Consumer(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	
	public void run() {
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value = cola.get();
			System.out.println(i + " => Consumer: " + n + " consumes: " + value);
		}
	}
	
}
