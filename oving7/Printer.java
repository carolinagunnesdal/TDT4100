package oving7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	
	Map<Employee, List<String>> employeesPrintingJobs;
	
	public Printer() {
		employeesPrintingJobs = new HashMap<Employee, List<String>>();
	}
	
	public void printDocument(String document, Employee employee) {
		if (document.trim().length() == 0) {
			throw new IllegalArgumentException("The document is emtpy");
		}
		List<String> employeesList;
		if (employeesPrintingJobs.containsKey(employee)) {
			employeesList = employeesPrintingJobs.get(employee);
		} else {
			employeesList = new ArrayList<String>();
		}
		employeesList.add(document); 
		employeesPrintingJobs.put(employee, employeesList);
		System.out.println(document);
	}
	
	public List<String> getPrintHistory(Employee employee) {
		return employeesPrintingJobs.get(employee);
		
	}

}