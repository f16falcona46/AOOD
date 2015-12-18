
public class ComputerBattleshipPlayerTester {
	public static void main(String[] args) {
		PlayerEvaluator pE = new PlayerEvaluator(new JasonLiStrategy(), 1000);
		//44.93322
		//44.94859
		System.out.println("Maximum: "+pE.maxTurns());
		System.out.println("Minimum: "+pE.minTurns());
		System.out.println("Average: "+pE.averageTurns());
	}
}
