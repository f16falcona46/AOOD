public class BogoStrategy extends GreedStrategy {
	private double stupidParameter;
	
	BogoStrategy() { stupidParameter = 3; }
	
	BogoStrategy(double x) {stupidParameter = x; }
	
	@Override
	public int choose(GreedOption[] options, int[] dice, int bank) {
		//return (int)(Math.random()*stupidParameter);
		return 1;
	}

	@Override
	public String playerName() {
		return "dumdum";
	}

	@Override
	public String author() {
		return new String(new char[]{(char)4});
	}
}