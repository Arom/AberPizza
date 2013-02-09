package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

public class DrinkChoiceFrame extends JFrame {
	/**
	 * This class is the frame of the drink selection menu.
	 */
	private static final long serialVersionUID = 1L;
	JButton cola, sprite, water, orange;
	JPanel panel;
	Double cokecost = 0.99;
	AddOrderPanel orderPanel;

	public DrinkChoiceFrame(AddOrderPanel orderPanel) {
		this.orderPanel = orderPanel;
		setSize(600, 250);
		setVisible(true);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		cola = new ShopItemButton(new ShopItem("Coca Cola", new BigDecimal(
				"1.00")), orderPanel, orderPanel.getMyMainFrameObject());
		sprite = new ShopItemButton(new ShopItem("Sprite", new BigDecimal(
				"1.00")), orderPanel, orderPanel.getMyMainFrameObject());
		water = new ShopItemButton(
				new ShopItem("Water", new BigDecimal("1.00")), orderPanel,
				orderPanel.getMyMainFrameObject());
		orange = new ShopItemButton(new ShopItem("Orange Juice",
				new BigDecimal("1.00")), orderPanel,
				orderPanel.getMyMainFrameObject());
		add(panel);
		panel.add(cola);
		panel.add(sprite);
		panel.add(water);
		panel.add(orange);

	}
}
