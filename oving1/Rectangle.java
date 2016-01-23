package oving1;

public class Rectangle {
	int x1=0; int x2=0; int y1=0; int y2=0;
	boolean isEmpty = true;
	
	int getMinX(){
		if(isEmpty){
			return 0;
		}
		else {
			return Math.min(this.x1, this.x2);
		}
	}
	int getMinY(){
		if(isEmpty){
			return 0;
		}
		else{
			return Math.min(this.y1,this.y2);
		}
	}
	int getMaxX(){
		if(isEmpty){
			return 0;
		}
		else{
			return Math.max(this.x1,this.x2);
		}
	}
	int getMaxY(){
		if(isEmpty){
			return 0;
		}
		else{
			return Math.max(this.y1,this.y2);
		}
	}
	int getWidth(){
		if(isEmpty){
			return 0;
		}
		else {
			return Math.max(x1, x2)-Math.min(x1, x2);
		}
	}
	int getHeight(){
		if(isEmpty){
			return 0;
		}
		else{
			return Math.max(x1, y1)-Math.min(x1, y1);
		}
	}
	boolean isEmpty(){
		if(x1-x2==0 || y1-x1==0){
			return true;
		}
		return false;
	}
	boolean contains(int x, int y){
		if((x>=Math.min(x1, x2) && x<=Math.max(x1, x2) && y>=Math.min(y1, y2) && y<=Math.max(y1, y2))){
			return true;
		}
		return false;
	}
	boolean contains(Rectangle rect){
		if (contains(rect.x1,rect.y2)){
			return true;
		}
		return false;
	}
	boolean add(int x, int y){
		if(contains(x,y)){
			return false;
		}
		else if() {
			
		}
		
	}
	
	
}
