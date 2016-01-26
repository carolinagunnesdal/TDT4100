package oving2;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Person {
	String navn, fornavn, etternavn, epost;
	char kjonn;
	Date fodselsdato;
	
	boolean godkjentnavn(String a){
		if(a.contains(" ")){
			String[] split = a.split(" ");
			String temp1 = split[0];
			String temp2 = split[1];
			//Sjekker om fornavn og etternavn bare består av bokstaver i det norske alfabetet. Regex.
			if(temp1.matches("[a-zA-ZæøåÆØÅ]+") && temp2.matches("[a-zA-ZæøåÆØÅ]+")){
				if (temp1.length()>=2 && temp2.length()>=2){
					return true;
				}
			}
		}
		return false;
	}
	
	void setName(String name){
		if(godkjentnavn(name)){
			this.navn=name;
			this.fornavn = name.split(" ")[0];
			this.etternavn = name.split(" ")[1];
		}
		else {
			throw new IllegalArgumentException("Ikke godkjent navn");
		}
	}
	
	
	boolean godkjentepost(String epost) {
		String[] splitt1 = epost.split("@");
		if(splitt1.length!=2){
			System.out.println("1");
			throw new IllegalArgumentException(epost+" inneholder ikke @ eller 2 deler før og etter @.");
		}
		String[] splitt2=epost.split("\\W");
		String[] cc = Locale.getISOCountries();
		if(splitt2.length !=4){
			System.out.println("2");
			throw new IllegalArgumentException(epost+" består ikke av nok elementer.");
		}
		
		if(!(epost.toLowerCase().contains(this.fornavn.toLowerCase()) && epost.toLowerCase().contains(this.etternavn.toLowerCase()))){
			System.out.println("3");
			throw new IllegalStateException(epost+" passer ikke til navnet.");
		}
		else if(!Arrays.asList(cc).contains(splitt2[3].toUpperCase())){
			System.out.println("4");
			throw new IllegalArgumentException(epost+" domenet finnes ikke.");
		}
		return true;
		
	}
	
	
	void setEmail(String e){
		if(godkjentepost(e)){
			this.epost = e;
		}
		else {
			throw new IllegalArgumentException("Ikke godkjent epost.");
		}
	}
	
	void setBirthday(Date dato){
		if(dato.before(new Date())){
			this.fodselsdato = dato;
		}
		else{
			throw new IllegalArgumentException("Ikke godkjent bursdag.");
		}
	}
	
	void setGender(char g){
		String a = g+"";
		if(a.equals("M")||a.equals("F")||a.equals("\0")){
			this.kjonn = g;
		}
		else {
			throw new IllegalArgumentException("Ugyldig kjønn.");
		}
	}
	
	String getName(){
		return this.navn;
	}
	

	public String getEmail() {
		return this.epost;
	}

	public Date getBirthday() {
		return this.fodselsdato;
	}

	public char getGender() {
		return this.kjonn;
	}
	
	
	public static void main(String args[]){
		Person alfred = new Person();
		alfred.setName("Ola Nordmann");
		alfred.setEmail("ola.nordmann@ntnu.no");
		//System.out.println(alfred.godkjentepost("ost.nordmann@ntnu.no"));
	}
	
	
}
