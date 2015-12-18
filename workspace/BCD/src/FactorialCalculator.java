//Jason Li
//Program BCD2
//2014 Computer Science 3


public class FactorialCalculator {
	public static void main(String[] args) {

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
		System.out.println("Added a digit \"5\", new digit 0: "
				+testNum.nthDigit(0));
		System.out.println("New number of digits: "
				+testNum.numberOfDigits()+"\n");

		testNum=new BCD(oneDigit);
		System.out.println("Using number 1");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\", new digit 0: "
				+testNum.nthDigit(0));
		System.out.println("New number of digits: "
				+testNum.numberOfDigits()+"\n");

		testNum=new BCD(twoDigits);
		System.out.println("Using number 37");
		System.out.println("Number of digits: "+testNum.numberOfDigits());
		System.out.println("Digit 0: "+testNum.nthDigit(0));
		System.out.println("Digit 1: "+testNum.nthDigit(1));
		System.out.println("Digit 2: "+testNum.nthDigit(2));
		System.out.println("Digit 3: "+testNum.nthDigit(3));
		testNum.addADigit(5);
		System.out.println("Added a digit \"5\", new digit 0: "
				+testNum.nthDigit(0));
		System.out.println("New number of digits: "
				+testNum.numberOfDigits()+"\n");

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
		System.out.println("Added a digit \"5\", new digit 0: "
				+testNum.nthDigit(0));
		System.out.println("New number of digits: "
				+testNum.numberOfDigits()+"\n");

	}

	public static int factorial(int x) {
		if (x>1) {
			return (x*factorial(x-1));
		}
		else if (x==1 || x==0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
