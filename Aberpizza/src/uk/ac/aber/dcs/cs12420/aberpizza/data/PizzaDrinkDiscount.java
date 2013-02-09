package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * 
 * This class is used to check for the Pizza and a Drink discount in the order.
 * 
 */
public class PizzaDrinkDiscount {
	Order order;
	BigDecimal discount2 = new BigDecimal("1.00");

	/**
	 * 
	 * @param order
	 */
	public PizzaDrinkDiscount(Order order) {
		this.order = order;
	}

	/**
	 * A method that checks for a discount that applies to one Large pizza and
	 * any drink.
	 * 
	 * @return BigDecimal discount
	 */
	public BigDecimal checkForDiscounts() {
		boolean containsPizza = false;
		boolean containsDrink = false;

		for (OrderItem o : order.getOrderItems()) {
			if (o.getItem().getDescription().contains("Large")) {
				containsPizza = true;
			}
			if (o.getItem().getDescription().contains("Coca")
					|| o.getItem().getDescription().contains("Orange")
					|| o.getItem().getDescription().contains("Water")
					|| o.getItem().getDescription().contains("Sprite"))
				containsDrink = true;

		}
		if (!containsPizza || !containsDrink) {
			return new BigDecimal("0.00");

		}
		return discount2;
	}

}
