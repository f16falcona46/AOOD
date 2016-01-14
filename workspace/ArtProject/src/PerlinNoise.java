import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PerlinNoise {
	private static final int[] permutations =
		{41,28,222,152,105,144,182,212,14,106,226,204,200,120,245,43,19,59,173,131,116,
		227,30,39,234,31,158,58,68,85,53,240,48,40,185,72,252,175,203,20,12,254,221,174,238,18,
		117,194,139,156,79,82,229,121,96,127,15,13,248,181,171,35,93,128,21,108,9,22,219,215,
		170,242,232,54,197,99,236,114,29,233,2,201,6,74,161,77,122,235,135,209,97,149,186,0,50,
		56,253,140,119,71,34,166,211,243,146,147,153,124,55,191,16,130,37,87,123,155,62,210,75,
		38,183,89,189,73,67,141,52,83,1,42,44,230,45,7,165,27,63,33,157,150,176,66,178,110,142,
		115,129,255,104,145,187,86,172,193,249,151,231,207,168,100,84,23,51,138,88,162,95,199,
		101,169,148,225,103,167,136,65,205,213,251,250,24,118,132,134,228,216,60,76,5,78,164,
		241,192,49,113,69,125,64,198,177,217,26,208,184,3,25,111,17,46,223,244,112,247,11,80,8,
		109,195,61,180,91,188,36,202,237,94,214,102,224,98,163,32,246,220,137,196,70,239,206,
		57,4,90,190,92,10,218,154,107,81,133,143,126,160,159,179,47};
	
	double interpolate(double a1, double a2, double weight) {
		return (1-weight)*a1+weight*a2;
	}
	
	public static void main(String args[]) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 256; ++i) {
			l.add(i);
		}
		Collections.shuffle(l);
		for (Integer i : l) {
			System.out.print(i+",");
		}
	}
}
