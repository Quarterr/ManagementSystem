package System.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Entity.Entity_Ticket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Interface of choosing eat-in or take away.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class EatInOrTakeAway extends JFrame {

	private JPanel contentPane;
	private Entity_Ticket ramenTicket;
	private int flag=0;


	/**
	 * Create the frame.
	 * @param ti
	 */
	public EatInOrTakeAway(Entity_Ticket ti) {
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
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnBack.setBounds(10, 531, 125, 46);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {     //maybe there also need to pass argument Ticket
			public void actionPerformed(ActionEvent e) {    
				RamenSelection d=new RamenSelection(ramenTicket);
				dispose();
			}
		});
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		btnContinue.setBounds(317, 531, 119, 46);
		contentPane.add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ramenTicket.getEatInPart()==false && ramenTicket.getTakeAway()==false) {
					NotChooseEatWay n=new NotChooseEatWay();
				}
				else {
					DisplayOrder c=new DisplayOrder(ramenTicket);
					dispose();	
				}
			}
		});
		
		JLabel lblTototalRamen = new JLabel("TOTORO    RAMEN");
		lblTototalRamen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTototalRamen.setForeground(new Color(255, 140, 0));
		lblTototalRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTototalRamen.setBackground(Color.WHITE);
		lblTototalRamen.setBounds(0, 0, 446, 48);
		contentPane.add(lblTototalRamen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 56, 446, 5);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 239, 213));
		panel_2.setBounds(0, 60, 446, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbldiningOption = new JLabel(">Dining Option");
		lbldiningOption.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lbldiningOption.setForeground(new Color(255, 140, 0));
		lbldiningOption.setBounds(14, 0, 152, 46);
		panel_2.add(lbldiningOption);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setForeground(new Color(255, 140, 0));
		panel_1.setBounds(128, 203, 206, 105);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEatin_1 = new JButton("Eat-in");
		btnEatin_1.setForeground(Color.BLACK);
		btnEatin_1.setBackground(Color.WHITE);
		btnEatin_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
		btnEatin_1.setBounds(13, 13, 182, 80);
		panel_1.add(btnEatin_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 140, 0));
		panel_3.setBounds(128, 339, 206, 105);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnTakeaway = new JButton("Take-away");
		btnTakeaway.setForeground(Color.BLACK);
		btnTakeaway.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 27));
		btnTakeaway.setBackground(new Color(255, 239, 213));
		btnTakeaway.setBounds(13, 13, 182, 80);
		panel_3.add(btnTakeaway);
		
		if(ti.getEatInPart()==true) {
			btnEatin_1.setForeground(Color.RED);	
			flag+=1;
		}
		if(ti.getTakeAway()==true) {
			btnTakeaway.setForeground(Color.RED);
			flag+=1;
		}
		
		btnTakeaway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0) {
					btnTakeaway.setForeground(Color.RED);
					flag+=1;
				}
				else {
					btnTakeaway.setForeground(Color.RED);
					btnEatin_1.setForeground(Color.BLACK);
				}
				ramenTicket.setEatInPart(false);
				ramenTicket.setTakeAway(true);
			}
		});
		
		btnEatin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==0) {
					btnEatin_1.setForeground(Color.RED);
					flag+=1;
				}
				else {
					btnTakeaway.setForeground(Color.BLACK);
					btnEatin_1.setForeground(Color.RED);
				}
				ramenTicket.setEatInPart(true);
				ramenTicket.setTakeAway(false);
			}
		});
		
	}

}
