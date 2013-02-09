package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Item;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;

/**
 * This class is a button that is created for each item.
 */
public class ShopItemButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	Item item;
	AddOrderPanel orderPanel;
	MainFrame frame;

	public ShopItemButton(Item item, AddOrderPanel orderPanel, MainFrame frame) {
		this.frame = frame;
		this.item = item;
		this.orderPanel = orderPanel;

		this.setText(item.getDescription());

		this.addActionListener(this);
	}
	/**
	 * When the button is clicked, a new panel is created with the details of the item that was assigned to the button.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		OrderItem oi = new OrderItem(item, 1);
		orderPanel.addToArray(new OrderItemPanel(oi,frame));
		frame.getCurrentOrder().addItem(oi);
		frame.updatePrice();
		orderPanel.validate();

	}

}
