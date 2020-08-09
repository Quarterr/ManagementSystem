package TDD;
import java.util.ArrayList;

import org.quartz.Scheduler;

import System.Control.Loyalty;
import System.Control.Report;
import System.Control.SendMail;
import System.Control.TimeTrigger;
import System.Data.Chart_Generater;
import System.Data.Loyalty_Reader;
import System.Data.Menu_Reader;
import System.Data.Report_Reader;
import System.Data.Report_Storer;
import System.Entity.Entity_Loyalty;
import System.Entity.Entity_Menu;
import System.Entity.Entity_Report;

import org.junit.jupiter.api.Test;
/**
 * Test functions related to report.
 * @author Jing Hu
 */
class Report_Test {
	/**
	 * Test function Generate Report.csv from Order.csv which contain the order use for generating report. 
	 */
	@Test
	void GenerateReportFile() {
		Entity_Report repo = new Entity_Report();
		Report_Storer.csvforstatistic(repo.getrepoDate());
	}
	
	/**
	 * Test function creatRepo put the info read from Report.csv into an entity 
	 */
	@Test
	void ReadReportFile() {
		
		  Entity_Report repo = new Entity_Report();
		  Report_Storer.csvforstatistic(repo.getrepoDate());
		  repo=Report_Reader.creatRepo();
		  
	}
	/**
	 * Test function EmailContent which put the info store in Report entity into the format convenient to Send Email
	 */
	@Test
	void EmailReportContent() {
		String content=Report.EmailFormat().toString();
		System.out.println(content); 
	}
}
