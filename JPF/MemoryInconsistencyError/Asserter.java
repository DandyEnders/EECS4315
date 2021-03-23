
public class Asserter implements Runnable {
	
	private Counter counter;
	
	public Asserter(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		assert counter.value() == 1;
		System.out.println("asserted " + counter.value());
		assert false;
	}

}
