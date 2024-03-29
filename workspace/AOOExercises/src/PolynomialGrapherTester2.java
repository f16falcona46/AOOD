
public class PolynomialGrapherTester2 extends PolynomialGrapher {
	private static final double[] coef = {1,-3,-4,12};
	private static final Coordinate start = new Coordinate(-4,-2);
	@Override
	public double[] coefficients() {
		return coef;
	}

	@Override
	public double xIncrement() {
		return 0.1;
	}

	@Override
	public Coordinate xyStart() {
		return start;
	}

	@Override
	public double xRange() {
		return 8;
	}

	@Override
	public double yRange() {
		return 16;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new PolynomialGrapherTester2();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
