//DO NOT CHANGE THIS FILE!!!
//If there are errors, fix your own program
class RunBCD5Tester {
	public static void main (String Args[])
    {
		// Aliveness test:
		BCD b1=new BCD(1);b1=b1.multiplyBCDs(b1);
		
    	AssignmentTester test = new BCD5Tester();
    	test.runTestCases();
    }
}
