//DO NOT CHANGE THIS FILE!!!
//Fix any errors in your own classes.
class MablibStoryExecuteable extends MadLibStory {
	
	public static void alivenessTest(boolean run){
		if (run)
			Madlib.playMadlibs(new String[]{});
	}
	
	public static void main(String args[])
	{
		alivenessTest(false);
		MadLibStory.run();
	}		
}