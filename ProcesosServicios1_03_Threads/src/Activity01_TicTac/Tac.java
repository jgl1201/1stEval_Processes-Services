package Activity01_TicTac;

public class Tac extends Thread {
	
	String tac;
	
	public Tac(String tac) {
		this.tac= tac;
	}
	
	public void run() {
		while(true) {
			System.out.println(tac);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
