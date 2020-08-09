package System.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import System.Entity.Entity_Report;
/**
 * This class reads the content of report.csv file.
 * @author Jing Hu
 * @version 2.0
 */
public class Report_Reader {
	static HashMap<String, HashMap<String,Integer>> Required;
	static HashMap<String, Integer> Optional;
	static Entity_Report repo;		//store all info in the new csv
	static HashMap<String, Integer> RequiredCol;
	static HashMap<String, Integer> OptionalCol;
	static String RequiredHead[]= {"Soup","Noodle","Spring onion","Spiciness"};
	/**
	 * Create report.
	 * @return repo
	 */
	public static Entity_Report creatRepo() {
		String line = null;
		int col=0;	// store number of Attributes(column)
		initHeadCol();
		initRequired();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/report.csv"));
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//store each header in array list head[]
			col=head.length; 	// get the column number of the csv file

			for(int c=0; c<col; c++) {
				if(Arrays.asList(RequiredHead).contains(head[c])) {
					RequiredCol.put(head[c], c);	
				}
				else
					OptionalCol.put(head[c], c);
			}
			boolean get=false;
			initOptional();
			while(((line = reader.readLine()) != null)&&get==false){
				String item[] = line.split(",");
				for(String r :Required.keySet()) {
					if (Required.get(r).containsKey(item[RequiredCol.get(r)])){ 	//contains this type
						Required.get(r).put(item[RequiredCol.get(r)],Required.get(r).get(item[RequiredCol.get(r)])+1); 	//add 1 in this type
		            }else {
		            	Required.get(r).put(item[RequiredCol.get(r)],1);	//find a new type
		            }
				}
				
				Set<String> op=OptionalCol.keySet();
				for (String str : op) {
					Optional.put(str,Optional.get(str)+Integer.parseInt(item[OptionalCol.get(str)]));
				}
			}
			
			setRepo();
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return repo;	//return an Entity_Loyalty
	}
	/**
	 * Initialization.
	 */
	public static void initHeadCol() {
		RequiredCol= new HashMap<>();
		OptionalCol= new HashMap<>();
	}
	/**
	 * Initialization.
	 */
	public static void initRequired() {
		Required = new HashMap<>();
		HashMap<String, Integer> Soup = new HashMap<>();
		HashMap<String, Integer> Noodle = new HashMap<>();
		HashMap<String, Integer> Onion = new HashMap<>();
		HashMap<String, Integer> Spiciness = new HashMap<>();
		Required.put("Soup", Soup);
		Required.put("Noodle", Noodle);
		Required.put("Spring onion", Onion);
		Required.put("Spiciness", Spiciness);
	}
	/**
	 * Initialization.
	 */
	public static void initOptional() {
		Optional = new HashMap<>();
		Set<String> head=OptionalCol.keySet();
		for (String str : head) {  
			Optional.put(str, 0);
		}  
	}
	/**
	 * Set report content.
	 * @throws IOException
	 */
	public static void setRepo() throws IOException {
		repo = new Entity_Report();
		repo.setn_Order(BM.countLines("src/File/report.csv")-1);	//set n_Order which is the number of row in report.csv
		repo.setSoup(Required.get("Soup"));
		repo.setNoodle(Required.get("Noodle"));
		repo.setOnion(Required.get("Spring onion"));
		repo.setSpiciness(Required.get("Spiciness"));
		repo.setn_Nori(Optional.get("Nori"));
		repo.setn_Chashu(Optional.get("Chashu"));
		repo.setn_Egg(Optional.get("Egg"));
		repo.setn_Bamboo(Optional.get("Bamboo Shoots"));
	}
}
