package Activity02_SyncPingPong;

public class Ping extends Thread {
	
	private Cola cola;
	
	public Ping(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) 
			cola.printPing();
		
	}
}
