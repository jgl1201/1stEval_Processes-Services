package Ejemplo05_ContarVocales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Counter {

	// Metodo para un lector, lee ficheros
	// Para leer un fichero
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {

		FileReader lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}

	// Metodo/Herramienta par escribir
	// Para escribir en un fichero
	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {

		FileWriter fileWriter = new FileWriter(nombreFichero);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		return printWriter;
	}

	// para obtener una lista dinamica(Strings) de las lineas de un fichero
	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {

		ArrayList<String> lineas = new ArrayList<String>();
		// usamos el metodo de arriba
		BufferedReader bfr = getBufferedReader(nombreFichero);

		// Leemos líneas del fichero...
		String linea = bfr.readLine();
		while (linea != null) {
			// Y las añadimos al array
			lineas.add(linea);
			linea = bfr.readLine();
		}
		// Fin del bucle que lee líneas
		return lineas;
	}

	// Dado un fichero de entrada y una letra
	// contamos cuantas veces aparece dicha letra
	// y dejamos el recuento en un fichero de salida
	public static void hacerRecuento(String fichEntrada, String letra, String fichSalida)
			throws FileNotFoundException, IOException {

		BufferedReader br = getBufferedReader(fichEntrada);

		PrintWriter pw = getPrintWriter(fichSalida);

		String linea = br.readLine();

		int total = 0;

		// Mientras no queden líneas....
		while (linea != null) {
			// ...recorremos la linea...
			for (int i = 0; i < linea.length(); i++) {
				char leida = linea.charAt(i);
				char pasada = letra.charAt(0);
				// incrementamos el contador
				if (leida == pasada) {
					total++;
				} // fin del if
			} // fin del for

			// Pasamos a la siguiente linea
			linea = br.readLine();
		} // fin while

		// Escribimos el total de vocales
		// en el fichero de salida
		pw.println(total);
		pw.flush();
		// Y cerramos los ficheros
		pw.close();
		br.close();
		// fin del método hacerRecuento
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Se probo con Scanner como por args

		// Scanner sc = new Scanner(System.in);

		System.out.println("intoduzca el nombre de fichero de entrada: ");
		String fileIn = args[0];// sc.nextLine();
		System.out.println("introduzca el caracter a buscar en dicho fichero: ");
		String letter = args[1];// sc.nextLine();
		System.out.println("introduzca el normbre de fichero de salida");
		String fileOut = args[2];// sc.nextLine();

		hacerRecuento(fileIn, letter, fileOut);
	}

}
