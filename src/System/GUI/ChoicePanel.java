package System.GUI;

import javax.swing.JPanel;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import System.Control.TimeTrigger;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class enables the interface that the manager choose the choice.
 * @author Siyi Yan
 * @version 3.0
 */
public class ChoicePanel {
	private JFrame manage;
	private JPanel jp;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoicePanel window = new ChoicePanel();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the choice panel.
	 * @param tt
	 * @param sched
	 */
	public ChoicePanel(TimeTrigger tt, Scheduler sched) {
		manage = new JFrame();
		jp=new JPanel();
		manage.setVisible(true);
		//frmManageYourRestaurant.getContentPane().setBackground();
		manage.setTitle("Manage your restaurant");
		manage.setBounds(100, 100, 1013, 650);
		manage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manage.getContentPane().setLayout(null);
		manage.add(jp);
		jp.setBounds(0, 0, 1000,700);
		jp.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(146, 0, 655, 86);
		jp.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Totoro Ramen");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(181, 13, 333, 60);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(170, 99, 631, 450);
		jp.add(panel_2);
		
		JButton btnNewButton = new JButton("Modify menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyMenu window = new ModifyMenu(tt,sched);
				manage.setVisible(false);
				/*
				setVisible(false);
				jf=(JFrame)getRootPane().getParent(); //turn to the modify panel
				jp=new ModifyMenu();
				jp.setBounds(0, 0, 1000,700);
				jf.add(jp);
				*/
			}
		});
		btnNewButton.setForeground(new Color(255, 153, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		btnNewButton.setBounds(112, 47, 406, 81);
		panel_2.add(btnNewButton);
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.setForeground(new Color(255, 153, 0));
		btnGenerateReport.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		btnGenerateReport.setBounds(112, 194, 406, 81);
		panel_2.add(btnGenerateReport);
		
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	ReportPanel window = new ReportPanel();
				manage.setVisible(false);
				GeneralReport frame = new GeneralReport(tt,sched);
				frame.setVisible(true);
				/*
				jp.setVisible(false);
				jf=(JFrame)getRootPane().getParent(); //turn to the modify panel
				jp=new ReportPanel();
				jp.setBounds(0, 0, 1000,700);
				jf.add(jp);
				*/
			}
		});
		JButton btnNewButton_1_1 = new JButton("Email Set");
		btnNewButton_1_1.setForeground(new Color(255, 153, 0));
		btnNewButton_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		btnNewButton_1_1.setBounds(112, 330, 406, 81);
		panel_2.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage.setVisible(false);
				try {
					EmailSet frame = new EmailSet(tt,sched);
				} catch (SchedulerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
