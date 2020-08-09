package System.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Ticket;
/**
 * This class is the interface for users to remind him that the stamp's number has been updated.
 * @author Tong Wu
 * @version 2.1
 */
public class RemindUpdate {

	private JFrame frmRamenRestaurant;
	private Entity_Ticket ramenTicket;
	private Entity_Loyalty aloyalty;
	
	/**
	 * Create the application.
	 * @param ti
	 * @param lo
	 */
	public RemindUpdate(Entity_Ticket ti, Entity_Loyalty lo) {
		initialize(ti, lo);
	}
	/**
	 * Initialize the contents of the frame.
	 * @param ti
	 * @param lo
	 */
	private void initialize(Entity_Ticket ti, Entity_Loyalty lo) {
		ramenTicket=ti;
		frmRamenRestaurant = new JFrame();
		frmRamenRestaurant.getContentPane().setBackground(new Color(255, 153,0));
		frmRamenRestaurant.setTitle("Ramen Restaurant");
		frmRamenRestaurant.setBounds(100, 100, 450, 300);
		frmRamenRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenRestaurant.getContentPane().setLayout(null);
		frmRamenRestaurant.setVisible(true);
		JLabel lblNewLabel = new JLabel("<html> You'v got a stamp and the email/note is sent to inform you.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(15, 26, 405, 168);
		frmRamenRestaurant.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Finish f = new Finish(ramenTicket);
				frmRamenRestaurant.dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 21));
		btnNewButton.setBounds(147, 201, 138, 39);
		frmRamenRestaurant.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(15, 18, 405, 232);
		frmRamenRestaurant.getContentPane().add(panel);
	}
}
