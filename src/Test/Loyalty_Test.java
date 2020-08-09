package Test;
import java.util.ArrayList;
import java.util.Random;

import System.Data.Loyalty_Reader;
import System.Data.Loyalty_Storer;
import System.Entity.Entity_Loyalty;
/**
 * @author Jing Hu
 * @version 1.0
 */
public class Loyalty_Test {
	public static void main(String[] args) {
	      //Verify the existence of the member (by id number)
		  String L_ID1="1";//no matched ID
		  System.out.println(Loyalty_Reader.findLoyalty(L_ID1));//print false
		  Entity_Loyalty profile1=Loyalty_Reader.personalInfo(L_ID1);
		  System.out.println(profile1.getLID()+","+profile1.getFname()+","+profile1.getSname()+","+profile1.getEmail()+","+profile1.getPhone()+","+profile1.getStamp());
		  
		  String L_ID2="19374602";//matched ID
		  System.out.println(Loyalty_Reader.findLoyalty(L_ID2));//print true
		  Entity_Loyalty profile2=Loyalty_Reader.personalInfo(L_ID2);//return entity profile2
		  System.out.println(profile2.getLID()+","+profile2.getFname()+","+profile2.getSname()+","+profile2.getEmail()+","+profile2.getPhone()+","+profile2.getStamp());
		  
		  //loyalty register
		  Entity_Loyalty L_ID3 = new Entity_Loyalty();
		  L_ID3.setFname("a");
		  L_ID3.setSname("b");
		  L_ID3.setEmail("aaa@163.com");
		  Loyalty_Storer.register(L_ID3);//You can see the project folder generated under a TXT, CSV file data update
		  
		  //add stamp
		  Entity_Loyalty L_ID4 = Loyalty_Reader.personalInfo("19374602");
		  System.out.println(L_ID4.getStamp());
		  Loyalty_Storer.addStamp(L_ID4);
		  System.out.println(L_ID4.getStamp());
		  
		  //clear stamp
		  Entity_Loyalty L_ID5 = Loyalty_Reader.personalInfo("17382901");
		  System.out.println(L_ID5.getStamp());
		  Loyalty_Storer.useStamp(L_ID5);
		  System.out.println(L_ID5.getStamp());
	}
}
