package Example06_Bank;

public class Account {

	private int balance;

	Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	void subtract(int amount) {
		balance = balance - amount;
	}

	synchronized void retireMoney(int amount, String name) {
		if (getBalance() >= amount) {
			System.out.println("Se va a retirar saldo " + amount + " (ACTUAL: " + getBalance() + ")");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {}
			subtract(amount);
			System.out.println(name + " retira => " + amount + "(ACTUAL: " + getBalance() + ")");
		} else
			System.out.println(name + " NO puede retirar saldo, NO HAY SALDO(ACTUAL: " + getBalance() + ")");
		if (getBalance() < 0) System.out.println("SALDO NEGATIVO => " + getBalance());
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}

}
