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
import javax.swing.border.EmptyBorder;

/**
 * Interface showing a error.
 * @author Mengmeng Ai
 * @version 1.0
 */

public class NotChooseEatWay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotChooseEatWay frame = new NotChooseEatWay();
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
	public NotChooseEatWay() {
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
		
		JLabel lblpayment = new JLabel(">Dining Option");
		lblpayment.setForeground(new Color(255, 140, 0));
		lblpayment.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblpayment.setBounds(14, 0, 150, 31);
		panel_1.add(lblpayment);
		
		JLabel lblYouHaveModified = new JLabel("Please choose Eat-in/Take-away !");
		lblYouHaveModified.setForeground(new Color(165, 42, 42));
		lblYouHaveModified.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblYouHaveModified.setBounds(10, 106, 403, 61);
		contentPane.add(lblYouHaveModified);
		
		JButton btnBack = new JButton("OK");
		btnBack.setForeground(new Color(255, 140, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		btnBack.setBounds(148, 216, 113, 27);
	    btnBack.setBackground(new Color(255, 235, 205));
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
