
public class PolynomialGrapherTester3 extends PolynomialGrapher {
	//Maclaurin series of cosine
	private static final double[] coef = {1,0,-0.5,0,0.041666666667,0,0.001388888889,0,0.000024801587,0,-0.0000002755732};
	private static final Coordinate start = new Coordinate(-6,-5);
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
		return 12;
	}

	@Override
	public double yRange() {
		return 10;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new PolynomialGrapherTester3();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
