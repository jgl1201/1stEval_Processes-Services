package Example03_Dices;

import java.util.Random;

public class Dice extends Thread {

	private int result;

	Dice() {
		this.result = random();
	}

	public int getResult() {
		return result;
	}

	public static int random() {
		return new Random().nextInt(6) + 1;
	}

	public void run() {
	//	System.out.println("Dice: " + result);
	}

}
