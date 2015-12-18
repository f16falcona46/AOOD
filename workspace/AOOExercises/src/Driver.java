
public class Driver {
	public static void main(String[] args) {
		XYGrapher xyg = new Blank();
		xyg.drawGraph(0, 0, 150, 150);
	}
}

class Blank extends XYGrapher {
	public Coordinate xyStart() { return new Coordinate(10,10); }
	public double xRange() { return 20; }
	public double yRange() { return 20; }
	public Coordinate getPoint(int pointNum) {
		if (pointNum > 200) return null;
		//return new Coordinate(pointNum/10.-10, Math.sin(pointNum/10.-10));
		return new Coordinate(pointNum/10.+10, 1/(pointNum/10.+10));
	}
}
