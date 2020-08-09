package System.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import System.Entity.Entity_Loyalty;

/**
 * The class describes how to store info of new loyalty in csv.
 * @author Xinyu Li, Tingxuan Zhang
 * @version 3.0
 */
public class Loyalty_Storer {
	/**
	 * This method contributes to generate a registration ticket when a customer register to be a loyalty.
	 * @param l
	 */
	public static void register(Entity_Loyalty l) {
		//generate id
		l.setLID(generateLID());
		String s = l.getLID() + "\n" + l.getFname()+ "\n" + l.getSname() + "\n" + l.getPhone() + "\n" 
				+ l.getEmail();
		//generate registration ticketS
		File fileName = new File("src/RegistrationTicket/loyalty_" + l.getLID() + ".txt");
		try {
			FileWriter filewriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			bufferedWriter.write(s);
			bufferedWriter.close();
			filewriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		//save the loyalty info in csv
		addToLoyaltyFile(s.replace('\n', ',') + "," + l.getStamp());
	}
	
	/**
	 * This method generates 8-digit random loyalty id.
	 * @return str
	 */
	public static String generateLID() {
		String str = "";
		Random random = new Random();
		while(true) {
			str = str.concat(Integer.toString(random.nextInt(9)+1));
			for(int i=0;i<7;i++){
			    str = str.concat(Integer.toString(random.nextInt(10)));
			}
			
			if(Loyalty_Reader.all_LID().contains(str))
				continue;
			else {
				break;
			}
		}
		return str;
	}
	
	/**
	 * This method enables the register information to be stored in the file.
	 * @param s
	 */
	public static void addToLoyaltyFile(String s) {
		try {
	        FileWriter writer = new FileWriter("src/File/loyalty.csv", true);
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);
	        writer.write(s);
	        writer.write("\n");
	        bufferedWriter.close();
	        writer.close();
	    } 
		catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * This method contributes to add one stamp when loyalty uses cash/card to pay.
	 * @param l
	 */
	public static void addStamp(Entity_Loyalty l) {
		int stamp = l.getStamp() + 1;
		l.setStamp(stamp);
		updateStamp(l);
	}
	
	/**
	 * Stamp counter will be set back to 0 when loyalty uses 10 virtual stamps to pay.
	 * @param l
	 */
	public static void useStamp(Entity_Loyalty l) {
		l.setStamp(0);
		updateStamp(l);
	}
	
	/**
	 * This method helps to update the number of stamps saved in csv.
	 * @param l
	 */
	public static void updateStamp(Entity_Loyalty l) {
		try {           
			BufferedReader reader = new BufferedReader(new FileReader("src/File/loyalty.csv"));      
	        //reader.readLine(); 
	        String line = null;
	        String s = "";
	        while((line=reader.readLine())!=null){
	        	String item[] = line.split(",");
	            if(item[0].equals(l.getLID())){
	                s = s.concat(l.getLID() + "," + l.getFname() + "," + l.getSname() + "," + l.getPhone() + "," 
					+ l.getEmail() + "," + l.getStamp() + "\n");
	            }
	            else {
	            	s = s.concat(line + "\n");
	            }
	        } 
	        reader.close();
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter("src/File/loyalty.csv"));  
	        writer.write(s);
	        writer.close();
	    } 
		catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
