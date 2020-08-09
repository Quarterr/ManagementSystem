package System.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Interface indicating the wrong format of price.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class PriceWrong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceWrong frame = new PriceWrong();
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
	public PriceWrong() {
		setTitle("warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setForeground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 432, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 13, 404, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLoyaltyIsNot = new JLabel("Please input a non-negative price!");
		lblLoyaltyIsNot.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblLoyaltyIsNot.setBounds(27, 45, 347, 38);
		panel_1.add(lblLoyaltyIsNot);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(139, 128, 113, 27);
		panel_1.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ModifyMenu d=new ModifyMenu();
				dispose();
			}
		});
	}

}
