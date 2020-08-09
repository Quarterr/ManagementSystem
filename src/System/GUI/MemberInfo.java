package System.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Data.Loyalty_Reader;
import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Ticket;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * Interface of displaying the member information.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class MemberInfo extends JFrame {

	private JPanel contentPane;
	private Entity_Ticket ramenTicket;
	private String loyaltyID;


	/**
	 * Create the frame.
	 * @param ti
	 * @param s
	 */
	public MemberInfo(Entity_Ticket ti,String s) {
		setTitle("Welcome to Ramen Restaurant!");
		ramenTicket=ti;
		loyaltyID=s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 460, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		/*get the basic loyalty information according to the ID */
		Entity_Loyalty member=Loyalty_Reader.personalInfo(loyaltyID);
		String id=member.getLID();          
		String fname=member.getFname();
		String lname=member.getSname();
		String Email=member.getEmail();
		String phone=member.getPhone();
		int stamps=member.getStamp();
		
		JLabel lblTotoralRamen = new JLabel("TOTORO  RAMEN");
		lblTotoralRamen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotoralRamen.setForeground(new Color(255, 140, 0));
		lblTotoralRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTotoralRamen.setBounds(0, 0, 446, 45);
		contentPane.add(lblTotoralRamen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 50, 446, 5);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(0, 56, 446, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblloyalty = new JLabel(">Loyalty");
		lblloyalty.setHorizontalAlignment(SwingConstants.CENTER);
		lblloyalty.setForeground(new Color(255, 140, 0));
		lblloyalty.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblloyalty.setBounds(14, 0, 86, 37);
		panel_1.add(lblloyalty);
		
		JButton btnStamps = new JButton("Confirm");
		btnStamps.setBackground(new Color(255, 235, 205));
		btnStamps.setBounds(149, 520, 131, 45);
		contentPane.add(btnStamps);
		btnStamps.setForeground(new Color(255, 140, 0));
		btnStamps.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		btnStamps.addActionListener(new ActionListener() {      //check the stamps, if the stamps>10, the pay complete, else, turn to the lack
			public void actionPerformed(ActionEvent e) {
				if(stamps<10) {
					LackStamps l= new LackStamps(ramenTicket,member);
					dispose();
				}
				else {
					PayComplete a=new PayComplete(ramenTicket,member);
					dispose();	
				}
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(169, 169, 169));
		panel_3.setBounds(24, 116, 391, 246);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 240));
		panel_2.setBounds(16, 14, 356, 217);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblStamps = new JLabel("Stamps");
		lblStamps.setBounds(36, 181, 72, 18);
		panel_2.add(lblStamps);
		lblStamps.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblSt = new JLabel(String.valueOf(stamps));
		lblSt.setBounds(158, 181, 72, 18);
		panel_2.add(lblSt);
		lblSt.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblSt.setForeground(new Color(255, 140, 0));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 150, 72, 18);
		panel_2.add(lblEmail);
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblEm = new JLabel(Email);
		lblEm.setBounds(158, 150, 187, 18);
		panel_2.add(lblEm);
		lblEm.setForeground(new Color(255, 140, 0));
		lblEm.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(36, 119, 72, 18);
		panel_2.add(lblPhone);
		lblPhone.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblPh = new JLabel(phone);
		lblPh.setBounds(158, 119, 187, 18);
		panel_2.add(lblPh);
		lblPh.setForeground(new Color(255, 140, 0));
		lblPh.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(36, 88, 72, 18);
		panel_2.add(lblSurname);
		lblSurname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblLname = new JLabel(lname);
		lblLname.setBounds(158, 88, 187, 18);
		panel_2.add(lblLname);
		lblLname.setForeground(new Color(255, 140, 0));
		lblLname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(36, 57, 94, 18);
		panel_2.add(lblFirstName);
		lblFirstName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblFirstName.setForeground(new Color(0, 0, 0));
		
		JLabel lblFiname = new JLabel(fname);
		lblFiname.setBounds(158, 57, 187, 18);
		panel_2.add(lblFiname);
		lblFiname.setForeground(new Color(255, 140, 0));
		lblFiname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblId_1 = new JLabel(id);
		lblId_1.setBounds(158, 26, 165, 18);
		panel_2.add(lblId_1);
		lblId_1.setForeground(new Color(255, 140, 0));
		lblId_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblId.setBounds(36, 26, 72, 18);
		panel_2.add(lblId);
		
		JLabel lblIfYouAre = new JLabel("<html>If you are registering for the first time, please remember your ID, you will use it every time you log in.</html>");
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouAre.setForeground(Color.RED);
		lblIfYouAre.setFont(new Font("Comic Sans MS", Font.ITALIC, 21));
		lblIfYouAre.setBounds(10, 359, 436, 151);
		contentPane.add(lblIfYouAre);

	}
}
