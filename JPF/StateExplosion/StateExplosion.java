
public class StateExplosion {

	public static void main(String[] args) {
		try {
			if (args.length == 1) {
				Integer nThreads = Integer.parseInt(args[0]);

				for (int i = 1; i <= nThreads; i++) {
					Thread newThread = new Thread("" + i) {
						public void run() {
							System.out.println("Thread #" + Thread.currentThread().getName());
						}
					};

					newThread.start();
				}

			} else {
				System.out.println("There must be one argument.");
			}
		} catch (Exception e) {
			System.out.println("Argument must be integer parseable.");
			e.printStackTrace();
		}

	}

}
