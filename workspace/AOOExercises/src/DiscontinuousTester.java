
public class DiscontinuousTester extends DiscontinuousFunctionGrapher {

	@Override
	public double xIncrement() {
		return 0.2;
	}

	@Override
	public double yValue(double xValue) {
		return (Math.pow(xValue, 2)-1)/(xValue-1);
	}

	@Override
	public Coordinate xyStart() {
		return new Coordinate(0,0);
	}

	@Override
	public double xRange() {
		return 3;
	}

	@Override
	public double yRange() {
		return 5;
	}

	@Override
	public boolean exclude(double x) {
		return x==1;
	}
	
	public static void main(String[] args) {
		XYGrapher xyg = new DiscontinuousTester();
		xyg.drawGraph(0, 0, 400, 400);
	}
}