package Activity02_SyncPingPong;

public class Pong extends Thread {

	private Cola cola;
	
	public Pong(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++)
			cola.printPong();
	}
}
