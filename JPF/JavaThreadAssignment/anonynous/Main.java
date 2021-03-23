
public class Main {

	public static void main(String[] args) {
		
		Runnable runnableMyNameIs = new Runnable() {
			public void run() {
				for(int i = 1; i <= 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		Runnable runnableJinho = new Runnable() {
			public void run() {
				for(int i = 1; i <= 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		
		
		Thread threadMyNameIs = new Thread(runnableMyNameIs, "My name is ");
		Thread threadJinho = new Thread(runnableJinho, "Jinho");

		threadMyNameIs.start();
		threadJinho.start();
	}

}
