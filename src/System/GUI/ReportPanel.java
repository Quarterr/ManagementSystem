package System.GUI;
import javax.swing.JPanel;
import java.awt.Font;   
import org.jfree.chart.ChartPanel;
import org.quartz.Scheduler;

import System.Control.TimeTrigger;
import System.Data.Chart_Generater;
import System.Data.Chart_Getter;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  


/**
 * This class provide the interface that the manager can check the pie chart of each item.
 * @author Siyi Yan, Xinyu Li
 * @version 2.0
 */
public class ReportPanel {
	
     	JFrame manage;
     	JPanel jp; 
     	
     	/**
    	 * Launch the application.
    	 */
    	/*public static void main(String[] args) {
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					ReportPanel window = new ReportPanel();
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	}*/
	 
	 /**
	  * Create the panel to display pie chart.
	  * @param tt
	  * @param sched
	  */
	public ReportPanel(TimeTrigger tt, Scheduler sched) {
		manage = new JFrame();
        JPanel panel = new JPanel();
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
	        
	        JLabel lblNewLabel_1 = new JLabel(">Report-Chart");
	        lblNewLabel_1.setForeground(new Color(255, 153, 0));
	        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
	        lblNewLabel_1.setBounds(24, 13, 200, 38);
	        panel_1.add(lblNewLabel_1);
	        
	        JButton btnNewButton = new JButton("Back");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		ChoicePanel window = new ChoicePanel(tt,sched);
					manage.setVisible(false);
	        	}
	        });
	        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        btnNewButton.setBounds(777, 511, 135, 41);
	        jp.add(btnNewButton);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBackground(new Color(255, 153, 0));
	        panel_2.setBounds(43, 177, 182, 334);
	        jp.add(panel_2);
	        panel_2.setLayout(null);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBounds(14, 13, 154, 309);
	        panel_2.add(panel_3);
	        panel_3.setLayout(null);
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBackground(new Color(255, 153, 0));
	        panel_4.setBounds(0, 55, 154, 10);
	        panel_3.add(panel_4);
	        
	        JPanel panel_4_1 = new JPanel();
	        panel_4_1.setBackground(new Color(255, 153, 0));
	        panel_4_1.setBounds(0, 118, 154, 10);
	        panel_3.add(panel_4_1);
	        
	        JPanel panel_4_2 = new JPanel();
	        panel_4_2.setBackground(new Color(255, 153, 0));
	        panel_4_2.setBounds(0, 183, 154, 10);
	        panel_3.add(panel_4_2);
	        
	        JPanel panel_4_3 = new JPanel();
	        panel_4_3.setBackground(new Color(255, 153, 0));
	        panel_4_3.setBounds(0, 246, 154, 10);
	        panel_3.add(panel_4_3);
	        
	        JButton soup = new JButton("Soup");
	        JButton noodle = new JButton("Noodle");
	        JButton Spring = new JButton("Spring Onion");
	        JButton Add = new JButton("Add-on");
	        JButton Spicy = new JButton("Spiciness");
	        
	        soup.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		soup.setForeground(Color.RED);
	        		noodle.setForeground(Color.BLACK);
	        		Spring.setForeground(Color.BLACK);
	        		Add.setForeground(Color.BLACK);
	        		Spicy.setForeground(Color.BLACK);
	        		ChartPanel panel =  new ChartPanel(getter.getpie("Soup")); 
	                panel.setBounds(300, 152, 612, 346);
	                jp.add(panel);
	    	        panel.setBackground(Color.WHITE);
	    	         panel.setVisible(true);
	        	}
	        });
	        soup.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        soup.setBounds(0, 0, 154, 56);
	        panel_3.add(soup);
	        
	       
	        noodle.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		noodle.setForeground(Color.RED);
	        		soup.setForeground(Color.BLACK);
	        		Spring.setForeground(Color.BLACK);
	        		Add.setForeground(Color.BLACK);
	        		Spicy.setForeground(Color.BLACK);
	        		ChartPanel panel =  new ChartPanel(getter.getpie("Noodle")); 
	    	        panel.setBounds(300, 152, 612, 346);
	    	        jp.add(panel);
	    	        panel.setBackground(Color.WHITE);
	    	         panel.setVisible(true);
	        	}
	        });
	        noodle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        noodle.setBounds(0, 63, 154, 56);
	        panel_3.add(noodle);
	        
	       
	        Spring.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		Spring.setForeground(Color.RED);
	        		soup.setForeground(Color.BLACK);
	        		noodle.setForeground(Color.BLACK);
	        		Add.setForeground(Color.BLACK);
	        		Spicy.setForeground(Color.BLACK);
	        		ChartPanel panel =  new ChartPanel(getter.getpie("Spring")); 
	    	        panel.setBounds(300, 152, 612, 346);
	    	        jp.add(panel);
	    	        panel.setBackground(Color.WHITE);
	    	         panel.setVisible(true);
	        	}
	        });
	        Spring.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
	        Spring.setBounds(0, 128, 154, 56);
	        panel_3.add(Spring);
	        
	        
	        Add.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		Add.setForeground(Color.RED);
	        		soup.setForeground(Color.BLACK);
	        		noodle.setForeground(Color.BLACK);
	        		Spring.setForeground(Color.BLACK);
	        		Spicy.setForeground(Color.BLACK);
	        		ChartPanel panel =  new ChartPanel(getter.getbar()); 
	    	        panel.setBounds(300, 152, 612, 346);
	    	        jp.add(panel);
	    	        panel.setBackground(Color.WHITE);
	    	        panel.setVisible(true);
	        	}
	        });
	        Add.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        Add.setBounds(0, 191, 154, 56);
	        panel_3.add(Add);
	        
	        Spicy.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		panel.setVisible(false);
	        		Spicy.setForeground(Color.RED);
	        		soup.setForeground(Color.BLACK);
	        		noodle.setForeground(Color.BLACK);
	        		Spring.setForeground(Color.BLACK);
	        		Add.setForeground(Color.BLACK);
	        		ChartPanel panel =  new ChartPanel(getter.getpie("spi")); 
	    	        panel.setBounds(300, 152, 612, 346);
	    	        jp.add(panel);
	    	        panel.setBackground(Color.WHITE);
	    	         panel.setVisible(true);
	        		
	        	}
	        });
	        Spicy.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	        Spicy.setBounds(0, 255, 154, 56);
	        panel_3.add(Spicy);
	        
	        
	        panel.setBackground(new Color(255, 153, 0));
	        panel.setBounds(359, 177, 593, 299);
	        jp.add(panel);
	        panel.setLayout(null);
	        
	        JPanel panel_5 = new JPanel();
	        panel_5.setBounds(14, 13, 565, 273);
	        panel.add(panel_5);
	        panel_5.setLayout(null);
	        
	        JLabel lblNewLabel_2 = new JLabel("Please click the button on the left");
	        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        lblNewLabel_2.setBounds(14, 60, 511, 55);
	        panel_5.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_3 = new JLabel("to view the pie chart");
	        lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
	        lblNewLabel_3.setBounds(14, 135, 293, 45);
	        panel_5.add(lblNewLabel_3);
	       
	}
}
