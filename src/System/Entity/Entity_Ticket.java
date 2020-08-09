package System.Entity;

import java.io.*;
import java.text.*;
import java.util.*;

import System.Data.Ticket_Storer;
import System.Data.Menu_Reader;

/**
 * This class describes the properties and operations associated with the ticket.
 * @author Xinyu Li, Tingxuan Zhang
 * @version 3.0
 */
public class Entity_Ticket {
	private String date1;//time
	private String date2;//time
	private int ticketNo;//ticket number
	
	//basic ramen information
	private String soup;
	private String noodle;
	private String springOnion;
	private boolean nori;
	private boolean chashu;
	private boolean egg;
	private int spiciness;
	
	//the number of extra dishes
	private int eggNo;
	private int bambooNo;
	private int noriNo;
	private int chashuNo;
	
	private boolean eatIn;
	private boolean takeAway;
	
	private float totalPrice;	//total price of this order
	
	private boolean useStamp;
	
	private String ticketStr;
	
	/**
	 * Generate order time and the ticket number
	 */
	public Entity_Ticket() {
		
	}
	
	/**
	 * Set the type of soup and noodles and how much spring onions to add selected by the customer.
	 * @param itemName
	 * @param choice
	 */
	public void setBasicPart1(String itemName, String choice) {
		if(itemName.equals("soup"))
			this.soup = choice;
		else if(itemName.equals("noodle"))
			this.noodle = choice;
		else if(itemName.equals("springOnion"))
			this.springOnion = choice;
	}
	
	/**
	 * Set the number of nori, chashu and eggs selected by the customer.
	 * @param itemName
	 * @param choice
	 */
	public void setBasicPart2(String itemName, boolean choice) {
		if(itemName.equals("nori"))
			this.nori = choice;
		else if(itemName.equals("chashu"))
			this.chashu = choice;
		else if(itemName.equals("egg"))
			this.egg = choice;
	}
	
	/**
	 * Set the user's desired spiciness.
	 * @param spiciness
	 */
	public void setSpiciness(int spiciness) {
		this.spiciness = spiciness;
	}
	
	/**
	 * Set the amount of each add-on item.
	 * @param itemName
	 * @param amount
	 */
	public void setAddOnPart(String itemName, int amount) {
		if(itemName.equals("eggNo"))
			this.eggNo = amount;
		else if(itemName.equals("bambooNo"))
			this.bambooNo = amount;
		else if(itemName.equals("noriNo"))
			this.noriNo = amount;
		else if(itemName.equals("chashuNo"))
			this.chashuNo = amount;
	}
	
	/**
	 * Set customers eat in or take away.
	 * @param eatIn
	 */
	public void setEatInPart(boolean eatIn) {
		this.eatIn = eatIn;
	}
	
	/**
	 * Set customers eat in or take away.
	 * @param takeAway
	 */
	public void setTakeAway(boolean takeAway) {
		this.takeAway = takeAway;
	}
	
	/**
	 * Set whether costomer use stamp to pay.
	 * @param useStamp
	 */
	public void setUseStamp(boolean useStamp) {
		this.useStamp = useStamp;
	}
	
	/**
	 * Get the date.
	 * @return date
	 */
	public String getDate() {
		return this.date2;
	}
	
	/**
	 * Get the ticket number.
	 * @return ticketNo
	 */
	public int getTicketNo() {
		return this.ticketNo;
	}
	
	/**
	 * Get the type of soup and noodles and how much spring onions to add selected by the customer.
	 * @param itemName
	 * @return choice
	 */
	public String getBasicPart1(String itemName) {
		String choice = null;
		
		if(itemName.equals("soup"))
			choice = this.soup;
		else if(itemName.equals("noodle"))
			choice = this.noodle;
		else if(itemName.equals("springOnion"))
			choice = this.springOnion;
		
		return choice;
	}
	
	/**
	 * Get the number of nori, chashu and eggs selected by the customer.
	 * @param itemName
	 * @return choice
	 */
	public boolean getBasicPart2(String itemName) {
		boolean choice = true;
		
		if(itemName.equals("nori"))
			choice = this.nori;
		else if(itemName.equals("chashu"))
			choice = this.chashu;
		else if(itemName.equals("egg"))
			choice = this.egg;
		
		return choice;
	}
	
