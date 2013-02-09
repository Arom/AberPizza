package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.TwoLargeDiscount;
/**
 * This test case tests TwoLargeDiscount class.
 */
public class TwoLargeDiscountTest {
	/**
	 * This tests checkForDiscounts(); method
	 * New Order object is created.
	 * Two ShopItem objects are created.
	 * ShopItem objects are added to the OrderItem.
	 * OrderItem objects are added to the Order.
	 * New TwoLargeDiscount object is created.
	 * Checks if the value returned is "3.00" using checkForDiscounts(); method.
	 */
	@Test
	public void testCheckForDiscounts() {
		Order order = new Order();
		ShopItem pizza = new ShopItem("Large Pizza", new BigDecimal("1.00"));
		ShopItem pizza2 = new ShopItem("Large Pizza", new BigDecimal("1.00"));
		OrderItem pizzaItem = new OrderItem(pizza, 1);
		OrderItem drinkItem = new OrderItem(pizza2, 1);
		order.addItem(pizzaItem);
		order.addItem(drinkItem);
		TwoLargeDiscount discount = new TwoLargeDiscount(order);

		assertEquals("Discount wasn't applied", new BigDecimal("3.00"),
				discount.checkForDiscounts());
	}

}
