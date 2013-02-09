/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class holds the methods used by the current order.
 * 
 */
public class Order {
	private Date date;
	private String customerName;
	private BigDecimal tendered;

	ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

	/**
	 * Order constructor for XML serialization.
	 */
	public Order() {

	}

	/**
	 * Method sets the customer name.
	 * 
	 * @param name
	 */
	public void setCustomerName(String name) {
		customerName = name;
	}

	/**
	 * Returns a string with a customer name.
	 * 
	 * @return returns customer name String
	 */

	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Creates an item, requires for a certain item and its quantity.
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addItem(Item item, int quantity) {
		orderItems.add(new OrderItem(item, quantity));
	}

	/**
	 * Adds an item to the order created in addItem(item,quantity) method.
	 * 
	 * @param item
	 */

	public void addItem(OrderItem item) {
		orderItems.add(item);
	}

	/**
	 * Updates the quantity of the item.
	 * 
	 * @param item
	 * @param quantity
	 */
	public void updateItemQuantity(Item item, int quantity) {
		for (OrderItem o : orderItems) {
			if (o.getItem().getDescription() == item.getDescription()) {
				o.setQuantity(quantity);
			}
		}
	}

	/**
	 * Calculates the Subtotal for the order.
	 * 
	 * @return Decimal sub
	 */
	public BigDecimal getSubtotal() {
		BigDecimal sub = new BigDecimal("0.00");
		for (int i = 0; i < orderItems.size(); i++) {
			sub = sub.add(orderItems.get(i).getOrderItemTotal());
		}

		return sub.subtract(getDiscount());
	}

	/**
	 * Gets a amount to be discounted.
	 * 
	 * @return BigDecimal discount
	 */	
	/*
	 * Creates instances of discounts and variables then checks for each in the order and returns a value.
	 */
	public BigDecimal getDiscount() {
		BigDecimal discount = new BigDecimal("0.00");
		BigDecimal discount2 = new BigDecimal("0.00");
		TwoLargeDiscount disc = new TwoLargeDiscount(this);
		PizzaDrinkDiscount disc2 = new PizzaDrinkDiscount(this);
		discount = discount.add(disc.checkForDiscounts());
		discount2 = discount2.add(disc2.checkForDiscounts());

		return (discount.compareTo(discount2) == 1) ? discount : discount2;

	}

	/**
	 * Prints out the receipt with the order details.
	 * 
	 * @return String receipt.
	 */
	/*
	 * I have used StringBuilder for this method because it is more suitable for appending larger Strings.
	 */
	public String getReceipt() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table align=\"center\", width=\"340\"><tr><td><font size=\"5\", text-align=\"center\"> Aber Pizza </font></td></tr><br/><tr><td><font size =\"5\", align=\"center\"> 25 Example Street</font></td></tr><br /><tr><td><font size = \"5\", align=\"center\"> SY23 1EX </font></td></tr></table><table align=\"center\", width=\"340\"><tr><td> Till 1 </td></tr><br /><tr><td> Example Cashier Name</td></tr><td>"
				+ this.customerName
				+ "</td><br /><tr><td align=\"center\">*******************************</tr></td></table>");
		sb.append("<table align=\"center\", width=\"340\">");
		for (OrderItem o : orderItems) {
			sb.append("<tr><td>" + o.getQuantity() + "</td><td>"
					+ o.getItem().getDescription() + " </td><td >"
					+ o.getOrderItemTotal() + "</td></tr>");
		}
		sb.append("</table>");
		sb.append("<table align=\"center\", wdith=\"340\"><tr><td>*******************************</tr></td></table>");
		sb.append("<table align=\"center\", width=\"340\">");
		sb.append("<tr><td align=\"right\">Subtotal:  </td><td align=\"right\">"
				+ getSubtotal().add(getDiscount()) + " </td></tr>");
		sb.append("<tr> <td align=\"right\"> Discount: </td> <td align=\"right\">"
				+ getDiscount() + "</td></tr>");
		sb.append("<tr> <td align=\"right\"> Total to Pay : </td> <td align=\"right\">"
				+ getSubtotal() + " </td></tr>");
		sb.append("<tr> <td align=\"right\"> Tendered:<td align=\"right\">"
				+ tendered + " </td></tr>");
		sb.append("<tr> <td align=\"right\"> Change: <td align=\"right\">"
				+ tendered.subtract(getSubtotal()) + "</td></tr>");
		sb.append("</table><p align=\"center\"> Thank you for your money!</p>");
		return sb.toString();
	}

	/**
	 * Gets the date
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns all the order items from the ArrayList
	 * 
	 * @return ArrayList with OrderItems.
	 */
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * Sets the OrderItem, method for XML serialization. Not implemented in the
	 * code.
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * Gets the tendered amount. Not used, required by XML.
	 * 
	 * @return BigDecimal tendered.
	 */
	public BigDecimal getTendered() {
		return tendered;
	}

	/**
	 * Sets the tendered amount.
	 * 
	 * @param tendered
	 */
	public void setTendered(BigDecimal tendered) {
		this.tendered = tendered.add(new BigDecimal("0.00"));

	}

}
