//Jason Li
//BCD Class

public class BCD {
	private int[] digits;
	
	BCD(int[] bcdDigits) {
		digits=new int[bcdDigits.length];
		for (int counter=0; counter<bcdDigits.length; counter++)
			digits[counter]=bcdDigits[counter];
	}
	
	BCD(BCD oldBCD) {
		digits=new int[oldBCD.numberOfDigits()];
		for (int counter=0; counter<oldBCD.numberOfDigits(); counter++) {
			digits[counter]=oldBCD.nthDigit(counter);
		}
	}
	
	BCD(int number) {
		int counter=0;
		
		int numberBAK=number;
		
		for (counter=0; numberBAK!=0; numberBAK/=10)
				counter++;
		if (number==0) {
			counter=1;
			digits=new int[1];
			digits[0]=0;
		}
		else {
			digits=new int[counter];
		}
		counter=0;
		while (number!=0) {
			digits[counter]=number % 10;
			number=number/10;
			counter++;
		}
	}
	
	public int numberOfDigits() {
		return digits.length;
	}
	
	public int nthDigit(int n) {
		if (n>=digits.length)
			return 0;
		else
			return digits[n];
	}
	
	public void addADigit(int newdigit) {
		int[] bufferDigits=new int[digits.length+1];
		
		for (int counter=0; counter<=(digits.length-1); counter++) {
			bufferDigits[counter]=digits[counter];
		}
		bufferDigits[digits.length]=newdigit;
		digits=bufferDigits;
	}
	
	public String toString() {
		String numberString="";
		for (int counter = (digits.length-1); counter>=0; counter--) {
			numberString = numberString + digits[counter];
			if ((counter % 3 == 0) && (counter != 0)) {
				numberString = numberString + ",";
			}
		}
		return numberString;
	}
	
	public void stripLeadingZeroes() {
		int numberOfZeroes=0;
		for (int counter=digits.length-1; counter > 0 && digits[counter]==0; counter--)
		{
			numberOfZeroes++;
		}
		int[] bufferDigits=new int[digits.length-numberOfZeroes];
		
		for (int counter=0; counter<=(digits.length-1-numberOfZeroes); counter++) {
			bufferDigits[counter]=digits[counter];
		}
		digits=bufferDigits;
	}
	
	public BCD addBCDs(BCD addend) {
		BCD result=null;
		int carry=0;
		if (this.numberOfDigits() >= addend.numberOfDigits()) {
			for (int counter = 0; counter < this.numberOfDigits()+1; counter++) {
				if (counter == 0) {
					result=new BCD((this.nthDigit(counter) 
							+ addend.nthDigit(counter))%10);
					carry=(this.nthDigit(counter) 
							+ addend.nthDigit(counter))/10;
				}
				else {
					result.addADigit((this.nthDigit(counter) 
							+ addend.nthDigit(counter)+carry)%10);
					carry=(this.nthDigit(counter) 
							+ addend.nthDigit(counter)+carry)/10;
				}
			}
		}
		if (this.numberOfDigits() < addend.numberOfDigits()) {
			for (int counter = 0; counter < addend.numberOfDigits()+1; counter++) {
				if (counter == 0) {
					result=new BCD((this.nthDigit(counter) 
							+ addend.nthDigit(counter))%10);
					carry=(this.nthDigit(counter) 
							+ addend.nthDigit(counter))/10;
				}
				else {
					result.addADigit((this.nthDigit(counter) 
							+ addend.nthDigit(counter)+carry)%10);
					carry=(this.nthDigit(counter) 
							+ addend.nthDigit(counter)+carry)/10;
				}
			}
		}
		result.stripLeadingZeroes();
		return result;
	}

