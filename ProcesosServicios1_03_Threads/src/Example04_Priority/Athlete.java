package Example04_Priority;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class Athlete implements Runnable, Comparable  {
	
	int dorsal;
	String name;
	long time;
	String country;
	
	public Athlete(int dorsal, String name, String country) {
		super();
		this.dorsal = dorsal;
		this.name = name;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Athlete [dorsal=" + dorsal + ", name=" + name + ", time=" + time + ", country=" + country + "]";
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		System.out.println(this.name + " preparado");
		Random random = new Random();
		long start = System.currentTimeMillis();
		time = random.nextLong(8000, 12000);
		
		try {
			// min time is 8 seconds and max is 12 seconds
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(this.name + " llegando");
		long end = System.currentTimeMillis();
		//this.time = end - start;
		System.out.println(this.toString());
	}

	@Override
	public int compareTo(Object o) {
		Athlete a = (Athlete) o;
		return (int)(this.time - a.time);
	}
	
	

}
