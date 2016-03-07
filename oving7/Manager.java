package oving7;

import java.util.Collection;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
	
	Collection<Employee> ansatte;
	
	int antallAnsatte;
	
	Manager(Collection<Employee> employees){
		if(employees.isEmpty()){
			throw new IllegalArgumentException("En manager må ha minst 1 ansatt.");
		}
		
		this.ansatte = employees;
		this.antallAnsatte = employees.size();
	}
	
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		Clerk employee = (Clerk) chooseEmployee();
		return employee.doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		Clerk employee = (Clerk) chooseEmployee();
		employee.printDocument(document);
	}

	@Override
	public int getTaskCount() {
		int a = 0;
		for(Employee employee : this.ansatte){
			a+=employee.getTaskCount();
		}
		
		return a;
		//return this.ansatte.stream().map(Employee::getTaskCount).reduce((count, nextCount) -> count+nextCount).get();
	}

	@Override
	public int getResourceCount() {
		return antallAnsatte+1; //Ansatte+printer
	}
	
	public Employee chooseEmployee(){
		
		Employee ansatt1 = null;
		Employee ansatt2 = null;
		
		for(Employee employee : this.ansatte){
			
			if(ansatt1 == null){
				ansatt1 = employee;
			}
			if(ansatt2 == null){
				ansatt2 = employee;
			}
			if(ansatt2 != null && employee.getTaskCount() < ansatt2.getTaskCount()){
				return employee;
			}
		}
		return ansatt1;
		
	}
	
	

}
