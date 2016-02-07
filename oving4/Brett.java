package oving4;

public class Brett {
	Brikker[][] brett;
	int hoyde,bredde, spillerX,spillerY;
	
	public Brett(String board){
		//Initialiserer brettet. Lager en tabell av datatypen Brikker (se Java-klassen).
		String[] temp = board.split("\n");
		hoyde = temp.length;
		bredde = temp[0].length(); //Antar at banen er en perfekt firkant.
		brett = new Brikker[hoyde][bredde];
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp[i].length();j++){
				brett[i][j] = new Brikker(temp[i].charAt(j));
				if(brett[i][j].spiller()){
					endrespillerY(i);
					endrespillerX(j);
				}
			}
		}
	}
	
	public void endrespillerX(int x){
		this.spillerX = x;
	}
	
	public void endrespillerY(int y){
		this.spillerY = y;
	}
	public void opp(){
		int x = this.spillerX;
		int y = this.spillerY;
		
		if(brett[y-1][x].hentbrikke()=='#'){
			throw new IllegalArgumentException("Kan ikke gå i veggen oppover!");
		}
		else if((brett[y-1][x].hentbrikke() == '$' || brett[y-1][x].hentbrikke() == '*') && !brett[y-2][x].tomt()){
			throw new IllegalArgumentException("Kan ikke dytte en boks inn i noe!");
		}
		
		char er = (brett[y][x].hentbrikke() == '+') ? '.' : ' ';
		
		if(brett[y-1][x].tomt() && !brett[y-1][x].maal()){
			endrespillerY(y-1);
			brett[y][x].endrepos(er);
			brett[y-1][x].endrepos('@');
		}
		else if(brett[y-1][x].maal()){
			endrespillerY(y-1);
			brett[y][x].endrepos(er);
			brett[y-1][x].endrepos('+');
		}
		else if(brett[y-1][x].hentbrikke()=='$' && brett[y-2][x].hentbrikke()=='.'){
			endrespillerY(y-1);
			brett[y][x].endrepos(er);
			brett[y-1][x].endrepos('@');
			brett[y-2][x].endrepos('*');
		}
		else if(brett[y-1][x].hentbrikke() == '$' && brett[y-2][x].tomt()){
			endrespillerY(y-1);
			brett[y][x].endrepos(er);
			brett[y-1][x].endrepos('@');
			brett[y-2][x].endrepos('$');
		}
		else if(brett[y-1][x].hentbrikke() == '*' && brett[y-2][x].tomt()){
			endrespillerY(y-1);
			brett[y][x].endrepos(er);
			brett[y-1][x].endrepos('+');
			if(brett[y-2][x].maal()){
				brett[y-2][x].endrepos('*');
			}
			else{
				brett[y-2][x].endrepos('$');
			}
		}
	}
	
	public void ned(){
		int x = this.spillerX;
		int y = this.spillerY;
		
		if(brett[y+1][x].hentbrikke()=='#'){
			throw new IllegalArgumentException("Kan ikke gå i veggen nedover!");
		}
		else if((brett[y+1][x].hentbrikke() == '$' || brett[y+1][x].hentbrikke() == '*') && !brett[y+2][x].tomt()){
			throw new IllegalArgumentException("Kan ikke dytte en boks inn i noe!");
		}
		
		char er = (brett[y][x].hentbrikke() == '+') ? '.' : ' ';
		
		if(brett[y+1][x].tomt() && !brett[y+1][x].maal()){
			endrespillerY(y+1);
			brett[y][x].endrepos(er);
			brett[y+1][x].endrepos('@');
		}
		else if(brett[y+1][x].maal()){
			endrespillerY(y+1);
			brett[y][x].endrepos(er);
			brett[y+1][x].endrepos('+');
		}
		else if(brett[y+1][x].hentbrikke()=='$' && brett[y+2][x].hentbrikke()=='.'){
			endrespillerY(y+1);
			brett[y][x].endrepos(er);
			brett[y+1][x].endrepos('@');
			brett[y+2][x].endrepos('*');
		}
		else if(brett[y+1][x].hentbrikke() == '$' && brett[y+2][x].tomt()){
			endrespillerY(y+1);
			brett[y][x].endrepos(er);
			brett[y+1][x].endrepos('@');
			brett[y+2][x].endrepos('$');
		}
		else if(brett[y+1][x].hentbrikke() == '*' && brett[y+2][x].tomt()){
			endrespillerY(y+1);
			brett[y][x].endrepos(er);
			brett[y+1][x].endrepos('+');
			if(brett[y+2][x].maal()){
				brett[y+2][x].endrepos('*');
			}
			else{
				brett[y+2][x].endrepos('$');
			}
		}
		
	}
	
	public void venstre(){
		int x = this.spillerX;
		int y = this.spillerY;
		
		if(x-1<0){
			throw new IllegalArgumentException("Det funker dårlig...");
		}
		else if(brett[y][x-1].hentbrikke() == '#'){
			throw new IllegalArgumentException("Kan ikke gå i veggen.");
		}
		else if((brett[y][x-1].hentbrikke() == '$' || brett[y][x-1].hentbrikke() == '*') && !brett[y][x-2].tomt()){
			throw new IllegalArgumentException("Kan ikke dytte en boks inn i noe!");
		}
		
		char er = (brett[y][x].hentbrikke() == '+') ? '.' : ' ';
		
		if(brett[y][x-1].maal()){
			endrespillerX(x-1);
			brett[y][x].endrepos(er);
			brett[y][x-1].endrepos('+');
		}
		else if(brett[y][x-1].tomt()){
			endrespillerX(x-1);
			brett[y][x].endrepos(er);
			brett[y][x-1].endrepos('@');
		}
		else if(brett[y][x-1].hentbrikke() == '$' && brett[y][x-2].hentbrikke()=='.'){
			endrespillerX(x-1);
			brett[y][x].endrepos(er);
			brett[y][x-1].endrepos('@');
			brett[y][x-2].endrepos('*');
		}
		else if(brett[y][x-1].hentbrikke() == '$'  && brett[y][x-2].tomt()){
			endrespillerX(x-1);
			brett[y][x].endrepos(er);
			brett[y][x-1].endrepos('@');
			brett[y][x-2].endrepos('$');
		}
		else if(brett[y][x-1].hentbrikke() == '*' && brett[y][x-2].tomt()){
			endrespillerX(x-1);
			brett[y][x].endrepos(er);
			brett[y][x-1].endrepos('+');
			if(brett[y][x-2].maal()){
				brett[y][x-2].endrepos('*');
			}
			else{
				brett[y][x-2].endrepos('$');
			}
		}
	}
	
	public void hoyre(){
		int x = this.spillerX;
		int y = this.spillerY;
		
		if(x+2>brett[0].length){
			throw new IllegalArgumentException("Det går nok dårlig, ja.");
		}
		else if(brett[y][x+1].hentbrikke()=='#'){
			throw new IllegalArgumentException("Nå krasjer du i veggen.");
		}
		else if((brett[y][x+1].hentbrikke() == '$' || brett[y][x+1].hentbrikke()=='*') && !brett[y][x+2].tomt()){
			throw new IllegalArgumentException("Kan ikke dytte en boks inn i noe.");
		}
		
		char er = (brett[y][x].hentbrikke() == '+') ? '.' : ' ';
		
		if(brett[y][x+1].maal()){
			endrespillerX(x+1);
			brett[y][x].endrepos(er);
			brett[y][x+1].endrepos('+');
		}
		else if(brett[y][x+1].tomt()){
			endrespillerX(x+1);
			brett[y][x].endrepos(er);
			brett[y][x+1].endrepos('@');
		}
		else if(brett[y][x+1].hentbrikke() == '$' && brett[y][x+2].hentbrikke()=='.'){
			endrespillerX(x+1);
			brett[y][x].endrepos(er);
			brett[y][x+1].endrepos('@');
			brett[y][x+2].endrepos('*');
		}
		else if((brett[y][x+1].hentbrikke() == '$' || brett[y][x+1].hentbrikke() == '*')  && brett[y][x+2].tomt()){
			endrespillerX(x+1);
			brett[y][x].endrepos(er);
			brett[y][x+1].endrepos('@');
			brett[y][x+2].endrepos('$');
		}
		else if(brett[y][x+1].hentbrikke() == '*' && brett[y][x+2].tomt()){
			endrespillerX(x+1);
			brett[y][x].endrepos(er);
			brett[y][x+1].endrepos('+');
			if(brett[y][x+2].maal()){
				brett[y][x+2].endrepos('*');
			}
			else{
				brett[y][x+2].endrepos('$');
			}
		}
	}
	
	public boolean ferdig(){
		//Ferdig når det er 0 $ igjen på kartet.
		int antall = 0;
		Brikker[][] brettet = this.brett;
		for(int i = 0; i<brettet.length;i++){
			for(int j = 0; j<brettet.length;j++){
				if(brettet[i][j].hentbrikke() == '$'){
					antall++;
				}
			}
		}
		if(antall>0){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	
	@Override
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
		Brett k = new Brett(SampleLevels.SAMPLE_LEVEL2);
		System.out.println(k);
	}
}
