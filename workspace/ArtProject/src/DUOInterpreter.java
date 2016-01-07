import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DUOInterpreter {
	private int[] heap;
	private int[] eeprom;
	private String[] instructions;
	public static void main(String[] args) {
		DUOInterpreter interpreter = new DUOInterpreter();
		interpreter.inputProg();
	}
	
	DUOInterpreter() {
		heap = new int[100];
		eeprom = new int[65536];
		instructions = new String[]{};
		ArrayList<Integer> tokens = tokenizeArgList("CA\"HELLO WORLD\"255");
		for (int token : tokens) {
			System.out.println(token);
		}
	}
	
	public void inputProg() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter program code> ");
		String prog = sc.nextLine();
		instructions = prog.split("[.]");
		for (String token : instructions) {System.out.println("A"+token);}
	}
	
	public void inputEEPROM() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter program code> ");
		String prog = sc.nextLine();
		instructions = prog.split("[.]");
		for (String token : instructions) {System.out.println("A"+token);}
	}
	
	public void run() {
		int index = 0;
		while (true) {
			String instruction = instructions[index].substring(0,2);
			switch (instruction) {
				case "NW":
					//heap[]
			}
		}
	}
	
	private void normalize(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = arr[i]&0xFF;
			
		}
	}
	
	private ArrayList<Integer> tokenizeArgList(String arglist) {
		ArrayList<Integer> tokens = new ArrayList<>();
		for (int i = 0; i < arglist.length(); ++i) {
			if (Character.isDigit(arglist.charAt(i))) {
				tokens.add(Integer.parseInt(arglist.substring(i,i+3)));
				i+=2;
			}
			else if (arglist.charAt(i) == '"') {
				++i;
				while (arglist.charAt(i) != '"') {
					tokens.add((int)arglist.charAt(i));
					++i;
				}
			}
			else {
				tokens.add(heap[varIndex(arglist.substring(i,i+2))]);
				++i;
			}
		}
		return tokens;
	}
	
	private static int varIndex(String var) {
		return (var.charAt(0)-'A')*26+var.charAt(1)-'A';
	}
}
