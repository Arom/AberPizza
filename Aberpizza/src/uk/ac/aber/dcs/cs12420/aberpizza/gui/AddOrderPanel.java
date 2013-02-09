package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AddOrderPanel extends JPanel {

	/**
	 * This class is the panel to which the orders are added for display.
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame myMainFrameObject;

	ArrayList<OrderItemPanel> orderItemPanels = new ArrayList<OrderItemPanel>();

	public AddOrderPanel(MainFrame theMainFr) {
		myMainFrameObject = theMainFr;
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		setPreferredSize(new Dimension(900, 0));
	}

	/**
	 * Adds a panel that holds item details to the array
	 * 
	 * @param panel
	 */
	public void addToArray(OrderItemPanel panel) {
		orderItemPanels.add(panel);
		this.add(panel);
	}

	/**
	 * Refreshes panels so that whenever one is removed, they are re-organised
	 * and shown one after another without gaps in between.
	 */
	public void checkItems() {
		for (OrderItemPanel o : orderItemPanels) {
			if (o.getItem().getQuantity() == 0) {
				myMainFrameObject.getCurrentOrder().getOrderItems().remove(o);
				orderItemPanels.remove(o);
				this.removeAll();

				for (OrderItemPanel i : orderItemPanels) {
					this.add(i);

				}

				repaint();
				validate();
				break;

			}
		}
	}

	/**
	 * 
	 * @return MainFrame object.
	 */
	public MainFrame getMyMainFrameObject() {
		return myMainFrameObject;
	}
	
	/**
	 * Sets a new order after the transaction has been completed.
	 */
	public void resetOrder() {
		orderItemPanels = new ArrayList<OrderItemPanel>();
		this.removeAll();
		myMainFrameObject.getTopPanel().getCustomer().setText("");
		validate();
		repaint();
	}

}