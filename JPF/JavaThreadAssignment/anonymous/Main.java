package anonymous;

public class Main {

	public static void main(String[] args) {
		Thread threadMyNameIs = new Thread("My name is ") {
			public void run() {
				for(int i = 1; i <= 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		Thread threadJinho = new Thread("Jinho"){
			public void run() {
				for(int i = 1; i <= 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		};

		threadMyNameIs.start();
		threadJinho.start();
	}

}
