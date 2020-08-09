package System.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * The class related to remind users and warn users.
 * @author Siyi Yan
 * @version 1.0
 */
public class RemindPanel {
	private JFrame frmRamenRestaurant;
	/**
	 * Initialization.
	 * @param s1
	 * @param s2
	 */
	protected void initialize(String s1,String s2) {
		frmRamenRestaurant = new JFrame();
		frmRamenRestaurant.setVisible(true);
		frmRamenRestaurant.getContentPane().setBackground(new Color(255, 153, 0));
		frmRamenRestaurant.setTitle("Ramen Restaurant");
		frmRamenRestaurant.setBounds(100, 100, 450, 300);
		frmRamenRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenRestaurant.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(15, 21, 404, 221);
		frmRamenRestaurant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(s1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(0, 13, 404, 76);
		panel.add(lblNewLabel);
		
		JLabel lblThenAddMore = new JLabel(s2);
		lblThenAddMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblThenAddMore.setForeground(new Color(255, 153, 0));
		lblThenAddMore.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 32));
		lblThenAddMore.setBounds(10, 86, 380, 76);
		panel.add(lblThenAddMore);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenRestaurant.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(148, 178, 113, 39);
		panel.add(btnNewButton);
	}
	
}
