import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class BloodDrive implements ActionListener {
	private static final String[] DEPARTMENT_NAMES = {"Sales", "HR", "Legal", "IT", "Marketing"};
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField[] donated;
	//private JButton button;
	private BloodDriveChart chart;
	
	private BloodDrive() { //so when code is copied, old constructor isn't used by accident
		frame = new JFrame("BloodDrive");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel label = new JLabel("Enter blood donation amounts:");
		label.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(3, 3, 3, 3);
		contentPane.add(label, gbc);
		
		donated = new JTextField[5];
		for (int i = 0; i < donated.length; ++i) {
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = i+1;
			gbc.insets = new Insets(3, 3, 3, 3);
			gbc.anchor = GridBagConstraints.LINE_END;
			contentPane.add(new JLabel(DEPARTMENT_NAMES[i]+":"), gbc);
			donated[i] = new JTextField(10);
			gbc.gridx = 1;
			gbc.anchor = GridBagConstraints.LINE_START;
			contentPane.add(donated[i], gbc);
		}
		
		donated[donated.length-1].setActionCommand("Enter");
		donated[donated.length-1].addActionListener(this);
		/*
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(3, 3, 3, 3);
		button = new JButton("Plot");
		button.setPreferredSize(new Dimension(100, 30));
		button.setActionCommand("Plot");
		button.addActionListener(this);
		contentPane.add(button, gbc);
		*/
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6; //used to be 7 if button is included
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 2;
		chart = new BloodDriveChart();
		chart.setPreferredSize(new Dimension(560, 240));
		contentPane.add(chart, gbc);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new BloodDrive();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals("Enter")) { //ev.getActionCommand().equals("Plot") || 
			double[] donationAmounts = new double[donated.length];
			for (int i = 0; i < donated.length; ++i) {
				try {
					donationAmounts[i] = Double.parseDouble(donated[i].getText());
				}
				catch (NumberFormatException ex) {
					donationAmounts[i] = 0;
				}
			}
			chart.updateDonations(donationAmounts);
			chart.repaint();
		}
	}
}

class BloodDriveChart extends JPanel {
	private static final String[] DEPARTMENT_NAMES = {"Sales", "HR", "Legal", "IT", "Marketing"};
	private double[] donations = new double[5];
	
	private static final long serialVersionUID = -7433006090831042906L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double max = findMax(donations);
		for (int i = 0; i < donations.length; ++i) {
			donations[i]/=max;
		}
		if (max < 0) {
			for (int i = 0; i < donations.length; ++i) {
				donations[i] = 0;
			}
			g.drawString("Invalid inputs! Please don't enter negative numbers.", 130, 100);
			max = 0;
		}
		g.setColor(Color.BLACK);
		g.drawLine(79, 0, 79, 200);
		for (int i = 0; i < donations.length; ++i) {
			g.setColor(Color.BLACK);
			g.drawString(DEPARTMENT_NAMES[i], 0, 40*i+20);
			g.setColor(Color.RED);
			g.fillRect(80, 40*i+11, (int)(400*donations[i]), 10);
		}
		g.setColor(Color.BLACK);
		g.drawLine(79, 200, 480, 200);
		g.drawLine(480, 200, 480, 210);
		g.drawString("Pints of blood", 230, 225);
		if (max != 0) {
			g.drawString(String.format("%.4f", max), 460, 225);
		}
	}
	
	public void updateDonations(double[] donations) { this.donations = donations; }
	
	private static double findMax(double[] arr) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i]>arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
}
