import java.util.Scanner;

public class ComputerBattleshipPlayer extends BattleshipPlayer {
	private static final int MAX_VERT = 10;
	private static final int MAX_HORIZ = 10;
	
	private static final String name = "Computer Player";
	
	ComputerBattleshipPlayer() {
		initializeGrid();
	}
	
	public void startGame() {
		this.initializeGrid();
	}
	
	public String playerName() {
		return name;
	}
	
	public Position shoot() {
		Position result = null;
		boolean valid = false;
		while (!valid) {
			result = new Position((int)(MAX_VERT*Math.random()),(int)(MAX_HORIZ*Math.random()));
			if (this.getGrid().empty(result)) { valid = true; }
		}
		return result;
	}
	
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
		updateGrid(pos, hit, initial);
	}
}
