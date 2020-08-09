package System.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
/**
 * This class is the interface for users to remind him that he has inputed a wrong format.
 * @author Tong Wu
 * @version 2.1
 */
public class WrongFormat {

	private JFrame frmRamenRestaurant;


	/**
	 * Create the application.
	 */
	public WrongFormat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRamenRestaurant = new JFrame();
		frmRamenRestaurant.getContentPane().setBackground(new Color(255, 153, 0));
		frmRamenRestaurant.getContentPane().setForeground(new Color(255, 255, 255));
		frmRamenRestaurant.setFont(new Font("Dialog", Font.PLAIN, 7));
		frmRamenRestaurant.setTitle("Ramen Restaurant");
		frmRamenRestaurant.setBounds(100,100,450,300);
		frmRamenRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenRestaurant.getContentPane().setLayout(null);
		frmRamenRestaurant.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Wrong Format!");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setBounds(20, 58, 395, 111);
		lblNewLabel.setLabelFor(frmRamenRestaurant);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 42));
		lblNewLabel.setBackground(Color.WHITE);
		frmRamenRestaurant.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenRestaurant.dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.setBounds(156,191,114,37);
		frmRamenRestaurant.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(15, 20, 405, 220);
		frmRamenRestaurant.getContentPane().add(panel);
		
	}
}
