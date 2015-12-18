
public abstract class DiscontinuousFunctionGrapher extends FunctionGrapher {
	public boolean exclude(double xValue) { return false; }
	
	@Override
	public Coordinate getPoint(int pointNum) {
		if (this.exclude(this.xValue(pointNum))) {
			return new Coordinate(0,0,false,false);
		}
		else {
			return super.getPoint(pointNum);
		}
	}
}
