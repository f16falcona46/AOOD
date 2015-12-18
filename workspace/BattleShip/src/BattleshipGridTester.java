
public class BattleshipGridTester {
	public static void main(String[] args) {
		BattleshipGrid grid1 = new BattleshipGrid();
		System.out.println("Empty");
		System.out.println(toString_BattleshipGrid(grid1));
		
		grid1.shotAt(new Position('B',7), true, 'D');
		
		System.out.println("After one shot (a hit)");
		System.out.println(toString_BattleshipGrid(grid1));
		
		grid1.shotAt(new Position('A',1), true, 'D');
		grid1.shotAt(new Position('J',10), true, 'A');
		grid1.shotAt(new Position('J',1), true, 'B');
		grid1.shotAt(new Position('A',10), true, 'C');
		grid1.shotAt(new Position('E',2), true, 'S');
		grid1.shotAt(new Position('G',5), true, 'D');
		
		System.out.println("After five more shots (all hits)");
		System.out.println(toString_BattleshipGrid(grid1));
		
		grid1.shotAt(new Position('B',2), false, 'D');
		grid1.shotAt(new Position('I',9), false, 'A');
		grid1.shotAt(new Position('I',2), false, 'B');
		grid1.shotAt(new Position('B',9), false, 'C');
		grid1.shotAt(new Position('F',1), false, 'S');
		grid1.shotAt(new Position('H',4), false, 'D');
		
		System.out.println("After five more shots (all misses)");
		System.out.println(toString_BattleshipGrid(grid1));
		
		BattleshipGrid grid2 = new BattleshipGrid();
		System.out.println("New, empty grid");
		System.out.println(toString_BattleshipGrid(grid2));
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				grid2.shotAt(new Position(i,j), true, new char[]{'A','B','C','D','S'}[(i*10+j)%5]);
			}
		}
		System.out.println("Hit every position");
		System.out.println(toString_BattleshipGrid(grid2));
		
		BattleshipGrid grid3 = new BattleshipGrid();
		System.out.println("New, empty grid");
		System.out.println(toString_BattleshipGrid(grid3));
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				grid3.shotAt(new Position(i,j), false, new char[]{'A','B','C','D','S'}[(i*10+j)%5]);
			}
		}
		System.out.println("Missed every position");
		System.out.println(toString_BattleshipGrid(grid3));
		
		BattleshipGrid grid4 = new BattleshipGrid();
		System.out.println("New, empty grid");
		System.out.println(toString_BattleshipGrid(grid4));
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				grid4.shotAt(new Position(i,j), true, new char[]{'A','B','C','D','S'}[(int)(5*Math.random())]);
			}
		}
		System.out.println("Hit every position, random boats");
		System.out.println(toString_BattleshipGrid(grid4));
	}
	
	public static String toString_BattleshipGrid(BattleshipGrid grid) {
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
}
