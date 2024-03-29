import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class XYGrapher {
	private static class GraphArea extends JPanel {
		private XYGrapher xyg;
		private int xstart;
		private int ystart;
		private int xsize;
		private int ysize;
		private static final long serialVersionUID = 5283408121493711494L;
		
		GraphArea(int newxstart, int newystart, int newXsize, int newYsize, XYGrapher newXyg) {
			xstart = newxstart;
			ystart = newystart;
			xsize = newXsize;
			ysize = newYsize;
			xyg = newXyg;
			setBackground(new Color(250,250,240));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.drawLine(scaleX(0),0,scaleX(0),ysize);
			g.drawLine(0,scaleY(0),xsize,scaleY(0));
			int i = 1;
			g.setColor(Color.BLACK);
			while (xyg.getPoint(i) != null) {
				if (i > 0 && xyg.getPoint(i-1).drawFrom() && xyg.getPoint(i).drawTo()){
					g.drawLine(getScaledX(i-1),getScaledY(i-1),getScaledX(i),getScaledY(i));
				}
				++i;
			}
		}
		
		private int scaleX(double x) {
			return (int)(xstart + (x-xyg.xyStart().getX())*(xsize/xyg.xRange()));
		}
		
		private int scaleY(double y) {
			return (int)(ystart + (xyg.xyStart().getY()+xyg.yRange()-y)*(ysize/xyg.yRange()));
		}
		
		private double getX(int i) {
			return xyg.getPoint(i).getX();
		}
		
		private double getY(int i) {
			return xyg.getPoint(i).getY();
		}
		
		private int getScaledX(int i) {
			return scaleX(getX(i));
		}
		
		private int getScaledY(int i) {
			return scaleY(getY(i));
		}
	}
	
	private static class GraphWindow implements ActionListener {
		
		private JFrame frame;
		private GraphArea plane;
		
		GraphWindow(int xstart, int ystart, int xsize, int ysize, XYGrapher xyg) { //so when code is copied, old constructor isn't used by accident
			JFrame.setDefaultLookAndFeelDecorated(false);
			frame = new JFrame("Grapher");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			plane = new GraphArea(xstart, ystart, xsize, ysize, xyg);
			plane.setPreferredSize(new Dimension(xsize, ysize));
			plane.repaint();
			
			frame.setContentPane(plane);
			frame.pack();
			frame.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent arg0) { }
	}
	
	@SuppressWarnings({ "unused"})
	private GraphWindow graph;
	
	abstract public Coordinate xyStart();
	abstract public double xRange();
	abstract public double yRange();
	abstract public Coordinate getPoint(int pointNum);
	public void drawGraph(int xPixelStart, int yPixelStart, int pixelsWide, int pixelsHigh) {
		graph = new GraphWindow(xPixelStart, yPixelStart, pixelsWide, pixelsHigh, this);
	}
}
