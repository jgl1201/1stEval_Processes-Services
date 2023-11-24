package Example04_Priority;

public class TestAthlete {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Athlete a = new Athlete(i + 1, "Athlete " + i, "Country " + i);
			new Thread(a).start();
			//a.run();
		}
	}

}
