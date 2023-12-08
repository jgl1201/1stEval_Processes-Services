package Activity03_Parking_EXAM;

public class Car extends Thread {
	
	private Parking parking;
	int time = 0;
	
	public Car(String number, Parking parking) {
		super(number);
		this.parking = parking;
		start();
	}
	
	public void run() {
		try {
			sleep((int) (Math.random() * 10000));
		} catch (InterruptedException e) {}
		
		parking.enter();
		System.out.println(getName() + " aparca");
		
		try {
			this.time = (int)(Math.random() * 20000);
			sleep(time);
		} catch (InterruptedException e) {}
		
		parking.leave();
		System.out.println(getName() + " sale");
	}

	@Override
	public String toString() {
		return getName() + " Tiempo = " + time;
	}

}
