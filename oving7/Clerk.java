package oving7;

import java.util.function.BinaryOperator;


public class Clerk implements Employee{
	
	Printer printer;
	int taskCount;
	
	
	Clerk(Printer printer){
		this.printer = printer;
		taskCount = 0;
	}
	
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		taskCount++;
		printer.printDocument(document, this);
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
	
	public static void main(String[] args) {
		Printer b = new Printer();
		Clerk a = new Clerk(b);
		System.out.println(a.printer.getPrintHistory(a));
	}
}
