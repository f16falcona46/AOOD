public class TestDriver {
	public static void main(String[] args) {
		Vector testVector1 = new Vector(1,2,3);
		Vector testVector2 = new Vector(5,6,7);
		
		System.out.println(testVector1.crossProduct(testVector2));
		
		Point testPoint1 = new Point(1,2,3);
		Point testPoint2 = new Point(5,6,7);
		
		Line intersectingLine = new Line();
		intersectingLine.findIntersectLine(testPoint1, testPoint2);
		System.out.println(intersectingLine);
		
		Plane newPlane= new Plane(new Point(8,-10,8) ,new Vector(16,4,-20));
		System.out.println(newPlane.parallelToPlane(intersectingLine));
		
		newPlane= new Plane(new Point(8,-10,8) ,new Vector(14,5,-20));
		System.out.println(newPlane.parallelToPlane(intersectingLine));
		
		newPlane = new Plane(new Point(0,0,0), new Vector(0,0,1));
		intersectingLine = new Line(new Vector(1,1,1), new Point(1,1,1));
		
		System.out.println(newPlane.isectPlaneAndLine(intersectingLine));
	}
}