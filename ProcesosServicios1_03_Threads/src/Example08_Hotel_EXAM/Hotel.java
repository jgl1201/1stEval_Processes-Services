package Example08_Hotel_EXAM;

public class Hotel {
	
	private int places;
	
	public Hotel(int places) {
		if (places < 0) places = 0;
		this.places = places;
	}
	
	public synchronized void enter() {
		while (places == 0) {
			try {
				System.out.println("ESPERANDO --- El hotel esta lleno");
				wait();
			} catch (InterruptedException e) {}
		}
		
		places--;
		
	}
	
	public synchronized void leave() {
		System.out.println("CLIENTE SALE --- Cama liberada");
		places++;
		notifyAll();
	}

}