	public BCD multiplyBCDs(BCD multiplicand) {
		this.stripLeadingZeroes(); //strip leading zeroes
		multiplicand.stripLeadingZeroes();
		
		int[][] lattice = new int[this.numberOfDigits()]
				[multiplicand.numberOfDigits()]; //create a lattice
		
		for (int counter=0; counter<this.numberOfDigits(); counter++) {
			//insert values into lattice
			for (int innerCounter=0; 
					innerCounter<multiplicand.numberOfDigits();
						innerCounter++) {
				lattice[this.numberOfDigits()-counter-1]
						[multiplicand.numberOfDigits()-innerCounter-1]
								=(this.nthDigit(counter)
								*multiplicand.nthDigit(innerCounter));
			}
		}
		
		BCD[] sumList=new BCD[this.numberOfDigits()
		     +multiplicand.numberOfDigits()-1]; //find size of sumList
		
		for (int counter=0; counter<this.numberOfDigits()
				+multiplicand.numberOfDigits()-1; counter++) {
				//put diagonal sums into sumList
			sumList[counter]=diagonalSum(lattice,counter);
		}
		
		BCD result = new BCD(0); //set and initialize result value
		BCD truncatedForNext = null; //declare next number var
		
		for (int counter=sumList.length-1; counter>=0; counter--) {
			for (int innerCounter=1; innerCounter
					<sumList[counter].numberOfDigits(); innerCounter++) {
				//create truncatedForNext
				if (innerCounter==1) {
					truncatedForNext = new 
							BCD(sumList[counter].nthDigit(innerCounter));
				}
				else {
					truncatedForNext.addADigit(
							sumList[counter].nthDigit(innerCounter));
				}
			}
			
			if (sumList[counter].numberOfDigits()==1) {
				//in case there isn't anything left to truncate
				truncatedForNext = new BCD(0);
			}
			
			if (counter==sumList.length-1) {
				result=new BCD(sumList[counter].nthDigit(0));
			}
			else {
				result.addADigit(sumList[counter].nthDigit(0));
			}
			
			if (counter!=0) {
				sumList[counter-1]=sumList[counter-1].addBCDs(truncatedForNext);
			}
		}
		if (!truncatedForNext.toString().equals("0")) {
			for (int counter=0; counter
					<truncatedForNext.numberOfDigits(); counter++) {
				result.addADigit(truncatedForNext.nthDigit(counter));
			}
		}
		result.stripLeadingZeroes();
		return result;
	}
	
	private BCD diagonalSum(int[][] lattice, int offset) {
		if (offset<lattice.length && offset+1<lattice[0].length) {
			BCD sum=new BCD(0);
			for (int counter=0; counter<offset+1; counter++) {
				sum=sum.addBCDs(new BCD(lattice[offset-counter][counter]));
			}
			sum.stripLeadingZeroes();
			return sum;
		}
		else if (offset<lattice.length && offset+1>=lattice[0].length) {
			BCD sum=new BCD(0);
			for (int counter=0; counter<lattice[0].length; counter++) {
				sum=sum.addBCDs(new BCD(lattice[offset-counter][counter]));
			}
			sum.stripLeadingZeroes();
			return sum;
		}
		else if (offset>=lattice.length) {
			BCD sum=new BCD(0);
			if (lattice.length<lattice[0].length) {
				offset=offset+1;
				if (lattice.length
						<=(lattice.length+lattice[0].length-offset)) {
					for (int counter=0; counter<lattice.length; counter++) {
						sum=sum.addBCDs(
								new BCD(lattice[lattice.length
								                -counter-1]
								[offset-lattice.length+counter]));
					}
				}
				else {
					for (int counter=0; counter
							<(lattice.length+lattice[0].length-offset);
							counter++) {
						sum=sum.addBCDs(new BCD(
								lattice[lattice.length-counter-1]
								[offset-lattice.length+counter]));
					}
				}
			}
			else {
				offset+=1;
				if (lattice[0].length
						<=(lattice.length+lattice[0].length-offset)) {
					for (int counter=0; counter<lattice.length; counter++) {
						sum=sum.addBCDs(new BCD(
								lattice[lattice.length-counter-1]
								[offset-lattice.length+counter]));
					}
				}
				else {
					for (int counter=0; counter
							<(lattice.length+lattice[0].length-offset);
							counter++) {
						sum=sum.addBCDs(new BCD(lattice[
						     lattice.length-counter-1]
								[offset-lattice.length+counter]));
					}
				}
			}
			sum.stripLeadingZeroes();
			return sum;
		}
		else
			return null;
	}
	
}