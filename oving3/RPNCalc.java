package oving3;
import java.util.ArrayList;

public class RPNCalc {
	ArrayList<Double> stack=new ArrayList<Double>();
	String operands = "+-*/~";
	
	
	
	public void push(double arg){
		this.stack.add(arg);
	}
	
	public double pop(){
		if(stack.isEmpty()){
			return Double.NaN;
		}
		double topp = this.stack.get(getSize()-1);
		this.stack.remove(getSize()-1);
		return topp;
	}
	
	public double peek(int indeks){
		if(indeks<0 || indeks>=getSize()){
			return Double.NaN;
		}
		return this.stack.get(getSize()-indeks-1);
	}
	
	public int getSize(){
		return this.stack.size();
	}
	
	public void performOperation(char opp){
		String k = opp + "";
		if(!operands.contains(k)){
			throw new IllegalArgumentException("Operanden er ugyldig.");
		}
		else if(getSize()<2){
			throw new IllegalStateException("Ikke nok tall å bruke.");
		}
		
		double a,b,c;
		c=0;
		a=pop();
		b=pop();
		switch(opp){
		case '*':
			c=b*a;
			push(c);
			break;
		case '/':
			c=b/a;
			push(c);
			break;
		case '+':
			c=b+a;
			push(c);
			break;
		case '-':
			c=b-a;
			push(c);
			break;
		case '~':
			push(a);
			push(b);
			break;
		}
	}
	
	public String toString(){
		return "Stacken : " + this.stack;
	}
	
	
	public static void main(String args[]){
		RPNCalc k = new RPNCalc();
		
		for(int i=0;i<10;i++){
			k.push(i+1);
		}
		
		System.out.println(k);
		k.performOperation('+');
		System.out.println(k);
	}
}
