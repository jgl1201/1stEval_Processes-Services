package Example05_Synchronization;

public class TestCounter {
	
	private static Counter counter;
	
	public static void main(String[] args) {
		counter = new Counter(100);
		ThreadIncrement t1 = new ThreadIncrement("Thread 1", counter);
		ThreadDecrement d1 = new ThreadDecrement("Thread 2", counter);
		t1.start();
		d1.start();
	}

}
