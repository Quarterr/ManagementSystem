package System.GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import System.Entity.Entity_Ticket;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Finishing ordering the dishes.
 * @author Siyi Yan
 * @version 1.0
 */
public class Finish {

	private JFrame frmWelcomeToRamen;




	/**
	 * Create the application.
	 * @param t
	 */
	public Finish(Entity_Ticket t) {
		initialize(t);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param t
	 */
	private void initialize(Entity_Ticket t) {
		frmWelcomeToRamen = new JFrame();
		frmWelcomeToRamen.setVisible(true);
		frmWelcomeToRamen.getContentPane().setBackground(new Color(255, 255, 255));
		frmWelcomeToRamen.setTitle("Welcome to Ramen Restaurant");
		frmWelcomeToRamen.setBounds(0, 0, 460, 650);
		frmWelcomeToRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToRamen.getContentPane().setLayout(null);
		
		JPanel panelFinish = new JPanel();
		panelFinish.setBackground(new Color(255, 255, 240));
		panelFinish.setBounds(0, 0, 446, 603);
		frmWelcomeToRamen.getContentPane().add(panelFinish);
		panelFinish.setLayout(null);
		
		JLabel labelFinish = new JLabel("Your Ramen is being made!");
		labelFinish.setHorizontalAlignment(SwingConstants.CENTER);
		labelFinish.setForeground(new Color(255, 153, 0));
		labelFinish.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		labelFinish.setBounds(0, 304, 446, 63);
		panelFinish.add( labelFinish);
		
		JLabel lblTototalRamen = new JLabel("TOTORO    RAMEN");
		lblTototalRamen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTototalRamen.setForeground(new Color(255, 140, 0));
		lblTototalRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblTototalRamen.setBackground(Color.WHITE);
		lblTototalRamen.setBounds(0, 0, 446, 48);
		panelFinish.add(lblTototalRamen);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 239, 213));
		panel_2.setBounds(0, 60, 446, 46);
		panelFinish.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbldiningOption = new JLabel(">Finish");
		lbldiningOption.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
		lbldiningOption.setForeground(new Color(255, 140, 0));
		lbldiningOption.setBounds(14, 0, 152, 46);
		panel_2.add(lbldiningOption);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 56, 446, 5);
		panelFinish.add(panel);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmWelcomeToRamen.setVisible(false);
				RamenSelection window = new RamenSelection();
			}
		});
		exit.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		exit.setBounds(155, 547, 126, 46);
		panelFinish.add(exit);
		
		JLabel lblNewLabel = new JLabel("\uFFE1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 47));
		lblNewLabel.setBounds(81, 179, 93, 78);
		panelFinish.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 47));
		lblNewLabel_1.setText(String.valueOf(t.getTotalPrice()));
		lblNewLabel_1.setBounds(130, 180, 246, 78);
		panelFinish.add(lblNewLabel_1);
	}
}
