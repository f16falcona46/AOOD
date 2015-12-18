
public class PolynomialGrapherTester extends PolynomialGrapher {
	private static final double[] coef = {4.8,-1.2,0.2};
	@Override
	public double[] coefficients() {
		return coef;
	}

	@Override
	public double xIncrement() {
		return 0.2;
	}

	@Override
	public Coordinate xyStart() {
		return  new Coordinate(0,0);
	}

	@Override
	public double xRange() {
		return 6;
	}

	@Override
	public double yRange() {
		return 10;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new PolynomialGrapherTester();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
