/* STRATEGY DESCRIPTION
 * Before each turn, the program computes the probability that there is a ship at that point.
 * It first resets the probability matrix to all zeroes.
 * It goes through every position, every type of boat, and every orientation.
 * If the potential boat's positions are not blocked by misses or hits on other boats, and
 * 		the number of hits in the potential boat's positions of the potential boat's type equals
 * 		the number of hits seen so far of that boat type,
 * the positions of the potential boat are incremented in the probability matrix.
 * Misses and previous hits are then assigned a probability score of 0; there is no use in hitting them
 * again.
 * 
 * To pick the position to shoot, the highest-probability (i.e., highest value in probability matrix)
 * position is selected. In case of ties, the upper left most tied position is shot at.
 */

public class JasonLiStrategy extends ComputerBattleshipPlayer {
	private static final String stratName = "Turbo Teen";
	private static final String authorName = "Jason Li";
	private static final int VERT_SIZE = 10;
	private static final int HORIZ_SIZE = 10;
	private static final int[] lengths = {5, 4, 3, 2, 3};
	private static final char[] ships = {'A', 'B', 'C', 'D', 'S'};
	
	private int[][] candidates;
	private int[] seen;
	private boolean[] directions;
	
	public JasonLiStrategy() {
		super();
		candidates = new int[VERT_SIZE][HORIZ_SIZE];
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
		return result;
	}
	
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
		int index = boatIndex(initial);
		
		if (hit) {
			++seen[index];
		}
		super.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
		if (hit) seen[index] = found(initial);
		if (hit && seen[index] == 2) {
			directions[index] = computeOrientation(initial);
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
	
	private boolean computeOrientation(char c) { //true = vertical, false = horizontal
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
		return seen[boatIndex(c)];
	}
	
	private void updateCandidates() {
		candidates = new int[VERT_SIZE][HORIZ_SIZE];
		
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
								candidates[w+i][j]+=1;
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
								candidates[i][j+w]+=1;
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
	}
	
	private static int boatIndex(char c) {
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
