package Ejemplo03_SumadorFicheros;

import java.io.File;

public class Launcher {

	// nuevo parametro --> fichero de almacenamiento para el resultado
	public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
		String clase = "C:\\Users\\jogal\\eclipse-workspace\\ProcesosServicios1_02_LanzadorProcesos\\src\\SumadorFicheros\\Sumador.java";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Launcher l = new Launcher();
		l.lanzarSumador(1, 10, "suma1.txt");
		l.lanzarSumador(11, 20, "suma2.txt");
		System.out.println("Ok");
	}
}
