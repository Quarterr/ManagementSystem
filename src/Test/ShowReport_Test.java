package Test;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import System.Data.Report_Reader;
import System.Data.Report_Storer;
import System.Entity.Entity_Report;

/**
 * @author Jing Hu
 * @version 1.0
 */
public class ShowReport_Test {
	public static void main(String[] args) {
		
		  //Test function creatRepo 
		  Entity_Report repo = new Entity_Report();
		  Report_Storer.csvforstatistic(repo.getrepoDate());
		  repo=Report_Reader.creatRepo();
		  System.out.println("Date: "+repo.getrepoDate());
		  System.out.println("Order: "+repo.getn_Order());
		  System.out.println("-----------Add-on------------");
		  System.out.println("Nori: "+repo.getn_Nori());
		  System.out.println("Chashu: "+repo.getn_Chashu());
		  System.out.println("Egg: "+repo.getn_Egg());
		  System.out.println("Bamboo: "+repo.getn_Bamboo());
		  System.out.println("-----------Soup------------");
		  Set<Entry<String,Integer>> e = repo.getSoup().entrySet();
		  Iterator<Entry<String, Integer>> it = e.iterator();
		  while(it.hasNext()){
			  Entry<String, Integer> entry = it.next();
			  String type = entry.getKey();
			  int number = entry.getValue();
			  System.out.println(type+": "+number);
		  }
		  
		  System.out.println("-----------Noodle------------");
		  e = repo.getNoodle().entrySet();
		  it = e.iterator();
		  while(it.hasNext()){
			  Entry<String, Integer> entry = it.next();
			  String type = entry.getKey();
			  int number = entry.getValue();
			  System.out.println(type+": "+number);
		  }
		  
		  System.out.println("-----------Spring Onion------------");
		  e = repo.getOnion().entrySet();
		  it = e.iterator();
		  while(it.hasNext()){
			  Entry<String, Integer> entry = it.next();
			  String type = entry.getKey();
			  int number = entry.getValue();
			  System.out.println(type+": "+number);
		  }
		  
		  System.out.println("-----------Spiciness------------");
		  e = repo.getSpiciness().entrySet();
		  it = e.iterator();
		  while(it.hasNext()){
			  Entry<String, Integer> entry = it.next();
			  String type = entry.getKey();
			  int number = entry.getValue();
			  System.out.println(type+": "+number);
		  }
	}
}
