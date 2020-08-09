package System.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import System.Control.Loyalty;
import System.Entity.Entity_Loyalty;

/**
 * This class reads the info of a loyalty.
 * @author Jing Hu
 * @version 2.0
 */
public class Loyalty_Reader {
	/**
	 * Get all the Loyalty ID for Identification Verify.
	 * @return ArrayList of String
	 */
	public static ArrayList<String> all_LID() {
		String line = null;
		int col=0;	// number of Attributes(column)
		int c_LID=0;	// the col number of Loyalty ID
		ArrayList<String> all_LID = new ArrayList<>();		//store all the Loyalty ID
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/Loyalty.csv"));
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//store each header in array list head[]
			col=head.length;
			//System.out.println(col);
			for(int c=0; c<col; c++) {
				if(head[c].equals("ID")==true) {
					c_LID=c;	//get col number of Loyalty ID
				}
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				all_LID.add(item[c_LID]);
			}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return all_LID;	//return an arraylist
	}
	/**
	 * Get all the info of a person.
	 * @param L_ID
	 * @return Entity_Menu
	 */
	public static Entity_Loyalty personalInfo(String L_ID) {
		String line = null;
		int col=0;	// store number of Attributes(column)
		int c_LID=0;	// the col number of Loyalty ID
		int c_Fname=0;	// the col number of first name
		int c_Sname=0;	// the col number of surname
		int c_Email=0;	// the col number of email
		int c_Phone=0;	// the col number of phone
		int c_Stamp=0;	// the col number of stamp
		
		Entity_Loyalty profile = new Entity_Loyalty();		//store all the dish name
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/Loyalty.csv"));
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//store each header in array list head[]
			col=head.length; 	// get the column number of the csv file
			//System.out.println(col);
			for(int c=0; c<col; c++) {
				if(head[c].equals("LID")==true) {
					c_LID=c;	
				}
				else if(head[c].equals("First name")==true) {
					c_Fname=c;	
				}
				else if(head[c].equals("Surname")==true) {
					c_Sname=c;	
				}
				else if(head[c].equals("Email")==true) {
					c_Email=c;	
				}
				else if(head[c].equals("Phone")==true) {
					c_Phone=c;	
				}
				else if(head[c].equals("Stamp")==true) {
					c_Stamp=c;	
				}
			}
			boolean get=false;
			while(((line = reader.readLine()) != null)&&get==false){
				String item[] = line.split(",");
				if(item[c_LID].equals(L_ID)==true) {	//if this is the ID column but the content is not the same with the Loyalty ID you want to search
					Loyalty.clearprofile(profile); //clear the profile incase the ID is not the first column it might save the other info before check if ID matched
					profile.setLID(item[c_LID]); 	//set L_ID in entity profile
					profile.setFname(item[c_Fname]); 	//set FirstName in entity profile
					profile.setSname(item[c_Sname]); 	//set Surname in entity profile
					profile.setEmail(item[c_Email]); 	//set Email in entity profile
					profile.setPhone(item[c_Phone]); 	//set Phone in entity profile
					profile.setStamp(Integer.parseInt(item[c_Stamp])); 	//set Stamp in entity profile
					get=true;
				}
			}
			reader.close();
			/*
			 * if no ID matched
			 */
			if(profile.getLID()==null) {
				System.out.println("No matched Loyalty, check if you enter the wrong ID!");
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return profile;	//return an Entity_Loyalty
	}
	/**
	 * Look through csv to find out if there exists one loyalty with such id.
	 * @param id
	 * @return flag
	 */
	public static boolean findLoyalty(String id) {
		boolean flag = false;
		if(personalInfo(id).getLID()!=null) 
			flag = true;
		else
			flag = false;
		return flag;
	}
}
