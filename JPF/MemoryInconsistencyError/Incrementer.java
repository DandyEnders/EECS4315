
public class Incrementer implements Runnable{

	private Counter counter;
	
	public Incrementer(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		counter.increment();
		System.out.println("incremented");
	}

}
