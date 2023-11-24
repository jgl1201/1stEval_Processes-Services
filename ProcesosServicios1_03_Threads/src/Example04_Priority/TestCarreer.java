package Example04_Priority;

public class TestCarreer {
	
	public static void main(String[] args) {
		Carreer carreer = new Carreer();
		carreer.startCarreer();
		carreer.run();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carreer.showPodium();
		
		System.out.println("Acabo la carrera");
	}

}
