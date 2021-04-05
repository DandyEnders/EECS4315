
public class Main {

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		Runnable incrementer = new Incrementer(counter);
		Runnable asserter = new Asserter(counter);
		
		Thread threadIncrementer = new Thread(incrementer, "Incrementer");
		Thread threadAsserter = new Thread(asserter, "Asserter");
		
		threadIncrementer.start();
		threadAsserter.start();
		
	}

}
