import java.util.Arrays;

//How to find out if the NSA is snooping on your computer:
//cat /dev/urandom | grep nsa
//Any output indicates an NSA attack!

public class JasonLiStrategy extends ComputerBattleshipPlayer {
	private static final String stratName = "NSA Super Secret Program";
	private static final String authorName = "Jason Li";
	private static final int VERT_SIZE = 10;
	private static final int HORIZ_SIZE = 10;
	private static final int[] lengths = {5, 4, 3, 2, 3};
	private static final char[] ships = {'A', 'B', 'C', 'D', 'S'};
	
	private static final boolean DEBUG = false;
	
	private int[][] candidates;
	private int[] seen;
	private boolean[] directions;
	
	public JasonLiStrategy() {
		super();
		candidates = new int[VERT_SIZE][HORIZ_SIZE];
		for (int[] row : candidates) {
			Arrays.fill(row,0);
		}
		seen = new int[5];
		directions = new boolean[5];
	}
	
	public void startGame() {
		super.startGame();
		super.initializeGrid();
		updateCandidates();
		seen = new int[5];
		directions = new boolean[5];
	}
	
	public String playerName() {
		return stratName;
	}
	
	public String author() {
		return authorName;
	}
	
	public Position shoot() {
		int max_vert = 0;
		int max_horiz = 0;
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (candidates[i][j] > candidates[max_vert][max_horiz]) {
					max_vert = i;
					max_horiz = j;
				}
			}
		}
		
		Position result = null;
		if (candidates[max_vert][max_horiz] == 0) {
			boolean valid = false;
			while (!valid) {
				result = new Position((int)(VERT_SIZE*Math.random()),(int)(HORIZ_SIZE*Math.random()));
				if (this.getGrid().empty(result)) { valid = true; }
			}
		}
		else {
			result = new Position(max_vert,max_horiz);
		}
		if (DEBUG) System.out.println(result);
		return result;
	}
	
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
		if (hit) {
			++seen[boatIndex(initial)];
		}
		super.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
		if (hit) seen[boatIndex(initial)] = found(initial);
		if (hit && seen[boatIndex(initial)] == 2) {
			directions[boatIndex(initial)] = oldOrientation(initial);
		}
		updateCandidates();
	}
	
	private static int getSize(char c) {
		return (c=='A')?5:
			(c=='B')?4:
			(c=='C')?3:
			(c=='D')?2:
			(c=='S')?3:0;
	}
	
	private boolean orientation(char c) {
		return directions[boatIndex(c)];
	}
	
	private boolean oldOrientation(char c) { //true = vertical, false = horizontal
		int foundi = -1;
		boolean foundFirst = false;
		
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (super.getGrid().hit(new Position(i,j)) && (super.getGrid().boatInitial(new Position(i,j)) == c)) {
					if (foundFirst) {
						if (i == foundi) {
							return false;
						}
						else {
							return true;
						}
					}
					else {
						foundi = i;
						foundFirst = true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean isSunk(char c) {
		return remain(c)==0;
	}
	
	private int remain(char c) {
		return getSize(c)-found(c);
	}
	
	private int found(char c) {
		
		int found = 0;
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (super.getGrid().hit(new Position(i,j)) && (super.getGrid().boatInitial(new Position(i,j)) == c)) {
					++found;
				}
			}
		}
		return found;
		
		//return seen[boatIndex(c)];
	}
	
	private void updateCandidates() {
		candidates = new int[VERT_SIZE][HORIZ_SIZE];
		
		/*
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (super.getGrid().hit(new Position(i,j)) && !isSunk(super.getGrid().boatInitial(new Position(i,j)))) {
					if (found(super.getGrid().boatInitial(new Position(i,j))) > 1) {
						if (orientation(super.getGrid().boatInitial(new Position(i,j)))) {
							for (int w = Math.max(0, i-remain(super.getGrid().boatInitial(new Position(i,j)))); w<Math.min(VERT_SIZE, i+remain(super.getGrid().boatInitial(new Position(i,j)))+1); ++w) {
								//candidates[w][j]+=(w-i+getSize(super.getGrid().boatInitial(new Position(i,j))));
								candidates[w][j]+=1;//(getSize(super.getGrid().boatInitial(new Position(i,j)))-Math.abs(w-i));
							}
						}
						else {
							for (int w = Math.max(0, j-remain(super.getGrid().boatInitial(new Position(i,j)))); w<Math.min(HORIZ_SIZE, j+remain(super.getGrid().boatInitial(new Position(i,j)))+1); ++w) {
								candidates[i][w]+=1;//(getSize(super.getGrid().boatInitial(new Position(i,j)))-Math.abs(w-j));
							}
						}
					}
					else {
						for (int w = Math.max(0, i-remain(super.getGrid().boatInitial(new Position(i,j)))); w<Math.min(VERT_SIZE, i+remain(super.getGrid().boatInitial(new Position(i,j)))+1); ++w) {
							//candidates[w][j]+=(w-i+getSize(super.getGrid().boatInitial(new Position(i,j))));
							candidates[w][j]+=1;//(getSize(super.getGrid().boatInitial(new Position(i,j)))-Math.abs(w-i));
						}
						for (int w = Math.max(0, j-remain(super.getGrid().boatInitial(new Position(i,j)))); w<Math.min(HORIZ_SIZE, j+remain(super.getGrid().boatInitial(new Position(i,j)))+1); ++w) {
							candidates[i][w]+=1;//(getSize(super.getGrid().boatInitial(new Position(i,j)))-Math.abs(w-j));
						}
					}
				}
			}
		}
		
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (super.getGrid().hit(new Position(i,j)) || super.getGrid().miss(new Position(i,j)) || !isSunk(super.getGrid().boatInitial(new Position(i,j)))) {
					candidates[i][j] = -1;
				}
			}
		}
		*/
		for (int boat = 0; boat < lengths.length; ++boat) {
			if (isSunk(ships[boat])) {
				continue;
			}
			int foundPlaces = seen[boat];
			for (int i = 0; i < VERT_SIZE; ++i) {
				for (int j = 0; j < HORIZ_SIZE; ++j) {
					boolean valid = true;
					int hits = 0;
					if (foundPlaces < 2 || directions[boat]) {
						for (int w = 0; w < lengths[boat]; ++w) {
							Position vertPos = new Position(i+w, j);
							if ((w+i >= VERT_SIZE) || (super.getGrid().miss(vertPos)) || (super.getGrid().hit(vertPos) && (super.getGrid().boatInitial(vertPos) != ships[boat]))) {
								valid = false;
								break;
							}
							if ((super.getGrid().hit(vertPos) && super.getGrid().boatInitial(vertPos) == ships[boat])) {
								++hits;
							}
						}
						if (hits != foundPlaces) valid = false;
						if (valid) {
							for (int w = 0; w < lengths[boat]; ++w) {
								candidates[w+i][j]+=1;//+2*((found(ships[boat])!=0)?found(ships[boat])-1:0);
							}
						}
					}
					
					valid = true;
					hits = 0;
					
					if (foundPlaces < 2 || !orientation(ships[boat])) {
						for (int w = 0; w < lengths[boat]; ++w) {
							Position horizPos = new Position(i, j+w);
							if ((w+j >= HORIZ_SIZE) || (super.getGrid().miss(horizPos)) || (super.getGrid().hit(horizPos) && (super.getGrid().boatInitial(horizPos) != ships[boat]))) {
								valid = false;
								break;
							}
							if ((super.getGrid().hit(horizPos) && super.getGrid().boatInitial(horizPos) == ships[boat])) {
								++hits;
							}
						}
						if (hits != foundPlaces) valid = false;
						if (valid) {
							for (int w = 0; w < lengths[boat]; ++w) {
								candidates[i][j+w]+=1;//+2*((found(ships[boat])!=0)?found(ships[boat]):0);
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				if (!super.getGrid().empty(new Position(i,j))) {
					candidates[i][j] = 0;
				}
			}
		}
		
		if (DEBUG) printCandidates();
	}
	
	private void printCandidates() {
		for (int i = 0; i < VERT_SIZE; ++i) {
			for (int j = 0; j < HORIZ_SIZE; ++j) {
				System.out.print(candidates[i][j]+"\t");
			}
			System.out.println();
		}
		
		for (char c : new char[]{'A','B','C','D','S'}) {
			System.out.print(c+" "+found(c)+" ");
			if (found(c) > 1) {
				System.out.print(orientation(c)?"vertical":"horizontal");
			}
			System.out.println();
		}
		System.out.println(toString_BattleshipGrid(super.getGrid()));
	}
	
	private static String toString_BattleshipGrid(BattleshipGrid grid) {
		String result = "  1 2 3 4 5 6 7 8 9 10";
		
		for (int row = 0; row < 10; ++row) {
			result += "\n"+(char)('A'+row) +" ";
			for (int col = 0; col < 10; ++col) {
				Position pos = new Position(row, col);
				if (grid.hit(pos)) {
					result += grid.boatInitial(pos);
				}
				else if (grid.miss(pos)) {
					result += 'X';
				}
				else {
					result += '.';
				}
				result += ' ';
			}
		}
		return result;
	}
	
	private int boatIndex(char c) {
		int result = -1;
		switch (c) {
		case 'A': result = 0; break;
		case 'B': result = 1; break;
		case 'C': result = 2; break;
		case 'D': result = 3; break;
		case 'S': result = 4; break;
		default: result = -1;
		}
		return result;
	}
}
