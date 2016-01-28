package oving3;

import oving3.Nim;
import java.util.Scanner;

public class NimProgram {
	Nim k;
	Scanner skan;
	int spiller=0;
	void init(){
		int initt = 0;
		skan = new Scanner(System.in);
		while(initt==0){
			System.out.println("Hvor mange steiner skal det være i hver haug?");
			System.out.print("> ");
			int stor = skan.nextInt();
			try{
				k = new Nim(stor);
				initt=1;
			}
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	void run(){
		while(!k.isGameOver()){
			if (spiller==0 || spiller==2){
				spiller=1;
			}
			else if(spiller==1){
				spiller=2;
			}
			System.out.println("Spiller "+spiller+" sin tur.");
			System.out.println("Hvor mange steiner ønsker du å fjerne?");
			System.out.print("> ");
			int antall = skan.nextInt();
			System.out.println("Fra hvilken haug ønsker du å fjerne disse?");
			System.out.print("> ");
			int haug = skan.nextInt();
			
			try{
				k.removePieces(antall, haug);
			}
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
				continue;
			}
			if(k.isGameOver()){
				if(spiller==1){
					System.out.println("Spiller 2 vant!");
				}
				else if(spiller==2){
					System.out.println("Spiller 1 vant!");
				}
				break;
			}
		}
	}
	
	public static void main(String args[]){
		NimProgram a = new NimProgram();
		a.init();
		a.run();
	}
}
