package System.Entity;

/**
 * The functions and Entity of Menu.
 * @author Jing Hu
 * @version 1.3
 */
public class Entity_Menu {
	private String Dish_name;
	private float price;
	private boolean Available;
	/**
	 * Entity class of menu.
	 */
	public Entity_Menu() {
		this.Dish_name=null;
		this.price=0;
		this.Available=true;
	}
	/**
	 * Entity class of menu.
	 * @param Dish_name
	 * @param price
	 * @param Available
	 */
	public Entity_Menu(String Dish_name, float price, boolean Available) {
		this.Dish_name=Dish_name;
		this.price=price;
		this.Available=true;
	}
	/**
	 * Get name of dish.
	 * @return Dish_name
	 */
	public String getDish_name() {
		return this.Dish_name;
	}
	/**
	 * Set name of dish.
	 * @param Dish_name
	 */
	public void setDish_name(String Dish_name) {
		this.Dish_name=Dish_name;
	}
	/**
	 * Get price of dish.
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * Get price of dish.
	 * @param Dish_name
	 * @return price
	 */
	public float getPrice(String Dish_name) {
		return price;
	}
	/**
	 * Set price of dish.
	 * @param price
	 */
	public void setPrice(float price) {
		this.price=price;
	}
	/**
	 * Get Available of dish.
	 * @return Available
	 */
	public boolean getAvailable() {
		return Available;
	}
	/**
	 * Get Available of dish.
	 * @param Dish_name
	 * @return available
	 */
	public boolean getAvailable(String Dish_name) {
		return Available;
	}
	/**
	 * Set Available of dish.
	 * @param Available
	 */
	public void setAvailable(boolean Available) {
		this.Available=Available;
	}
}
