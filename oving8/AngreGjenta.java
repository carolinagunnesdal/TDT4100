package oving8;

import java.util.*;
//Notat: Dette var helt jævli å kode. Frarådes på det sterkeste - koking oppfordres.
public class AngreGjenta {
	
	public Stack<String> undo = new Stack<String>();
	public Stack<String> redo = new Stack<String>();
	Brett spillet;
	
	public AngreGjenta(Brett start){
		this.spillet = start;
		addToUndo(start);
	}
	
	public void addToUndo(Brett brett){
		String dummy = brett.toString();
		//System.out.println("Shits getting added yo\n"+brett);
		this.undo.add(dummy);
		//System.out.println(this.undo);
	}
	
	public void nyttTrekk(Brett nyttbrett){
		this.redo.clear();
		addToUndo(this.spillet);
		this.spillet = nyttbrett;
	}
	
	public String undoMove(){
		int a = this.undo.size()-2;
		String move = this.undo.get(this.undo.size()-2);
		this.undo.remove(a);
		//System.out.println("Move\n"+move);
		this.redo.add(this.spillet.toString());
		this.spillet = new Brett(move);
		return move;
		
	}
	
	public String redoMove(){
		//System.out.println("Redo:"+this.redo);
		String move = this.redo.pop();
		addToUndo(this.spillet);
		this.spillet = new Brett(move);
		return move;
	}
	
	
//	public static void main(String[] args) {
//		Brett test = new Brett(SampleLevels.SAMPLE_LEVEL2);
//		AngreGjenta a = new AngreGjenta(test);
//		
//		System.out.println("0:"+test);
//		
//		test.venstre();
//		a.nyttTrekk(test);
////		System.out.println(test);
////		System.out.println(a.spillet);
////		
//		//System.out.println("ASASDASD\n"+a.undoMove());
//		System.out.println("1:"+a.undoMove());
//		
//		System.out.println("2:"+a.redoMove());
//		
//		
//		
//	}
	
}
