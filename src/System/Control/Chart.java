package System.Control;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import System.Data.Report_Reader;
import System.Data.Report_Storer;
import System.Entity.Entity_Report;

/**
 * This class describes the function of getting the dataset for the charts.
 * @author Siyi Yan, Xinyu Li
 * @version 2.0
 */
public class Chart {
	/**
	 * Get the data from the background order file.
	 * @param s the type that manager want to check
	 * @return a DefaultPieDataset instance
	 */
	public static DefaultPieDataset getDataSet(String s) 
	{  
		  DefaultPieDataset dataset = new DefaultPieDataset();  
		  DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		  Entity_Report repo = new Entity_Report();
		  Report_Storer.csvforstatistic(repo.getrepoDate());
		  repo=Report_Reader.creatRepo();
		  Set<Entry<String,Integer>> e = repo.getSoup().entrySet();
		  Iterator<Entry<String, Integer>> it = e.iterator();
		  
		  if(s=="Spiciness") {  //choice of spiciness
		  e = repo.getSpiciness().entrySet();
		  it = e.iterator();
		  while(it.hasNext()){
			  Entry<String, Integer> entry = it.next();
			  String type = entry.getKey();
			  int number = entry.getValue();
			  dataset.setValue(type, number); 
			  }
		  }
		  if(s=="Soup") {  //choice of soup
			  while(it.hasNext()){
				  Entry<String, Integer> entry = it.next();
				  String type = entry.getKey();
				  int number = entry.getValue();
				  dataset.setValue(type, number); 
			  }
			  }
		  if(s=="Noodle") {  //choice of noodle
			  e = repo.getNoodle().entrySet();
			  it = e.iterator();
			  while(it.hasNext()){
				  Entry<String, Integer> entry = it.next();
				  String type = entry.getKey();
				  int number = entry.getValue();
				  dataset.setValue(type, number); 
			  }
		  }
		  if(s=="Spring") {  //choice of spring onion
			  e = repo.getOnion().entrySet();
			  it = e.iterator();
			  while(it.hasNext()){
				  Entry<String, Integer> entry = it.next();
				  String type = entry.getKey();
				  int number = entry.getValue();
				  dataset.setValue(type, number); 
			  }
		  }
		  
	      return dataset;  
	    }  
	/**
	 * Get the data from the background order file.
	 * @return a CategoryDataset instance
	 */
	public static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Entity_Report repo = new Entity_Report();
		Report_Storer.csvforstatistic(repo.getrepoDate());
		repo=Report_Reader.creatRepo();
		dataset.addValue(repo.getn_Bamboo(),"Bamboo","Bamboo");
		dataset.addValue(repo.getn_Chashu(),"Chashu","Chashu");
		dataset.addValue(repo.getn_Nori(),"Nori","Nori");
		dataset.addValue(repo.getn_Egg(),"Egg","Egg");
	 
		return dataset;
	}
		
}
