package runnable;

public class Printer implements Runnable {
	
	private int number;
	
	public Printer(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= this.number; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
