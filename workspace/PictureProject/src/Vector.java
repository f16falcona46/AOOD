public class Vector {
	private double x;
	private double y;
	private double z;
	
	Vector(double xNew, double yNew, double zNew) {
		x=xNew;
		y=yNew;
		z=zNew;
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	
	public void setX(double xNew) {x=xNew;}
	public void setY(double yNew) {y=yNew;}
	public void setZ(double zNew) {z=zNew;}
	
	public Vector copy() {
		return new Vector(x,y,z);
	}
	
	public double dotProduct(Vector otherVector) { //this . otherVector
		double result = this.getX()*otherVector.getX()+this.getY()*otherVector.getY()+this.getZ()*otherVector.getZ();
		return result;
	}
	
	public Vector crossProduct(Vector otherVector) { //this x otherVector, order IS IMPORTANT
		Vector resultVector = new Vector(0,0,0);
		
		resultVector.setX(this.getY()*otherVector.getZ()-this.getZ()*otherVector.getY());
		resultVector.setY(this.getZ()*otherVector.getX()-this.getX()*otherVector.getZ());
		resultVector.setZ(this.getX()*otherVector.getY()-this.getY()*otherVector.getX());
		
		return resultVector;
	}
	
	public String toString() {
		String output="["+String.valueOf(x)+" "+String.valueOf(y)+" "+String.valueOf(z)+"]";
		return output;
	}
	
	public Vector scalarMul(double scalar) { //scalar*(this), scalar multiplication
		Vector resultVector = new Vector(0,0,0);
		
		resultVector.setX(this.getX()*scalar);
		resultVector.setY(this.getY()*scalar);
		resultVector.setZ(this.getZ()*scalar);
		
		return resultVector;
	}
	
	public Point toPoint() { //magically converts vector into a point
		return new Point(x,y,z);
	}
}