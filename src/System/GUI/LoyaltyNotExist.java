package System.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Entity.Entity_Ticket;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * This class is for robustness.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class LoyaltyNotExist extends JFrame {

	private JPanel contentPane;
	private Entity_Ticket ramenTicket;



	/**
	 * Create the frame.
	 * @param ti
	 */
	public LoyaltyNotExist(Entity_Ticket ti) {
		ramenTicket=ti;
		setTitle("warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		panel.setForeground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 436, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(14, 20, 412, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLoyaltyIsNot = new JLabel("Loyalty is not exist");
		lblLoyaltyIsNot.setForeground(new Color(255, 153, 0));
		lblLoyaltyIsNot.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblLoyaltyIsNot.setBounds(10, 46, 347, 53);
		panel_1.add(lblLoyaltyIsNot);
		
		JLabel lblPleaseCheckThe = new JLabel("Please check the ID ");
		lblPleaseCheckThe.setForeground(new Color(255, 153, 0));
		lblPleaseCheckThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseCheckThe.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblPleaseCheckThe.setBounds(94, 102, 318, 47);
		panel_1.add(lblPleaseCheckThe);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnOk.setBounds(146, 178, 113, 39);
		panel_1.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ChoosePayWay d=new ChoosePayWay(ramenTicket);
				dispose();
			}
		});
	}
}
