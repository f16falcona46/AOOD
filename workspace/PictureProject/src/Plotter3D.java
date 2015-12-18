import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.io.*;

public class Plotter3D extends FlexiblePictureExplorer {
	private Point[] pointList;	
	private boolean lastEventWasMouseDrag = false;
	private Plane eyePlane;
	private MouseEvent lastLocation;
	private Point eyePoint;
	private Point midCenterPoint;
	private String titleString;
	private Point middleOfPointCloud;
	private double distance;

	public Plotter3D(DigitalPicture picture) {
		super(picture);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (lastEventWasMouseDrag) {
			int xDiff;
			int yDiff;
			if (lastLocation==null) {
				xDiff = e.getX();
				yDiff = e.getY();
			}
			else {
				xDiff = e.getX()-lastLocation.getX();
				yDiff = e.getY()-lastLocation.getY();
			}
			
			lastLocation = e;
			
			
			//Point normalizedEyePoint = Point.subtract(eyePoint,midCenterPoint);
			//double distance = normalizedEyePoint.distanceToOrigin();
			
			Point newEyePoint = new Point(0,0,0);
			/*
				rotation about x axis (yDiff)
				y' = y*cos q - z*sin q
				z' = y*sin q + z*cos q
				x' = x
			*/
			
			eyePoint.setY(Math.cos((double)yDiff/500.0)*eyePoint.getY()-Math.sin((double)yDiff/500.0)*eyePoint.getZ());
			eyePoint.setZ(Math.sin((double)yDiff/500.0)*eyePoint.getY()+Math.cos((double)yDiff/500.0)*eyePoint.getZ());
			
			/*
				rotation about y axis (xDiff)
				z' = z*cos q - x*sin q
				x' = z*sin q + x*cos q
				y' = y
			*/
			
			eyePoint.setZ(Math.cos((double)xDiff/500.0)*eyePoint.getZ()-Math.sin((double)xDiff/500.0)*eyePoint.getX());
			eyePoint.setX(Math.sin((double)xDiff/500.0)*eyePoint.getZ()+Math.cos((double)xDiff/500.0)*eyePoint.getX());
			
			//System.out.println(Point.subtract(eyePoint,middleOfPointCloud).distanceToOrigin()+" "+xDiff+" "+yDiff);
			
			eyePoint=eyePoint.scalarMul(distance/eyePoint.distanceToOrigin());
			/*
			newEyePoint.setX(eyePoint.getX()+xDiff/300.0);
			newEyePoint.setY(eyePoint.getY()-yDiff/100.0);
			newEyePoint.setZ(eyePoint.getZ());
			*/
			newEyePoint = eyePoint.copy();
			if (Math.abs(newEyePoint.getX())>1) {
				newEyePoint.setX(Math.signum(newEyePoint.getX()));
			}
			if (Math.abs(newEyePoint.getY())>1) {
				newEyePoint.setY(Math.signum(newEyePoint.getY()));
			}
			eyePoint=newEyePoint;
			
			
			//System.out.println("Eyepoint: "+eyePoint);
			
			this.rePlot();
			
			/*
			DigitalPicture buffer = new Picture("images/background.jpg");
			buffer.getPixel((int)((double)xDiff+320),(int)((double)yDiff)+320).setColor(Color.WHITE);
			this.setImage(buffer);
			*/
			this.setTitle(titleString);
			
			//System.out.println(xDiff+" "+yDiff);
		}
		else {
			lastEventWasMouseDrag=false;
			lastLocation = e;
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		lastEventWasMouseDrag=true;
		lastLocation = e;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Picture pix = new Picture("images/background.jpg");
		Plotter3D expl = new Plotter3D(pix);
		expl.init();
		
		/*Point[] pointList = new Point[50];
		
		for(int counter=0; counter<pointList.length; counter++) {
			pointList[counter] = new Point(counter%4, counter/4, Math.sqrt(Math.pow(counter%4,2)+Math.pow(counter/4,2)));
		}*/
		expl.rePlot();
	}
	
	private void init() {
		PointListReader input = new PointListReader("pointList.txt");
		try {
			ArrayList result = input.scanPoints();
			pointList = (Point[])result.get(2);
			eyePoint = (Point)result.get(1);
			titleString = (String)result.get(0);
			this.setTitle(titleString);
			
			middleOfPointCloud = Point.getCenterPoint(pointList);
			
			Point normalizedPoint = Point.subtract(eyePoint, middleOfPointCloud);
			distance = normalizedPoint.distanceToOrigin();
		}
		catch (IOException e) {
			System.out.println(" "+e);
		}
	}
	
	private void rePlot() {
		midCenterPoint = Point.getMidpoint(eyePoint, middleOfPointCloud);
		Vector eyeVector = Point.subtract(eyePoint,middleOfPointCloud).toVector();
		
		eyePlane = new Plane(midCenterPoint, eyeVector);
		
		//System.out.println("EyePlane: "+eyePlane);
		//System.out.println("Middle of Point Cloud: "+middleOfPointCloud);
		//System.out.println("MidCenterPoint: "+midCenterPoint);
		//System.out.println("EyeVector: "+eyeVector);
		//System.out.println("Point intersections: ");
		
		Point[] projectedPoints = new Point[pointList.length];
		for(int counter=0; counter<pointList.length; counter++) {
			projectedPoints[counter]=eyePlane.isectPlaneAndLine(new Line(eyePoint, pointList[counter]));
		}
		
		projectedPoints = eyePlane.normalizePoints(projectedPoints, midCenterPoint);
		
		DigitalPicture buffer = new Picture("images/background.jpg");
		
		for(int counter=0; counter<pointList.length; counter++) {
			//System.out.println(projectedPoints[counter]);
			//System.out.println(((int)((double)320*projectedPoints[counter].getY()+320))+" "+((int)((double)320*projectedPoints[counter].getZ())+320));
			buffer.getPixel((int)((double)320*projectedPoints[counter].getX()+320),(int)((double)320*projectedPoints[counter].getY())+320).setColor(Color.WHITE);
		}
		this.setImage(buffer);
		this.setTitle(titleString);
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
	}
}