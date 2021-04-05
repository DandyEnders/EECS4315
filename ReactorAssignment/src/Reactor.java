import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Jinho Hwang
 *
 */
public class Reactor {
	/**
	 * Number of oxygen molecules to form one water molecule.
	 */
	static volatile int OXYGEN;

	/**
	 * Number of hydrogen molecules to form one water molecule.
	 */
	static volatile int HYDROGEN;

	
	private volatile static List<List<String>> moleculeList;

	private volatile List<String> bondedWaterMolecules;

	/**
	 * Initializes this reactor.
	 */
	public Reactor() {
		this.OXYGEN = 0;
		this.HYDROGEN = 0;
		this.moleculeList = new ArrayList<List<String>>();
		this.bondedWaterMolecules = new ArrayList<String>();
	}

	private synchronized void addMoleculeListIfLess(int nCandidate) {
		if (nCandidate > this.moleculeList.size()) {
			this.moleculeList.add(new ArrayList<String>());
			this.bondedWaterMolecules.add(null);
		}
	}
	
	private synchronized List<String> getnTHMolecule(int index){
		return this.moleculeList.get(index);
	}
	
	private synchronized int getnTHMoleculeSize(int index) {
		return this.moleculeList.get(index).size();
	}
	
	private synchronized void addAOxygenMolecule(int index, String name) {
		this.moleculeList.get(index).add(name);
	}
	
	private synchronized void addAHydrogenMolecule(int index, String name) {
		this.moleculeList.get(index).add(name);
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

		addMoleculeListIfLess(Math.max(OXYGEN, HYDROGEN / 2) + 1);
		
		try {
			if (currentThread instanceof Oxygen || currentThread instanceof Hydrogen) {
				int nTHMolecule = 0;
			
				if (currentThread instanceof Oxygen) {
					nTHMolecule = this.OXYGEN;
					this.OXYGEN++;
				} else if (currentThread instanceof Hydrogen) {
					nTHMolecule = this.HYDROGEN / 2;
					this.HYDROGEN++;
				}
				
				addMoleculeListIfLess( Math.max(OXYGEN, HYDROGEN / 2) + 1);
				
				synchronized (getnTHMolecule(nTHMolecule)) {
					if (getnTHMoleculeSize(nTHMolecule) < 2) {
						addAOxygenMolecule(nTHMolecule, currentThread.getName());
						getnTHMolecule(nTHMolecule).wait();
					} else {
						addAOxygenMolecule(nTHMolecule, currentThread.getName());
						getnTHMolecule(nTHMolecule).notifyAll();
					}
				}
				
				List<String> oneMoleculeList = this.moleculeList.get(nTHMolecule);
				
				String resultMolecule = oneMoleculeList.get(0)
						+ " - "
						+ oneMoleculeList.get(1)
						+ " - "
						+ oneMoleculeList.get(2);
				
				this.bondedWaterMolecules.set(nTHMolecule, resultMolecule);
			} else {
				throw new IllegalMoleculeException("This reactor can only take Hydrogen or Oxygen!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		this.bondedWaterMolecules.remove(null);
		return this.bondedWaterMolecules;
	}
}
