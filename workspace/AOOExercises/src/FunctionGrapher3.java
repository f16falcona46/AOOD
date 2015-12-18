
public class FunctionGrapher3 extends FunctionGrapher {

	@Override
	public double xIncrement() {
		return 0.01;
	}

	@Override
	public double yValue(double xValue) {
		int xIndex = ((int)xValue+10);
		double xGrow = xValue+10-xIndex;
		return 10*(1-Math.exp(-xGrow));
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(0,0);
	}

	@Override
	public double xRange() {
		return 3.3;
	}

	@Override
	public double yRange() {
		return 10;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new FunctionGrapher3();
		xyg.drawGraph(0,0,200,200);
	}
}
