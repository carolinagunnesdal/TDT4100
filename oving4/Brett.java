package oving4;

public class Brett {
	Brikker[][] brett;
	int hoyde,bredde, spillerX,spillerY;
	
	public Brett(String board){
		String[] temp = board.split("\n");
		hoyde = temp.length;
		bredde = temp[0].length(); //Antar at banen er en perfekt firkant.
		brett = new Brikker[hoyde][bredde];
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[i].length();j++){
				brett[i][j] = new Brikker(temp[i].charAt(j));
				if(brett[i][j].spiller()){
					endrespillerXY(i,j);
				}
			}
		}
	}
	
	public void endrespillerXY(int x,int y){
		this.spillerX = x;
		this.spillerY = y;
	}
	
	
//	public boolean godkjent(int x, int y){
//		if(brett[x][y].hentbrikke() == '#'){
//			return false;
//		}
//		else if ((brett[x][y].hentbrikke() == '$' || brett[x][y].hentbrikke() == '*') && (godkjent(x+1,y) || godkjent(x-1,y) || godkjent(x,y+1) || godkjent(x,y-1))){
//			return false;
//		}
//	}
	
	
	public void opp(){
		if(brett[this.spillerX][this.spillerY-1].hentbrikke()=='#'){
			throw new IllegalArgumentException("Kan ikke gå inn i veggen!");
		}
		else if((brett[this.spillerX][this.spillerY-1].hentbrikke() == '$' || brett[this.spillerX][this.spillerY-1].hentbrikke() == '*') && brett[this.spillerX][this.spillerY-2].hentbrikke() == '#'){
			throw new IllegalArgumentException("Kan ikke dytte boksen inn i veggen!");
		}
		
		if(brett[this.spillerX][this.spillerY].hentbrikke() == '+'){
			
		}
		else {
			endrespillerXY(this.spillerX,this.spillerY);
		}
		
	}
	
	
	
	
	public String toString(){
		String res = "";
		for(int k=0; k<this.brett.length;k++){
			for(int l=0; l<this.brett[0].length;l++){
				res+=brett[k][l]+"";
			}
			res+="\n";
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		Brett k = new Brett(SampleLevels.SAMPLE_LEVEL4);
		System.out.println(k);
		k.opp();
		System.out.println(k);
	}
	
}
