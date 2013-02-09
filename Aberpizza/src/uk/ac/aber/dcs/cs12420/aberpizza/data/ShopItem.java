/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * This class is implementing Item and contains methods for its details.
 */
public class ShopItem implements Item {

	BigDecimal price;
	String desc;

	/**
	 * Empty constructor for XML serialization
	 */
	public ShopItem() {

	}

	/**
	 * Main constructor of the class.
	 * 
	 * @param description
	 * @param price
	 */
	public ShopItem(String description, BigDecimal price) {
		this.desc = description;
		this.price = price;
	}

	/**
	 * Gets the price of the item.
	 * 
	 * @return BigDecimal price
	 */
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Gets the description of the item
	 * 
	 * @return String description
	 */
	@Override
	public String getDescription() {
		return desc;
	}

	/**
	 * Sets the price of the item
	 * 
	 * @param price
	 */
	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	/**
	 * Sets the description of the item
	 * @param description
	 */
	public void setDescription(String description) {
		this.desc = description;
	}

}
