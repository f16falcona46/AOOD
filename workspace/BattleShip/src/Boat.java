import java.util.Arrays;

public class Boat {
	private static final char[] ships = {'A', 'B', 'C', 'D', 'S', '!'};
	private static final String[] shipNames = {"Aircraft Carrier", "Battleship", "Cruiser", "Destroyer", "Submarine", "!!INVALID!!"};
	private static final int[] lengths = {5, 4, 3, 2, 3, -1};
	
	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL = false;
	
	private int ship;
	private Position startPos;
	private boolean direction; //true is horizontal, false is vertical (down)
	private boolean[] posHits;
	
	Boat(String shipName, Position newPos, String orientation) {
		
		int index = Arrays.binarySearch(shipNames, shipName);
		if (index >= 0) { //found ship char in ships array
			ship = index;
			posHits = new boolean[lengths[index]];
			Arrays.fill(posHits, false);
		}
		else {
			ship = 5;
		}
		
		startPos = newPos;
		
		if (newPos.columnIndex()==-1) {
			ship = 5;
		}
		
		if (orientation.equals("horizontal")) {
			direction = HORIZONTAL;
		}
		else if (orientation.equals("vertical")) {
			direction = VERTICAL;
		}
		else {
			ship = 5;
		}
		
		if (ship == 5) {
			startPos = new Position(-1, -1);
		}
	}
	
	public String name() {
		return shipNames[ship];
	}
	
	public char abbreviation() {
		return ships[ship];
	}
	
	public Position position() {
		return startPos;
	}
	
	public String direction() {
		if (direction==HORIZONTAL) {
			return "horizontal";
		}
		else {
			return "vertical";
		}
	}
	
	public int size() {
		return lengths[ship];
	}
	
	public boolean onBoat(Position pos) {
		if (direction == HORIZONTAL) {
			if (pos.rowIndex() == startPos.rowIndex()) {
				if ((pos.columnIndex() - startPos.columnIndex() < size()) && (pos.columnIndex() - startPos.columnIndex() > -1)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			if (pos.columnIndex() == startPos.columnIndex()) {
				if ((pos.rowIndex() - startPos.rowIndex() < size()) && (pos.rowIndex() - startPos.rowIndex() > -1)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
	
	public void hit(Position pos) {
		if (onBoat(pos)) {
			if (direction == HORIZONTAL) {
				posHits[pos.columnIndex()-startPos.columnIndex()] = true;
			}
			else {
				posHits[pos.rowIndex()-startPos.rowIndex()] = true;
			}
		}
	}
	
	public boolean isHit(Position pos) {
		if (onBoat(pos)) {
			if (direction == HORIZONTAL) {
				return posHits[pos.columnIndex()-startPos.columnIndex()];
			}
			else {
				return posHits[pos.rowIndex()-startPos.rowIndex()];
			}
		}
		else {
			return false;
		}
	}
	
	public boolean sunk() {
		if (posHits == null) { return false; }
		for (boolean space : posHits) {
			if (!space) {
				return false;
			}
		}
		return true;
	}
}