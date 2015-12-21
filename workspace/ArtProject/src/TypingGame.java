import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TypingGame {
	private static class GameCanvas extends JPanel {
		private static final long serialVersionUID = 5283408121493711494L;
		
		GameCanvas(int newXsize, int newYsize) {
			setBackground(new Color(250,250,240));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			((Graphics2D)g).setRenderingHints(rh);
			Map<TextAttribute, Object> attributes = new HashMap<>();
			attributes.put(TextAttribute.SIZE, 20);
			g.setFont(Font.getFont(attributes));
			g.drawString("YOLOSWAG", 50, 50);
		}
	}
	
	private static class GameWindow implements ActionListener {
		
		private JFrame frame;
		private GameCanvas plane;
		
		GameWindow(int xsize, int ysize) { //so when code is copied, old constructor isn't used by accident
			JFrame.setDefaultLookAndFeelDecorated(false);
			frame = new JFrame("Circuit");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			plane = new GameCanvas(xsize, ysize);
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
		GameWindow win = new GameWindow(400,300);
	}
}
