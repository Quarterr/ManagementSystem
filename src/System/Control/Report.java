package System.Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import System.Data.BM;
import System.Data.Report_Reader;
import System.Data.Report_Storer;
import System.Entity.Entity_Report;
import java.util.Map.Entry;

/**
 * The functions of generating report.
 * @author Jing Hu
 * @version 1.2
 */
public class Report {
	/**
	 * Generate email content for report.
	 * @return content
	 */
	public static ArrayList<String> EmailFormat() {
		Entity_Report repo = new Entity_Report();
		Report_Storer.csvforstatistic(repo.getrepoDate());
	  	repo=Report_Reader.creatRepo();
		ArrayList<String> content=new ArrayList<>();
		StringBuffer c = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date sd=BM.getLastWeekMonday(repo.getrepoDate());
		Date ed=BM.getLastWeekSunday(repo.getrepoDate());
		String date=sdf.format(sd)+"--"+sdf.format(ed);
		c.append("<br>------------Report-------------<br>");
		c.append("Date: "+date+"<br>");
		c.append("Order: "+repo.getn_Order()+"<br>");
		c.append("------------Add on-------------<br>");
		c.append("Nori: "+repo.getn_Nori()+"<br>");
		c.append("Chashu: "+repo.getn_Chashu()+"<br>");
		c.append("Egg: "+repo.getn_Egg()+"<br>");
		c.append("Bamboo: "+repo.getn_Bamboo()+"<br>");
		content.add(c.toString());	// the bar chart of add on will be after content[0]
		c.setLength(0);
		c.append("<br>-------------Soup--------------<br>");
		Set<Entry<String,Integer>> e = repo.getSoup().entrySet();
		Iterator<Entry<String, Integer>> it = e.iterator();
		while(it.hasNext()){
		  Entry<String, Integer> entry = it.next();
		  String type = entry.getKey();
		  int number = entry.getValue();
		  c.append(type+": "+number+"<br>");
		  }
		content.add(c.toString());	// pie chart of Soup will be add at here
		c.setLength(0);
		c.append("<br>-------------Noodle------------<br>");
		e = repo.getNoodle().entrySet();
		it = e.iterator();
		while(it.hasNext()){
			Entry<String, Integer> entry = it.next();
			String type = entry.getKey();
			int number = entry.getValue();
			c.append(type+": "+number+"<br>");
		}
		content.add(c.toString());	// pie chart of Noodle will be add at here
		c.setLength(0);
		c.append("<br>---------Spring Onion----------<br>");
		e = repo.getOnion().entrySet();
		it = e.iterator();
		while(it.hasNext()){
			Entry<String, Integer> entry = it.next();
			String type = entry.getKey();
			int number = entry.getValue();
			c.append(type+": "+number+"<br>");
		}
		content.add(c.toString());	// pie chart of Spring Onion will be add at here
		c.setLength(0);
		c.append("<br>-----------Spiciness-----------<br>");
		e = repo.getSpiciness().entrySet();
		it = e.iterator();
		while(it.hasNext()){
			Entry<String, Integer> entry = it.next();
			String type = entry.getKey();
			int number = entry.getValue();
			c.append(type+": "+number+"<br>");
		}
		content.add(c.toString());	// pie chart of Spiciness will be add at here
		c.setLength(0);
		return content;
	}
}
