import java.util.Scanner;

//Jason Li
//Program Intro6
//2014 Computer Science 3
public class Madlib {
	
	public static void main(String[] args) {
		String[] testStory = {"The T-34 tank was the <adjective ending in -est>"
					+" tank in WWII.",
				"It had <adjective> tracks and sloped armor, making it"
						+" mobile and well-protected.",
				"A German general remarked, \"We had nothing"
						+" <adjective>.\"",
				"However, the two-man <vehicle> limited its"
						+" combat capacity.",
				"Later in the war, the T-34 tank received a bigger"
						+" <noun> to combat German <plural noun>.",
				"However, the <noun> was never upgraded.",
				"Compared to American <plural noun>, the T-34 had a"
						+" better gun, but less crew comfort.",
				"The T-34 was <adjective>, reliable, and easy to"
						+" produce.",
				"Various <adjective> countries still have the"
						+" T-34 in service."};
		playMadlibs(testStory);
	}
	
	public static void testTheQueryReplace() {
		System.out.println("Part 1");
		System.out.println(wordInsideBrackets("<beginning> bracket at"
				+" the beginning"));
		System.out.println(wordInsideBrackets("this bracket <embed>"
				+" is embedded within"));
		System.out.println(wordInsideBrackets("bracket at the end"
				+" <end>"));
		System.out.println(wordInsideBrackets("<test replaced phrase>"));
		System.out.println(wordInsideBrackets("<more than one word in this"
				+" bracket> there are more brackets here"));
		System.out.println(wordInsideBrackets("<one> <two>"));
		System.out.println(wordInsideBrackets("<three> <three> <three>"
				+" <test replaced phrase>"));
		System.out.println(wordInsideBrackets("$<Amount of $>? You have lots of"
				+" money!"));
		System.out.println(wordInsideBrackets(""));
		System.out.println(wordInsideBrackets("no angle brackets"));

		System.out.println("Part 2 and 3");
		System.out.println(queryReplace("When in the course of"
				+" human events"));
		System.out.println(queryReplace("<Adverb> in the"
				+" course of human events"));
		System.out.println(queryReplace("When in the course"
				+" of human <Plural noun>"));
		System.out.println(queryReplace("When in the <noun>"
				+" of <adjective> events"));
		System.out.println(queryReplace("When in the <noun>"
				+" of <adjective> <plural noun>"));
		System.out.println(queryReplace("When in the"
				+" <noun><adjective> events"));
		System.out.println(queryReplace("When in the"
				+" <e> events"));
		System.out.println(queryReplace("When in the"
				+" <i> events"));
		System.out.println(queryReplace("When in the"
				+" <O> events"));
		System.out.println(queryReplace("When in the"
				+" <u> events"));
		System.out.println(queryReplace(""));
	}
	
	public static void playMadlibs(String[] story) {
		System.out.println("Welcome to Madlibs. Game created by Jason Li.");
		for (int count=0; count<story.length; count++) {
			story[count]=queryReplace(story[count]);
		}
		for (int count=0; count<story.length; count++) {
			System.out.println(story[count]);
		}
	}
	
	public static String substituteWord(String storyLine, String word) {
		int startOfReplacement=storyLine.indexOf("<");
		int endOfReplacement=storyLine.indexOf(">");
		
		String firstHalf=new String(storyLine.substring(0, startOfReplacement));
		String secondHalf=new String(storyLine.substring(endOfReplacement+1,
				storyLine.length()));
		
		return (firstHalf+word+secondHalf);
	}
	
	public static String wordInsideBrackets(String storyLine) {
		int startOfReplacement=storyLine.indexOf("<");
		int endOfReplacement=storyLine.indexOf(">");
		String word;
		
		if ((startOfReplacement<0) || (endOfReplacement<0)) {
			word="";
		}
		else {
			word=storyLine.substring(startOfReplacement+1,endOfReplacement);
		}
		
		return word;
	}
	
	public static String queryReplace(String storyLine) {
		String userInput;
		while (!wordInsideBrackets(storyLine).equals("")) {
			if (startsWithVowel(wordInsideBrackets(storyLine))) 
				System.out.println("Enter an "
					+wordInsideBrackets(storyLine)+": ");
			else
				System.out.println("Enter a "
					+wordInsideBrackets(storyLine)+": ");
			userInput=inputString();
			storyLine=substituteWord(storyLine,userInput);
		}
		return storyLine;
	}
	
	public static String inputString() {
		   Scanner sc = new Scanner(System.in);
		   return sc.nextLine();
	}
	
	public static boolean startsWithVowel(String str) {
		return ("AEIOU".indexOf(str.toUpperCase())!=-1);
	}

}
