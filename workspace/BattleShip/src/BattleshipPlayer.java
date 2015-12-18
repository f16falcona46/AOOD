import java.util.Scanner;

public class BattleshipPlayer {
	private static final int MAX_VERT = 10;
	private static final int MAX_HORIZ = 10;
	
	private String name;
	private BattleshipGrid grid;
	
	BattleshipPlayer() {
		name = null;
		initializeGrid();
	}
	
	public void startGame() {
		grid = new BattleshipGrid();
		if (name == null) {
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			System.out.print("What is your name, comrade? > ");
			name = sc.next();
			name = name.substring(0, name.length()-1);
			System.out.println("Welcome to the Naval Combat Simulator, "+name);
		}
	}
	
	public String playerName() {
		return name;
	}
	
	public Position shoot() {
		char row = '\0';
		int column = -1;
		Position result = null;
		boolean valid = false;
		System.out.println("Format Xn, where X is a letter A-J, and n is a number 1-10.");
		while (!valid) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a location to fire upon: ");
			sc.useDelimiter("\n");
			String input = sc.next();
			input = input.substring(0,input.length()-1);
			String inputScrubbed = input.toUpperCase();
			try {
				row = inputScrubbed.charAt(0);
				column = Integer.parseInt(inputScrubbed.substring(1, inputScrubbed.length()));
				if ((column <= 0) || (column > MAX_HORIZ) || (row < 'A') || (row >= 'A'+MAX_VERT)) {
					throw new Exception("Invalid input");
				}
				else {
					result = new Position(row, column);
					valid = true;
				}
			}
			catch (Exception e) {
				System.out.println("We're sorry, but "+input+" is not a valid position. (Format Xn, where X is a letter A-J, and n is a number 1-10.)");
			}
		}
		return result;
	}
	
	public void updateGrid(Position pos, boolean hit, char initial) {
		grid.shotAt(pos, hit, initial);
	}
	
	public BattleshipGrid getGrid() {
		return grid;
	}
	
	public void initializeGrid() {
		grid = new BattleshipGrid();
	}
	
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
		updateGrid(pos, hit, initial);
		
		System.out.print("  1 2 3 4 5 6 7 8 9 10");
		for (int i = 0; i < MAX_VERT; ++i) {
			System.out.print("\n"+(char)('A'+i)+" ");
			for (int j = 0; j < MAX_HORIZ; ++j) {
				Position curPos = new Position(i,j);
				if (grid.hit(curPos)) {
					System.out.print(grid.boatInitial(curPos));
				}
				else if (grid.miss(curPos)) {
					System.out.print("*");
				}
				else if (grid.empty(curPos)) {
					System.out.print(".");
				}
				System.out.print(" ");
			}
		}
		
		System.out.print("\nTurn "+turns+": ");
		if (hit) {
			if (sunk) {
				System.out.println("Sunk a ship "+boatName+" at "+pos);
			}
			else {
				System.out.println("Hit a ship "+boatName+" at "+pos);
			}
		}
		else {
			System.out.println("Miss at "+pos);
		}
		
		if (gameOver) {
			System.out.println("The game is over.");
		}
		if (tooManyTurns) {
			System.out.println("Too many turns.");
		}
	}
}
