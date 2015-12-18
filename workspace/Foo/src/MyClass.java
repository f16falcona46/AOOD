
public class MyClass {
	public static String ConvertFromBase10(int b, int n)
    {
        String baseb = "";
        while(n > 0){
            baseb += (n%b);
            n = n/b ;
        }
        return baseb;
    }
    
    public static boolean IsPalindrome(String str)
    {
        boolean bPalindrome = true;
        int median = str.length( ) / 2;
        int a = 0;
        while(a < median)
        {
            if(str.charAt(a) != str.charAt(str.length() - a - 1) )
                bPalindrome = false;
            a++;
        }
        return bPalindrome;
    }
    
    public static int answer(int n) { 
        boolean bIsPalindrome = false;
        int base = 2, numAsBase = n;
        
        while(!bIsPalindrome)
        {
            bIsPalindrome = IsPalindrome(ConvertFromBase10(base, n));
            if(!bIsPalindrome) base++;
            
        }
        return base;

    }
	public static void main(String[] args) {
		//System.out.println((int)'A');

		System.out.println( answer(0) + " " + answer(42));
	}
}