	/**
	 * Get the user's desired spiciness.
	 * @return spiciness
	 */
	public int getSpiciness() {
		return this.spiciness;
	}
	
	/**
	 * Get the amount of each add-on item.
	 * @param itemName
	 * @return amount
	 */
	public int getAddOnPart(String itemName) {
		int amount = 0;
		
		if(itemName.equals("eggNo"))
			amount = this.eggNo;
		else if(itemName.equals("bambooNo"))
			amount = this.bambooNo;
		else if(itemName.equals("noriNo"))
			amount = this.noriNo;
		else if(itemName.equals("chashuNo"))
			 amount = this.chashuNo;
		
		return amount;
	}
	
	/**
	 * Get if customers eat in.
	 * @return eatIn
	 */
	public boolean getEatInPart() {
		return this.eatIn;
	}
	
	/**
	 * Get if customers take away.
	 * @return eatIn
	 */
	public boolean getTakeAway() {
		return this.takeAway;
	}
	
	/**
	 * Get total price of dishes selected by the customer.
	 * @return totalPrice
	 */
	public float getTotalPrice() {
		this.totalPriceCalculate();
		return this.totalPrice;
	}
	
	/**
	 * Get various information about a ticket as a string.
	 * @return ticketStr
	 */
	public String getTicketStr() {
		return this.ticketStr;
	}
	
	/**
	 * Get whether customer uses stamp.
	 * @return useStamp
	 */
	public boolean getUseStamp() {
		return this.useStamp;
	}
	
	/**
	 * Generate two formats of date.
	 */
	public void generateTime() {
		Date d = new Date();    
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy/M/d");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		this.date1 = df1.format(d);
		this.date2 = df2.format(d);
	}
	
	/**
	 * Generate the ticket number.
	 */
	public void generateTicketNo() {
		int count = 0;
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/File/order.csv"));
			while((line = reader.readLine()) != null){
				String item[] = line.split(",");
				if(item.length > 0) {
					String s = item[0];
					if(s.equals(date1) || s.equals(date2))
						count++;
				}
			}
			reader.close();
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		this.ticketNo = ++count;
	}
	
	/**
	 * Calculate the total price of dishes.
	 */
	public void totalPriceCalculate() {
		float basicPrice = Menu_Reader.readPrice("Basic");
		float eggPrice = Menu_Reader.readPrice("Egg");
		float noriPrice= Menu_Reader.readPrice("Nori");
		float chashuPrice = Menu_Reader.readPrice("Chashu");
		float bambooPrice = Menu_Reader.readPrice("Bamboo Shoots");
		
		float addOnPrice = eggPrice * this.eggNo + noriPrice * this.noriNo + chashuPrice * this.chashuNo + bambooPrice * this.bambooNo;
		
		this.totalPrice = basicPrice + addOnPrice;//The total price is calculated.		
	}
	
	/**
	 * Generate the ticket for customers, waiters and cooks.
	 */
	public void generateTicket() {
		this.generateTime();
		this.generateTicketNo();
		
		this.ticketStr = this.date1 + "\n" + this.ticketNo + "\n" + this.soup + "\n" + this.noodle + "\n" + this.springOnion + "\n"
				+ this.nori + "\n" + this.chashu + "\n" + this.egg + "\n" + this.spiciness + "\n" + this.eggNo + "\n" + this.bambooNo + "\n" + this.noriNo + "\n"
				+ this.chashuNo + "\n" + this.eatIn + "\n" + this.totalPrice + "\n" + this.useStamp;
		
		File fileName = new File("src/OrderTicket/ticket_" + this.date2 + "_" + this.ticketNo + ".txt");
		try {
			FileWriter filewriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			bufferedWriter.write(ticketStr);
			bufferedWriter.close();
			filewriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		Ticket_Storer o = new Ticket_Storer();
		o.addToOrderList(this);
	}
}
