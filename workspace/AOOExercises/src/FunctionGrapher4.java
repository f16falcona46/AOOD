
public class FunctionGrapher4 extends FunctionGrapher {

	@Override
	public double xIncrement() {
		return 0.1;
	}

	@Override
	public double yValue(double xValue) {
		return 1/(1+Math.exp(-xValue));
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-10,-0.1);
	}

	@Override
	public double xRange() {
		return 20;
	}

	@Override
	public double yRange() {
		return 1.2;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new FunctionGrapher4();
		xyg.drawGraph(0,0,200,200);
	}
}
