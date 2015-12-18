
public abstract class ParametricGrapher extends XYGrapher {
	abstract public double tInterval();
	abstract public double tStart();
	abstract public double tEnd();
	abstract public double xValue(double t);
	abstract public double yValue(double t);
	
	private double tValue(int pointNum) {
		return this.tStart()+this.tInterval()*pointNum;
	}
	
	@Override
	public Coordinate getPoint(int pointNum) {
		if (tValue(pointNum)>this.tEnd()) {
			return null;
		}
		else {
			return new Coordinate(xValue(tValue(pointNum)),yValue(tValue(pointNum)));
		}
	}
}
