/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * 
 * This class is an OrderItem object that is added to the Order ArrayList.
 */

public class OrderItem {
	private int quantity;
	Item item;

	/**
	 * Empty constructor, not implemented, used for XML serialization.
	 */
	public OrderItem() {

	}

	/**
	 * OrderItem constructor.
	 * 
	 * @param item
	 * @param quantity
	 */
	public OrderItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Gets the quantity.
	 * 
	 * @return int quantity.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Gets the total for the item, multiplies item price by its quantity.
	 * 
	 * @return BigDecimal total
	 */
	public BigDecimal getOrderItemTotal() {
		BigDecimal total = item.getPrice().multiply(new BigDecimal(quantity));
		return total;
	}

	/**
	 * Gets the item.
	 * 
	 * @return Item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the quantity of the item
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method for XML serialization.
	 * 
	 * @param item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

}
