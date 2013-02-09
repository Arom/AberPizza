package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

/**
 * This test case I am testing the ShopItem class.
 */
public class ShopItemTest {
	/**
	 * This test tests get and setPrice(); methods.
	 * Creates new ShopItem object.
	 * Sets the item price to "1.00".
	 * Checks if method returns new BigDecimal("1.00") using getPrice();.
	 */
	@Test
	public void testGetPrice() {
		ShopItem item = new ShopItem("Pizza", new BigDecimal("0.99"));
		item.setPrice(new BigDecimal("1.00"));
		assertEquals("Wrong value returned", new BigDecimal("1.00"),
				item.getPrice());
	}
	/**
	 * This tests get and setDescription(); methods.
	 * Creates new ShopItem object.
	 * Sets the description to "BigPizza".
	 * Checks if the return String is "BigPizza" using getDescription(); method.
	 */
	@Test
	public void testGetDescription() {
		ShopItem item = new ShopItem("Pizza", new BigDecimal("0.99"));
		item.setDescription("BigPizza");
		assertEquals("Wrong String returned", "BigPizza", item.getDescription());
	}

}
