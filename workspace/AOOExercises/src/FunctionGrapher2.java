
public class FunctionGrapher2 extends FunctionGrapher {
	//Cosine

	@Override
	public double xIncrement() {
		return 0.1;
	}

	@Override
	public double yValue(double xValue) {
		return Math.cos(xValue);
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-6.28,-2);
	}

	@Override
	public double xRange() {
		return 12.56;
	}

	@Override
	public double yRange() {
		return 4;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new FunctionGrapher2();
		xyg.drawGraph(0,0,200,200);
	}
}
