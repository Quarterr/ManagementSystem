package System.Entity;
import java.util.Date;
import java.util.HashMap;
/**
 * The functions and Entity of report.
 * @author Jing Hu
 * @version 1.0
 */
public class Entity_Report {
	private Date repoDate=new Date();
	private int n_Order;
	private int n_Nori;
	private int n_Chashu;
	private int n_Egg;
	private int n_Bamboo;
	private HashMap<String, Integer> Soup = new HashMap<>();
	private HashMap<String, Integer> Noodle = new HashMap<>();
	private HashMap<String, Integer> Onion = new HashMap<>();
	private HashMap<String, Integer> Spiciness = new HashMap<>();
	/**
	 * Set start date of Report, usually is the last Monday.
	 * @param repoDate
	 */
	public void setrepoDate(Date repoDate) {
		this.repoDate=repoDate;
	}
	/**
	 * Get start date of Report.
	 * @return repoDate
	 */
	public Date getrepoDate() {
		return repoDate;
	}
	
	/**
	 * Set number of Order.
	 * @param n_Order
	 */
	public void setn_Order(int n_Order) {
		this.n_Order=n_Order;
	}
	/**
	 * Get number of Order.
	 * @return n_Order
	 */
	public int getn_Order() {
		return n_Order;
	}
	/**
	 * Set number of Nori.
	 * @param n_Nori
	 */
	public void setn_Nori(int n_Nori) {
		this.n_Nori=n_Nori;
	}
	/**
	 * Get number of Nori.
	 * @return n_Nori
	 */
	public int getn_Nori() {
		return n_Nori;
	}
	/**
	 * Set number of Chashu.
	 * @param n_Chashu
	 */
	public void setn_Chashu(int n_Chashu) {
		this.n_Chashu=n_Chashu;
	}
	/**
	 * Get number of Chashu.
	 * @return n_Chashu
	 */
	public int getn_Chashu() {
		return n_Chashu;
	}
	/**
	 * Set number of Egg.
	 * @param n_Egg
	 */
	public void setn_Egg(int n_Egg) {
		this.n_Egg=n_Egg;
	}
	/**
	 * Get number of Egg.
	 * @return n_Egg
	 */
	public int getn_Egg() {
		return n_Egg;
	}
	/**
	 * Set number of Bamboo.
	 * @param n_Bamboo
	 */
	public void setn_Bamboo(int n_Bamboo) {
		this.n_Bamboo=n_Bamboo;
	}
	/**
	 * Get number of Bamboo.
	 * @return n_Bamboo
	 */
	public int getn_Bamboo() {
		return n_Bamboo;
	}
	/**
	 * Set hash map of Soup.
	 * @param Soup
	 */
	public void setSoup(HashMap<String, Integer> Soup) {
		this.Soup=Soup;
	}
	/**
	 * Get hash map of Soup.
	 * @return Soup
	 */
	public HashMap<String, Integer> getSoup() {
		return Soup;
	}
	/**
	 * Set hash map of Noodle.
	 * @param Noodle
	 */
	public void setNoodle(HashMap<String, Integer> Noodle) {
		this.Noodle=Noodle;
	}
	/**
	 * Get hash map of Noodle.
	 * @return Noodle
	 */
	public HashMap<String, Integer> getNoodle() {
		return Noodle;
	}
	/**
	 * Set hash map of Onion.
	 * @param Onion
	 */
	public void setOnion(HashMap<String, Integer> Onion) {
		this.Onion=Onion;
	}
	/**
	 * Get hash map of Onion.
	 * @return Onion
	 */
	public HashMap<String, Integer> getOnion() {
		return Onion;
	}
	/**
	 * Set hash map of Spiciness.
	 * @param Spiciness
	 */
	public void setSpiciness(HashMap<String, Integer> Spiciness) {
		this.Spiciness=Spiciness;
	}
	/**
	 * Get hash map of Spiciness.
	 * @return Spiciness
	 */
	public HashMap<String, Integer> getSpiciness() {
		return Spiciness;
	}

}

