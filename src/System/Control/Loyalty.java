package System.Control;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import System.Data.Loyalty_Reader;
import System.Entity.Entity_Loyalty;

/**
 * Read Loyalty info.
 * @author Jing Hu
 * @version 1.1
 *
 */
public class Loyalty{
	
	/**
	 * Generate the email content for stamp changes.
	 * @param L_ID
	 * @return content
	 */
	public static StringBuffer EmailFormat(String L_ID) {
		StringBuffer content = new StringBuffer();
		Entity_Loyalty profile = new Entity_Loyalty();
		profile=Loyalty_Reader.personalInfo(L_ID);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-d-hh-mm",Locale.ENGLISH);
		String[] date=sdf.format(new Date()).split("-");
		String time=date[3]+":"+date[4];
		
		String day=null;
		if(date[2].endsWith("1") && !date[2].endsWith("11")){
			day=date[0]+" "+date[1]+" "+date[2]+"st";
        }else if(date[2].endsWith("2") && !date[2].endsWith("12")){
        	day=date[0]+" "+date[1]+" "+date[2]+"nd";
        }else if(date[2].endsWith("3") && !date[2].endsWith("13")){
        	day=date[0]+" "+date[1]+" "+date[2]+"rd";
        }else{ 
        	day=date[0]+" "+date[1]+" "+date[2]+"th";
        }
		
		content.append("<br>------------Consumption Reminder-------------<br>");
		content.append("Dear "+profile.getFname()+" "+profile.getSname()+":  <br>");
		content.append("You have one consumption record at "+time+" on "+day+". Your stamp number has changed.You now have "+profile.getStamp()+" stamps.<br>");
		content.append("Please confirm your ID : "+ profile.getLID()+"<br>");
		content.append("Hope to see you again!<br>");
		content.append("TOTORA RAMEN");
		content.append("<br>-----------------------------------------------------------<br>");
		//System.out.println(content);
		
		return content;
	}
	
	
	/**
	 * Clear Loyalty entity.
	 * @param profile
	 */
	public static void clearprofile(Entity_Loyalty profile) {
		profile.setFname(null);
		profile.setSname(null);
		profile.setEmail(null);
		profile.setPhone(null);
		profile.setStamp(0);
	}
}

