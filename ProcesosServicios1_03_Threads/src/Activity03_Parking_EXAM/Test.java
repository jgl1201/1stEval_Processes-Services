package Activity03_Parking_EXAM;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<>();

		Parking parking = new Parking(25);

		for (int i = 0; i < 50; i++) {
			cars.add(new Car("Coche " + i, parking));
		}

		for (Car c : cars) {
			try {
				c.join();
			} catch (InterruptedException e) {
			}
		}

		System.out.println("--- Gestión de pagos ---");
		
		for (Car c : cars) System.out.println(c.toString());
		
	}

}
