package Example08_Hotel_EXAM;

public class Client extends Thread {

	private Hotel hotel;

	public Client(String number, Hotel hotel) {
		super(number);
		this.hotel = hotel;
		start();
	}

	public void run() {
		try {
			// They don't enter at the same time
			sleep((int) (Math.random() * 10000));
		} catch (InterruptedException e) {
		}

		hotel.enter();
		System.out.println(getName() + " entra");

		try {
			sleep((int) (Math.random() * 20000));
		} catch (InterruptedException e) {
		}

		hotel.leave();
		System.out.println(getName() + " sale");

	}

}
