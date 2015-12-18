import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RandGenButton implements ActionListener {
	private static final String NAME = "Jason Li";
	
	private JFrame frame;
	private JPanel contentPane;
	private JButton button;
	private JLabel label;
	
	private RandGenButton() {
		frame = new JFrame("Name");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		
		label = new JLabel("");
		label.setPreferredSize(new Dimension(200, 30));
		contentPane.add(label);
		
		button = new JButton("Show");
		button.setPreferredSize(new Dimension(100, 30));
		button.setActionCommand("Show");
		button.addActionListener(this);
		contentPane.add(button);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new RandGenButton();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Show")) {
			label.setText(NAME);
			button.setText("Hide");
			button.setActionCommand("Hide");
		}
		else {
			label.setText("");
			button.setText("Show");
			button.setActionCommand("Show");
		}
	}

}
