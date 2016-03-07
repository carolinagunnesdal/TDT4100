package oving7;

import java.util.Arrays;
import oving7.Clerk;
import oving7.Employee;
import oving7.Manager;
import oving7.Printer;


public class OfficeProgram {
	public static void main(String[] args) {
		Printer printer = new Printer();

		Clerk ansatt1 = new Clerk(printer);
		Clerk ansatt2 = new Clerk(printer);
		Manager manager = new Manager(Arrays.asList(ansatt1, ansatt2));
		
		ansatt1.printDocument("sdasd");
		ansatt2.printDocument("asdhaskfjhasjkh");
		ansatt2.printDocument("asdhkasdjkh");
		ansatt1.printDocument("asjkha");
		System.out.println(ansatt1.getTaskCount());
		System.out.println(ansatt2.getTaskCount());
		System.out.println(manager.getResourceCount());
	}
	
}
