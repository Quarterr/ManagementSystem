package System.Entity;
/**
 * The functions and Entity of Loyalty.
 * @author Jing Hu
 * @version 1.0
 */
public class Entity_Loyalty {
	private String L_ID;	// 8 digits
	private String FirstName;
	private String Surname;
	private String Email;	// format : ***@***.***
	private String Phone;	// 11 digits
	private int Stamp;		// 0-10
	/**
	 * Entity class of Loyalty.
	 */
	public Entity_Loyalty() {
		this.L_ID=null;	// 8 digits
		this.FirstName=null;
		this.Surname=null;
		this.Email=null;	// format : ***@***.***
		this.Phone=null;	// 11 digits
		this.Stamp=0;		// 0-10
	}
	/**
	 * Entity class of menu.
	 * @param FirstName
	 * @param Surname
	 * @param Email
	 * @param Phone
	 */
	public Entity_Loyalty(String FirstName, String Surname, String Email, String Phone) {
		this.L_ID=null;		// need generate ID function
		/*
		 * generateLID();
		 */
		this.FirstName=FirstName;
		this.Surname=Surname;
		this.Email=Email;	// format : ***@***.***
		this.Phone=Phone;	// 11 digits
		this.Stamp=0;
	}
	/**
	 * Get L_ID.
	 * @return L_ID
	 */
	public String getLID() {
		return L_ID;
	}
	/**
	 * Get FirstName.
	 * @return FirstName
	 */
	public String getFname() {
		return FirstName;
	}
	/**
	 * Get Surname.
	 * @return Surname
	 */
	public String getSname() {
		return Surname;
	}
	/**
	 * Get Phone.
	 * @return Phone
	 */
	public String getPhone() {
		return Phone;
	}
	/**
	 * Get Email.
	 * @return Email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * Get Email.
	 * @return Email
	 */
	public int getStamp() {
		return Stamp;
	}
	/**
	 * Set LI_D.
	 * @param L_ID
	 */
	public void setLID(String L_ID) {
		this.L_ID=L_ID;
	}
	/**
	 * Set FirstName.
	 * @param FirstName
	 */
	public void setFname(String FirstName) {
		this.FirstName=FirstName;
	}
	/**
	 * Set Surname.
	 * @param Surname
	 */
	public void setSname(String Surname) {
		this.Surname=Surname;
	}
	/**
	 * Set Phone.
	 * @param Phone
	 */
	public void setPhone(String Phone) {
		this.Phone=Phone;
	}
	/**
	 * Set Email.
	 * @param Email
	 */
	public void setEmail(String Email) {
		this.Email=Email;
	}
	/**
	 * Set Stamp.
	 * @param Stamp
	 */
	public void setStamp(int Stamp) {
		this.Stamp=Stamp;
	}


}
