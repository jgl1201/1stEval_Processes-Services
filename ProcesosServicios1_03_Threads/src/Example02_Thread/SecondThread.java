package Example02_Thread;

public class SecondThread extends Thread {
	
	int c;
	int thread;
	
	public SecondThread(int c, int thread) {
		this.thread = thread;
		System.out.println("Creando hilo " + thread);
	}
	
	public void run() {
		c = 0;
		while(c < 5) {
			System.out.println("Hilo" + thread + " contador " + c);
			c++;
		}
	}

}
