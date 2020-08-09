package System.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 * This class enables the interface that to tell the customer fill in the full information.
 * @author Siyi Yan
 * @version 2.0
 */
public class Failure extends RemindPanel {

	/**
	 * Initialize the contents of the frame to tell user fill information.
	 * @param s
	 * @param o
	 */
	private void initialize(String s,Object o) {
		frame = new JFrame();
		frame.setTitle("Ramen Restaurant");
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(16, 15, 404, 227);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>"+s);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(0, 30, 352, 118);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(148, 178, 113, 39);
		panel.add(btnNewButton);
	}
	private JFrame frame;


	/**
	 * Create the application.
	 * @param s
	 * @param t
	 */
	public Failure(String s,Object t) {
		initialize(s,t);
	}

	

}
