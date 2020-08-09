package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import System.Data.Menu_Reader;

/**
 * Test the function of showing menu.
 * @author Jing Hu
 * @version 1.0
 */
class ReadMenu_Test {
	/**
	 * Test the function of reading menu.
	 */
	@Test
	void readMenu() {
		assertEquals(Menu_Reader.readPrice("Nori"), (float)1);
		assertTrue(Menu_Reader.readAvailable("Nori"));
	}

}
