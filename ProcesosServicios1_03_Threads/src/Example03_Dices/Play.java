package Example03_Dices;

@SuppressWarnings("rawtypes")
public class Play extends Thread implements Comparable {
	
	String nameP;
	int points;
	
	Play(String n){
		this.nameP = n;
	}
	
	public String getNameP() {
		return nameP;
	}

	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		return "Play [name=" + nameP + ", points=" + points + "]";
	}

	public void run() {
		Dice dice;
//		int marcador = 0;

		for (int i = 0; i < 5; i++) {
			dice = new Dice();
			dice.start();
//			System.out.println("Creando " + dice.getId() + " " + dice.getName());
//			System.out.println(dice.toString());
			points += dice.getResult();
		}
		System.out.println(this.toString());
	}

	@Override
	public int compareTo(Object o) {
		Play p = (Play) o;
		
		// - before to make it descendent
		return -(this.points - p.points);
	}

}
