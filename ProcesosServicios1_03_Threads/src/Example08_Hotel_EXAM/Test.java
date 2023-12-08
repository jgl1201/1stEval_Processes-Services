package Example08_Hotel_EXAM;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Hotel hotel = new Hotel(10);
		
		for (int i = 0; i < 50; i++) {
			Client client = new Client("Cliente " + i, hotel);
		}
	}

}
