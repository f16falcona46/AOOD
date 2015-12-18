public class Point {
	double x;
	double y;
	double z;
	
	Point(double initX, double initY, double initZ) {
		x=initX;
		y=initY;
		z=initZ;
	}
	
	Point(double[] coords) {
		x=coords[0];
		y=coords[1];
		z=coords[2];
	}
	
	//getters
	public double[] getCoords() {
		double[] coordinates = new double[3];
		coordinates[0]=x; coordinates[1]=y; coordinates[2]=z;
		return coordinates;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public Point copy() {
		return new Point(x,y,z);
	}
	
	public Vector toVector() {
		return new Vector(x,y,z);
	}
	
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
	
	//setters
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}
	
	public void setZ(double newZ) {
		z = newZ;
	}
	
	public void setCoords(double[] newCoords) {
		x = newCoords[0]; y = newCoords[1]; z = newCoords[2];
	}
	
	//ops
	public static Point getMidpoint(Point point1, Point point2) {
		Point midpoint = new Point((point1.getX()+point2.getX())/(2.0),
				(point1.getY()+point2.getY())/(2.0),
				(point1.getZ()+point2.getZ())/(2.0));
		
		return midpoint;
	}
	
	public static Point getCenterPoint(Point[] pointList) {
		Point sumPoint = new Point(0,0,0);
		for (int counter = 0; counter<pointList.length; counter++) {
			sumPoint.setX(sumPoint.getX()+pointList[counter].getX());
			sumPoint.setY(sumPoint.getY()+pointList[counter].getY());
			sumPoint.setZ(sumPoint.getZ()+pointList[counter].getZ());
		}
		sumPoint.setX(sumPoint.getX()/((double)pointList.length));
		sumPoint.setY(sumPoint.getY()/((double)pointList.length));
		sumPoint.setZ(sumPoint.getZ()/((double)pointList.length));
		
		return sumPoint;
	}
	
	public static Point add(Point point1, Point point2) {
		Point sumpoint = new Point((point1.getX()+point2.getX()),
				(point1.getY()+point2.getY()),
				(point1.getZ()+point2.getZ()));
		
		return sumpoint;
	}
	
	public static Point subtract(Point point1, Point point2) {
		Point diffpoint = new Point((point1.getX()+point2.getX()),
				(point1.getY()-point2.getY()),
				(point1.getZ()-point2.getZ()));
		
		return diffpoint;
	}
	
	public Point scalarMul(double scalar) {
		return new Point(scalar*x, scalar*y, scalar*z);
	}
	
	public double distanceToOrigin() {
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
	}
	
	public void normalizePoint() {
		double horizDistanceToOrigin = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		double xRatio = x/horizDistanceToOrigin;
		double yRatio = y/horizDistanceToOrigin;
		double distance = distanceToOrigin();
		
		x = xRatio*distance;
		y = yRatio*distance;
		z=0;
	}
}