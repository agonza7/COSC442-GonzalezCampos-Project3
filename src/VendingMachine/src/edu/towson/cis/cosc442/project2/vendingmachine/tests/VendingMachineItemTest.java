package VendingMachine.src.edu.towson.cis.cosc442.project2.vendingmachine.tests;

/**
 * @author agonza7
 *
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import VendingMachine.src.edu.towson.cis.cosc442.project2.vendingmachine.*;

public class VendingMachineItemTest {
	VendingMachineItem vendingMachineItem;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vendingMachineItem = new VendingMachineItem("Pepsi", 10.0);
	}

	/**
	 * @throws java.lang.Exception
	 */

	@After
	public void tearDown() throws Exception {
		vendingMachineItem = null;
	}

	/**
	 * Test to see if VendingMachineItem is constructed as intended.
	 */
	@Test // (expected = VendingMachineException.class)
	public final void testMachineItem() {
		vendingMachineItem = new VendingMachineItem("Sprite", 1.50);
	}

	/**
	 * Test to see if an item with a negative price cannot be created.
	 */

	@Test(expected = VendingMachineException.class)
	public final void testVendingMachineItemNegativePrice() {
		vendingMachineItem = new VendingMachineItem("Crush", -1.50);
	}

	/**
	 * Test to see if proper name is returned from item.
	 */
	@Test
	public final void testGetProperName() {
		assertTrue("Returned incorrect item name.", "Pepsi".equals(vendingMachineItem.getName()));
	}

	/**
	 * Test to see if exception is thrown when wrong name is returned from item.
	 */
	@Test
	public final void testGetWrongName() {
		assertFalse("Returned incorrect item name.", "Coke".equals(vendingMachineItem.getName()));
	}

	/**
	 * Test to see if correct price is returned.
	 */
	@Test
	public final void testGetPrice() {
		assertEquals(10.0, vendingMachineItem.getPrice(), 0.01);
	}
}