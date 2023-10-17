package Ejemplo05_ContarVocales;

import java.io.File;
import java.io.IOException;

public class Launcher {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException {
		String ficheroEntrada = ""; // args[0];
		//String classpathUtilidades = args[1];
		String route = "Counter.java";
		String[] vocales = { "a", "e", "i", "o", "u" };
		String classPath = System.getProperty("java.class.path");
		System.out.println("Usando classpath:" + classPath);
		
		/* Se lanzan los procesos */
		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", "-cp", classPath, "nombre_paquete.ProcesadorFichero", ficheroEntrada,
					vocales[i], vocales[i] + ".txt");
			// Si hay algún error, almacenarlo en un fichero
			pb.redirectError(new File(fichErrores));
			pb.start();
		}

		/* Esperamos un poco */
		Thread.sleep(3000);
	}

}
