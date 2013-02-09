package uk.ac.aber.dcs.cs12420.aberpizza.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.PizzaDrinkDiscount;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;
/**
 * This test case test the pizza and drink discount.
 */
public class PizzaDrinkDiscountTest {
	/**
	 * This test checks if Large pizza+drink discount applies properly.
	 * Order object is created.
	 * Two ShopItem objects are created, large pizza and a drink.
	 * Two OrderItems are created for each ShopItem.
	 * OrderItems are added to the order.
	 * Creates new PizzaDrinkDiscount object and adds it to the order.
	 * Checks if the BigDecimal returned is "1.00" using checkForDiscount(); method.
	 */
	@Test
	public void testCheckForDiscounts() {
		Order order = new Order();
		ShopItem pizza = new ShopItem("Large", new BigDecimal("1.00"));
		ShopItem drink = new ShopItem("Sprite", new BigDecimal("1.00"));
		OrderItem pizzaItem = new OrderItem(pizza,1);
		OrderItem drinkItem = new OrderItem(drink,1);
		order.addItem(pizzaItem);
		order.addItem(drinkItem);
		PizzaDrinkDiscount discount = new PizzaDrinkDiscount(order);
		
		assertEquals("Discount wasn't applied", new BigDecimal("1.00"), discount.checkForDiscounts());
		
	}

}
