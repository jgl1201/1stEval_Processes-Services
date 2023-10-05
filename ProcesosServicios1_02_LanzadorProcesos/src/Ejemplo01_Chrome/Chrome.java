package Ejemplo01_Chrome;

public class Chrome {

	public void ejecutar(String ruta) {

		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		Chrome lp = new Chrome();
		lp.ejecutar(ruta);
		System.out.println("Finalizado");
	}
}
