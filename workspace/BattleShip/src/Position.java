public class Position {
	private int rownum;
	private int colnum;
	Position(char rw, int col) {
		//if (('A' <= rw) && (rw <= 'J') && (1 <= col) && (col <= 10)) {
			rownum = rw-'A';
			colnum = col-1;
		/*}
		else {
			rownum = -1;
			colnum = -1;
		}*/
	}
	
	Position(int rw, int col) {
		//if ((0 <= rw) && (rw <= 9) && (0 <= col) && (col <= 9)) {
			rownum = rw;
			colnum = col;
		/*
		}
		else {
			rownum = -1;
			colnum = -1;
		}
		*/
	}
	
	public char row() {
		return (char)('A'+rownum);
	}
	
	public int column() {
		return (colnum+1);
	}
	
	public int rowIndex() {
		return rownum;
	}
	
	public int columnIndex() {
		return colnum;
	}
	
	public String toString() {
		return "" + row() + "-" + column();
	}
}