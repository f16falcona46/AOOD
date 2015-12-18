public class Line {
	private Vector dirVec;
	private Point thruPoint;
	
	Line() {
		dirVec=null;
		thruPoint=null;
	}
	
	Line(Vector dir, Point p0) {
		dirVec=dir.copy();
		thruPoint=p0.copy();
	}
	
	Line(Point p1, Point p2) {
		dirVec=new Vector(p1.getX()-p2.getX(),p1.getY()-p2.getY(),p1.getZ()-p2.getZ());
		thruPoint=p1.copy();
	}
	
	public Point getPoint(double arbitScalar) {
		Point foundPoint = Point.add(dirVec.scalarMul(arbitScalar).toPoint(),thruPoint);
		return foundPoint;
	}
	
	public Vector getDir() {
		return dirVec.copy();
	}
	public Point getThruPoint() {
		return thruPoint.copy();
	}
	
	public String toString() {
		return dirVec.toString() + " " + thruPoint.toString();
	}
	
	public void findIntersectLine(Point p1, Point p2) {
		dirVec=new Vector(p1.getX()-p2.getX(),p1.getY()-p2.getY(),p1.getZ()-p2.getZ());
		thruPoint=p1.copy();
	}
}