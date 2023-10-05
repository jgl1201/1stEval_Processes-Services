package Pruebas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prueba03 {

	public static void main(String[] arg) throws IOException {
		// creating list of process
		List<String> list = new ArrayList<String>();
		list.add("notepad.exe");
		list.add("abc.txt");

		// creating the process
		ProcessBuilder build = new ProcessBuilder(list);

		// setting the directory, has to exist
		build.directory(new File("src"));

		// checking the directory, on which currently working on
		System.out.println("directory: " + build.directory());
		
		build.start();

	}
}
