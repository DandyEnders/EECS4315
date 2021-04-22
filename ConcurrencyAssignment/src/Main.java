import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try {
			Scheduler scheduler = new Scheduler(args[0]);
			Set<Process> processes = new HashSet<Process>();
			for (String name : scheduler.getNames()) {
				processes.add(new Process(name, scheduler));
			}
			for (Process process : processes) {
				process.start();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
