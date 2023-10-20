package Ejemplo05_ContarVocales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Launcher {

	/*
	 * 1. Recoger el primer parámetro (args[0]), que contendrá el fichero a
	 * procesar. 2. Recoger el segundo parámetro, que contendrá el directorio de
	 * “CLASSPATH” donde habrá que buscar la clase “UtilidadesFicheros”. ????? 3.
	 * Recoger el tercer parámetro, que contendrá el directorio donde habrá que
	 * buscar la clase “Contador”. 4. Una vez recogidos los parámetros, se lanzarán
	 * VARIOS procesos utilizando la clase “ProcessBuilder”. 5. Los procesos se
	 * ejecutarán y después recogeremos los resultados en UNOS FICHEROS con un dato
	 * ENTERO
	 */
	@SuppressWarnings("resource")
	public static int getResultadoFichero(String nombreFichero) {

		int suma = 0;

		try {
			// cañeria al fichero
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);

			// SOLO LEE UNA LINEA
			String linea = br.readLine();
			suma = Integer.parseInt(linea);
			return suma;
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + nombreFichero);
		} catch (IOException e) {
			System.out.println("No hay nada en " + nombreFichero);
		}
		return suma;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException {
		// Fichero song.txt
		String entrada ="song.txt"; //args[0];
		// Otra forma
		//String entrada = args[0];

		/*
		 * String classpathUtilidades; classpathUtilidades = args[1];
		 */

		// C:\\ruta hasta contador.java
		// String ruta ="\\src\\ejemplo5\\Contador.java";// args[1];
		// Otra forma
		String ruta = "\\src\\Ejemplo05_ContarVocales\\Counter.java";
		// OJO MAYUSCULAS Y MINUSCULAS
		String[] vocales = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		// "C:\Users\jogal\eclipse-workspace\ProcesosServicios1_02_LanzadorProcesos\src\Ejemplo05_ContarVocales\Counter.java"
		// No me funciona ni a Pepe ni a otro
		String classPath = System.getProperty("user.dir");

		// revisar
		//String classPath = System.getProperty("user.dir");
		// borro lo comentado abajo
		// classPath = ruta ;//+ ":" +
		// classpathUtilidades;
		System.out.println("Usando ruta:" + ruta);
		System.out.println("Usando classpath: " + classPath);
		System.out.println("classpath+ruta " + classPath + ruta);

		// se lanzan los procesos
		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", classPath + ruta, entrada, vocales[i], vocales[i] + ".txt");
			System.out.println(entrada);
			// Si hay algún error, almacenarlo en un fichero
			pb.redirectError(new File(fichErrores));
			pb.start();
			// fin del for
		}

		// COMO MOSTRARIAMOS los resultados de cada fichero
		// COMO guardariamos dichos resultados en un fichero resultados totales
		Thread.sleep(1000);

		// total de vocales
		String res = "RES.txt";
		File f = new File("RES.txt");

		PrintWriter pw = Counter.getPrintWriter(res);

		for (int i = 0; i < vocales.length; i++) {
			// abrir a.txt y mostrar a consola su resultado y demas vocales
			// valueOf() para forzarlo a que transforme a String los Integers
			String cad = "El numero de " + vocales[i] + " es: " + String.valueOf(getResultadoFichero(vocales[i] + ".txt"));

			System.out.println(cad);

			pw.append(cad + "\n");

		}
		pw.close();

	}
}