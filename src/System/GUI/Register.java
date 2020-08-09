package System.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import System.Data.Loyalty_Storer;
import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Ticket;
/**
 * This class enables the interface that the customer can register for loyalty.
 * @author Siyi Yan
 * @version 2.0
 */
public class Register {
    private static Entity_Ticket t; 
    private Entity_Loyalty l = new Entity_Loyalty();
	private JFrame frmWelcomeToRamen;
	private JTextField firstName;
	private JTextField surnName;
	private JTextField email;
	private JTextField mobilePhone;
	private int count=0;
	Entity_Ticket ramenTicket;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			Register window = new Register(t);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the register frame.
	 * @param t
	 */
	public Register(Entity_Ticket t) {
		initialize(t);
	}

	/**
	 * Initialize the contents of the frame for customer to register.
	 * @param t
	 */
	private void initialize(Entity_Ticket t) {
		ramenTicket=t;
		frmWelcomeToRamen = new JFrame();
		frmWelcomeToRamen.setVisible(true);
		frmWelcomeToRamen.setTitle("Welcome to Ramen Restaurant!");
		frmWelcomeToRamen.setBounds(0, 0, 461, 652);
		frmWelcomeToRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToRamen.getContentPane().setLayout(null);
		
		JPanel panelConfirm = new JPanel();
		panelConfirm.setBounds(14, 13, 429, 90);
		frmWelcomeToRamen.getContentPane().add(panelConfirm);
		panelConfirm.setLayout(null);
		JLabel confirm = new JLabel("Welcome to become a loyalty!");
		confirm.setForeground(new Color(255, 153, 0));
		confirm.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		confirm.setBounds(0, 0, 415, 43);
		panelConfirm.add(confirm);
		
		JLabel lblNewLabel = new JLabel("Please fill in the following details!");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(79, 43, 336, 34);
		panelConfirm.add(lblNewLabel);
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(new Color(255, 153, 0));
		panelMid.setBounds(14, 110, 415, 379);
		frmWelcomeToRamen.getContentPane().add(panelMid);
		panelMid.setLayout(null);
		
		JPanel panelMid1 = new JPanel();
		panelMid1.setBackground(new Color(255, 255, 255));
		panelMid1.setBounds(14, 13, 387, 353);
		panelMid.add(panelMid1);
		panelMid1.setLayout(null);
		
		firstName= new JTextField();
		firstName.setBounds(170, 18, 99, 37);
		panelMid1.add(firstName);
		firstName.setColumns(10);
		
		JLabel fName = new JLabel("First name:");
		fName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		fName.setForeground(new Color(255, 153, 0));
		fName.setBounds(14, 17, 127, 33);
		panelMid1.add(fName);
		
		JLabel sName = new JLabel("Surname:");
		sName.setForeground(new Color(255, 153, 0));
		sName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		sName.setBounds(14, 87, 110, 37);
		panelMid1.add(sName);
		
		surnName = new JTextField();
		surnName.setBounds(170, 90, 99, 37);
		panelMid1.add(surnName);
		surnName.setColumns(10);
		
		JLabel mustDo = new JLabel("*The following information you must");
		 mustDo.setForeground(new Color(255, 0, 0));
		 mustDo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		 mustDo.setBounds(14, 137, 359, 37);
		panelMid1.add( mustDo);
		
		JLabel fill = new JLabel("fill in at least one!");
		 fill.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		 fill.setForeground(new Color(255, 0, 0));
		 fill.setBounds(24, 182, 191, 33);
		panelMid1.add( fill);
		
		JLabel mail = new JLabel("E-mail:");
		mail.setForeground(new Color(255, 153, 0));
		mail.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		mail.setBounds(14, 229, 99, 28);
		panelMid1.add(mail);
		
		email = new JTextField();
		email.setBounds(170, 228, 99, 37);
		panelMid1.add(email);
		email.setColumns(10);
		
		JLabel phone = new JLabel("Mobile number:");
		phone.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		phone.setForeground(new Color(255, 153, 0));
		phone.setBounds(14, 291, 146, 37);
		panelMid1.add(phone);
		
		mobilePhone = new JTextField();
		mobilePhone.setBounds(170, 294, 99, 37);
		panelMid1.add(mobilePhone);
		mobilePhone.setColumns(10);
		
		JPanel panelBack = new JPanel();
		panelBack.setBounds(14, 502, 415, 90);
		frmWelcomeToRamen.getContentPane().add(panelBack);
		panelBack.setLayout(null);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoosePayWay frame = new ChoosePayWay(ramenTicket);
				frmWelcomeToRamen.setVisible(false);
			}
		});
		back.setBounds(14, 31, 137, 46);
		panelBack.add(back);
		
	//	private JTextField firstName;
		//private JTextField surnName;
		//private JTextField email;
		//private JTextField mobilePhone;
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1=firstName.getText();
				String str2=surnName.getText();
				String str3=email.getText();
				String str4=mobilePhone.getText();
				count=0;
				for(int i=0;i<str3.length();i++) {
					if(str3.charAt(i)=='@') {
						count++;
					}
				}
		       if(str1.equals("")!=true && str2.equals("")!=true) {
		    	  if(str3.equals("")!=true || str4.equals("")!=true) {
		    		  if(count==1&&str3.equals("")!=true) //fill in email
		    		  {
		    			  l.setFname(str1);
			    		  l.setSname(str2);
			    		  l.setEmail(str3);
			    		  if(str4.equals("")!=true) //fill in phone
			    		  {
			    			  if(str4.length()==11) {
			    				  l.setPhone(str4);
			    				  Loyalty_Storer.register(l);
			    				  MemberInfo frame = new MemberInfo(ramenTicket,l.getLID());
					    		  frmWelcomeToRamen.setVisible(false);
			    			  }
			    			  else {
			    				  WrongFormat w = new WrongFormat();
			    			  }
			    		  }
			    		  else {
			    			//  l.setPhone(null);
			    			  Loyalty_Storer.register(l);
			    			  MemberInfo frame = new MemberInfo(ramenTicket,l.getLID());
				    		  frmWelcomeToRamen.setVisible(false);
			    		  }
		    		 
		    		  }
		    		  else if(str3.equals("")==true && str4.equals("")!=true)//fill in mail
		    		  {
		    			  if(str4.length()==11) {
		    				  l.setFname(str1);
				    		  l.setSname(str2);
				    	//	  l.setEmail(null);
				    		  l.setPhone(str4);
				    		  Loyalty_Storer.register(l);
		    			  MemberInfo frame = new MemberInfo(ramenTicket,l.getLID());
			    		  frmWelcomeToRamen.setVisible(false);
			    		  }
		    			  else {
		    				  WrongFormat w = new WrongFormat();
		    				  
		    			  }
		    		  }
		    		  else {
		    			
				    	   WrongFormat w = new WrongFormat();
		    		  }
		    	   }
		    	  else {
		    	   
		    	   Failure f = new Failure("Pleaese fill in at least one!",t);
		    	   }
		    	  
		       }
		       else {
		    		  Failure f = new Failure("Pleaese fill in the information!",t); 
		    	  }
			}
			
		});
		
		submit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		submit.setBounds(264, 31, 137, 46);
		panelBack.add(submit);
	}
}
