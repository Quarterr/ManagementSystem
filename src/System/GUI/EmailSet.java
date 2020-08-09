package System.GUI;
import javax.swing.JPanel;

import java.awt.Font;   
import org.jfree.chart.ChartPanel;

import System.Control.TimeTrigger;
import System.Data.Chart_Generater;
import System.Data.Chart_Getter;
import System.Data.Constant;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;  


/**
 * This class provide the interface that the manager can change the email set.
 * @author Siyi Yan
 * @version 2.0
 */
public class EmailSet {
	 //   public static String  addr = "2092693662@qq.com";
	    String To,w,h,m,addr;
	    Constant c;
	    int count=0;
	    JFrame manage;
     	JPanel jp; 
     	private JTextField mailtextField;
     	boolean choice; 
     	/**
    	 * Launch the application.
    	 */
    	/*public static void main(String[] args) {
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    			//		EmailSet window = new EmailSet();
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	}*/
	 public void initial() throws Exception {
		    To="2683430727@qq.com";
	     	c = new Constant();
	     	addr = c.getManagerEmail();
	        String time=c.getAutoEmailTime();
			String t[]=time.split(" ");
	        w=t[5];
		    h=t[2];
		    m=t[1];
	 }
	/**
	 * Create the panel to display pie chart.
	 * @param tt
	 * @param sched
	 * @throws Exception
	 * @throws SchedulerException
	 */
	public EmailSet(TimeTrigger tt,Scheduler sched) throws Exception,SchedulerException {
		initial();
		manage = new JFrame();
		jp=new JPanel();
		Chart_Generater.generate();
		Chart_Getter getter = new Chart_Getter(); 
		manage.setVisible(true);
		//frmManageYourRestaurant.getContentPane().setBackground();
		manage.setTitle("Manage your restaurant");
		manage.setBounds(100, 100, 1013, 650);
		manage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manage.getContentPane().setLayout(null);
		manage.getContentPane().add(jp);
		jp.setBounds(0, 0, 1000,700);
		choice= tt.getAutoEmail();
		    jp.setBackground(new Color(240, 240, 240));
		    jp.setLayout(null);
	        JLabel lblNewLabel = new JLabel("Totoro Ramen");
	        lblNewLabel.setForeground(new Color(255, 153, 0));
	        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 45));
	        lblNewLabel.setBounds(300, 0, 371, 64);
	        jp.add(lblNewLabel);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(255, 204, 102));
	        panel_1.setBounds(0, 64, 993, 64);
	        jp.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel(">Email Set");
	        lblNewLabel_1.setForeground(new Color(255, 153, 0));
	        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
	        lblNewLabel_1.setBounds(24, 13, 200, 38);
	        panel_1.add(lblNewLabel_1);
	        
	        JButton btnNewButton = new JButton("Save");
	        
	        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        btnNewButton.setBounds(777, 511, 135, 41);
	        jp.add(btnNewButton);
	        
	        JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		ChoicePanel window = new ChoicePanel(tt,sched);
					manage.setVisible(false);
	        	}
	        });
	        btnBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        btnBack.setBounds(60, 511, 135, 41);
	        jp.add(btnBack);
	        
	        JLabel lblNewLabel_2 = new JLabel("*Email Address");
	        lblNewLabel_2.setForeground(Color.RED);
	        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
	        lblNewLabel_2.setBounds(52, 171, 241, 52);
	        jp.add(lblNewLabel_2);
	        
	        mailtextField = new JTextField();
	        mailtextField.setBounds(79, 247, 251, 52);
	        mailtextField.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
	        jp.add(mailtextField);
	        mailtextField.setColumns(10);
	        mailtextField.setText(c.getManagerEmail());
	        JLabel lblNewLabel_2_1 = new JLabel("*Auto Seding");
	        lblNewLabel_2_1.setForeground(Color.RED);
	        lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
	        lblNewLabel_2_1.setBounds(443, 212, 241, 52);
	        jp.add(lblNewLabel_2_1);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 153, 0));
	        panel.setBounds(674, 182, 271, 94);
	        jp.add(panel);
	        panel.setLayout(null);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBounds(14, 13, 243, 68);
	        panel.add(panel_2);
	        panel_2.setLayout(null);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBackground(new Color(255, 153, 0));
	        panel_3.setBounds(117, 0, 10, 68);
	        panel_2.add(panel_3);
	        
	        JButton btnNewButton_1 = new JButton("Yes");
	        
	        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
	        btnNewButton_1.setBounds(0, 0, 119, 68);
	        panel_2.add(btnNewButton_1);
	        
	        JButton btnNewButton_1_1 = new JButton("No");
	        btnNewButton_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
	        btnNewButton_1_1.setBounds(125, 0, 119, 68);
	        panel_2.add(btnNewButton_1_1);
	        
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBounds(443, 313, 518, 189);
	        jp.add(panel_4);
	        panel_4.setLayout(null);
	        if(choice==true) {
	        	btnNewButton_1.setForeground(Color.RED);
        		btnNewButton_1_1.setForeground(Color.BLACK);
        		panel_4.setVisible(true);
	        }
	        else {
	        	btnNewButton_1_1.setForeground(Color.RED);
        		btnNewButton_1.setForeground(Color.BLACK);
        		panel_4.setVisible(false);
	        }
	        
	        JLabel lblNewLabel_2_1_1 = new JLabel("*Set time");
	        lblNewLabel_2_1_1.setForeground(Color.RED);
	        lblNewLabel_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
	        lblNewLabel_2_1_1.setBounds(14, 13, 241, 52);
	        panel_4.add(lblNewLabel_2_1_1);
	        
	        JLabel lblNewLabel_3 = new JLabel("Weekday");
	        lblNewLabel_3.setForeground(new Color(255, 153, 0));
	        lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	        lblNewLabel_3.setBounds(14, 77, 138, 33);
	        panel_4.add(lblNewLabel_3);
	        
	        JLabel lblNewLabel_3_1 = new JLabel("Minute");
	        lblNewLabel_3_1.setForeground(new Color(255, 153, 0));
	        lblNewLabel_3_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	        lblNewLabel_3_1.setBounds(393, 77, 138, 33);
	        panel_4.add(lblNewLabel_3_1);
	        
	        JLabel lblNewLabel_3_2 = new JLabel("Hour");
	        lblNewLabel_3_2.setForeground(new Color(255, 153, 0));
	        lblNewLabel_3_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	        lblNewLabel_3_2.setBounds(222, 78, 138, 33);
	        panel_4.add(lblNewLabel_3_2);
	        HashMap<String, String> time = tt.gettime();
	      
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(14, 123, 96, 33);
	        comboBox.addItem("Monday");
	        comboBox.addItem("Tuesday");
	        comboBox.addItem("Wednesday");
	        comboBox.addItem("Thursday");
	        comboBox.addItem("Friday");
	        comboBox.addItem("Saturday");
	        comboBox.addItem("Sunday");
	        panel_4.add(comboBox);
	        if(w.equals("MON")) {
	        	comboBox.setSelectedIndex(0);
	        }
	        else if(w.equals("TUE")) {
	        	comboBox.setSelectedIndex(1);
	        }
	        else if(w.equals("WED")) {
	        	comboBox.setSelectedIndex(2);
	        }
	        else if(w.equals("THU")) {
	        	comboBox.setSelectedIndex(3);
	        }
	        else if(w.equals("FRI")) {
	        	comboBox.setSelectedIndex(4);
	        }
	        else if(w.equals("SAT")) {
	        	comboBox.setSelectedIndex(5);
	        }
	        else if(w.equals("SUN")) {
	        	comboBox.setSelectedIndex(6);
	        }
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setBounds(202, 123, 96, 33);
	        for(int i=0;i<24;i++) {
	        	comboBox_1.addItem(String.valueOf(i));
	        }
	        comboBox_1.setSelectedIndex(Integer.valueOf(h));
	        panel_4.add(comboBox_1);
	        
	        JComboBox comboBox_2 = new JComboBox();
	        for(int i=0;i<60;i++) {
	        	comboBox_2.addItem(String.valueOf(i));
	        }
	        comboBox_2.setBounds(379, 123, 96, 33);
	        panel_4.add(comboBox_2);
	        comboBox_2.setSelectedIndex(Integer.valueOf(m));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		count=0;
	        		for(int i=0;i<mailtextField.getText().length();i++) {
						if(mailtextField.getText().charAt(i)=='@') {
							count++;
						}
					}
	        		if(count!=0) {
	        		tt.setAutoEmail(choice);
	        		if(addr.equals(mailtextField.getText())==false){ //change mail addr
	        			try {
							c.setManagerEmail(mailtextField.getText());  //set mail addr
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
	        			
	        			try {
							tt.cancel(sched);  //cancel the old one
						} catch (SchedulerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			if(choice==true) {
	        				Scheduler schednew = null;
							try {
								schednew = tt.run(mailtextField.getText()); //new one
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	        		String s=String.valueOf(comboBox.getSelectedItem());
	    	        		String s1 = String.valueOf(comboBox_1.getSelectedItem());
	    	        		String s2=String.valueOf(comboBox_2.getSelectedItem());
	    	        		s=s.substring(0, 3).toUpperCase();
	    	        		try {
	    						tt.change(s,s1,s2, schednew, mailtextField.getText());
	    	        	    	c.setAutoEmailTime("0"+" "+s2+" "+s1+" ? * "+s);
	    					} catch (Exception e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					}}
	        			else {
	        				String s=String.valueOf(comboBox.getSelectedItem());
	    	        		String s1 = String.valueOf(comboBox_1.getSelectedItem());
	    	        		String s2=String.valueOf(comboBox_2.getSelectedItem());
	    	        		s=s.substring(0, 3).toUpperCase();
	    	        		try {
	    					//	tt.changetime(s,s1,s2, sched, To);
	    	        	    	c.setAutoEmailTime("0"+" "+s2+" "+s1+" ? * "+s);
	    					} catch (Exception e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					}
	        			}
	        		}
	        		else {  //addr not change
	        			if(choice==true) {  
	    	        		String s=String.valueOf(comboBox.getSelectedItem());
	    	        		String s1 = String.valueOf(comboBox_1.getSelectedItem());
	    	        		String s2=String.valueOf(comboBox_2.getSelectedItem());
	    	        		s=s.substring(0, 3).toUpperCase();
	    	        		try {
	    						tt.change(s,s1,s2, sched, mailtextField.getText());
	    	        	    	c.setAutoEmailTime("0"+" "+s2+" "+s1+" ? * "+s);
	    					} catch (Exception e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					}}
	    	        		else {
	    	        		try {
	    						tt.cancel(sched);
	    					} catch (SchedulerException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}
	    	        		String s=String.valueOf(comboBox.getSelectedItem());
	    	        		String s1 = String.valueOf(comboBox_1.getSelectedItem());
	    	        		String s2=String.valueOf(comboBox_2.getSelectedItem());
	    	        		s=s.substring(0, 3).toUpperCase();
	    	        		try {
	    	        	    	c.setAutoEmailTime("0"+" "+s2+" "+s1+" ? * "+s);
	    					} catch (Exception e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					}
	    	        		}
	        			
	        			}
	        		
	        		manage.setVisible(false);
	        		ChoicePanel c = new ChoicePanel(tt,sched);
	        	}
	        		else {
	        		WrongFormat w= new WrongFormat();
	        	}}
	        	
	        });
	        btnNewButton_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		btnNewButton_1_1.setForeground(Color.RED);
	        		btnNewButton_1.setForeground(Color.BLACK);
	        		choice=false;
	        		 panel_4.setVisible(choice);
	        		
	        	}
	        });
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnNewButton_1.setForeground(Color.RED);
	        		btnNewButton_1_1.setForeground(Color.BLACK);
	        		choice=true;
	        		 panel_4.setVisible(choice);
	        	}
	        });
	     
	}
}
