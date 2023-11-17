package Example01_Thread;

public class FirstThread extends Thread {

	int x;
	
	FirstThread(int x) {
		System.out.println("FirstThread");
		this.x = x;
	}
	
	public void run() {
		for(int i = 0; i < x; i++) {
			System.out.println("Me imprimo por vez " + i);			
		}
	}
	
}
