package Ejemplo02_Sumador;

public class Launcher {

	public void lanzarSumador(Integer n1, Integer n2) {
		String clase = "Sumador.Sumador";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Launcher l = new Launcher();
		l.lanzarSumador(1, 51);
		l.lanzarSumador(51, 100);
		System.out.println("Ok");
	}

}
