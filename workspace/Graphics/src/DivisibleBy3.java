import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DivisibleBy3 implements ActionListener {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField numberInput;
	private JButton button;
	private JLabel outLabel;
	
	private DivisibleBy3() { //so when code is copied, old constructor isn't used by accident
		frame = new JFrame("DivisibleBy3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2,2,5,5));
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel label = new JLabel("Enter an integer:");
		label.setPreferredSize(new Dimension(200, 30));
		contentPane.add(label);
		
		numberInput = new JTextField(10);
		contentPane.add(numberInput);
		
		button = new JButton("Check");
		button.setPreferredSize(new Dimension(100, 30));
		button.setActionCommand("Check");
		button.addActionListener(this);
		contentPane.add(button);
		
		outLabel = new JLabel("");
		outLabel.setPreferredSize(new Dimension(200, 30));
		contentPane.add(outLabel);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new DivisibleBy3();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals("Check")) {
			try {
				long num = Long.parseLong(numberInput.getText());
				if (num%3 == 0) {
					outLabel.setText("Number is divisible by 3.");
				}
				else {
					outLabel.setText("Number is not divisible by 3.");
				}
			}
			catch (NumberFormatException ex) {
				outLabel.setText("Invalid format!");
			}
		}
	}

}
