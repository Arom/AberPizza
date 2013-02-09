package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;

public class OrderItemPanel extends JPanel implements ActionListener {
	/**
	 * This class is the panel in which the item details and buttons are located
	 * once the item is added to the order.
	 */
	private static final long serialVersionUID = 1L;
	JLabel desc, q, price;
	JButton incr, decr;
	OrderItem item;
	MainFrame frame;

	public OrderItemPanel(OrderItem item, MainFrame frame) {
		this.frame = frame;
		this.item = item;
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(0, 5));
		q = new JLabel("Quantity : " + item.getQuantity());
		desc = new JLabel(item.getItem().getDescription());
		price = new JLabel("£ " + item.getItem().getPrice());
		decr = new JButton("-");
		incr = new JButton("+");
		this.setPreferredSize(new Dimension(895, 50));
		add(desc);
		add(q);
		add(price);
		add(decr);
		add(incr);
		decr.addActionListener(this);
		incr.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("+")) {
			item.setQuantity(item.getQuantity() + 1);

		}
		if (e.getActionCommand().equals("-")) {
			item.setQuantity(item.getQuantity() - 1);
			if (item.getQuantity() == 0) {
				AddOrderPanel op = (AddOrderPanel) this.getParent();
				frame.getCurrentOrder().getOrderItems().remove(item);
				op.checkItems();
			}
		}
		frame.updatePrice();
		q.setText("Quantity : " + item.getQuantity());
		this.validate();
		this.repaint();

	}

	/**
	 * Gets the current item
	 * 
	 * @return item
	 */
	public OrderItem getItem() {
		return item;
	}
}
