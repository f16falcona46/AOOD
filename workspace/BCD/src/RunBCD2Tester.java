//DO NOT CHANGE THIS FILE!!!
//If there are errors, fix your own program
class RunBCD2Tester {
	public static void main (String Args[])
    {
		//Aliveness test:
		BCD b=new BCD(new int[]{0});
		int i=b.numberOfDigits(), j=b.nthDigit(0);
		b.addADigit(i+j);
		
    	AssignmentTester test = new BCD2Tester();
    	test.runTestCases();

    }
}
