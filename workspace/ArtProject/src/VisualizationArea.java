import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class VisualizationArea extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7949497226496174835L;
	
	private PortHolder port;
	private int reading;
	private Timer refreshTimer;
	private double perlinZOffset;
	
	VisualizationArea(PortHolder newHolder) {
		port = newHolder;
		port.addActionListener(this);
		
		perlinZOffset = 0;

		refreshTimer = new Timer(10, this);
		refreshTimer.setActionCommand("repaint");
		refreshTimer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double perlinZ = (double)reading/100+perlinZOffset;
		for (int i = 0; i < this.getWidth(); ++i) {
			for (int j = 0; j < this.getHeight(); ++j) {
				g.setColor(new Color(Color.HSBtoRGB(
						(float)Math.pow(ImprovedNoise.noise((double)i/this.getWidth()*5, (double)j/this.getHeight()*5, perlinZ),1.5),
						(float)ImprovedNoise.noise((double)i/this.getWidth()*5+10, (double)j/this.getHeight()*5+10, perlinZ),
						(float)ImprovedNoise.noise((double)i/this.getWidth()*5+100, (double)j/this.getHeight()*5+100, perlinZ))));
				g.fillRect(i,j,1,1);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals("repaint")) {
			perlinZOffset = perlinZOffset+0.009;
			this.repaint();
		}
		else if (ev.getActionCommand().equals("byte gotten")) {
			reading = ((PortHolder)ev.getSource()).getReading();
			this.repaint();
		}
	}
}