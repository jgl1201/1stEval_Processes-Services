package Example03_Dices;

public class Test {

	public static void main(String[] args) {
		Dice dice;
		int marcador = 0;

		for (int i = 0; i < 5; i++) {
			dice = new Dice();
			dice.start();
//			System.out.println("Creando " + dice.getId() + " " + dice.getName());
//			System.out.println(dice.toString());
			marcador += dice.getResult();
		}
		System.out.println("Marcador: " + marcador);
	}

}
