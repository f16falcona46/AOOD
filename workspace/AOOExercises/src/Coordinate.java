
public class Coordinate {
	private double x;
	private double y;
	private boolean From;
	private boolean To;
	
	Coordinate(double newx, double newy) {
		x = newx;
		y = newy;
		From = true;
		To = true;
	}
	
	Coordinate(double newx, double newy, boolean newFrom, boolean newTo) {
		x = newx;
		y = newy;
		From = newFrom;
		To = newTo;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public boolean drawTo() { return To; }
	public boolean drawFrom() { return From; }
}
