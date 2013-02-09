package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

/**
 * This is the frame that holds all side items.
 */
public class SidesFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	ShopItemButton ribs, chips, nuggets, garlicBread;
	JPanel panel;
	AddOrderPanel orderPanel;
	MainFrame frame;

	public SidesFrame(AddOrderPanel orderPanel, MainFrame frame) {

		this.frame = frame;
		this.orderPanel = orderPanel;

		JPanel panel = new JPanel();
		ribs = new ShopItemButton(new ShopItem("Ribs", new BigDecimal("2.00")),
				orderPanel, frame);
		chips = new ShopItemButton(
				new ShopItem("Chips", new BigDecimal("1.50")), orderPanel,
				frame);
		nuggets = new ShopItemButton(new ShopItem("Nuggets", new BigDecimal(
				"2.50")), orderPanel, frame);
		garlicBread = new ShopItemButton(new ShopItem("Garlic Bread",
				new BigDecimal("4.00")), orderPanel, frame);
		setSize(650, 250);
		this.setVisible(true);
		add(panel);
		panel.setLayout(new GridLayout(2, 2));
		panel.add(ribs);
		panel.add(chips);
		panel.add(nuggets);
		panel.add(garlicBread);

	}
}
