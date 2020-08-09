package Test;

import javax.swing.JFrame;

import org.quartz.Scheduler;

import System.Control.SendMail;
import System.Control.TimeTrigger;

/**
 * Test class for sending Email
 * Remember not to test too frequently, the QQ Email might block the account for few hours 
 * @author Jing Hu
 * @version 1.2
 */
public class AutoEmailForReport_Test {
	
	
	public static void main(String[] args) throws Exception {
		String Repo_To="2683430727@qq.com";
		TimeTrigger Auto = new TimeTrigger();
		Auto.run(Repo_To);	
	}
}
