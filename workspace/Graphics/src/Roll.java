import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Roll implements ActionListener {
	private JFrame frame;
	private JPanel contentPane;
	private JButton button;
	private JLabel face1;
	private JLabel face2;
	
	private Roll() { //so when code is copied, old constructor isn't used by accident
		frame = new JFrame("Roll");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2,1,5,5));
		contentPane.setBorder(new EmptyBorder(10,10,10,10));
		
		face1 = new JLabel(new ImageIcon(getDieName()));
		contentPane.add(face1);
		
		face2 = new JLabel(new ImageIcon(getDieName()));
		contentPane.add(face2);
		
		button = new JButton("Roll");
		button.setActionCommand("Roll");
		button.addActionListener(this);
		contentPane.add(button);
		
		contentPane.setBackground(new Color((int)(256*Math.random()), (int)(256*Math.random()), (int)(256*Math.random())));
		button.setBackground(new Color((int)(100*Math.random())+156, (int)(100*Math.random())+156, (int)(100*Math.random())+156));
		button.setForeground(new Color((int)(28*Math.random()), (int)(28*Math.random()), (int)(28*Math.random())));
		
		frame.setContentPane(contentPane);
		frame.getRootPane().setDefaultButton(button);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		new Roll();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand() == "Roll") {
			contentPane.setBackground(new Color((int)(256*Math.random()), (int)(256*Math.random()), (int)(256*Math.random())));
			button.setBackground(new Color((int)(100*Math.random())+156, (int)(100*Math.random())+156, (int)(100*Math.random())+156));
			button.setForeground(new Color((int)(28*Math.random()), (int)(28*Math.random()), (int)(28*Math.random())));
			face1.setIcon(new ImageIcon(getDieName()));
			face2.setIcon(new ImageIcon(getDieName()));
		}
	}

	private static String getDieName() {
		return "die"+(int)(6*Math.random()+1)+".gif";
	}
}
