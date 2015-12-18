import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Riddle implements ActionListener {
	private final static String QUESTION = "How much more is C++ compared to C?";
	private final static String ANSWER = "Nothing, C++ is postincrement!";
	private JFrame frame;
	private GridLayout layout;
	private JPanel contentPane;
	private JButton button;
	private JLabel answer;
	
	public Riddle() {
		frame = new JFrame("Riddle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		layout = new GridLayout(2, 1);
		contentPane.setLayout(layout);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		JLabel question = new JLabel(QUESTION);
		question.setPreferredSize(new Dimension(300, 20));
		contentPane.add(question);
		
		answer = new JLabel("");
		answer.setPreferredSize(new Dimension(200, 20));
		contentPane.add(answer);
		
		button = new JButton("Answer");
		button.setMinimumSize(new Dimension(100, 30));
		button.setActionCommand("Show");
		button.addActionListener(this);
		contentPane.add(button);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new Riddle();
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
			answer.setText(ANSWER);
			button.setText("Hide Answer");
			button.setActionCommand("Hide");
		}
		else {
			answer.setText("");
			button.setText("Answer");
			button.setActionCommand("Show");
		}
	}

}
