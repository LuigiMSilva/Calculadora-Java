import java.util.Scanner;

public class Calculator {	
	public static void main(String[] args) {	
		int a = 0, b = 0, c = 0;
		double x = 0, y, z = 0, w;
		char ch;
		Pilha<Double> pilhaDa = new Pilha<Double>();
		Pilha<Double> pilhaDb = new Pilha<Double>();
		Pilha<Character> pilhaCa = new Pilha<Character>();
		Pilha<Character> pilhaCb = new Pilha<Character>();
		Scanner teclado = new Scanner(System.in);	
		System.out.println("Informe a equação com parênteses:");
		String equation = teclado.nextLine();		
		while (a < equation.length()) {			
		if (equation.charAt(a) == '(') {b = 0; pilhaDb.push(x);}			
		else if (equation.charAt(a) == '+' || equation.charAt(a) == '-' || equation.charAt(a) == '/' || equation.charAt(a) == '*' || equation.charAt(a) == '^') {				
			pilhaCa.push(equation.charAt(a));
				if (pilhaCb.isEmpty() == false) {
					while (pilhaCb.isEmpty() == false) {
						w = (double) (pilhaCb.pop() - '0');
						z += w * Math.pow(10, c);
						c++;
					}
					pilhaDa.push(z);
					c = 0;
					z = 0;
				}			
		}			
		else if (equation.charAt(a) == ')' && b == 1) {				
			if (pilhaCb.isEmpty() == false) {
				while (pilhaCb.isEmpty() == false) {
					w = (double) (pilhaCb.pop() - '0');
					z += w * Math.pow(10, c);
					c++;
				}
				pilhaDa.push(z);
				c = 0;
				z = 0;
			}								
			if (pilhaDa.isEmpty() == true) {y = x; x = pilhaDb.pop();}				
			else {y = pilhaDa.pop();}				
			ch = pilhaCa.pop();				
			if (ch == '+') {x = x+y;}				
			else if (ch == '-') {x = x-y;}				
			else if (ch == '/') {x = x/y;}				
			else if (ch == '*') {x = x*y;}				
			else if (ch == '^') {x = Math.pow(x, y);}								
		}			
		else if (equation.charAt(a) == ')' && b == 0) {				
			if (pilhaCb.isEmpty() == false) {
				while (pilhaCb.isEmpty() == false) {
					w = (double) (pilhaCb.pop() - '0');
					z += w * Math.pow(10, c);
					c++;
				}
				pilhaDa.push(z);
				c = 0;
				z = 0;
			}				
			y = pilhaDa.pop();				
			if (pilhaDa.isEmpty() == true) {x = pilhaDb.pop();}
			else {x = pilhaDa.pop();}
			ch = pilhaCa.pop();
			if (ch == '+') {x = x+y;}				
			else if (ch == '-') {x = x-y;}				
			else if (ch == '/') {x = x/y;}				
			else if (ch == '*') {x = x*y;}				
			else if (ch == '^') {x = Math.pow(x, y);}
			b = 1;				
		}			
		else if (equation.charAt(a) == '0' || equation.charAt(a) == '1' || equation.charAt(a) == '2' || equation.charAt(a) == '3' || equation.charAt(a) == '4' || equation.charAt(a) == '5' || equation.charAt(a) == '6' || equation.charAt(a) == '7' || equation.charAt(a) == '8' || equation.charAt(a) == '9'){pilhaCb.push(equation.charAt(a));}			
		else {System.out.println("Por favor, insira apenas número inteiros e os operadores informados no manual."); break;}			
		a++;						
	}
		System.out.println(x);
		teclado.close();	
	}	
}