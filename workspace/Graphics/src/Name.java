import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Name implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JButton button;
	JLabel label;
	
	private Name() { //so when code is copied, old constructor isn't used by accident
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
		new Name();
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
			label.setText("Jason Li");
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
