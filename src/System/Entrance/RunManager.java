package System.Entrance;

import java.awt.EventQueue;

import org.quartz.Scheduler;

import System.Control.TimeTrigger;
import System.Data.Constant;
import System.GUI.Management;


public class RunManager {
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String To= Constant.getManagerEmail();
		//Start time trigger
		TimeTrigger tt = new TimeTrigger();
		Scheduler sched = tt.run(To);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management window = new Management(tt,sched);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
