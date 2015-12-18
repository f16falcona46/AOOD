//DO NOT CHANGE THIS FILE!!!
//If there are errors, fix your own program
class RunBCD4Tester {
	public static void main (String Args[])
    {
		// Aliveness test:
		BCD b1=new BCD(1);b1=b1.addBCDs(b1);
		
	   	AssignmentTester test = new BCD4Tester();
		test.runTestCases();
	}
}
