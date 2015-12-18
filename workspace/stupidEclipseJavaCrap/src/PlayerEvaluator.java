public class PlayerEvaluator {
	private static final int MAX_TURNS = 100;
	
	private ComputerBattleshipPlayer player;
	private int[] turns;
	private int maxTurns;
	private int minTurns;
	private float averageTurns;

	PlayerEvaluator(ComputerBattleshipPlayer newPlayer, int runs) {
		player = newPlayer;
		turns = new int[runs];
		minTurns = MAX_TURNS;
		maxTurns = -1;
		int sum = 0;
		for (int i = 0; i < runs; ++i) {
			player.startGame();
			BattleshipGame game = new BattleshipGame(player);
			sum += turns[i] = game.play();
			if (turns[i] > maxTurns) {
				maxTurns = turns[i];
			}
			if (turns[i] < minTurns) {
				minTurns = turns[i];
			}
		}
		averageTurns = (float) (sum / (double)runs);
	}
	
	public int maxTurns() {
		return maxTurns;
	}
	
	public int minTurns() {
		return minTurns;
	}
	
	public float averageTurns() {
		return averageTurns;
	}
}
