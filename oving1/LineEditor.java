package oving1;

public class LineEditor {
	String text = "";
	int insertionIndex=0;
	
	void left(){
		if(this.insertionIndex>0){
			this.insertionIndex--;
		}
	}
	
	void right(){
		if(this.insertionIndex<this.text.length()){
			insertionIndex++;
		}
	}
	void insertString(String s){
		this.text = this.text.substring(0,insertionIndex)+s+this.text.substring(insertionIndex,text.length());
		this.insertionIndex+=s.length();
	}
	
	void deleteLeft(){
		if(this.insertionIndex>0){
			this.text = this.text.substring(0,this.insertionIndex-1)+this.text.substring(this.insertionIndex);
			this.insertionIndex--;
		}
	}
	void deleteRight(){
		if(this.insertionIndex<this.text.length()){
			this.text = this.text.substring(0,this.insertionIndex)+this.text.substring(this.insertionIndex+1,this.text.length());
		}
	}
	
	public String toString(){
		return this.text.substring(0,this.insertionIndex)+"|"+this.text.substring(this.insertionIndex,this.text.length());
	}
	
	public static void main(String[] args){
		LineEditor a = new LineEditor();
		a.text="gløshaugen";
		System.out.println(a);
		a.right();
		System.out.println(a);
		a.right();
		System.out.println(a);
		a.deleteLeft();
		System.out.println(a);
		a.deleteRight();
		System.out.println(a);
		a.insertString("olaf");
		System.out.println(a);
	}
	
}
