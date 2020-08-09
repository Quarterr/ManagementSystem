package System.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Entity.Entity_Ticket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


/**
 * Interface of displaying the order.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class DisplayOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private Entity_Ticket ramenTicket;



	/**
	 * Create the frame.
	 * @param ti
	 */
	public DisplayOrder(Entity_Ticket ti) {
		setTitle("Welcome to Ramen Restaurant!");
		ramenTicket=ti;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 460, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setForeground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JButton btnContinue = new JButton("Pay");
		btnContinue.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoosePayWay a=new ChoosePayWay(ramenTicket);
				dispose();
			}
		});
		btnContinue.setBounds(323, 529, 113, 46);
		contentPane.add(btnContinue);
		
		JButton btnBack = new JButton("Back");       // now don't have back interface
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		btnBack.setBounds(14, 529, 113, 46);
		contentPane.add(btnBack);
		
		
		table = new JTable();     //This table is used to display the order
		table.setBounds(117, 170, 187, -114);
		contentPane.add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 57, 446, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOrder = new JLabel("> ORDER");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setForeground(new Color(255, 140, 0));
		lblOrder.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblOrder.setBounds(0, 0, 136, 36);
		panel.add(lblOrder);
		
		JLabel lblTotoralRamen = new JLabel("TOTORO   RAMEN");
		lblTotoralRamen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotoralRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTotoralRamen.setForeground(new Color(255, 140, 0));
		lblTotoralRamen.setBounds(0, 0, 446, 36);
		contentPane.add(lblTotoralRamen);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 49, 446, 5);
		contentPane.add(panel_2);
		
		JLabel lblTonkostu = new JLabel("Please confirm your order ");
		lblTonkostu.setForeground(new Color(255, 140, 0));
		lblTonkostu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTonkostu.setBounds(14, 103, 422, 57);
		contentPane.add(lblTonkostu);
		
		//* get object
		float totalPrice=ramenTicket.getTotalPrice();
		int eggNo=ramenTicket.getAddOnPart("eggNo");
		int noriNo=ramenTicket.getAddOnPart("NoriNo");
		int chashuNo=ramenTicket.getAddOnPart("chashuNo");
		int bambooNo=ramenTicket.getAddOnPart("bambooNo");
		boolean egg=ramenTicket.getBasicPart2("egg");
		if(egg!=false)
			eggNo+=1;
		boolean chashu=ramenTicket.getBasicPart2("chashu");
		if(chashu!=false)
			chashuNo+=1;
		boolean nori=ramenTicket.getBasicPart2("nori");
		if(nori!=false)
			noriNo+=1;
		String soup=ramenTicket.getBasicPart1("soup");
		String noodle=ramenTicket.getBasicPart1("noodle");
		String springOnion=ramenTicket.getBasicPart1("springOnion");
		Boolean eatIn=ramenTicket.getEatInPart();
	
		
		String[]  colsName= {"option","number"};
		Object[][] tableValues= {{"Egg",eggNo},{"Nori",noriNo},
				{"Chashu",chashuNo},{"Bamboo Shoots",bambooNo},
				{"Soup",soup},{"Noodle",noodle},{"Spring Onion",springOnion},{"Eat-in",eatIn}};
		table_1 = new JTable(tableValues,colsName);
		table_1.setEnabled(false);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(31, 206, 392, 200);
		table_1.setRowHeight(25);
		table_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(table_1);
		
		JLabel lblTotal = new JLabel(String.valueOf(totalPrice));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblTotal.setBounds(145, 436, 159, 57);
		contentPane.add(lblTotal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(14, 187, 422, 240);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("\uFFE1");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(161, 448, 32, 36);
		contentPane.add(lblNewLabel);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EatInOrTakeAway a=new EatInOrTakeAway(ramenTicket);
				dispose();
			}
		});
		
	}
}
