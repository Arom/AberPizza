package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class is a Till class that contains methods to manipulate the orders.
 * 
 */
public class Till {
	ArrayList<Order> orders = new ArrayList<Order>();

	/**
	 * Till constructor creates a new order ArrayList.
	 */
	public Till() {
		orders = new ArrayList<Order>();
	}

	/**
	 * Adds an order to the array.
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * Returns a total price for the day.
	 * 
	 * @return BigDecimal - total for the day.
	 */
	public BigDecimal getTotalForDay() {
		BigDecimal total = new BigDecimal("0.00");
		for (Order o : orders) {
			total = total.add(o.getSubtotal());
		}
		return total;
	}

	/**
	 * This method saves the order to the order.xml file.
	 */
	public void save() {
		try {
			XMLBigDecimal encoder = new XMLBigDecimal(new BufferedOutputStream(
					new FileOutputStream("order.xml")));
			encoder.writeObject(orders);
			encoder.close();
		} catch (IOException e) {

		}
	}

	/**
	 * Loads the till from the order.xml file.
	 * 
	 * @return Reads the till from the order.xml file.
	 */
	@SuppressWarnings("unchecked")
	public static Till load() {

		Till till = new Till();
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
					new FileInputStream("order.xml")));
			till.orders = (ArrayList<Order>) decoder.readObject();
			decoder.close();
		} catch (IOException e) {

		}
		return till;
	}

	/**
	 * 
	 * @return ArrayList orders.
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * Method used only for the XML save/load requirements.
	 * 
	 * @param orders
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
