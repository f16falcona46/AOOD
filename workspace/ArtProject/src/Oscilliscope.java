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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class Oscilliscope {
	private static final int BYTES_PER_SCREEN = 256;
	private static final int SCREEN_HEIGHT = 256;
	
	private static class VisualizationArea extends JPanel implements ActionListener {
		private int[] buffer;
		private Timer refreshTimer;
		
		VisualizationArea(int[] newbuffer) {
			buffer = newbuffer;

			refreshTimer = new Timer(100, this);
			refreshTimer.setActionCommand("repaint");
			refreshTimer.start();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			double perlinZ = 0;
			synchronized (buffer) {
				perlinZ = buffer[0];
			}
			
		}
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			if (ev.getActionCommand().equals("repaint")) {
				this.repaint();
			}
		}
	}
	
	private static class ScopeArea extends JPanel implements ActionListener {
		private static final long serialVersionUID = 5283408121493711494L;
		
		private SerialPort port;
		public int[] buffer;
		private Timer refreshTimer;
		
		ScopeArea() {
			String[] ports = SerialPortList.getPortNames();
			String portName = (String)JOptionPane.showInputDialog(null,"Choose COM port:","COM Ports",JOptionPane.PLAIN_MESSAGE,null,ports,null);
			port = new SerialPort(portName);
			try {
				port.openPort();
				port.setParams(9600, 8, 1, 0);
			} catch (SerialPortException ex) {
				System.out.println(ex);
				System.exit(ERROR);
			}
			setBackground(new Color(250,250,240));
			refreshTimer = new Timer(100, this);
			refreshTimer.setActionCommand("repaint");
			refreshTimer.start();
		}
		
		@Override
		public void paintComponent(Graphics g) { 
			super.paintComponent(g);
			try {
				synchronized (buffer) {
					if (port.getInputBufferBytesCount() >= BYTES_PER_SCREEN) {
						buffer = convUnsignedByteArrToIntArr(port.readBytes(BYTES_PER_SCREEN));
						System.out.println(port.getInputBufferBytesCount());
					}
					if (buffer != null) {
						for (int i = 0; i < BYTES_PER_SCREEN; ++i) {
							g.fillRect(i,SCREEN_HEIGHT-buffer[i],1,1);
						}
					}
				}
			}
			catch (SerialPortException ex) {
				System.out.println(ex);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			switch (ev.getActionCommand()) {
				case "repaint":
					this.repaint();
					break;
				default:
					break;
			}
		}
	}
	
	private static class ScopeWindow implements ActionListener {
		
		private JFrame frame;
		private ScopeArea plane;
		
		ScopeWindow() { //so when code is copied, old constructor isn't used by accident
			JFrame.setDefaultLookAndFeelDecorated(false);
			frame = new JFrame("Scope");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			plane = new ScopeArea();
			plane.setPreferredSize(new Dimension(BYTES_PER_SCREEN, SCREEN_HEIGHT));
			plane.repaint();
			
			frame.setContentPane(plane);
			frame.pack();
			frame.setResizable(false);
			frame.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ev) {
			System.out.println(ev);
		}
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new ScopeWindow();
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}
	
	private static int[] convUnsignedByteArrToIntArr(byte[] byteArr) {
		int[] result = new int[byteArr.length];
		for (int i = 0; i < byteArr.length; ++i) {
			result[i] = byteArr[i]&0xFF;
		}
		return result;
	}
}
