package EjercicioExamen01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Indica entre que dos cantidades sumas.
 * Indica cuantos procesos haces.
 * Crea ficheros de resultados parciales.
 * Crea ek fichero de resultado final (intenta crear un metodo para obntener dicho fichero).
 */
public class Launcher {
	
	// Suma de 1 a 800, en 8 procesos y 8 ficheros más el del resultado 
	
	static final int NUM_PROCESOS = 8;
	static final String PREFIJO_FICHEROS = "EjFich";
	
	public static void launchSumador (int n1, int n2, String fichResultados) throws IOException {
		String comando = "Sumador.java";
		
		File directorioSumador = new File(
			"C:\\Users\\jogal\\eclipse-workspace\\ProcesosServicios1_02_LanzadorProcesos\\src\\EjercicioExamen01\\");
		File fichResultado = new File(fichResultados);
		
		ProcessBuilder pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));
		
		pb.directory(directorioSumador);
		pb.redirectOutput(fichResultado);
		pb.redirectError(new File("errores.txt"));
		
		pb.start();
	}
	
	public static int getResultadoFichero(String nombreFichero) {
		int suma = 0;
		
		try {
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			// SOLO LEE UNA LINEA
			String linea = br.readLine();
			suma = Integer.parseInt(linea);
			br.close();
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
	
	public static void writeOnFile (int sumaTotal, String fichResultados) throws IOException {
		File resultado = new File(fichResultados);
		FileWriter fw = new FileWriter(resultado, true);
		fw.write(sumaTotal + "\n");
		fw.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int salto = (n2 / NUM_PROCESOS) - 1;
		
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1:" + n1);
			int resultadoSumaConSalto = n1 + salto;
			System.out.println("n2:" + resultadoSumaConSalto);
			launchSumador(n1, n1 + salto, PREFIJO_FICHEROS + String.valueOf(i));
			n1 = n1 + salto + 1;
			System.out.println("Suma lanzada...");
		}
		
		Thread.sleep(5000);
		int sumaTotal = getSumaTotal(NUM_PROCESOS);
		writeOnFile(sumaTotal, PREFIJO_FICHEROS + "resultado.txt");
		System.out.println("La suma total es:" + sumaTotal);
	}

}
