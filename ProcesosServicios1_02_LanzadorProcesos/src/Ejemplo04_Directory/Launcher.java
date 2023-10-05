package Ejemplo04_Directory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

	static final int NUM_PROCESOS = 4;
	static final String PREFIJO_FICHEROS = "fich";

	public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {
		String comando;
		// No poner el nombre del paquete; Al estar al mismo nivel, no lo va a encontrar, porque dentro del paquete, no existe el propio paquete
		comando = "Sumador.java";

		File directorioSumador = new File(
				"C:\\Users\\jogal\\eclipse-workspace\\ProcesosServicios1_02_LanzadorProcesos\\src\\Ejemplo04_Directory\\");
		File fichResultado = new File(fichResultados);

		ProcessBuilder pb;
		pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));

		// directorio donde busca el comando a ejecutar
		pb.directory(directorioSumador);
		pb.redirectOutput(fichResultado);
		pb.redirectError(new File("errores.txt"));

		pb.start();
	}

	@SuppressWarnings({"resource"})
	public static int getResultadoFichero(String nombreFichero) {
		int suma = 0;

		try {
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

	public static int getSumaTotal(int numFicheros) {
		int sumaTotal = 0;

		for (int i = 1; i <= NUM_PROCESOS; i++) {
			sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i));
		}
		return sumaTotal;
	}

	/**
	 * Recibe dos parámetros y hará la suma de los valores comprendidos entre ambos
	 * parametros
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int salto = (n2 / NUM_PROCESOS) - 1;

		// División de la suma en 4 partes
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1:" + n1);
			int resultadoSumaConSalto = n1 + salto;
			System.out.println("n2:" + resultadoSumaConSalto);
			lanzarSumador(n1, n1 + salto, PREFIJO_FICHEROS + String.valueOf(i));
			n1 = n1 + salto + 1;
			System.out.println("Suma lanzada...");
		}

		// Thread es Hilo, llamamos a un metodo estatico ---> Dormir medio segundo el hilo principal Main
		// para que se hagan las sumas, se guarden, se recuperen los valores, lo sume y lo muestre porque necesita tiempo
		Thread.sleep(5000);
		int sumaTotal = getSumaTotal(NUM_PROCESOS);
		System.out.println("La suma total es:" + sumaTotal);
		
		File resultado = new File("C:\\Users\\jogal\\eclipse-workspace\\ProcesosServicios1_02_LanzadorProcesos\\src\\Ejemplo04_Directory\\resultado.txt");
		FileWriter fw = new FileWriter(resultado, true);
		fw.append("La suma total es: " + sumaTotal);
		fw.close();
	}

}
