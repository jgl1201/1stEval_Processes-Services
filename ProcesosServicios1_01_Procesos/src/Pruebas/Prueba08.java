package Pruebas;

import java.io.IOException;

public class Prueba08 {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("powershell.exe", 
				"echo", "Hello GeeksforGeeks" + "This is ProcessBuilder Example");
		pb.inheritIO();
		
		Process process = pb.start();
		// esperamos a que termine la ejecucion del echo
		process.waitFor();
	}

}
