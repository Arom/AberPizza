package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.GridLayout;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.ShopItem;

/**
 * This class is the menu that contains pizzas.
 */
public class PizzaChoiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	AddOrderPanel orderPanel;
	MainFrame frame;
	OrderItem item;

	public PizzaChoiceFrame(AddOrderPanel orderPanel, MainFrame frame) {
		this.frame = frame;
		this.orderPanel = orderPanel;
		ShopItemButton lCheese = new ShopItemButton(new ShopItem(
				"Large Cheese/Tomato", new BigDecimal("10.00")), orderPanel,
				frame);
		ShopItemButton mCheese = new ShopItemButton(new ShopItem(
				"Medium Cheese/Tomato", new BigDecimal("8.00")), orderPanel,
				frame);
		ShopItemButton sCheese = new ShopItemButton(new ShopItem(
				"Small Cheese/Tomato", new BigDecimal("5.00")), orderPanel,
				frame);
		ShopItemButton lPepperoni = new ShopItemButton(new ShopItem(
				"Large Pepperoni", new BigDecimal("12.00")), orderPanel, frame);
		ShopItemButton mPepperoni = new ShopItemButton(new ShopItem(
				"Medium Pepperoni", new BigDecimal("10.00")), orderPanel, frame);
		ShopItemButton sPepperoni = new ShopItemButton(new ShopItem(
				"Small Pepperoni", new BigDecimal("7.00")), orderPanel, frame);
		ShopItemButton lVegetarian = new ShopItemButton(new ShopItem(
				"Large Vegetarian", new BigDecimal("13.00")), orderPanel, frame);
		ShopItemButton mVegetarian = new ShopItemButton(new ShopItem(
				"Medium Vegetarian", new BigDecimal("11.00")), orderPanel,
				frame);
		ShopItemButton sVegetarian = new ShopItemButton(new ShopItem(
				"Small Vegetarian", new BigDecimal("8.00")), orderPanel, frame);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		add(panel);
		panel.add(lCheese);
		panel.add(lPepperoni);
		panel.add(lVegetarian);
		panel.add(mCheese);
		panel.add(mPepperoni);
		panel.add(mVegetarian);
		panel.add(sCheese);
		panel.add(sPepperoni);
		panel.add(sVegetarian);

		setVisible(true);
		setSize(600, 500);

	}
}
