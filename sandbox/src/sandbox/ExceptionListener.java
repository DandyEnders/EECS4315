package sandbox;

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
	
	private String currentMethodName = null;
	private Map<String, LinkedList<String>> exceptionHistory = new TreeMap<String, LinkedList<String>>();

	@Override
	public void exceptionBailout(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		String methodName = "name";
		String exceptionName = "exception";
		if (!exceptionHistory.containsKey(methodName)) {
			exceptionHistory.put(methodName, new LinkedList<String>());
		}
		if (!exceptionHistory.get(methodName).contains(exceptionName)) {
			exceptionHistory.get(methodName).add(exceptionName);
		}
		
	}

	@Override
	public void exceptionHandled(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exceptionThrown(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		System.out.println("	" + arg2.getClassInfo().getName() + " " + this.currentMethodName);
		
	}

	@Override
	public void methodEntered(VM arg0, ThreadInfo arg1, MethodInfo arg2) {
		String methodName = arg2.getName();
		if (methodName.equals("main") || methodName.equals("first") || methodName.equals("second")) {
			this.currentMethodName = arg2.getName();
			System.out.println("In method " + this.currentMethodName + ", exceptions of the following types are thrown:");
		}
	}

	@Override
	public void methodExited(VM arg0, ThreadInfo arg1, MethodInfo arg2) {
		this.currentMethodName = null;
		
	}
	
	@Override
	public void searchFinished(Search search) {
		for (String methodName : exceptionHistory.keySet()) {
			System.out.println("In method " + this.currentMethodName + ", exceptions of the following types are thrown:");
			LinkedList<String> exceptionStack = exceptionHistory.get(methodName);
			for (String exceptionName : exceptionStack) {
				System.out.println("	" + exceptionName);
			}
		}
	}

}
