package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import System.Data.Menu_Reader;
import System.Data.Menu_Storer;

/**
 * Test the function of modifying menu.
 * @author Xinyu Li
 * @version 2.0
 */
class StoreMenu_Test {
	/**
	 * Modify price.
	 */
	@Test
	void modifyPrice() {
		Menu_Storer.storePrice("Nori", (float) 3.5);
		
		assertEquals(Menu_Reader.readPrice("Nori"), (float) 3.5);
	}
	/**
	 * Modify availability.
	 */
	@Test
	void modifyAvailable() {
		Menu_Storer.storeAvailable("Chashu", false);
		
		assertFalse(Menu_Reader.readAvailable("Chashu"));
	}
}
