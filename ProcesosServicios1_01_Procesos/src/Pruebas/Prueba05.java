package Pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prueba05 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] arg) throws IOException {
		// creating list of commands
		List list = new ArrayList();

		list.add("notepad.exe");
		list.add("xyz.txt");

		// creating the process
		ProcessBuilder build = new ProcessBuilder(list);

		// checking if error stream is redirected
		System.out.println(build.redirectErrorStream());

	}

}
