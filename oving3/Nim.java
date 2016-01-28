package oving3;

public class Nim {
	int[] brikker = new int[3];
	//Konstruktører.
	public Nim(int storrelse) {
		if(storrelse<=0){
			throw new IllegalArgumentException("Det gå'kke vettu");
		}
		for(int i=0;i<3;i++){
			brikker[i]=storrelse;
		}
	}
	public Nim(){
		this.brikker[0]=10;
		this.brikker[1]=10;
		this.brikker[2]=10;
	}
	
	public void removePieces(int antall, int maal){
		if(isGameOver()){
			throw new IllegalStateException("Game over.");
		}
		else if(!isValidMove(antall,maal)){
			throw new IllegalArgumentException("Les reglene.");
		}
		this.brikker[maal]-=antall;
	}
	
	public boolean isValidMove(int antall, int maal){
		if(isGameOver()){
			return false;
		}
		else if(antall<1){
			return false;
		}
		else if(this.brikker[maal]-antall<0){
			return false;
		}
		else if(!(maal<3) && !(maal>=0)){
			return false;
		}
		return true;
	}
	
	public boolean isGameOver(){
		return (this.brikker[0]==0 || this.brikker[1]==0 || this.brikker[2]==0);
	}
	
	public int getPile(int maal){
		if(maal>3 || maal<0){
			throw new IllegalArgumentException("Det funker dårlig vettu.");
		}
		return brikker[maal];
	}
	
	public String toString(){
		return "Haug 1: "+brikker[0]+"   Haug 2: "+brikker[1]+"    Haug 3"+brikker[2];
	}
	
	public static void main(String args[]){
		Nim a = new Nim(10);
		System.out.println(a.brikker[0]);
		System.out.println(a.isValidMove(10, 0));
		
	}
}
