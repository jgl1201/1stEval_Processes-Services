package Pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prueba01 {
	
	public static void main(String[] args) throws IOException {
		// Creacion de la lista de proceso
		List<String> list = new ArrayList<>();
		list.add("notepad.exe");
		
		// Creacion del proceso
		ProcessBuilder build = new ProcessBuilder(list);
		
		// Comprobacion de la lista de comando
		System.out.println("Command: " + build.command());
	
		// Inicializacion del proceso
		build.start();
		
		// Codigo que aproveche el proceso lanzado
	}

}
