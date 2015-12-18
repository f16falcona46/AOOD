
public class GrapherTester2 extends XYGrapher {

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-0.75,-0.75);
	}

	@Override
	public double xRange() {
		return 1.5;
	}

	@Override
	public double yRange() {
		return 1.5;
	}

	@Override
	public Coordinate getPoint(int pointNum) {
		Coordinate result = null;
		switch (pointNum) {
			case 0: result = new Coordinate(0.5, 0.16246); break;
			case 1: result = new Coordinate(0.11803, 0.16246); break;
			case 2: result = new Coordinate(0, 0.57573); break;
			case 3: result = new Coordinate(-0.11803, 0.16246); break;
			case 4: result = new Coordinate(-0.5, 0.16246); break;
			case 5: result = new Coordinate(-0.19098, -0.06205); break;
			case 6: result = new Coordinate(-0.30902,-0.42533); break;
			case 7: result = new Coordinate(0, -0.20081); break;
			case 8: result = new Coordinate(0.30902, -0.42533); break;
			case 9: result = new Coordinate(0.19098, -0.06205); break;
			case 10: result = new Coordinate(0.5, 0.16246); break;
			default: break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new GrapherTester2();
		xyg.drawGraph(0, 0, 200, 200);
	}
}
