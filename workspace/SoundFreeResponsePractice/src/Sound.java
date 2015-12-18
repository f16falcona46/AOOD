// limitAmplitude test. Difficulty: EASY
// Sound.java: Sound class free response practice.
//
// 1. Review requirements in 
// Free-Response-Practice-Instructions file.
// 2. Open the Sound.pdf file.
// 3. Create the limitAmplitude method as described in the
// pdf file. Do not create the trimSilenceFromBeginning method.

public class Sound {
	private int[] samples;
	
	Sound(int[] input){
		samples=input;
	}
	
	public int[] getSamples(){
		return samples;
	}
	
	public int limitAmplitude(int limit){
		int numChanges = 0;
		for (int counter = 0; counter<samples.length; counter++) {
			if (Math.abs(samples[counter])>limit) {
				samples[counter]=(limit*samples[counter]/Math.abs(samples[counter]));
				numChanges++;
			}
		}
		return numChanges;
	}
	/** Removes all silence from the beginning of this sound.
	* Silence is represented by a value of 0.
		* Precondition: samples contains at least one nonzero value
	* Postcondition: the length of samples reflects the removal of starting silence
	*/
	
	// Do not run this until you are sure it works!!!
	
	public static void runLimitAmplitudeAcceptanceTest(){
		(new LimitAmplitudeTester()).generateCasesAndRun();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runLimitAmplitudeAcceptanceTest();
	}

}
