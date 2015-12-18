
public class ParametricGrapherTester3 extends ParametricGrapher {
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
		return 3*Math.cos(t/2)*Math.cos(t/3)*t;
	}

	@Override
	public double yValue(double t) {
		return 0.5*Math.sin(t*3)*Math.sin(t/3)*t;
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-6,-6);
	}

	@Override
	public double xRange() {
		return 12;
	}

	@Override
	public double yRange() {
		return 12;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new ParametricGrapherTester3();
		xyg.drawGraph(0, 0, 400, 400);
	}
}