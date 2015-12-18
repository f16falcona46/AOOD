
public class WordCounter {
	
	
	public static int[] allNums(String[] A, String[] B){
		int[] numberOfAppearances = new int[B.length];
		
		//initialize
		for(int counter=0; counter<B.length; counter++) {
			numberOfAppearances[counter]=0;
		}
		
		//count
		for(int counter=0; counter<A.length; counter++) {
			//each string in A, check which strings in B match
			for(int innerCounter=0; innerCounter<B.length; innerCounter++) {
				if (B[innerCounter].equals(A[counter])) {
					numberOfAppearances[innerCounter]++;
				}
			}
		}
		return numberOfAppearances;
	}

	// Do not run this until you are sure it works!!!
	public static void runWordCounterAcceptanceTest(){
		(new WordCounterTester()).generateCasesAndRun();
	}
	public static void main(String[] args) {
		
		runWordCounterAcceptanceTest();
		
	}
	/**
	 * @param args
	 */

}
