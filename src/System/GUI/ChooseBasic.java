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
import javax.swing.SwingConstants;

/**
 * This class is the interface for to tell user choose the basic part.
 * @author Siyi Yan
 * @version 1.0
 */
public class ChooseBasic extends RemindPanel {

	private JFrame frmRamenRestaurant;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseBasic window = new ChooseBasic();
				//	window.frmRamenRestaurant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ChooseBasic() {
		initialize("Please choose the basic  ","part!");
	}

}
