import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.*;

public class PointListGenerator {
	private static final String title = "I am stupid, version 2";
	private static final String eyepoint = "0,0,5"; //x,y,z For best results, use 0 and 0 for x and y
	private static final double xLow = -1; //do not change the Low and High for either x or y
	private static final double xHigh = 1;
	private static final double yLow = -1;
	private static final double yHigh = 1;
	private static final double xStep = 0.05; //can be changed
	private static final double yStep = 0.05; //can be changed
	
	private static double expr(double x, double y) {
		//Sample expressions to plot
		
		//return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)); //This is a cone. Although it does not look like a cone, it actually is.
		return Math.sin(x*5)*Math.cos(y*5);
		//return Math.sqrt(1-Math.pow(x,2)-Math.pow(y,2));
	}
	
	public static void main(String[] args) {
		try {
			Files.deleteIfExists(Paths.get("pointList.txt"));
			PrintWriter output = new PrintWriter("pointList.txt");
			output.println(title);
			output.println(eyepoint);
			
			double result = 0;
			for (double counter = xLow; counter < xHigh; counter += xStep) {
				for (double innerCounter = yLow; innerCounter < yHigh; innerCounter += yStep) {
					result = expr(counter, innerCounter);
					if (!Double.isNaN(result)) {
						output.println(counter+","+innerCounter+","+result);
					}
				}
			}
			output.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
