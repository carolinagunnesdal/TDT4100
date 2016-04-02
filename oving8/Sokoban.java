package oving8;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Sokoban {
	Brett brettet;
	AngreGjenta reun;
	String nivaa;
	Scanner skanner;
	String bevegelse;
	String[] gyldige = {"w","a","s","d","angre","gjenta","lagre"};
	boolean gyldig, init;
	public void init(){
		init = false;
		skanner = new Scanner(System.in);
		while(!init){
			System.out.println("Hvilket nivå ønker du å spille på? Velg fra 1 til-og-med 4.");
			System.out.print("> ");
			nivaa = skanner.next();
			if(nivaa.equals("1")){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL1);
			}
			else if(nivaa.equals("2")){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL2);
			}
			else if(nivaa.equals("3")){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL3);
			}
			else if(nivaa.equals("4")){
				init = true;
				brettet = new Brett(SampleLevels.SAMPLE_LEVEL4);
			}
			else{
				try {
					String banen = new Scanner(new File(nivaa)).useDelimiter("\\Z").next();
					System.out.println(banen);
					brettet = new Brett(banen);
					init = true;
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Du må velge et nivå mellom 1 og 4.");
				}
			}
			try{
				reun = new AngreGjenta(this.brettet);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void run() throws FileNotFoundException{
		while(!this.brettet.ferdig()){
			System.out.println(this.brettet);
			gyldig = false;
			while(!gyldig){
				System.out.print("> ");
				bevegelse = skanner.nextLine();
				if(Arrays.asList(gyldige).contains(bevegelse)){
					gyldig = true;
				}
			}
			try {
				if(bevegelse.equals("angre")){
					this.brettet = new Brett(this.reun.undoMove());
					System.out.println("Angrett trekk.");
				}
				else if(bevegelse.equals("gjenta")){
					this.brettet = new Brett(this.reun.redoMove());
				}
				else if(bevegelse.equals("lagre")){
					saveProgress();
				}
				else if(bevegelse.equals("w")){
					this.brettet.opp();
					this.reun.nyttTrekk(this.brettet);
				}
				else if(bevegelse.equals("a")){
					this.brettet.venstre();
					this.reun.nyttTrekk(this.brettet);
				}
				else if(bevegelse.equals("s")){
					this.brettet.ned();
					this.reun.nyttTrekk(this.brettet);
				}
				else if(bevegelse.equals("d")){
					this.brettet.hoyre();
					this.reun.nyttTrekk(this.brettet);
				}
			
			} 
			catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			catch (NullPointerException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Game over. GG");
		System.out.println(this.brettet);
	}
	
	public void saveProgress() throws FileNotFoundException{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("savegame.txt"), "utf-8"))) {
			writer.write(this.brettet.toString());
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Lagret spill til savegame.txt.");
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Sokoban spill = new Sokoban();
		spill.init();
		spill.run();
	}
}
