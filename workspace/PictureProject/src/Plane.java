public class Plane {
	private Point onPlane;
	private Vector normalVector;
	
	Plane() {
		onPlane=null;
		normalVector=null;
	}
	
	Plane(Point pointOnPlane, Vector normalToPlane) {
		onPlane=pointOnPlane.copy();
		normalVector=normalToPlane.copy();
	}
	
	public Vector getNormalVec() {
		return normalVector.copy();
	}
	
	public Point getPointOnPlane() {
		return onPlane.copy();
	}
	
	public String toString() {
		return onPlane.toString()+" "+normalVector.toString();
	}
	
	public Plane copy() {
		return new Plane(onPlane.copy(),normalVector.copy());
	}
	
	public boolean parallelToPlane(Line otherLine) {
		return Math.abs(otherLine.getDir().dotProduct(normalVector))<0.0001;
	}
	
	public Point isectPlaneAndLine(Line otherLine) { //( (p0-l0).n )/( l.n )=parameter
		Vector p0minusl0 = (Point.subtract(onPlane,otherLine.getThruPoint())).toVector();
		double numerator = p0minusl0.dotProduct(normalVector);
		double denominator = otherLine.getDir().dotProduct(normalVector);
		
		double parameter = numerator/denominator;
		
		Point isectPoint = otherLine.getPoint(parameter);
		
		return isectPoint;
	}
	
	public Point[] normalizePoints(Point[] pointList, Point origin) {
		Point[] normalizedPoints = new Point[pointList.length];
		double max = 0;
		
		for(int counter=0; counter<pointList.length; counter++) {
			normalizedPoints[counter] = Point.subtract(pointList[counter], origin);
			normalizedPoints[counter].normalizePoint();
			if (normalizedPoints[counter].distanceToOrigin()>max) {
				max = normalizedPoints[counter].distanceToOrigin();
			}
		}
		
		for(int counter=0; counter<pointList.length; counter++) {
			normalizedPoints[counter]=normalizedPoints[counter].scalarMul(1/max);
		}
		
		return normalizedPoints;
	}
}