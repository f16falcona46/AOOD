public class BoatTester {
	public static void main(String[] args) {
		testConstructor();
		
		System.out.println();
		
		test_hitting();
	}
	
	public static void testConstructor() {
		TesterResult[] testCases = new TesterResult[17];
		
		testCases[0] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Aircraft Carrier, Vertical"); // Aircraft Carrier, Vertical
		testCases[1] = new TesterResult(new Boat("Battleship", new Position('A',1), "vertical"), "Battleship"); // Battleship
		testCases[2] = new TesterResult(new Boat("Cruiser", new Position('A',1), "vertical"), "Cruiser"); // Cruiser
		testCases[3] = new TesterResult(new Boat("Destroyer", new Position('A',1), "vertical"), "Destroyer"); //Destroyer
		testCases[4] = new TesterResult(new Boat("Submarine", new Position('A',1), "vertical"), "Submarine"); //Submarine
		testCases[5] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "horizontal"), "Horizontal"); // Horizontal
		testCases[6] = new TesterResult(new Boat("blahblah", new Position('A',1), "vertical"), "Invalid"); // Invalid
		testCases[7] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "blahblah"), "Invalid"); // Invalid
		testCases[8] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',-1), "vertical"), "Hangs off left"); // Hangs off left
		testCases[9] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Hangs off right"); // Hangs off right
		testCases[10] = new TesterResult(new Boat("Aircraft Carrier", new Position('A'-5,1), "vertical"), "Hangs off top"); // Hangs off top
		testCases[11] = new TesterResult(new Boat("Aircraft Carrier", new Position('J',1), "vertical"), "Hangs off bottom"); // Hangs off bottom
		testCases[12] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Almost hangs off left"); // Almost hangs off left
		testCases[13] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Almost hangs off right"); // Almost hangs off right
		testCases[14] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Almost hangs off top"); // Almost hangs off top
		testCases[15] = new TesterResult(new Boat("Aircraft Carrier", new Position('A',1), "vertical"), "Almost hangs off bottom"); // Almost hangs off bottom
		testCases[16] =new TesterResult( new Boat("Aircraft Carrier", new Position('E',5), "vertical"), "Center of board"); // Center of board
		
		for (TesterResult result : testCases) {
			System.out.println("Test: "+result.comment);
			System.out.println("Boat "+result.boat.name()+" with abbreviation "+result.boat.abbreviation()+" and direction "+result.boat.direction());
			System.out.println("Constructed at "+result.boat.position()+" with size "+result.boat.size()+"\n");
		}
	}
	
	public static void test_hitting() {
		Boat[] boats = new Boat[6];
		boats[0] = new Boat("Aircraft Carrier", new Position('A',1), "vertical");
		boats[1] = new Boat("Battleship", new Position('A',2), "horizontal");
		boats[2] = new Boat("Cruiser", new Position('J', 8), "horizontal");
		boats[3] = new Boat("Destroyer", new Position('H', 10), "vertical");
		boats[4] = new Boat("Submarine", new Position('J', 7), "horizontal");
		boats[5] = new Boat("blargleblargh", new Position('J', 7), "horizontal");
		
		for (Boat b : boats) {
			System.out.println(print_boat(b));
			int horizontal = (b.direction().equals("horizontal")) ? 1 : 0;
			for (int i = 0; i < b.size(); ++i) {
				System.out.println("Hit "+ new Position(b.position().rowIndex()+(1-horizontal)*i,b.position().columnIndex()+(horizontal)*i));
				System.out.println(toString_spaces(b));
				System.out.println(toString_onBoat(b));
				System.out.println(toString_sunk(b));
				b.hit(new Position(b.position().rowIndex()+(1-horizontal)*i,b.position().columnIndex()+(horizontal)*i));
				System.out.println();
			}
			System.out.println(toString_spaces(b));
			System.out.println(toString_onBoat(b));
			System.out.println(toString_sunk(b));
		}
	}
	
	public static String toString_sunk(Boat b) {
		return "Status: "+(b.sunk() ? "Sunk" : "Not sunk");
	}
	
	public static String toString_spaces(Boat b) {
		boolean horizontal = (b.direction().equals("horizontal"));
		String result = "Hit status around boat: ";
		
		if (horizontal) {
			for (int j = -1; j < 2; ++j) {
				result += "\n";
				for (int i = -1; i < b.size()+1; ++i) {
					result += b.isHit(new Position(b.position().rowIndex()+j,b.position().columnIndex()+i))?"T":"F";
				}
			}
		}
		else {
			for (int j = -1; j < 2; ++j) {
				result += "\n";
				for (int i = -1; i < b.size()+1; ++i) {
					result += b.isHit(new Position(b.position().rowIndex()+i,b.position().columnIndex()+j))?"T":"F";
				}
			}
		}
		
		return result;
	}
	
	public static String toString_onBoat(Boat b) {
		boolean horizontal = (b.direction().equals("horizontal"));
		String result = "OnBoat around boat: ";
		
		if (horizontal) {
			for (int j = -1; j < 2; ++j) {
				result += "\n";
				for (int i = -1; i < b.size()+1; ++i) {
					result += b.onBoat(new Position(b.position().rowIndex()+j,b.position().columnIndex()+i))?"T":"F";
				}
			}
		}
		else {
			for (int j = -1; j < 2; ++j) {
				result += "\n";
				for (int i = -1; i < b.size()+1; ++i) {
					result += b.onBoat(new Position(b.position().rowIndex()+i,b.position().columnIndex()+j))?"T":"F";
				}
			}
		}
		
		return result;
	}
	
	public static String print_boat(Boat b) {
		return b.name()+" at "+b.position()+" with abbreviation "+b.abbreviation()+" and size "+b.size();
	}
}

class TesterResult {
	TesterResult(Boat newBoat, String newComment) {
		boat = newBoat;
		comment = newComment;
	}
	
	public boolean success;
	public Boat boat;
	public String comment;
}