
public class DiscontinuousTester2 extends DiscontinuousFunctionGrapher {

	@Override
	public double xIncrement() {
		return 0.2;
	}

	@Override
	public double yValue(double xValue) {
		return 1/xValue;
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(-3,-3);
	}

	@Override
	public double xRange() {
		return 6;
	}

	@Override
	public double yRange() {
		return 6;
	}

	@Override
	public boolean exclude(double x) {
		return x==0;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new DiscontinuousTester2();
		xyg.drawGraph(0, 0, 400, 400);
	}
}
