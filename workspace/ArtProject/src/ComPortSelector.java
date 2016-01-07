import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ComPortSelector implements ActionListener {
	private JFrame frame;
	private JPanel contentPane;
	private JComboBox<String> convType;
	private JLabel outLabel;
	
	private ComPortSelector() { //so when code is copied, old constructor isn't used by accident
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
		new ComPortSelector();
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
