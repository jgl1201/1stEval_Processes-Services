package Example06_Bank;

public class TestAccount {
	
	public static void main(String[] args) {
		System.out.println("SACANDO DINERO");
		
		Account account = new Account(40);
		RetireMoney ana = new RetireMoney("ANA", account);
		RetireMoney juan = new RetireMoney("JUAN", account);
		
		ana.start();
		juan.start();
	}

}
