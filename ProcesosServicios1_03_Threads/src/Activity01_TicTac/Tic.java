package Activity01_TicTac;

public class Tic extends Thread {
	
	String tic;
	
	public Tic(String tic) {
		this.tic= tic;
	}
	
	public void run() {
		while(true) {
			System.out.println(tic);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
