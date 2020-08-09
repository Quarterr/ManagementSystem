package System.Control;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jfree.util.StringUtils;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import System.Data.Chart_Generater;
import System.Data.Constant;
import System.Data.Loyalty_Reader;
import System.Entity.Entity_Loyalty;

/**
 * Function for sending email.
 * @author Jing Hu
 * @version 1.4
 */
public class SendMail implements org.quartz.Job {
	private static String chart[] = {"addpic.png","souppic.png","noodlepic.png","springpic.png","spicypic.png"};
	
	/**
	 * Send email put the text and image together and send to manager.
	 * @param To
	 */
	public static void sendRepo(String To) {
	  	ArrayList<String> content=new ArrayList<>();
	  	content=Report.EmailFormat();
	  	Chart_Generater.generate();
		try {
 
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.qq.com");
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.auth", "true");

	            //build session
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				//authorization
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Constant.DEFAULT_EMAIL_SENDER, Constant.DEFAUIT_EMAIL_SENDER_PASSWD);
				}
			});
			//mail object
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("2683430727@qq.com"));
			message.setRecipients(Message.RecipientType.TO, To);
			message.setSubject("Report For Last Week");
			//text part
			MimeMultipart text = new MimeMultipart();
			for(int i=0;i<chart.length;i++) {
				MimeBodyPart textPart = new MimeBodyPart();
				textPart.setContent("<br><font size =\"6\""+content.get(i)+"</font>"+"<br><img src='cid:"+chart[i]+"'/></br>", "text/html;charset=UTF-8");
				text.addBodyPart(textPart,i);
			}
			//picture part
			MimeMultipart img = new MimeMultipart();
			for(int i=0;i<chart.length;i++) {
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.setDataHandler(new DataHandler(new FileDataSource("src/Chart/"+chart[i])));	//picture path
				imagePart.setContentID(chart[i]);
				img.addBodyPart(imagePart,i);
				
			}
			//relate
			MimeMultipart mail = new MimeMultipart();
			for(int i=0;i<chart.length;i++) {
				mail.addBodyPart(text.getBodyPart(i));
				mail.addBodyPart(img.getBodyPart(i));
				mail.setSubType("related");
			}
			MimeBodyPart textImagePart = new MimeBodyPart();
			textImagePart.setContent(mail);
			mail.setSubType("mixed");
			message.setContent(mail);
			message.saveChanges();
			//send
			System.out.println("Sending...");
			Transport.send(message);
			Date currentTime = new Date();
		  	System.out.println("Date: "+currentTime+"\n"+"Send to "+To);
			
	       	} catch (Exception e) {
	       		e.printStackTrace();
	       	}
		}
	
	/**
	 * Send email put the text and image together and send to manager.
	 * @param L_ID
	 */
	public static  void sendStampchange(String L_ID) {
		Entity_Loyalty p =Loyalty_Reader.personalInfo(L_ID);
		String To=p.getEmail();
		if(To.equals("null")||To.length() == 0||To==null) {
			System.out.println(p.getLID()+" don't have E-mail address.");
			return ;
		}
		
	  	StringBuffer content=Loyalty.EmailFormat(L_ID);
		try {
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.qq.com");
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.auth", "true");

	            //build session
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				//authorization
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Constant.DEFAULT_EMAIL_SENDER, Constant.DEFAUIT_EMAIL_SENDER_PASSWD);
				}
			});
			//mail object
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("2683430727@qq.com"));
			message.setRecipients(Message.RecipientType.TO, To);
			message.setSubject("Consumption Notification");
			//text part
			MimeMultipart text = new MimeMultipart();
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent("<br><font size =\"6\""+content+"</font></br>", "text/html;charset=UTF-8");
			text.addBodyPart(textPart);
			message.setContent(text);
			message.saveChanges();
			//send
			System.out.println("Sending...");
			Transport.send(message);
			Date currentTime = new Date();
		  	System.out.println("Date: "+currentTime+"\n"+"Send to "+To);
			
	       	} catch (Exception e) {
	       		e.printStackTrace();
	       	}
		}
		
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();	//Receiver's address will be pass by the data map
        String To = dataMap.get("To").toString();
	  	SendMail.sendRepo(To);
	  	System.out.println("Complete.");
	}
	
}