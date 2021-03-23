
public class Printer extends Thread {
	
	private String name;
	private int number;
	
	public Printer(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= this.number; i++) {
			System.out.println(this.name);
		}
	}
}
