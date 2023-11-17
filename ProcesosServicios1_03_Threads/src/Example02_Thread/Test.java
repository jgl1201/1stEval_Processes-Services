package Example02_Thread;

public class Test {

	public static void main(String[] args) {
		SecondThread thread;
		
		for(int i = 0; i < 20; i++) {
			thread = new SecondThread(i, i);
			thread.start();
			try {
				thread.join(); //obliga al hilo que lo llama a terminar antes que el hilo desde el que se lanza
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin del programa");
	}
	
}
