
public class Tester {
	public static void main(String[] args) {
		char row = (char)((int)(Math.random()*10)+'A');
		int col = (int)(Math.random()*10)+1;
		Position p = new Position(row, col);
		
		Object row_ob = p.row();
		Object col_ob = p.column();
		Object row_index_ob = p.rowIndex();
		Object col_index_ob = p.columnIndex();
		
		System.out.println("Constructed a position with row "+row+" and col "+col);
		System.out.println("Type of row "+row_ob+" is "+row_ob.getClass());
		System.out.println("Type of col "+col_ob+" is "+col_ob.getClass());
		System.out.println("Type of row_index "+row_index_ob+" is "+row_index_ob.getClass());
		System.out.println("Type of col_index "+col_index_ob+" is "+col_index_ob.getClass());
		
		System.out.println(p);
		
		int row_index = (int)(Math.random()*10);
		int col_index = (int)(Math.random()*10);
		p = new Position(row_index, col_index);
		
		row_ob = p.row();
		col_ob = p.column();
		row_index_ob = p.rowIndex();
		col_index_ob = p.columnIndex();
		
		System.out.println("Constructed a position with row_index "+row_index+" and col_index "+col_index);
		System.out.println("Type of row "+row_ob+" is "+row_ob.getClass());
		System.out.println("Type of col "+col_ob+" is "+col_ob.getClass());
		System.out.println("Type of row_index "+row_index_ob+" is "+row_index_ob.getClass());
		System.out.println("Type of col_index "+col_index_ob+" is "+col_index_ob.getClass());
		
		System.out.println(p);
	}
}