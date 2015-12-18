import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class CircuitCanvas {
	private static class CircuitArea extends JPanel {
		private static final long serialVersionUID = 5283408121493711494L;
		
		CircuitArea(int newXsize, int newYsize) {
			setBackground(new Color(250,250,240));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		}
	}
	
	private static class CircuitWindow implements ActionListener {
		
		private JFrame frame;
		private CircuitArea plane;
		
		CircuitWindow(int xsize, int ysize) { //so when code is copied, old constructor isn't used by accident
			JFrame.setDefaultLookAndFeelDecorated(false);
			frame = new JFrame("Circuit");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			plane = new CircuitArea(xsize, ysize);
			plane.setPreferredSize(new Dimension(xsize, ysize));
			plane.repaint();
			
			frame.setContentPane(plane);
			frame.pack();
			frame.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ev) {
			System.out.println(ev);
		}
	}
	
	public static void main(String args[]) {
		CircuitWindow win = new CircuitWindow(400,300);
	}
}
