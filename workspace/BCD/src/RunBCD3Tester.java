//DO NOT CHANGE THIS FILE!!!
//If there are errors, fix your own program
class RunBCD3Tester {
	public static void main (String Args[])
    {
		//Aliveness test:
		BCD b=new BCD(0);b.toString();
		
    	AssignmentTester test = new BCD3Tester();
    	test.runTestCases();

    }
}
