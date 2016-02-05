package oving4;

import java.util.Arrays;
import java.util.Scanner;

public class Sokoban {
	Brett brettet;
	int nivaa;
	Scanner skanner;
	String bevegelse;
	String[] gyldige = {"w","a","s","d"};
	boolean gyldig, init;
	public void init(){
		init = false;
		skanner = new Scanner(System.in);
		while(!init){
			System.out.println("Hvilket nivå ønker du å spille på? Velg fra 1 til-og-med 4.");
			System.out.print("> ");
			nivaa = skanner.nextInt();
			if(nivaa == 1){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL1);
			}
			else if(nivaa == 2){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL2);
			}
			else if(nivaa == 3){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL3);
			}
			else if(nivaa == 4){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL4);
			}
			else{
				System.out.println("Du må velge et nivå mellom 1 og 4.");
			}
		}
	}
	
	public void run(){
		while(!brettet.ferdig()){
			System.out.println(brettet);
			gyldig = false;
			while(!gyldig){
				System.out.print("> ");
				bevegelse = skanner.nextLine();
				if(Arrays.asList(gyldige).contains(bevegelse)){
					gyldig = true;
				}
			}
			try {
				if(bevegelse.equals("w")){
					brettet.opp();
				}
				else if(bevegelse.equals("a")){
					brettet.venstre();
				}
				else if(bevegelse.equals("s")){
					brettet.ned();
				}
				else if(bevegelse.equals("d")){
					brettet.hoyre();
				}
			} 
			catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			//System.out.println(brettet);
		}
		System.out.println("Game over. GG");
		System.out.println(brettet);
	}
	public static void main(String[] args) {
		Sokoban spill = new Sokoban();
		spill.init();
		spill.run();
	}
}
