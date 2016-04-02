package oving8;

import java.util.Stack;
import oving8.Brett;


public class GjentaAngre {
	Brett brett;
	Stack<Brett> angre;
	Stack<Brett> gjenta;
	
	GjentaAngre(Brett start){
		this.brett = start;
		
		angre = new Stack<Brett>();
		angre.push(this.brett);
		
		gjenta = new Stack<Brett>();
		
	}
	
	public void trekk(Brett nyttbrett){
		this.angre.push(this.brett);
		this.gjenta.clear();
		this.brett = nyttbrett;
		
	}
	
	public Brett angretrekk(){
		this.gjenta.push(this.brett);
		this.brett = this.angre.pop();
		return this.brett;
	}
	
	public Brett gjentatrekk(){
		this.angre.push(this.brett);
		this.brett = this.gjenta.pop();
		return this.brett;
	}
	
	public static void main(String[] args) {
		Brett testbrett = new Brett(SampleLevels.SAMPLE_LEVEL2);
		GjentaAngre ag = new GjentaAngre(testbrett);
		System.out.println(ag.angre);
		System.out.println(testbrett);
		System.out.println(ag.brett);
		
		testbrett.hoyre();
		ag.trekk(testbrett);
		System.out.println("ost"+ag.angre);
	}
	
}
