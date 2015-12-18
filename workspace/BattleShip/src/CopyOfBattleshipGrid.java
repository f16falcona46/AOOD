import java.util.Arrays;

public class CopyOfBattleshipGrid {
	private final char MISS = '*';
	
	private hitPos[] positions;
	
	CopyOfBattleshipGrid() {
		positions = new hitPos[0];
	}
	
	public void shotAt(Position pos,boolean hit,char initial) {
		if (hit(pos)) return;
		if (hit) {
			hitPos[] newPositions = Arrays.copyOf(positions, positions.length+1);
			newPositions[positions.length] =new hitPos(initial, pos);
			positions = newPositions;
		}
		else {
			hitPos[] newPositions = Arrays.copyOf(positions, positions.length+1);
			newPositions[positions.length] =new hitPos(MISS, pos);
			positions = newPositions;
		}
	}
	
	public boolean hit(Position pos) {
		for (hitPos hp : positions) {
			if (posEquals(hp.pos, pos) && hp.status != MISS) {
				return true;
			}
		}
		return false;
	}
	
	public boolean miss(Position pos) {
		for (hitPos hp : positions) {
			if (posEquals(hp.pos, pos) && hp.status == MISS) {
				return true;
			}
		}
		return false;
	}
	
	public boolean empty(Position pos) {
		for (hitPos hp : positions) {
			if (posEquals(hp.pos, pos)) {
				return false;
			}
		}
		return true;
	}
	
	public char boatInitial(Position pos) {
		for (hitPos hp : positions) {
			if (posEquals(hp.pos, pos) && hp.status != MISS) {
				return hp.status;
			}
		}
		return '\0';
	}
	
	private boolean posEquals(Position p1, Position p2) {
		return ((p1.columnIndex()==p2.columnIndex()) && (p1.rowIndex()==p2.rowIndex()));
	}
	
	private class hitPos {
		hitPos(char newStatus, Position newPos) {
			status = newStatus;
			pos = newPos;
		}
		char status;
		Position pos;
	}
}
