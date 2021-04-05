/**
 * Makes water by combining oxygen and hydrogen molecules.
 * 
 * @author Franck van Breugel
 */
public class MakingWater {
	private MakingWater() {}
	
	/**
	 * Combines a number of oxygen and hydrogen molecules forming water.
	 * Prints the formed bondings.
	 * 
	 * @param args[0] number of oxygen molecules
	 * @param args[1] number of hydrogen molecules
	 */
	public static void main(String[] args) {
		Reactor reactor = new Reactor();

		final int OXYGEN = Integer.parseInt(args[0]);
		final int HYDROGEN = Integer.parseInt(args[1]);

		Oxygen[] oxygen = new Oxygen[OXYGEN];
		Hydrogen[] hydrogen= new Hydrogen[HYDROGEN];

		for (int i = 0; i < OXYGEN; i++) {
			oxygen[i] = new Oxygen("Oxygen " + i, reactor);
		}
		for (int i = 0; i < HYDROGEN; i++) {
			hydrogen[i] = new Hydrogen("Hydrogen " + i, reactor);
		}

		for (int i = 0; i < OXYGEN; i++) {
			oxygen[i].start();
		}
		for (int i = 0; i < HYDROGEN; i++) {
			hydrogen[i].start();
		}

		try {
			for (int i = 0; i < OXYGEN; i++) {
				oxygen[i].join();
			}
			for (int i = 0; i < HYDROGEN; i++) {
				hydrogen[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("Something went with joining.");
		}

		System.out.println(reactor.getBondings());
	}
}