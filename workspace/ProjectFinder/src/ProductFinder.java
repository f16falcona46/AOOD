import java.util.*;
public class ProductFinder {
	
	public static ArrayList<String> expensiveNewProducts 
	(Product[] newProducts, Product[] existingProducts){
		ArrayList<String> result = new ArrayList<String>();
		
		int highest = 0;
		for (int counter = 0; counter<existingProducts.length; counter++) {
			if (existingProducts[counter].getPrice()>highest) {
				highest = existingProducts[counter].getPrice();
			}
		}
		for (int counter = 0; counter<newProducts.length; counter++) {
			if (newProducts[counter].getPrice()>highest) {
				result.add(newProducts[counter].getName());
			}
		}
		return result;
	}

	
	// Do not run this until you are sure it works!!!
	
	public static void runProductFinderAcceptanceTest(){
		(new ProductFinderTester()).generateCasesAndRun();
	}
	
	public static void main(String[] args) {
		runProductFinderAcceptanceTest();
	}


}
