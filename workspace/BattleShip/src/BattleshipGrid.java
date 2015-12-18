import java.util.Arrays;

public class BattleshipGrid {
	private static final char MISS = '*';
	private static final char EMPTY = '.';
	private static final int VERT_SIZE = 10;
	private static final int HORIZ_SIZE = 10;
	
	private char[][] grid;
	
	BattleshipGrid() {
		grid = new char[VERT_SIZE][HORIZ_SIZE];
		for (char[] row : grid) {
			Arrays.fill(row, EMPTY);
		}
	}
	
	public void shotAt(Position pos,boolean hit,char initial) {
		if (hit(pos)) return;
		if (hit) {
			grid[pos.rowIndex()][pos.columnIndex()] = initial;
		}
		else {
			grid[pos.rowIndex()][pos.columnIndex()] = MISS;
		}
	}
	
	public boolean hit(Position pos) {
		return ((grid[pos.rowIndex()][pos.columnIndex()] != EMPTY) && (grid[pos.rowIndex()][pos.columnIndex()] != MISS));
	}
	
	public boolean miss(Position pos) {
		return grid[pos.rowIndex()][pos.columnIndex()] == MISS;
	}
	
	public boolean empty(Position pos) {
		return (grid[pos.rowIndex()][pos.columnIndex()] == EMPTY);
	}
	
	public char boatInitial(Position pos) {
		return grid[pos.rowIndex()][pos.columnIndex()];
	}
}
