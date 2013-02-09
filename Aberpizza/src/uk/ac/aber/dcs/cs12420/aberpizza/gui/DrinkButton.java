package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This class is a button that opens up a drink selection menu.
 */
public class DrinkButton extends JButton {

	private static final long serialVersionUID = 1L;
	AddOrderPanel orderPanel;

	public DrinkButton(AddOrderPanel orderPanel) {
		this.orderPanel = orderPanel;
	}
	/**
	 * Sets button properties.
	 */
	public void add() {
		setForeground(Color.BLACK);
		setText("Drinks");
		setBackground(Color.green);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				DrinkChoiceFrame frame = new DrinkChoiceFrame(orderPanel);
			}
		});
		this.setPreferredSize(new Dimension(140, 140));
	}
}
