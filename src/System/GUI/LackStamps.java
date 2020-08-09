package System.GUI;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import System.Control.SendMail;
import System.Data.Loyalty_Storer;
import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Ticket;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * This class is the interface to remind the customer that he lack stamps.
 * @author Tong Wu
 * @version 2.1
 */
public class LackStamps {

	private JFrame frmRamenRestaurant;
	private Entity_Ticket ramenTicket;
	private Entity_Loyalty aloyalty;

	/**
	 * Create the application.
	 * @param ti
	 * @param lo
	 */
	public LackStamps(Entity_Ticket ti, Entity_Loyalty lo) {
		initialize(ti,lo);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param ti
	 * @param lo
	 */
	private void initialize(Entity_Ticket ti, Entity_Loyalty lo) {
		ramenTicket=ti;
		aloyalty=lo;
		frmRamenRestaurant = new JFrame();
		frmRamenRestaurant.getContentPane().setBackground(new Color(255, 255, 240));
		frmRamenRestaurant.setTitle("Ramen Restaurant");
		frmRamenRestaurant.setBounds(0, 0, 460, 650);
		frmRamenRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenRestaurant.getContentPane().setLayout(null);
		frmRamenRestaurant.setVisible(true);
		JLabel lblNewLabel_3 = new JLabel("TOTORO RAMEN");
		lblNewLabel_3.setForeground(new Color(255, 153, 0));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 446, 42);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" >Loyalty");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(255, 228, 196));
		lblNewLabel_4.setForeground(new Color(255,153, 0));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(0, 49, 446, 32);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("<html>!!Stamps Not Enough!!</html>");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 235, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 46));
		lblNewLabel.setBounds(90, 168, 261, 258);
		frmRamenRestaurant.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cash/Card");
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 25));
		btnNewButton.setBounds(113, 518, 221, 46);
		frmRamenRestaurant.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 44, 446, 5);
		frmRamenRestaurant.getContentPane().add(panel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loyalty_Storer.addStamp(lo);
				if(lo.getEmail()!=null || !lo.getEmail().equals("null"))
					SendMail.sendStampchange(lo.getLID());
				RemindUpdate r = new RemindUpdate(ramenTicket, aloyalty);
				ti.generateTicket();
				frmRamenRestaurant.dispose();
			}
		});

	}
}
