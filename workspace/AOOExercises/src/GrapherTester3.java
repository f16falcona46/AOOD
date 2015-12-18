
public class GrapherTester3 extends XYGrapher {

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-1.5,-1.5);
	}

	@Override
	public double xRange() {
		return 3;
	}

	@Override
	public double yRange() {
		return 3;
	}

	@Override
	public Coordinate getPoint(int pointNum) {
		Coordinate result = null;
		switch (pointNum) {
			case 0: result = new Coordinate(-1, -1); break;
			case 1: result = new Coordinate(1, -1); break;
			case 2: result = new Coordinate(1, 1); break;
			case 3: result = new Coordinate(-1, -1,false, true); break;
			case 4: result = new Coordinate(-0.5, -0.8, true, false); break;
			case 5: result = new Coordinate(0.5, -0.8); break;
			case 6: result = new Coordinate(0.5, 0.2); break;
			case 7: result = new Coordinate(-0.5, -0.8); break;
			default: break;
		}
		return result;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new GrapherTester3();
		xyg.drawGraph(0, 0, 200, 200);
	}

}
