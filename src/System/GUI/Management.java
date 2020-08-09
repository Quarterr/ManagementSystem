package System.GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.quartz.Scheduler;

import System.Control.TimeTrigger;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class enables the interface that the manager can control the system.
 * @author Siyi Yan
 * @version 3.0
 */
public class Management {
    public JFrame manage ;
    JPanel panel = new JPanel();
	JPanel modi = new JPanel();
	JPanel choose = new JPanel();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management window = new Management();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @param tt
	 * @param sched
	 */
	public Management(TimeTrigger tt, Scheduler sched) {
		initialize(tt,sched);
	}
	/**
	 * Initialize the contents of the frame load the choice panel in the frame.
	 * @param tt
	 * @param sched
	 */
	private void initialize(TimeTrigger tt, Scheduler sched) {
		/*
		manage = new JFrame();
		manage.setVisible(true);
		//frmManageYourRestaurant.getContentPane().setBackground();
		manage.setTitle("Manage your restaurant");
		manage.setBounds(100, 100, 1013, 609);
		manage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manage.getContentPane().setLayout(null);
		
		panel=new ChoicePanel();
		panel.setBounds(0, 0, 1000,571);
		manage.getContentPane().add(panel);
		*/
		ChoicePanel window = new ChoicePanel(tt, sched);
		

	
		/*panel = new JPanel();
		panel.setBounds(0, 0, 655, 659);
		panel.setVisible(true);
		manage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 655, 86);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Totoral Ramen");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(181, 13, 333, 60);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 99, 631, 547);
		panel.add(panel_2);
		panel_2.setLayout(null);
		*/
		/*
		JButton btnNewButton = new JButton("Modify menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				panel.setVisible(false);
				modi=new modifyMenu();
				manage.add(modi);
				modi.setBounds(0, 0, 655,659);
				*/
//				manage.setVisible(false);
//				modifyNoodle window = new modifyNoodle();
	//		}
	//	});
		/*
		btnNewButton.setForeground(new Color(255, 153, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		btnNewButton.setBounds(112, 47, 406, 104);
		panel_2.add(btnNewButton);
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.setForeground(new Color(255, 153, 0));
		btnGenerateReport.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		btnGenerateReport.setBounds(112, 230, 406, 104);
		panel_2.add(btnGenerateReport);
		
		JButton btnNewButton_1_1 = new JButton("Modify personal information");
		btnNewButton_1_1.setForeground(new Color(255, 153, 0));
		btnNewButton_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1_1.setBounds(112, 404, 406, 104);
		panel_2.add(btnNewButton_1_1);
		*/
	}
}
