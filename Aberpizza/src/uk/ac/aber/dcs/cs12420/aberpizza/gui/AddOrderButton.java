package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddOrderButton extends JButton implements ActionListener {
	/**
	 * This class is a button that is used to create a new customer and start
	 * the order.
	 */
	private static final long serialVersionUID = 1L;
	TopPanel panel;

	AddOrderButton(TopPanel topPanel) {
		panel = topPanel;
	}

	/**
	 * Sets the properties for the button look.
	 */
	public void add() {

		setForeground(Color.RED);
		setText("New Customer");
		this.addActionListener(this);
		this.setPreferredSize(new Dimension(140, 140));
	}

	@Override
	/**
	 * Adds a listener and a method to display an InputDialog for the name input and outputs it.
	 */
	public void actionPerformed(ActionEvent arg0) {
		String cname = null;

		do {
			cname = JOptionPane.showInputDialog("Enter customer name");
			if (cname == null) {
				return;
			}
			if (cname.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Enter name!");
			}
		} while (cname.equals(""));
		panel.addCustomer(cname);
		panel.switchButtons();

	}
}