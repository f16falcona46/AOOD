import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ScopeArea extends JPanel implements ActionListener {
	private static final long serialVersionUID = 5283408121493711494L;
	
	private int[] buffer;
	private int head;
	private Timer refreshTimer;
	private int width;
	
	ScopeArea(PortHolder holder, int newWidth) {
		holder.addActionListener(this);
		width = newWidth;
		
		setBackground(new Color(0,0,0));
		refreshTimer = new Timer(1, this);
		refreshTimer.setActionCommand("repaint");
		refreshTimer.start();
		head = 0;
		buffer = new int[width];
	}
	
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(new Color(200,200,200));
		
		for (int i = 0; i < this.getWidth();i+=20) {
			g.drawLine(i, 0, i, this.getHeight());
		}
		
		for (int i = 0; i < this.getHeight();i+=20) {
			g.drawLine(0, i, this.getWidth(), i);
		}
		
		g.setColor(new Color(50,255,50));
		for (int i = 1; i < width-1;++i){
			g.drawLine(i-1, this.getHeight()-buffer[(i-1+head)%buffer.length], i, this.getHeight()-buffer[(i+head)%buffer.length]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		switch (ev.getActionCommand()) {
			case "repaint":
				this.repaint();
				break;
			case "byte gotten":
				buffer[(buffer.length+head-1)%buffer.length] = ((PortHolder)ev.getSource()).getReading();
				++head;
				break;
			default:
				break;
		}
	}
}