package Example07_Production;

public class Test {
	
	public static void main(String[] args) {
		Cola cola = new Cola();
		Producer llorch = new Producer(cola, 8);
		Consumer paco = new Consumer(cola, -33);
		
		llorch.start();
		paco.start();
	}

}
