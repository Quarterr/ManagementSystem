package System.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Data.Loyalty_Reader;
import System.Entity.Entity_Ticket;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Interface of choosing the pay way.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class ChoosePayWay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Entity_Ticket ramenTicket;

	/**
	 * Create the frame.
	 * @param ti
	 */
	public ChoosePayWay(Entity_Ticket ti) {
		//setType(Type.UTILITY);
		setTitle("Welcome to Ramen Restaurant!");
		ramenTicket=ti;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 460, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(255, 140, 0));
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		lblId.setBounds(0, 180, 100, 44);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(93, 180, 213, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnSearch.setBounds(316, 180, 106, 44);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {  //check the input and display the member info 
			public void actionPerformed(ActionEvent e) {
				String loyaltyID=textField.getText(); 
				//System.out.println(loyaltyID);
				//System.out.println("++++++++++++++++++++++++++++++++++++++++");
				if(Loyalty_Reader.findLoyalty(loyaltyID)) {
					MemberInfo d=new MemberInfo(ramenTicket,loyaltyID);
					dispose();
				}
				else {
					LoyaltyNotExist l=new LoyaltyNotExist(ramenTicket);
					//dispose();
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnBack.setBounds(14, 553, 98, 46);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayOrder d=new DisplayOrder(ramenTicket);
				dispose();
			}
		});
		
		JLabel lblTotoralRemen = new JLabel("TOTORO   REMEN");
		lblTotoralRemen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotoralRemen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTotoralRemen.setForeground(new Color(255, 140, 0));
		lblTotoralRemen.setBounds(0, 0, 446, 44);
		contentPane.add(lblTotoralRemen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 45, 446, 5);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(0, 51, 446, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblpayment = new JLabel(">PAYMENT");
		lblpayment.setForeground(new Color(255, 140, 0));
		lblpayment.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblpayment.setBounds(14, 0, 129, 31);
		panel_1.add(lblpayment);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 140, 0));
		panel_2.setBounds(126, 260, 176, 78);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 239, 213));
		btnRegister.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnRegister.setBounds(14, 14, 152, 55);
		panel_2.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register a=new Register(ramenTicket);
				dispose();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 140, 0));
		panel_3.setBounds(126, 358, 176, 78);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnCardcash = new JButton("Card/Cash");
		btnCardcash.setBackground(new Color(255, 235, 205));
		btnCardcash.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		btnCardcash.setBounds(14, 14, 152, 55);
		panel_3.add(btnCardcash);
		
		JLabel lblPleaseInputYour = new JLabel("Please input your loyalty ID:");
		lblPleaseInputYour.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblPleaseInputYour.setBounds(15, 103, 446, 44);
		contentPane.add(lblPleaseInputYour);
		btnCardcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.generateTicket();
				Finish f=new Finish(ramenTicket);
				dispose();
			}
		});
	}
}
