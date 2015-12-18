
public class BattleshipGame {
	private static final int MAX_TURNS = 100;
	
	private Ocean ocean;
	private BattleshipPlayer player;
	private int turns;
	
	BattleshipGame(BattleshipPlayer newPlayer) {
		player = newPlayer;
		ocean = new Ocean();
		ocean.placeAllBoats();
		turns = 0;
		player.startGame();
	}
	
	public int play() {
		while (turns < MAX_TURNS && !ocean.allSunk()) {
			Position pos = player.shoot();
			ocean.shootAt(pos);
			player.updateGrid(pos, ocean.hit(pos), ocean.boatInitial(pos));
			++turns;
			player.updatePlayer(pos, ocean.hit(pos), ocean.boatInitial(pos), ocean.boatName(pos), ocean.sunk(pos), ocean.allSunk(), turns>=MAX_TURNS, turns);
		}
		return turns;
	}
}
