import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

/**
 * Listener that monitors
 * <ul>
 * <li>when the bond method is entered,<li>
 * <li>when the bond method is exited, and</li>
 * <li>when a thread is interrupted.</li>
 * </ul>
 * 
 * @author Franck van Breugel
 */
public class MakingWaterListener extends ListenerAdapter {
	/**
	 * Prints the name of the thread that enters the bond method.
	 * 
	 * @param vm JPF's virtual machine
	 * @param currentThread the thread that invokes the method
	 * @param enteredMethod the method that is invoked
	 */
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		String methodName = enteredMethod.getName();
		if (methodName.equals("bond")) {
			String threadName = currentThread.getName();
			System.out.printf("Thread %s enters method %s.\n", threadName, methodName);
		}
	}
	
	/**
	 * Prints the name of the thread that exits the bond method.
	 * 
	 * @param vm JPF's virtual machine
	 * @param currentThread the thread that returns from the method
	 * @param enteredMethod the method from which is returned
	 */
	public void methodExited(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		String methodName = enteredMethod.getName();
		if (methodName.equals("bond")) {
			String threadName = currentThread.getName();
			System.out.printf("Thread %s exits method %s.\n", threadName, methodName);
		}
	}
	
	/**
	 * Prints the name of the thread that is interrupted.
	 * 
	 * @param vm JPF's virtual machine
	 * @param interruptedThread the thread that is interrupted
	 */
	public void threadInterrupted(VM vm, ThreadInfo interruptedThread) {
		String threadName = interruptedThread.getName();
		System.out.printf("Thread %s interrupted.\n", threadName);
	}
}