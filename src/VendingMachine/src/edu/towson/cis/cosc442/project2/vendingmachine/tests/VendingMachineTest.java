package VendingMachine.src.edu.towson.cis.cosc442.project2.vendingmachine.tests;

/**
 * @author agonza7
 *
 */

import static org.junit.Assert.*;
import VendingMachine.src.edu.towson.cis.cosc442.project2.vendingmachine.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine vendingMachine;

	@Before
	public void setUp() throws Exception {
		vendingMachine = new VendingMachine();
		vendingMachine.addItem(new VendingMachineItem("Pepsi", 2.50), "A");
		// vendingMachine.addItem(new VendingMachineItem("Sprite", 5.50), "B");
		vendingMachine.addItem(new VendingMachineItem("Deer Park", 0.99), "C");
		vendingMachine.addItem(new VendingMachineItem("IceTea", 4.00), "D");
	}

	@After
	public void tearDown() throws Exception {
		vendingMachine = null;
	}

	/**
	 * Test items are added correctly
	 */
	@Test
	public void testAddItem() {
		VendingMachineItem item = new VendingMachineItem("ORANX", 2.3);
		vendingMachine.addItem(item, "B");
		assertEquals(item, vendingMachine.getItem("B"));
	}

	/**
	 * Test that an exception is returned when an item is entered on a taken place
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemOnTakenPlace() {
		vendingMachine.addItem(new VendingMachineItem("COCACOLA", 9.99), "A");
	}

	/**
	 * Tests that an exception is returned when an item is entered on an inexistent
	 * place.
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemOnInvalidSpot() {
		vendingMachine.addItem(new VendingMachineItem("SODAX", 1.00), "F");
	}

	/**
	 * Tests that an item is removed correctly.
	 */
	@Test
	public void testRemoveItem() {
		vendingMachine.removeItem("A");
		assertNull(vendingMachine.getItem("A"));
	}

	/**
	 * Tests that an exception is returned when an item is added to an invalid spot
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemFromInvalidSpot() {
		vendingMachine.removeItem("X");
	}

	/**
	 * Tests that an exception is thrown when an item is attempted to be removed
	 * from an empty spot
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemFromUnasignedSpot() {
		vendingMachine.removeItem("B");
	}

	/**
	 * Tests that an exception is thrown when two items are attempted to be removed
	 * from the same spot
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemoveItem2Times() {
		vendingMachine.removeItem("D");
		vendingMachine.removeItem("D");
	}

	/**
	 * Tests that money is inserted corrected
	 */
	@Test
	public void insertMoney() {
		vendingMachine.insertMoney(10);
		assertEquals(10, vendingMachine.balance, 0.001);
	}

	/**
	 * Tests an exception is thrown if a wrong amount of momey is entered in this
	 * case (Negative).
	 */
	@Test(expected = VendingMachineException.class)
	public void testInsertWrongMoney() {
		vendingMachine.insertMoney(-10);
	}

	/**
	 * Tests the balance
	 */
	@Test
	public void testBalance() {
		vendingMachine.insertMoney(10);
		assertEquals(10, vendingMachine.balance, 0.001);
	}

	/**
	 * Tests that a purchase is made correctly
	 */
	@Test
	public void testMakePurchase() {
		vendingMachine.insertMoney(10);
		boolean purchaseX = vendingMachine.makePurchase("A");
		assertTrue(purchaseX);
	}

	/**
	 * Tests that a purchase is not made when there is no right balance present
	 */
	@Test
	public void testMakePurchaseNoMoney() {
		boolean purchaseX = vendingMachine.makePurchase("A");
		assertFalse(purchaseX);
	}

	/**
	 * Tests that an exception is thrown when an item from a wrong spot is selected
	 */
	@Test(expected = VendingMachineException.class)
	public void testMakePurchaseWrongSpot() {
		boolean purchaseX = vendingMachine.makePurchase("X");
		// assertFalse(purchaseX);
	}

	/**
	 * Tests that the change return is made correctly
	 */
	@Test
	public void testChange() {
		vendingMachine.insertMoney(10);
		vendingMachine.returnChange();
		assertEquals(0, vendingMachine.getBalance(), 0.001);
	}

}
