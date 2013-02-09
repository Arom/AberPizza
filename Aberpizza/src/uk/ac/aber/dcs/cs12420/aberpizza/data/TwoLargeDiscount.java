package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 
 * This class is for checking if a discount for two large pizzas apply and
 * return a BigDecimal for the calculation of the final subtotal.
 * 
 */
public class TwoLargeDiscount {
	Order order;
	BigDecimal discount = new BigDecimal("3.00");

	/**
	 * 
	 * @param order
	 */
	public TwoLargeDiscount(Order order) {
		this.order = order;
	}

	/**
	 * Checks if there are more than 1 Large pizza in the order and returns a
	 * BigDecimal with the amount.
	 * 
	 * @return BigDecimal discount
	 */
	public BigDecimal checkForDiscounts() {
		ArrayList<Item> discounts = new ArrayList<Item>();
		for (OrderItem o : order.getOrderItems()) {
			if (o.getItem().getDescription().contains("Large")) {
				for (int i = 0; i < o.getQuantity(); i++) {
					discounts.add(o.getItem());
				}
			}
		}
		if (discounts.size() < 2) {
			return new BigDecimal("0.00");
		}
		return discount;
	}

}
