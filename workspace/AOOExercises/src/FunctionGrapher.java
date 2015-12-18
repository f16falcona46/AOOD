
public abstract class FunctionGrapher extends XYGrapher {
	@Override
	public Coordinate getPoint(int pointNum) {
		if (xValue(pointNum)>this.xyStart().getX()+this.xRange()+this.xIncrement()) {
			return null;
		}
		else {
			return new Coordinate(xValue(pointNum),yValue(xValue(pointNum)));
		}
	}
	abstract public double xIncrement();
	abstract public double yValue(double xValue);
	
	public double xValue(int pointNum) {
		return this.xyStart().getX()+this.xIncrement()*pointNum;
	}
}