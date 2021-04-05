/**
 * A hydrogen molecule. 
 * 
 * @author Franck van Breugel
 */
public class Hydrogen extends Thread {
	private Reactor reactor;

	/**
	 * Initializes this hydrogen thread with the given name and reactor.
	 * 
	 * @param name name of the hydrogen thread
	 * @param reactor reactor reactor that is used to make water
	 */
	public Hydrogen(String name, Reactor reactor) {
		super(name);
		this.reactor = reactor;
	}

	/**
	 * Attempts to bond this hydrogen thread.
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