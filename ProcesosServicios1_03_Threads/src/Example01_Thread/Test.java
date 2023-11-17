package Example01_Thread;

public class Test {
	
	public static void main(String[] args) {
		FirstThread ft1 = new FirstThread(10);
		FirstThread ft2 = new FirstThread(400);
		System.out.println("antes de arrancar el hilo");
		
		ft1.start();
		ft2.start();
	}

}
