package System.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Interface indicating modify price successfully.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class ModifySuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifySuccess frame = new ModifySuccess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ModifySuccess() {
		//setType(Type.UTILITY);
		setTitle("Welcome to Ramen Restaurant!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblTotoralRemen = new JLabel("TOTORO   REMEN");
		lblTotoralRemen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblTotoralRemen.setForeground(new Color(255, 140, 0));
		lblTotoralRemen.setBounds(79, 0, 243, 33);
		contentPane.add(lblTotoralRemen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 35, 432, 4);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(0, 46, 432, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblpayment = new JLabel(">Modify Menu");
		lblpayment.setForeground(new Color(255, 150, 0));
		lblpayment.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblpayment.setBounds(14, 0, 120, 31);
		panel_1.add(lblpayment);
		
		JLabel lblYouHaveModified = new JLabel("You have modified the ");
		lblYouHaveModified.setForeground(new Color(165, 42, 42));
		lblYouHaveModified.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblYouHaveModified.setBounds(18, 92, 304, 61);
		contentPane.add(lblYouHaveModified);
		
		JLabel lblMenuSuccessfully = new JLabel("menu successfully");
		lblMenuSuccessfully.setForeground(new Color(165, 42, 42));
		lblMenuSuccessfully.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblMenuSuccessfully.setBounds(148, 144, 234, 43);
		contentPane.add(lblMenuSuccessfully);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 140, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		btnBack.setBounds(148, 216, 113, 27);
	    btnBack.setBackground(new Color(255, 235, 205));
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Management d=new Management();
				dispose();
			}
		});
		
	}
}
