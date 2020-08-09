package System.Data;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jing Hu, TingXuan Zhang, Xinyu Li
 * @version 2.0
 */
public class BM {
	/**
	 * Get the line number of csv file.
	 * @param filename
	 * @return cnt
	 * @throws IOException
	 */
	public static int countLines(String filename) throws IOException {    
	    LineNumberReader reader  = new LineNumberReader(new FileReader(filename));    
	    int cnt = 0;    
	    while ((reader.readLine()) != null) {}    
	    cnt = reader.getLineNumber();     
	    reader.close();    
	    return cnt;    
	}    
	/**
	 * Clear the content of relevant file.
	 * @param fileName
	 */
	public static void clearInfoForFile(String fileName) {//delete the content of the previous file
		File file =new File(fileName);
		try {
			if(!file.exists())
				file.createNewFile();
		    FileWriter fileWriter =new FileWriter(file);
		    fileWriter.write("");
		    fileWriter.flush();
		    fileWriter.close();
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	/**
	 * Compare whether the date is in the last week, week begin from Monday.
	 * @param repoDate the time to generate the report usually is the current time
	 * @param checkDate the time read from file which you want to check whether is in the range
	 * @return result
	 */
	public static boolean compareDate(Date repoDate,String checkDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date eDate= getLastWeekSunday(repoDate);
		Date sDate= getLastWeekSunday(eDate);
		//System.out.println(checkDate);
		//System.out.println(sDate);
		//System.out.println(eDate);
		boolean result=false;
		Date d;
		try {
			d = sdf.parse(checkDate);
			//System.out.println(d);
			if(d.after(sDate)==true&&d.before(eDate)==true) {
				result=true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Get the date of last Sunday
	 * @param date
	 * @return cal.getTime()
	 */
	public static Date getLastWeekMonday(Date date) {   
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day-7);
		return cal.getTime();

   }
	/**
	 * Get the date of last Sunday
	 * @param date
	 * @return cal.getTime()
	 */
	public static Date getLastWeekSunday(Date date) {    
		if(date == null)  
        {  
            throw new IllegalArgumentException("The date must not be null");  
        } else  
        {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(5, -1);  
            Date a = c.getTime();
            Calendar cal = Calendar.getInstance();    
            cal.setTime(a);    
            cal.set(Calendar.DAY_OF_WEEK, 1);     
            return cal.getTime(); 
        }          
   }
}
