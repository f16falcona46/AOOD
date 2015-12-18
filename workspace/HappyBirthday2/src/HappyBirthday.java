import java.util.*;

public class HappyBirthday {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		String name=HappyBirthday.inputString();
		int counter=0;
		while (counter<2) {
			System.out.println("Happy birthday to you.");
			counter++;
		}
		System.out.println("Happy birthday dear "+name+",");
		System.out.println("Happy birthday to you.");

	}
	
	// Input a line from the keyboard, return as string.
	public static String inputString() {
	   Scanner sc = new Scanner(System.in);
	   return sc.nextLine();
	}


}