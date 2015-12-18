// Zero test. Difficulty: EASY
// ZeroClass.java: Zero class free response practice.
//
// 1. Review requirements in 
// Free-Response-Practice-Instructions file.
// 2. Open the ZeroClass.pdf file.
// 3. Create the findZero method as described in part a of the
// pdf file. 
// 4. Create the setZeros method as described in part b of the
// pdf file.
public class ZeroClass {
	public static int findZero(int [] A, int pos){
		for (int counter = pos; counter <A.length; counter++) {
			if (0 == A[counter]) {return counter;}
		}
		return -1;
	}
	public static void setZeros(int[]A){
		int startPos = findZero(A,0);
		if (!(-1==startPos)) {
			int endPos = findZero(A,startPos+1);
			if (!(-1==endPos)) {
				for (int counter = startPos+1; counter<endPos; counter++) {
					A[counter] = 0;
				}
			}
		}
	}


	// Do not run this until you are sure it works!!!
	public static void runZeroClassAcceptanceTest(){
		(new ZeroClassProblemTester()).generateCasesAndRun();
	}
	public static void main(String[] args) {
		runZeroClassAcceptanceTest();
	}
}