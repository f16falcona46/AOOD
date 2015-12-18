//Jason Li
//Program BCD3
//2014 Computer Science 3


public class BCDWrapper {
	public static void main(String[] args) {
		BCD blah = new BCD(new int[]{1,2});
		BCD blahAddend = new BCD(34);
		System.out.println(blah.addBCDs(blahAddend));
		runBCD6test();
	}
	
	public static void testBCD2() {
		int[] zero={0};
		int[] oneDigit={1};
		int[] twoDigits={3,7};
		int[] moreDigits={3,1,4,7};


		BCD testNum=new BCD(zero);
		System.out.println("Using number 0");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\"");
		System.out.println("New number of digits: "
				+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("\n");

		testNum=new BCD(oneDigit);
		System.out.println("Using number 1");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\"");
		System.out.println("New number of digits: "
				+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("\n");

		testNum=new BCD(twoDigits);
		System.out.println("Using number 37");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("Digit 3: "+testNum.nthDigit(3));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\"");
		System.out.println("New number of digits: "
				+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("Digit 3: "+testNum.nthDigit(3));
		System.out.println("\n");

		testNum=new BCD(moreDigits);
		System.out.println("Using number 3147");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("Digit 3: "+testNum.nthDigit(3));
		System.out.println("Digit 4: "+testNum.nthDigit(4));
		System.out.println("Digit 5: "+testNum.nthDigit(5));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\"");
		System.out.println("New number of digits: "
				+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("Digit 3: "+testNum.nthDigit(3));
		System.out.println("Digit 4: "+testNum.nthDigit(4));
		System.out.println("Digit 5: "+testNum.nthDigit(5));
		System.out.println("\n");
	}
	
	public static void testBCD3and4and5() {
		
		BCD testNum=new BCD(0);
		BCD sum;
		
		System.out.println("Using number 0");
		System.out.println(testNum);
		
		testNum=new BCD(1);
		System.out.println("Using number 1");
		System.out.println(testNum);
		
		testNum=new BCD(123);
		System.out.println("Using number 123");
		System.out.println(testNum);
		
		testNum=new BCD(3258);
		System.out.println("Using number 3258");
		System.out.println(testNum);
		
		testNum=new BCD(654321);
		System.out.println("Using number 654321");
		System.out.println(testNum);
		
		testNum=new BCD(1234567890);
		System.out.println("Using number 1234567890");
		System.out.println(testNum);
		
		int[] test={0,1,2,3,4,0,0,0};
		testNum=new BCD(test);
		System.out.println(testNum);
		testNum.stripLeadingZeroes();
		System.out.println(testNum);
		
		testNum=new BCD(999000);
		sum=testNum.addBCDs(new BCD(456000));
		System.out.println(sum);
		
		testNum=new BCD(0);
		sum=testNum.addBCDs(new BCD(0));
		System.out.println(sum);
		
		testNum=new BCD(0);
		sum=testNum.addBCDs(new BCD(1));
		System.out.println(sum);
		
		testNum=new BCD(1);
		sum=testNum.addBCDs(new BCD(0));
		System.out.println(sum);
		
		testNum=new BCD(9);
		sum=testNum.addBCDs(new BCD(1));
		System.out.println(sum);
		
		testNum=new BCD(1);
		sum=testNum.addBCDs(new BCD(9));
		System.out.println(sum);
		
		testNum=new BCD(990090909);
		sum=testNum.addBCDs(new BCD(990090909));
		System.out.println(sum);
		
		testNum=new BCD(1);
		sum=testNum.addBCDs(new BCD(99999999));
		//System.out.println(sum);
		//System.out.println(6846548+78798);
		
		BCD multiplicand=new BCD(0);
		
		
		System.out.println("4857*329");
		testNum=new BCD(4857);
		multiplicand=new BCD(329);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(4857*329);
		
		System.out.println("329*4857");
		testNum=new BCD(329);
		multiplicand=new BCD(4857);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(4857*329);
		
		System.out.println("0*329");
		testNum=new BCD(0);
		multiplicand=new BCD(329);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(329*0);
		
		System.out.println("4857*0");
		testNum=new BCD(4857);
		multiplicand=new BCD(0);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(4857*0);
		
		System.out.println("9999*9999");
		testNum=new BCD(9999);
		multiplicand=new BCD(9999);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(9999*9999);
		
		System.out.println("9*9999");
		testNum=new BCD(9);
		multiplicand=new BCD(9999);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(9*9999);
		
		System.out.println("9999*9");
		testNum=new BCD(9999);
		multiplicand=new BCD(9);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(9*9999);
		
		System.out.println("1*1");
		testNum=new BCD(1);
		multiplicand=new BCD(1);
		System.out.println(testNum.multiplyBCDs(multiplicand));
		System.out.println(1);
		
		
		
		testNum=new BCD(1);
		for (BCD counter=new BCD(1); !counter.toString().equals("25"); counter=counter.addBCDs(new BCD(1))) {
			//System.out.println(counter+" "+testNum);
			testNum=testNum.multiplyBCDs(counter);
		}
		System.out.println(testNum);
		
		testNum=new BCD(1);
		for (BCD counter=new BCD(1); !counter.toString().equals("25"); counter=counter.addBCDs(new BCD(1))) {
			//System.out.println(counter+" "+testNum);
			testNum=counter.multiplyBCDs(testNum);
		}
		System.out.println(testNum);
		
		System.out.println(BCD.factorial(6));
		testNum=new BCD(2);
		System.out.println(testNum.pow(16));
		
		System.out.println(BCD.factorial(600));
		testNum=new BCD(2000);
		System.out.println(testNum.pow(1000));
		
	}
	
	public static void runBCD6test() {
		System.out.print("52! is: ");
		System.out.println(BCD.factorial(52));
		
		System.out.print("104! is: ");
		System.out.println(BCD.factorial(104));
		
		BCD testNum=new BCD(2);
		System.out.print("2^127! is: ");
		System.out.println(testNum.pow(127));
		
		testNum=new BCD(19);
		System.out.print("19^19! is: ");
		System.out.println(testNum.pow(19));
	}
}
