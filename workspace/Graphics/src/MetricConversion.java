import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MetricConversion implements ActionListener {
	//length of CONVERSIONS is length of CONVERSION_OPTIONS + 1, CONVERSIONS last element is "something really bad happened"
	private static final String[] CONVERSION_OPTIONS = {"inches to centimeters", "feet to meters", "gallons to liters", "pounds to kilograms"};
	private static final String[] CONVERSIONS = {"1 inch = 2.54 centimeters", "1 foot = 0.3048 meters", "1 gallon = 4.5461 liters", "1 pound = 0.4536 kilograms", "Something really bad happened."};
	
	private JFrame frame;
	private JPanel contentPane;
	private JComboBox<String> convType;
	private JLabel outLabel;
	
	private MetricConversion() { //so when code is copied, old constructor isn't used by accident
		frame = new JFrame("MetricConversion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2,1,5,5));
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		
		convType = new JComboBox<String>(CONVERSION_OPTIONS);
		convType.addActionListener(this);
		contentPane.add(convType);
		
		outLabel = new JLabel(getConversion(convType.getSelectedIndex()));
		outLabel.setPreferredSize(new Dimension(200, 30));
		contentPane.add(outLabel);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new MetricConversion();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand() == "comboBoxChanged") {
			outLabel.setText(getConversion(convType.getSelectedIndex()));
		}
	}

	private static String getConversion(int index) {
		String conversion = "";
		switch (index) {
		case -1:
			conversion = CONVERSIONS[CONVERSIONS.length];
		default:
			conversion = CONVERSIONS[index];
		}
		return conversion;
	}
}
