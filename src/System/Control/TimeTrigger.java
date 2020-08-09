package System.Control;
import java.util.ArrayList;
import java.util.HashMap;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Time trigger for generating report on every Monday.
 * @author Jing Hu
 * @version 1.1
 */
public class TimeTrigger {

	/**
	 * Put the order between sDate and eDate in a new file called report.csv .
	 * @param String to: the receiver Email address
	 */
	private static String time="0 0 0 ? * MON";
	private static JobKey key;
	private static boolean autoEmail = true;
	/**
	 * Choose automatically sent email or not.
	 * @param auto
	 */
	public void setAutoEmail(boolean auto) {
		autoEmail = auto;
	}
	/**
	 * Get whether to automatically send email.
	 * @return autoEmail
	 */
	public boolean getAutoEmail() {
		return autoEmail;
	}
	/**
	 * This method set the time of sending email.
	 * @param weekday
	 * @param h
	 * @param m
	 */
	public void settime(String weekday,String h,String m) {
		time="0"+" "+m+" "+h+" ? * "+weekday;
	}
	/**
	 * This method gets the time of sending an email.
	 * @return T
	 */
	public HashMap<String, String> gettime(){
		HashMap<String, String> T = new HashMap<>();
		String t[]=time.split(" ");
		T.put("minute", t[1]);
		T.put("hour", t[2]);
		T.put("weekday", t[5]);
		return T;
	}
	/**
	 * This method is related to the details of scheduler.
	 * @param To
	 * @return sched
	 * @throws Exception
	 */
	public Scheduler run(String To) throws Exception {	
		// First we must get a reference to a scheduler
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		// define the job and tie it to our HelloJob class
		JobDetail job = JobBuilder.newJob(SendMail.class)
	    				.usingJobData("To", To)	//receiver address in job data map use for passing parameter into execute function
	    				.withIdentity("job1", "group1")
	    				.build();
		
		key=job.getKey();
	    // Trigger the job to run on the next round minute
	    Trigger trigger = TriggerBuilder.newTrigger()
	    					.withIdentity("trigger1", "group1")
	    					.withSchedule(CronScheduleBuilder.cronSchedule(time))//Send every Monday at 7 o'clock
	    					.build();
	    sched.scheduleJob(job, trigger);
	    // scheduler has been started
	    System.out.println("Start...");
	    System.out.println("Current key: "+ sched.getJobDetail(key));
	    sched.start();
	    return sched;
	  }
	/**
	 * This method cancel the email sending of report.
	 * @param sched
	 * @throws SchedulerException
	 */
	public void cancel(Scheduler sched) throws SchedulerException {
		System.out.println("Precious key: "+ sched.getJobDetail(key));	
		sched.deleteJob(key);
		//System.out.println(sched.getJobDetail(key));
		System.out.println("Previous auto email sending is cancelled...");
	}
	/**
	 * This method changes time to send email or changes the receiver.
	 * @param weekday
	 * @param h
	 * @param m
	 * @param sched
	 * @param To
	 * @throws Exception
	 */
	public void change(String weekday,String h,String m,Scheduler sched,String To) throws Exception {
		this.cancel(sched);
		this.settime(weekday, h, m);
		run(To);
	}
}

	
	