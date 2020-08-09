package System.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import System.Entity.Entity_Menu;
/**
 * read menu info from file
 * @author Jing Hu
 * @version 5.0
 */
public class Menu_Reader {
	/**
	 * Get all the name of dish.
	 * @return ArrayList of String
	 */
	public static ArrayList<String> all_dish() {
		String line = null;
		int col=0;	// number of Attributes(column)
		int c_Dname=0;	// the col number of dish name
		ArrayList<String> all_name = new ArrayList<>();		//store all the dish name
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/menu.csv"));
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//store each header in array list head[]
			col=head.length;
			for(int c=0; c<col; c++) {
				if(head[c].equals("Dish")==true) {
					c_Dname=c;	//get col number of dish name
				}
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				all_name.add(item[c_Dname]);
			}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return all_name;	//return an arraylist
	}
	/**
	 * Get all the entity of menu.
	 * @return ArrayList of Entity_Menu
	 */
	public static ArrayList<Entity_Menu> all_menu() {
		String line = null;
		int col=0;	// store number of Attributes(column)
		int c_Dname=0;	// the col number of dish name
		int c_Price=0;	// the col number of price
		int c_Available=0;	// the col number of Available
		
		ArrayList<Entity_Menu> all_menu = new ArrayList<>();		//store all the dish name
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/menu.csv"));
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//store each header in array list head[]
			col=head.length; 	// get the column number of the csv file
			//System.out.println(col);
			for(int c=0; c<col; c++) {
				if(head[c].equals("Dish")==true) {
					c_Dname=c;	//which column is dish name
				}
				else if(head[c].equals("Price")==true) {
					c_Price=c;	//which column contains price
				}
				else if(head[c].equals("Available")==true) {
					c_Available=c;	//which column contains Available
				}
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				Entity_Menu temp= new Entity_Menu();
				temp.setDish_name(item[c_Dname]); 	//set Dish_name in entity temp
				temp.setPrice(Float.parseFloat(item[c_Price])); 	//set price in entity temp
				temp.setAvailable(Boolean.parseBoolean(item[c_Available])); 	//set Available in entity temp
				all_menu.add(temp);	//add entity temp in the Entity list
			}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return all_menu;	//return an Entity_Menu list 
	}
	/**
	 * Get price of certain dish
	 * @param Dish_name
	 * @return price
	 */
	public static float readPrice(String Dish_name) {
		String line = null;
		int col=0;
		int c_Dname=0;
		int c_Price=0;
		float price=0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/menu.csv"));	//read csv file
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//split with , and store each string in array head[]
			col=head.length; 
			for(int c=0; c<col; c++) {
				if(head[c].equals("Dish")==true) {	
					c_Dname=c;	//which column is dish name
				}
				else if(head[c].equals("Price")==true) {
					c_Price=c;	//which column contains price
				}
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				for(int c=0;c<col;c++) {
					if(c==c_Dname&&item[c_Dname].equals(Dish_name)==false) {  	//if this is the Dish_name column but the content is not the same with the dish name you want to search
						break;	//go to the next column
					}
					else if(c==c_Price) {	//the Dish name matched and this column is price column
						price=Float.parseFloat(item[c_Price]);  	//get the price 
					}
				}
			}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return price;		
	}
	
	/**
	 * Get price of certain dish
	 * @param Dish_name
	 * @return available
	 */
	public static boolean readAvailable(String Dish_name) {
		String line = null;
		int col=0;
		int c_Dname=0;
		int c_Available=0;
		boolean Available=true;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/menu.csv"));	//read csv file
			line = reader.readLine();	//read header
			String head[] = line.split(",");	//split with , and store each string in array head[]
			col=head.length; 
			for(int c=0; c<col; c++) {
				if(head[c].equals("Dish")==true) {
					c_Dname=c;	//which column is dish name
				}
				else if(head[c].equals("Available")==true) {
					c_Available=c;	//which column contains Available
				}
			}
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				for(int c=0;c<col;c++) {
					if(c==c_Dname&&item[c_Dname].equals(Dish_name)==false) {	//if this is the Dish name column but the content is not the same with the dish name you want to search
						break;	//go to the next column
					}
					else if(c==c_Available) {	//the Dish name matched and this column is Available column
						Available=Boolean.parseBoolean(item[c_Available]);  	//get the available
					}
				}
			}
			reader.close();
			
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		return Available;		
	}
}
