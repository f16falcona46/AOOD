
public class ProbabilityEvaluator {
	private static final int MAX_VERT = 10;
	private static final int MAX_HORIZ = 10;
	private static final int[] lengths = {5, 4, 3, 2, 3, -1};
	
	public ProbabilityEvaluator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int size : lengths) {
			for (int i = 0; i < MAX_VERT-size+1; ++i) {
				for (int j = 0; j < MAX_HORIZ; ++j) {
					
				}
			}
			for (int i = 0; i < MAX_VERT; ++i) {
				for (int j = 0; j < MAX_HORIZ-size+1; ++j) {
					
				}
			}
		}
	}

}
