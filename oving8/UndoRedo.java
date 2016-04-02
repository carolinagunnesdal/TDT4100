package oving8;

import java.util.Stack;

public class UndoRedo {
	
	Brett brettet;
	Stack<Brikker[][]> undo;
	Stack<Brikker[][]> redo;
	
	public UndoRedo(Brett brett){
		this.brettet = brett;
		
		undo = new Stack<Brikker[][]>();
		redo = new Stack<Brikker[][]>();
		undo.push(this.brettet.brett);
	}
	
	
	public void trekk(Brett brett){
		undo.push(this.brettet.brett);
		this.brettet = brett;
	}
	
	public Brett undoMove(){
		Brikker[][] temp = undo.pop();
		String board = "";
		for(int i = 0;i<temp.length;i++){
			for(int j = 0;j<temp[0].length;j++){
				board+=temp[i][j];
			}
			board+="\n";
		}
		System.out.println("Test0\n"+board);
		
		//this.brettet.brett = temp;
		redo.push(temp);
		this.brettet = new Brett(board);
		return this.brettet;
	}
	
	public Brett redoMove(){
		Brikker[][] temp = redo.pop();
		this.brettet.brett = temp;
		undo.push(temp);
		return this.brettet;
	}
	
	public static void main(String[] args) {
		Brett testbrett = new Brett(SampleLevels.SAMPLE_LEVEL2);
		UndoRedo a = new UndoRedo(testbrett);
		
		System.out.println("Før");
		System.out.println(testbrett);
		//System.out.println(a.undoMove());
		
		
		testbrett.hoyre();
		a.trekk(testbrett);
		System.out.println(testbrett);
		a.undoMove();
		System.out.println("Test\n"+a.undoMove());
	}
}
