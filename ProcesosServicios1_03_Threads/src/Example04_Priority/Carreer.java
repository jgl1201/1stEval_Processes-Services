package Example04_Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Carreer {

	static Scanner sc = new Scanner(System.in);

	ArrayList<Athlete> finalists = new ArrayList<Athlete>();

	Carreer() {

	}

	// initialize the carreer
	Carreer(ArrayList<Athlete> finalists) {
		this.finalists = finalists;
	}

	public int numParticipants() {
		System.out.println("Numero de competidores: ");
		int participants = sc.nextInt();
		// sc.close();
		return participants;
	}

	public void startCarreer() {
		int participants = numParticipants();

		for (int i = 0; i < participants; i++) {
			System.out.println("Competidor " + (i + 1));

			System.out.println("Nombre: ");
			String name = sc.next();
			System.out.println("Pais: ");
			String country = sc.next();
			System.out.println("Dorsal: ");
			int dorsal = sc.nextInt();

			Athlete athlete = new Athlete(dorsal, name, country);
			finalists.add(athlete);
		}

		// sc.close();
	}

	@SuppressWarnings("unchecked")
	public void showPodium() {
		Collections.sort(finalists);

		System.out.println("Podium:");

		for (Athlete athlete : finalists)
			System.out.println(athlete.toString());
	}

	public void run() {
		System.out.println("Comenzando---");
		Thread t = null;
		for (Athlete athlete : finalists) {
			t = new Thread(athlete);
			t.start();
		}
		try {
			t.join();
		} catch (InterruptedException e) {

		}

	}

}
