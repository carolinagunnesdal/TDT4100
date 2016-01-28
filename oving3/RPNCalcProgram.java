package oving3;

import java.util.Scanner;

public class RPNCalcProgram {
	RPNCalc kalk = new RPNCalc();
	public void init(){
	}
	
	public void run(){
		Scanner skan = new Scanner(System.in);
		System.out.println("Avbryt programmet ved � skrive inn \"avbryt\".");
		boolean k = true;
		while(k){
			System.out.println("Tast 0 for � legge til i stacken. Tast 1 for � fjerne og se det �verste elementet.");
			System.out.println("Tast 2 for � se p� en spesifikk indeks. Tast 3 for � se st�rrelsen p� stacken.");
			System.out.println("Tast 4 for � gj�re en operasjon p� de 2 �verste i stacken. Tast 5 for � se hele stacken.");
			System.out.print("> ");
			String inn = skan.next();
			if(inn.equals("avbryt")){
				break;
			}
			else if(inn.equals("0")){
				System.out.println("Hva vil du legge til?");
				System.out.print("> ");
				int tall = skan.nextInt();
				kalk.push(tall);
				System.out.println("Tallet er lagt til � stacken.");
				System.out.println(kalk.toString()+"\n");
			}
			else if(inn.equals("1")){
				System.out.println("�verste element er: "+kalk.pop()+"\n");
			}
			else if(inn.equals("2")){
				System.out.println("Hva er indeksen?");
				System.out.print("> ");
				int tall = skan.nextInt();
				System.out.println(kalk.peek(tall)+"\n");
			}
			else if(inn.equals("3")){
				System.out.println("St�rrelsen p� stacken er: "+kalk.getSize()+"\n");
			}
			else if(inn.equals("4")){
				System.out.println("Hva er �nsket operasjon? Velg blant +-*/~");
				System.out.print("> ");
				char c = skan.next().charAt(0);
				kalk.performOperation(c);
				System.out.println(kalk.toString()+"\n");
			}
			else if(inn.equals("5")){
				System.out.println(kalk.toString()+"\n");
			}
			
			
			
		}
		skan.close();
	}
	
	
	public static void main(String args[]){
		RPNCalcProgram ole = new RPNCalcProgram();
		ole.init();
		ole.run();
	}
}
