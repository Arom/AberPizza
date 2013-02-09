package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;
/**
 * This test case tests Till(); class
 */
public class TillTest {
	/**
	 * This tests for total for each day.
	 * New Till object is created.
	 * New Order object is created.
	 * New ShopItem object is created.
	 * New OrderItem is created with ShopItem added to it.
	 * OrderItem is added to the Order.
	 * Order is added to the Till.
	 * Checks if the return is "1.00" using getTotalForDay(); method.
	 */
	@Test
	public void testGetTotalForDay() {
		Till till = new Till();
		Order order = new Order();
		ShopItem pizza = new ShopItem("Large", new BigDecimal("1.00"));
		OrderItem item = new OrderItem(pizza, 1);
		order.addItem(item);
		till.addOrder(order);
		assertEquals("Wrong value returned", new BigDecimal("1.00"), till.getTotalForDay());
	}
	/**
	 * This tests set and getOrders(); methods.
	 * New ArrayList is created.
	 * New Till object is created.
	 * Array is added to the Till orders.
	 * Checks if the array is returned using getOrders(); method.
	 */
	@Test
	public void testSetOrders() {
		ArrayList<Order> array = new ArrayList<Order>();
		Till till = new Till();
		till.setOrders(array);
		assertEquals("Wrong array returned", array, till.getOrders());
	}

}
