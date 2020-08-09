package System.Data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * This class writes the report.csv file. 
 * @author Jing Hu
 * @version 2.0
 */
public class Report_Storer {
	static HashMap<String, Integer> HeadCol;
	static String RequiredHead[]= {"Soup","Noodle","Spring onion","Spiciness"};
	static String OptionalHead[]= {"Nori","Chashu","Egg"};
	/**
	 * Put the order between sDate and eDate in a new file called report.csv .
	 * @param repoDate
	 */
	public static void csvforstatistic(Date repoDate) {
		String line = null;
		HashMap<String, Integer> Item_Num = new HashMap<>();
		HeadCol= new HashMap<>();
		int col=0;
		int row=1;
		
		
		BM.clearInfoForFile("src/File/report.csv");
		try {   
			File csv = new File("src/File/report.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
			bw.write("Soup,Noodle,Spring onion,Spiciness,Nori,Chashu,Egg,Bamboo Shoots");
			bw.newLine();
			bw.close();    
			
			BufferedReader reader = new BufferedReader(new FileReader("src/File/order.csv"));	//read csv file
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//split with , and store each string in array head[]
			col=head.length; 
			for(int c=0; c<col; c++) {
				HeadCol.put(head[c], c);
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				for(String h:OptionalHead) {
					if(item[HeadCol.get(h)].equals("TRUE")) {
						Item_Num.put(h, 1 + Integer.parseInt(item[HeadCol.get("Extra "+h)]));
					}
					else 
						Item_Num.put(h, Integer.parseInt(item[HeadCol.get("Extra "+h)]));
				}

				if(BM.compareDate(repoDate,item[HeadCol.get("Date")])) {  	//if this is the Dish_name column but the content is not the same with the dish name you want to search
					try {
						FileWriter writer = new FileWriter("src/File/report.csv", true);
						BufferedWriter bufferedWriter = new BufferedWriter(writer);
						writer.write(item[HeadCol.get("Soup")]+","+item[HeadCol.get("Noodle")]+","+item[HeadCol.get("Spring onion")]+","+item[HeadCol.get("Spiciness")]+","+Item_Num.get("Nori")+","+Item_Num.get("Chashu")+","+Item_Num.get("Egg")+","+item[HeadCol.get("Bamboo Shoots")]);
						writer.write("\n");
						bufferedWriter.close();
						writer.close();
						} 
					catch (IOException e) {
					       e.printStackTrace();
					    }	
					}
				row++;
				}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }	
	}

	
}
