package Example06_Bank;

public class RetireMoney extends Thread {

	private Account account;
	String name;
	
	public RetireMoney(String name, Account account) {
		super(name);
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i <= 4; i++) {
			account.retireMoney(10, this.getName());
		}
	}
	
	
}
