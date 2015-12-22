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
	
	private void normalize(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = arr[i]&0xFF;
		}
	}
}
