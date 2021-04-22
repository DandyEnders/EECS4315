import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Scheduler {

	private Set<String> threads;
	Map<String, List<String>> requirements;
	Map<String, Boolean> requirementStatus;

	public Scheduler(String fileName) throws IllegalArgumentException, IOException {
		super();
		this.threads = new HashSet<String>();
		this.requirements = new HashMap<String, List<String>>();
		this.requirementStatus = new HashMap<String, Boolean>();

		File inputFile = new File(fileName);
		Scanner inputReader = new Scanner(inputFile);

		while (inputReader.hasNextLine()) {
			String data = inputReader.nextLine();
			String[] tokens = data.split(" ");

			String source = tokens[0];
			String target = tokens[2];

			if (this.requirements.get(target) == null) {
				this.requirements.put(target, new ArrayList<String>());
			}

			if (this.requirements.get(source) == null) {
				this.requirements.put(source, new ArrayList<String>());
			}

			this.requirements.get(target).add(source);

			this.threads.add(source);
			this.threads.add(target);
			requirementStatus.put(source, false);
			requirementStatus.put(target, false);

		}

		inputReader.close();
	}

	public synchronized void runWithRequirements(String name) throws InterruptedException {
		if (name != null) {

			for (String req : requirements.get(name)) {
				while (requirementStatus.get(req) == false) {
					wait();
				}
			}

			System.out.println("Thread " + name + " executes");
			this.requirementStatus.put(name, true);
			notifyAll();
		}

	}

	public Set<String> getNames() {
		return this.threads;
	}

}
