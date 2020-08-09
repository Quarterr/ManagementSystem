package System.Entrance;

import java.awt.EventQueue;

import System.GUI.RamenSelection;


public class RunCustomer {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RamenSelection window = new RamenSelection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
