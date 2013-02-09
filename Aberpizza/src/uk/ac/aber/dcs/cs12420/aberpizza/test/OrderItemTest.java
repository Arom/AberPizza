package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

/**
 * This test case test the OrderItem class.
 */
public class OrderItemTest {

	/**
	 * Tests the getQuantity(); method.
	 * Creates a new OrderItem object.
	 * Sets the item quantity to 1.
	 * Checks if the quantity is 1 through getQuantity(); method.
	 */
	@Test
	public void testGetQuantity() {
		OrderItem item = new OrderItem();
		item.setQuantity(1);
		assertEquals("Test returned false", 1, item.getQuantity());
	}
	/**
	 * Tests the getOrderItemTotal(); method.
	 * Creates new ShopItem object with description "Large" and price of 1.00.
	 * Creates new OrderItem object, adding ShopItem object and sets the quantity to 1.
	 * Checks if the price returned is "1.00" (Since the method calculates quantity x price 1x1.00 = 1.00) through the getOrderItemTotal();
	 */
	@Test
	public void testGetOrderItemTotal() {
		ShopItem pizza = new ShopItem("Large", new BigDecimal("1.00"));
		OrderItem item = new OrderItem(pizza, 1);
		assertEquals("Wrong item returned", new BigDecimal("1.00"),
				item.getOrderItemTotal());
	}
	/**
	 * Tests the getItem(); method.
	 * Creates new ShopItem object with description "Large" and price of 1.00
	 * Creates new OrderItem object adding pizza and sets its quantity to 1.
	 * Checks if the item returned is the ShopItem one created in the test using getItem();.
	 */
	@Test
	public void testGetItem() {
		ShopItem pizza = new ShopItem("Large", new BigDecimal("1.00"));
		OrderItem item = new OrderItem(pizza, 1);
		assertEquals("Item wasnt returned", pizza, item.getItem());
	}

}
