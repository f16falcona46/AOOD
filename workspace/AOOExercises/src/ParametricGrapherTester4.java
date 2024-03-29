
public class ParametricGrapherTester4 extends ParametricGrapher {
	@Override
	public double tInterval() {
		return 0.01*Math.PI;
	}

	@Override
	public double tStart() {
		return 0;
	}

	@Override
	public double tEnd() {
		return 6*Math.PI;
	}

	@Override
	public double xValue(double t) {
		return 3*Math.cos(t/2)*Math.cos(t/3);
	}

	@Override
	public double yValue(double t) {
		return 0.5*Math.sin(t*3)*Math.sin(t/3);
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-4,-4);
	}

	@Override
	public double xRange() {
		return 8;
	}

	@Override
	public double yRange() {
		return 8;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new ParametricGrapherTester4();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
