package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.quartz.Scheduler;

import System.Control.SendMail;
import System.Control.TimeTrigger;
/**
 * Test the function of sending email.
 * @author Jing Hu
 * @version 1.0
 */
class Email_Test {
	String Repo_To="844702734@qq.com";
	String L_ID="17382901";
	/**
	 * Send Report Email by pressing the button
	 */
	@Test
	void Report_Button() {
		SendMail.sendRepo(Repo_To);
	}
	/**
	 * turn off automatically sending Report function 
	 */
	@Test
	void Report_CancelAuto() throws Exception {
		TimeTrigger Auto = new TimeTrigger();
		Scheduler sched=Auto.run(Repo_To);
		Auto.cancel(sched);
	}
	/**
	 * turn off automatically sending Report function 
	 */
	@Test
	void Report_ChangeTime() throws Exception {
		String w="THU";
		String h="23";
		String m="01";
		TimeTrigger Auto = new TimeTrigger();
		Scheduler sched=Auto.run(Repo_To);
		Auto.change(w, h, m, sched, Repo_To);
	}
	/**
	 * Send Loyalty Email by pressing the button
	 */
	@Test
	void Loyalty_Button() {
		SendMail.sendStampchange(L_ID);
	}

}
