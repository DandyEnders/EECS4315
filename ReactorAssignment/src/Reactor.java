import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jinho Hwang
 *
 */
public class Reactor {
	/**
	 * Number of oxygen molecules to form one water molecule.
	 */
	static int OXYGEN;

	/**
	 * Number of hydrogen molecules to form one water molecule.
	 */
	static int HYDROGEN;

	/**
	 * List of number of bonding Hydrogen.
	 */
	private volatile static List<Hydrogen> bondingHydrogen;

	/**
	 * Number of bonding Oxygen.
	 */
	private volatile static List<Oxygen> bondingOxygen;

	/**
	 * Initializes this reactor.
	 */
	public Reactor() {
		this.OXYGEN = 0;
		this.HYDROGEN = 0;

		this.bondingHydrogen = new ArrayList<Hydrogen>();
		this.bondingOxygen = new ArrayList<Oxygen>();
	}

	/**
	 * Putting hydrogen on the imaginary chemistry table.
	 */
	private synchronized void putHydrogenOnTable(Hydrogen h) {
		this.bondingHydrogen.add(h);
		this.HYDROGEN++;
	}

	/**
	 * Putting oxygen on the imaginary chemistry table.
	 */
	private synchronized void putOxygenOnTable(Oxygen o) {
		this.bondingOxygen.add(o);
		this.OXYGEN++;
	}

	/**
	 * Forms a bond in this reactor of the thread invoking this method and other
	 * threads that have invoked this method to form a molecule of water.
	 * 
	 * @throws IllegalMoleculeException - if the thread invoking the method is not
	 *                                  of type Oxygen or Hydrogen
	 */
	public void bond() throws IllegalMoleculeException {
		Thread currentThread = Thread.currentThread();

		if (currentThread instanceof Oxygen) {
			putOxygenOnTable((Oxygen) currentThread);
		} else if (currentThread instanceof Hydrogen) {
			putHydrogenOnTable((Hydrogen) currentThread);
		} else {
			throw new IllegalMoleculeException("This reactor can only take Hydrogen or Oxygen!");
		}
	}

	/**
	 * Returns the list of bondings that are formed in this reactor. Each bonding
	 * consists of a string that combines the names of the threads that are part of
	 * the bonding separated by " - ".
	 * 
	 * @return the bondings that are formed in this reactor
	 */
	public List<String> getBondings() {
		List<String> result = new ArrayList<String>();

		int nWaterMolecules = Math.min(bondingHydrogen.size() / 2, bondingOxygen.size());

		for (int i = 0; i < nWaterMolecules; i++) {
			String aResult = "";

			aResult += bondingHydrogen.get(i * 2).getName();
			aResult += " - ";
			aResult += bondingHydrogen.get(i * 2 + 1).getName();
			aResult += " - ";
			aResult += bondingOxygen.get(i).getName();

			result.add(aResult);
		}

		return result;
	}
}
