package System.Data;

import java.io.*;

import System.Entity.Entity_Ticket;

/**
 * This class describes the properties and operations associated with order
 * @author Xinyu Li
 * @version 2.0
 */
public class Ticket_Storer {
	
	/**
	 * The empty constructor of the Order class
	 */
	public Ticket_Storer() {
		
	}

	/**
	 * Add the order to the order list
	 * @param ticket
	 */
	public void addToOrderList(Entity_Ticket ticket) {
		String str = ticket.getTicketStr().replace('\n', ',');
		
		try {
			RandomAccessFile randomFile = new RandomAccessFile("src/File/order.csv", "rw");
			long fileLength = randomFile.length();
            randomFile.seek(fileLength);
            randomFile.writeBytes(str + "\n");
            randomFile.close();
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}
