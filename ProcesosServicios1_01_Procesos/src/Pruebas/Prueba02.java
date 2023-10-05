package Pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prueba02 {

	public static void main(String[] arg) throws IOException {
		// creating list of process, ejecuta el bloc de notas y abre (o crea) el fichero xyz.txt
		List<String> list = new ArrayList<String>();
		list.add("notepad.exe");
		list.add("xyz.txt");

		// create the process
		ProcessBuilder build = new ProcessBuilder(list);

		// checking the command in list
		System.out.println("command: " + build.command());
		
		build.start();

	}

}
