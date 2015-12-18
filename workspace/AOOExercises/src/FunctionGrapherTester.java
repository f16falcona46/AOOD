
public class FunctionGrapherTester extends FunctionGrapher {
	//Sine
	@Override
	public double xIncrement() {
		return 0.1;
	}

	@Override
	public double yValue(double xValue) {
		return Math.sin(xValue);
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(0,-1);
	}

	@Override
	public double xRange() {
		return 20;
	}

	@Override
	public double yRange() {
		return 2;
	}

	public static void main(String[] args) {
		XYGrapher xyg = new FunctionGrapherTester();
		xyg.drawGraph(0,0,200,200);
	}
}
