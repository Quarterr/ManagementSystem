package System.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class enables the function that the manager can modify the menu.
 * @author Tingxuan Zhang, Xinyu Li
 * @version 2.0
 */
public class Menu_Storer {

	private static float basicPrice = Menu_Reader.readPrice("Basic");
	private static float eggPrice = Menu_Reader.readPrice("Egg");
	private static float noriPrice= Menu_Reader.readPrice("Nori");
	private static float chashuPrice = Menu_Reader.readPrice("Chashu");
	private static float bambooPrice = Menu_Reader.readPrice("Bamboo Shoots");
	private static boolean basic = Menu_Reader.readAvailable("Basic");
  	private static boolean egg = Menu_Reader.readAvailable("Egg");
  	private static boolean nori = Menu_Reader.readAvailable("Nori");
  	private static boolean chashu = Menu_Reader.readAvailable("Chashu");
  	private static boolean bamboo = Menu_Reader.readAvailable("Bamboo Shoots");
	
	/**
  	 * Set the price of dishes.
  	 * @param dishName
  	 * @param d
  	 */
  	public static void storePrice(String dishName, float d) {
		if(dishName.equals("Basic")) {
			basicPrice = d;
		}
		else if(dishName.equals("BoiledEgg")) {
			eggPrice = d;
		}
		else if(dishName.equals("Nori")) {
			noriPrice = d;
		}
		else if(dishName.equals("Chashu")) {
			chashuPrice = d;
		}
		else if(dishName.equals("BambooShoots")) {
			bambooPrice = d;
		}
		modifyFile();
	}
	
  	/**
  	 * Set the availability of dishes.
  	 * @param dishName
  	 * @param available
  	 */
	public static void storeAvailable(String dishName, boolean available) {
		if(dishName.equals("Basic")) {
			basic = available;
		}
		else if(dishName.equals("BoiledEgg")){
			egg = available;
		}
		else if(dishName.equals("Nori")){
			nori = available;
		}
		else if(dishName.equals("Chashu")){
			chashu = available;
		}
		else if(dishName.equals("BambooShoots")) {
			bamboo = available;
		}
		modifyFile();
	}
	
	/**
	 * Modify the csv file.
	 */
	public static void modifyFile() {
		BM.clearInfoForFile("src/File/menu.csv");
		try {   
			File csv = new File("src/File/menu.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
			bw.write("Dish" + "," + "Price" + "," + "Available");
			bw.newLine();
			bw.write("Basic" + "," + basicPrice + "," + basic);
			bw.newLine();
			bw.write("Egg" + "," + eggPrice + "," + egg);
			bw.newLine();
			bw.write("Nori" + "," + noriPrice + "," + nori);
			bw.newLine();
			bw.write("Chashu" + "," + chashuPrice + "," + chashu);
			bw.newLine();
			bw.write("Bamboo Shoots" + "," + bambooPrice + "," + bamboo);
			bw.newLine();
			bw.close();    
		} 
		catch (FileNotFoundException e) {    
			e.printStackTrace();    
		} 
		catch (IOException e) {    
			e.printStackTrace();    
		}    
	}
}
