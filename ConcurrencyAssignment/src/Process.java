public class Process extends Thread {

	private String name;
	private Scheduler scheduler;

	public Process(String name, Scheduler scheduler) {
		super();
		this.name = name;
		this.scheduler = scheduler;
	}

	@Override
	public void run() {
		try {
			this.scheduler.runWithRequirements(this.name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getThreadName() {
		return name;
	}

}
