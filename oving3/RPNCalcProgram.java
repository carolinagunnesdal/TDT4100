package oving3;

import java.util.Scanner;

public class RPNCalcProgram {
	RPNCalc kalk = new RPNCalc();
	public void init(){
	}
	
	public void run(){
		Scanner skan = new Scanner(System.in);
		System.out.println("Avbryt programmet ved å skrive inn \"avbryt\".");
		boolean k = true;
		while(k){
			System.out.println("Tast 0 for å legge til i stacken. Tast 1 for å fjerne og se det øverste elementet.");
			System.out.println("Tast 2 for å se på en spesifikk indeks. Tast 3 for å se størrelsen på stacken.");
			System.out.println("Tast 4 for å gjøre en operasjon på de 2 øverste i stacken. Tast 5 for å se hele stacken.");
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
				System.out.println("Tallet er lagt til å stacken.");
				System.out.println(kalk.toString()+"\n");
			}
			else if(inn.equals("1")){
				System.out.println("Øverste element er: "+kalk.pop()+"\n");
			}
			else if(inn.equals("2")){
				System.out.println("Hva er indeksen?");
				System.out.print("> ");
				int tall = skan.nextInt();
				System.out.println(kalk.peek(tall)+"\n");
			}
			else if(inn.equals("3")){
				System.out.println("Størrelsen på stacken er: "+kalk.getSize()+"\n");
			}
			else if(inn.equals("4")){
				System.out.println("Hva er ønsket operasjon? Velg blant +-*/~");
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
