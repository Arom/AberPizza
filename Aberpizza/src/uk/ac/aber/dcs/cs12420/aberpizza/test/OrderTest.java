package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

/**
 * This test case tests Order class.
 * 
 */
public class OrderTest {
	/**
	 * This tests set and getCustomerName(); method. 
	 * Creates new Order object. 
	 * Sets customerName to "John". 
	 * Checks if the result of getCustomerName();
	 * is "John".
	 */
	@Test
	public void testSetCustomerName() {
		Order o = new Order();
		o.setCustomerName("John");
		assertEquals("Error", "John", o.getCustomerName());
	}
	/**
	 * This tests getReceipt(); method.
	 * Creates new Order object.
	 * Creates new StringBuilder object.
	 * Appends a string "Hello!".
	 * Checks if the String returned is "Hello!" using getReceipt(); method.
	 */
	public void testGetReceipt(){
		Order o  = new  Order();
		StringBuilder sb = new StringBuilder();
		sb.append("Hello!");
		assertEquals("Wrong strin returned", "Hello!", o.getReceipt());
	}

	/**
	 * This tests add and getItem(); method.
	 * Creates new Item object with description "Pizza" and price 0.99. 
	 * Creates new Order object. Adds Item to the order, and sets the quantity to 1.
	 * Checks if the item is returned using getItem(); method.
	 */
	@Test
	public void testAddItem() {
		Item item = new ShopItem("Pizza", new BigDecimal("0.99"));
		Order o = new Order();
		o.addItem(item, 1);
		assertEquals("Error", item, o.getOrderItems().get(0).getItem());

	}

	/**
	 * Tests updateItemQuantity(); method 
	 * Creates new Item object with description "Pizza" and price 0.99. 
	 * Creates new Order object. Adds Item to the object with quantity 1. 
	 * Updates the Item quantity to 2. Checks if the quantity is 2 through getQuantity();
	 */
	@Test
	public void testUpdateItemQuantity() {
		Item item = new ShopItem("Pizza", new BigDecimal("0.99"));
		Order o = new Order();
		o.addItem(item, 1);
		o.updateItemQuantity(item, 2);
		assertEquals("Error", 2, o.getOrderItems().get(0).getQuantity());
	}

	/**
	 * This tests getSubtotal(); method. 
	 * Creates new Item object with description "Pizza" and price 1.00. 
	 * Creates new order object. Adds two objects of Item to the order, one with quantity 1 and another with 3.
	 * Price returned should be 4.00 Checks if the price is 4.00 using
	 * getSubtotal();
	 */
	@Test
	public void testGetSubtotal() {
		Item item = new ShopItem("Pizza", new BigDecimal("1.00"));

		Order o = new Order();
		o.addItem(item, 1);
		o.addItem(item, 3);
		assertEquals("Error", new BigDecimal("4.00"), o.getSubtotal());
	}
	/**
	 * Tests the set and getDate();
	 *  Creates new Order object. Sets orders date.
	 * Checks if the date returned is one created through getDate(); method.
	 */
	@Test
	public void testGetDate() {
		Date compare = new Date();
		Order o = new Order();
		o.setDate(compare);
		assertEquals("Error", compare, o.getDate());
	}

	/**
	 * Tests set and getOrderItems.
	 * Creates new Order object.
	 * Creates new ArrayList.
	 * Creates new ShopItem
	 * Creates new OrderItem with ShopItem.
	 * Adds OrderItem to the array.
	 * Adds array to the order.
	 * Checks if the array is returned using getOrderItems();
	 */
	@Test
	public void testGetOrderItems() {
		Order o = new Order();
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		ShopItem pizza = new ShopItem("Large", new BigDecimal("1.00"));
		OrderItem i = new OrderItem(pizza,1);
		orderItems.add(i);
		o.setOrderItems(orderItems);
		assertEquals("Wrong return", orderItems, o.getOrderItems());
	}

}
