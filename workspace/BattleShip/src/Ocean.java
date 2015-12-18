import java.util.Arrays;

class Ocean {
	Boat[] boats;
	
	private final int VERT_SIZE = 10;
	private final int HORIZ_SIZE = 10;
	
	private static final String[] shipNames = {"Aircraft Carrier", "Battleship", "Cruiser", "Destroyer", "Submarine"};
	
	Ocean() {
		boats = new Boat[0];
	}
	
	public void placeBoat(String boatName, String direction, Position pos) throws Exception {
		direction = direction.toLowerCase();
		
		Boat candidateBoat = new Boat(boatName, pos, direction);
		
		int horizontal = direction.equals("horizontal") ? 1 : 0;
		
		if (pos.rowIndex() < 0 || pos.columnIndex() < 0)
			throw new Exception("Boat out of range.");
		if (direction.equals("vertical")) {
			if (pos.columnIndex() >= HORIZ_SIZE || pos.rowIndex()+candidateBoat.size()-1 >= VERT_SIZE)
				throw new Exception("Boat out of range.");
		}
		else {
			if (pos.columnIndex() + candidateBoat.size()-1 >= HORIZ_SIZE || pos.rowIndex()>= VERT_SIZE)
				throw new Exception("Boat out of range.");
		}
		
		for (int i = 0; i < candidateBoat.size(); ++i) {
			for (Boat b : boats) {
				if (b.onBoat(new Position(pos.rowIndex()+(1-horizontal)*i, pos.columnIndex()+(horizontal)*i))) {
					throw new Exception("Boat overlaps an existing boat.");
				}
			}
		}
		
		Boat[] newBoats = Arrays.copyOf(boats, boats.length+1);
		newBoats[newBoats.length-1] = candidateBoat;
		
		boats = newBoats;
	}
	
	public void shootAt(Position pos) {
		for (Boat b : boats) {
			if (b.onBoat(pos)) {
				b.hit(pos);
			}
		}
	}
	
	public boolean hit(Position pos) {
		for (Boat b : boats) {
			if (b.isHit(pos)) {
				return true;
			}
		}
		return false;
	}
	
	public char boatInitial(Position pos) {
		for (Boat b : boats) {
			if (b.onBoat(pos) && b.isHit(pos)) {
				return b.abbreviation();
			}
		}
		return ' ';
	}
	
	public String boatName(Position pos) {
		for (Boat b : boats) {
			if (b.onBoat(pos) && b.isHit(pos)) {
				return b.name();
			}
		}
		return "";
	}
	
	public boolean sunk(Position pos) {
		for (Boat b : boats) {
			if (b.onBoat(pos)) {
				return b.sunk();
			}
		}
		return false;
	}
	
	public boolean allSunk() {
		for (Boat b : boats) {
			if (!b.sunk()) {
				return false;
			}
		}
		return true;
	}
	
	public void placeAllBoats() {
		for (String shipName : shipNames) {
			while (true) {
				try {
					this.placeBoat(shipName, (Math.random()>0.5)?"vertical":"horizontal", new Position((int)(Math.random()*10),(int)(Math.random()*10)));
					break;
				}
				catch (Exception e) {}
			}
		}
	}
}