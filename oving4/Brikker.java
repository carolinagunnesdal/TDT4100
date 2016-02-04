package oving4;

public class Brikker {
	char brikke;
	char[] gyldige = {'#','.','$','*','@','+',' '};
	public Brikker(char a){
		String tmp = a+"";
		if(String.valueOf(gyldige).contains(tmp)){
			endrepos(a);
		}
		else {
			throw new IllegalArgumentException("Ugyldig brikketype");
		}
	}
	public char hentbrikke(){
		return this.brikke;
	}
	public void endrepos(char a){
		this.brikke = a;
	}
	
	public boolean tomt(){
		return (this.brikke == '.' || this.brikke == ' ');
	}
	
	public boolean spiller(){
		return (this.brikke == '@' || this.brikke == '+');
	}
	public boolean maal(){
		return (this.brikke == '.' || this.brikke == '+');
	}
	public String toString(){
		return this.brikke+"";
	}
	
}
