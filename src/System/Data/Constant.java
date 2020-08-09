package System.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class includes some changeless constants and releated methods.
 * @author Jing Hu
 * @version 1.0
 */
public class Constant {
	public static final String DEFAULT_EMAIL_SENDER = "2683430727@qq.com";
	public static final String DEFAUIT_EMAIL_SENDER_PASSWD = "mafmgrrwlayfdibi";
	/**
	 * Get the auto time of sending Email.
	 * @return AutoEmailTime
	 * @throws IOException
	 */
	public static String getAutoEmailTime() throws IOException {
		String AutoEmailTime=null;
		String line = null;
			BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
			while(((line = reader.readLine()) != null)) {
				String item[] = line.split(",");
				if(item[0].equals("AutoEmailTime")) 
					AutoEmailTime=item[1];
			}
			return AutoEmailTime;
	}
	/**
	 * Get the manager email.
	 * @return ManagerEmail
	 * @throws IOException
	 */
	public static String getManagerEmail() throws IOException {
		String ManagerEmail=null;
		String line = null;
			BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
			while(((line = reader.readLine()) != null)) {
				String item[] = line.split(",");
				if(item[0].equals("ManagerEmail")) 
					ManagerEmail=item[1];
			}
			return ManagerEmail;
	}
	/**
	 * Get the required head.
	 * @return
	 * @throws IOException
	 */
	public static String[] getRequiredHead() throws IOException {
			String line = null;
			String head=null;
			BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
			while(((line = reader.readLine()) != null)) {
				String item[] = line.split(",");
				if(item[0].equals("RequiredHead")) {
					head=item[1];
					for(int i=2;i<item.length;i++)
						head=head+","+item[i];
				}
			}
			String RequiredHead[]=head.split(",");
			return RequiredHead;
	}
	/**
	 * Set auto time of sending email.
	 * @param time
	 * @throws IOException
	 */
	public static void setAutoEmailTime(String time) throws IOException {
		ArrayList<String> temp=new ArrayList<>();
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
		while(((line = reader.readLine()) != null)) {
			if(line.contains("AutoEmailTime")) 
				temp.add("AutoEmailTime,"+time);
			else 
				temp.add(line);
		}
		BM.clearInfoForFile("src/File/Manager_Setting.csv");
		File csv = new File("src/File/Manager_Setting.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		for(String str:temp) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
		
	}
	/**
	 * Set manager email.
	 * @param Email
	 * @throws IOException
	 */
	public static void setManagerEmail(String Email) throws IOException {
		ArrayList<String> temp=new ArrayList<>();
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
		while(((line = reader.readLine()) != null)) {
			if(line.contains("ManagerEmail")) 
				temp.add("ManagerEmail,"+Email);
			else 
				temp.add(line);
		}
		BM.clearInfoForFile("src/File/Manager_Setting.csv");
		File csv = new File("src/File/Manager_Setting.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		for(String str:temp) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
	}
	/**
	 * Set required head.
	 * @param h
	 * @throws IOException
	 */
	public static void setRequiredHead(String h) throws IOException {
		ArrayList<String> temp=new ArrayList<>();
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader("src/File/Manager_Setting.csv"));
		while(((line = reader.readLine()) != null)) {
			if(line.contains("RequiredHead")) {
				temp.add("RequiredHead,"+h);
			}
			else 
				temp.add(line);
		}
		BM.clearInfoForFile("src/File/Manager_Setting.csv");
		File csv = new File("src/File/Manager_Setting.csv");
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		for(String str:temp) {
			bw.write(str);
			bw.newLine();
		}
		bw.close();
	}
}
