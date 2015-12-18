
public class GrapherTester extends XYGrapher {

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-2, -2);
	}

	@Override
	public double xRange() {
		return 4;
	}

	@Override
	public double yRange() {
		return 4;
	}

	@Override
	public Coordinate getPoint(int pointNum) {
		Coordinate result = null;
		switch (pointNum) {
			case 0: result = new Coordinate(-1, -1); break;
			case 1: result = new Coordinate(1, -1); break;
			case 2: result = new Coordinate(1, 1); break;
			case 3: result = new Coordinate(-1, 1); break;
			case 4: result = new Coordinate(-1, -1); break;
			default: break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new GrapherTester();
		xyg.drawGraph(0, 0, 200, 200);
	}
}
