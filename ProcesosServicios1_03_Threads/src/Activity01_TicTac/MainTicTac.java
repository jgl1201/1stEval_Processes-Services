package Activity01_TicTac;

public class MainTicTac {
	
	public static void main(String[] args) {
		System.out.println("Prueba de tic tac");
		
		Tic tic = new Tic("TIC..............");
		Tac tac = new Tac("TAC**************");
		
		tic.start();
		tac.start();
		try {
			tic.join();
			tac.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
