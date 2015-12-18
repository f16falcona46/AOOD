import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class PointListReader {
	
	private Scanner file;
	private boolean scannerAtEnd=false;
	
	PointListReader(String filename) {
		try {
			file = new Scanner(new File(filename));
		}
		catch (IOException e) {
			System.out.println("IO failed. "+e);
		}
	}
	
	public ArrayList scanPoints() throws IOException {
		ArrayList result = new ArrayList(3);
		if (scannerAtEnd) {
			throw(new IOException());
		}
		result.add(file.nextLine());
		
		if (scannerAtEnd) {
			throw(new IOException());
		}
		String eyePointString = file.nextLine();
		Scanner eyePointNums = new Scanner(eyePointString);
		eyePointNums.useDelimiter(",");
		
		double[] eyePointNumList = new double[3];
		while (eyePointNums.hasNext()) {
			for (int counter = 0; counter<3; counter++) {
				eyePointNumList[counter]=Double.parseDouble(eyePointNums.next());
			}
		}
		
		result.add(new Point(eyePointNumList));
		
		Point[] pointList = new Point[0];
		while (file.hasNext()) {
			if (scannerAtEnd) {
				throw(new IOException());
			}
			String pointString = file.nextLine();
			
			Scanner pointNums = new Scanner(pointString);
			pointNums.useDelimiter(",");
			
			int counter = 0;
			double[] pointNumList = new double[3];
			while (pointNums.hasNext()) {
				for (counter = 0; counter<3; counter++) {
					pointNumList[counter]=Double.parseDouble(pointNums.next());
				}
			}
			Point currentPoint = new Point(pointNumList);
			
			Point[] newPointList = new Point[pointList.length+1];
			for (counter = 0; counter<pointList.length; counter++) {
				newPointList[counter] = pointList[counter];
			}
			newPointList[newPointList.length-1]=currentPoint;
			pointList = newPointList;
		}
		result.add(pointList);
		return result;
	}
}