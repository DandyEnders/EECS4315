import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

public class ExceptionListener extends ListenerAdapter {
	
	private Map<String, LinkedList<String>> exceptionHistory = new TreeMap<String, LinkedList<String>>();

	@Override
	public void exceptionThrown(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		String methodName = arg1.getTopFrameMethodInfo().getName();
		String exceptionName = arg2.getClassInfo().getName();
		
		if (!exceptionHistory.containsKey(methodName)) {
			exceptionHistory.put(methodName, new LinkedList<String>());
		}
		if (!exceptionHistory.get(methodName).contains(exceptionName)) {
			exceptionHistory.get(methodName).add(exceptionName);
		}
		
	}
	
	@Override
	public void searchFinished(Search search) {
		for (String methodName : exceptionHistory.keySet()) {
			System.out.println("In method " + methodName + ", exceptions of the following types are thrown:");
			LinkedList<String> exceptionStack = exceptionHistory.get(methodName);
			for (String exceptionName : exceptionStack) {
				System.out.println("	" + exceptionName);
			}
		}
	}

}