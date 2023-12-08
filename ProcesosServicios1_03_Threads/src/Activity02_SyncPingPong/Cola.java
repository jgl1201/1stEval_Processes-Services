package Activity02_SyncPingPong;

public class Cola {
	
	private boolean ping = true;
	
	public synchronized void printPing() {
		try {
			while (!ping) wait();
			System.out.println("Ping");
			ping = false;
			notifyAll();
		} catch (InterruptedException e) {}
	}
	
	public synchronized void printPong() {
		try {
			while (ping) wait();
			System.out.println("Pong");
			ping = true;
			notifyAll();
		} catch (InterruptedException e) {}
	}

}
