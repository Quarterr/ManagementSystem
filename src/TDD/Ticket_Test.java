package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import System.Entity.Entity_Ticket;

/**
 * Test the function of generating the ticket.
 * @author Xinyu Li
 * @version 2.0
 */
class Ticket_Test {
	/**
	 * Test the function of setting and getting info of the ticket.
	 */
	@Test
	void testTicket() {
		Entity_Ticket t1 = new Entity_Ticket();
		t1.setBasicPart1("soup","Shoyu");
		t1.setBasicPart1("noodle","Medium");
		t1.setBasicPart1("springOnion","Lot");
		t1.setBasicPart2("nori",true);
		t1.setBasicPart2("chashu",true);
		t1.setBasicPart2("egg",false);
		t1.setSpiciness(2);
		t1.setAddOnPart("eggNo",0);
		t1.setAddOnPart("bambooNo", 0);
		t1.setAddOnPart("noriNo", 3);
		t1.setAddOnPart("chashuNo", 1);
		t1.setEatInPart(false);
		t1.totalPriceCalculate();
		
		assertEquals(t1.getBasicPart1("soup"), "Shoyu");
		assertEquals(t1.getBasicPart1("noodle"), "Medium");
		assertEquals(t1.getBasicPart1("springOnion"), "Lot");
		assertTrue(t1.getBasicPart2("nori"));
		assertTrue(t1.getBasicPart2("chashu"));
		assertFalse(t1.getBasicPart2("egg"));
		assertEquals(t1.getSpiciness(), 2);
		assertEquals(t1.getAddOnPart("eggNo"), 0);
		assertEquals(t1.getAddOnPart("bambooNo"), 0);
		assertEquals(t1.getAddOnPart("noriNo"), 3);
		assertEquals(t1.getAddOnPart("chashuNo"), 1);
		assertFalse(t1.getEatInPart());
		assertEquals(t1.getTotalPrice(), (float)14.9);
	}

}

