/**
 * An oxygen molecule. 
 * 
 * @author Franck van Breugel
 */
public class Oxygen extends Thread {
	private Reactor reactor;
	
	/**
	 * Initializes this oxygen thread with the given name and reactor.
	 * 
	 * @param name name of the oxygen thread
	 * @param reactor reactor reactor that is used to make water
	 */
	public Oxygen(String name, Reactor reactor) {
		super(name);
		this.reactor = reactor;
	}

	/**
	 * Attempts to bond this oxygen thread.
	 */
	@Override
	public void run() {
		try {
			this.reactor.bond();
		} catch (IllegalMoleculeException e) {
			e.printStackTrace();
		}
	}
}