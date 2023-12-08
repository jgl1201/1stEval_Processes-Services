package Activity03_Parking_EXAM;

public class Parking {
	
	private int places;
	
	public Parking(int places) {
		if (places < 0) places = 0;
		this.places = places;
	}
	
	public synchronized void enter() {
		while (places == 0) {
			try {
				System.out.println("ESPERANDO --- El parking esta lleno");
				wait();
			} catch (InterruptedException e) {}
		}
		places--;
	}
	
	public synchronized void leave() {
		System.out.println("COCHE SALE --- Plaza liberada");
		places++;
		notifyAll();
	}

}
