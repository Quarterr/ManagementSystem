package System.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import System.Data.Loyalty_Storer;
import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Ticket;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
/**
 * This class is the interface to show the payment successful by the use stamps way.
 * @author Tong Wu
 * @version 2.1
 */
public class PayComplete {

	private JFrame frmRamenRestaurant;
	private Entity_Ticket ramenTicket;
	private Entity_Loyalty aloyalty;
	private String loyaltyID;
	private Float totalprice;
	private String s;

	/**
	 * Create the application.
	 * @param ti
	 * @param lo
	 */
	public PayComplete(Entity_Ticket ti, Entity_Loyalty lo) {
		initialize(ti,lo);
	}
	/**
	 * Initialize the contents of the frame.
	 * @param ti
	 * @param lo
	 */
	private void initialize(Entity_Ticket ti, Entity_Loyalty lo) {
		ramenTicket=ti;
		totalprice=ti.getTotalPrice();
		ti.setUseStamp(true);
		ti.generateTicket();
		String s=Float.toString(totalprice);
		aloyalty=lo;
		Loyalty_Storer.useStamp(aloyalty);
		loyaltyID=lo.getLID();
		frmRamenRestaurant = new JFrame();
		frmRamenRestaurant.getContentPane().setBackground(new Color(255, 255, 240));
		frmRamenRestaurant.setTitle("Ramen Restaurant");
		frmRamenRestaurant.setBounds(0,0,460,650);
		frmRamenRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenRestaurant.getContentPane().setLayout(null);
		frmRamenRestaurant.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\uFFE1    " + s);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel.setBounds(105, 149, 226, 57);
		frmRamenRestaurant.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Complete");
		lblNewLabel_2.setForeground(new Color(255, 153, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(65, 338, 328, 103);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RamenSelection d = new RamenSelection();
				
				frmRamenRestaurant.dispose();
			}
		});
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.setBounds(155, 525, 129, 48);
		frmRamenRestaurant.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("TOTORO RAMEN");
		lblNewLabel_3.setForeground(new Color(255, 153, 0));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 453, 56);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("  >Loyalty");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(255, 228, 196));
		lblNewLabel_4.setForeground(new Color(255, 153, 0));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(0, 82, 446, 41);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_4);
		
		//JLabel lblNewLabel_1 = new JLabel("ID");
		//lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		//lblNewLabel_1.setBounds(50, 242, 76, 56);
		//frmRamenRestaurant.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("ID     " + loyaltyID);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel_5.setBounds(50, 242, 361, 56);
		frmRamenRestaurant.getContentPane().add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 67, 453, 5);
		frmRamenRestaurant.getContentPane().add(panel);
	}
}
