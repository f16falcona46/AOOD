
public class ParametricGrapherTester1 extends ParametricGrapher {
	@Override
	public double tInterval() {
		return 0.05*Math.PI;
	}

	@Override
	public double tStart() {
		return Math.PI/2;
	}

	@Override
	public double tEnd() {
		return 3*Math.PI/2;
	}

	@Override
	public double xValue(double t) {
		return Math.cos(t);
	}

	@Override
	public double yValue(double t) {
		return Math.sin(t);
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-1,-1);
	}

	@Override
	public double xRange() {
		return 2;
	}

	@Override
	public double yRange() {
		return 2;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new ParametricGrapherTester1();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
