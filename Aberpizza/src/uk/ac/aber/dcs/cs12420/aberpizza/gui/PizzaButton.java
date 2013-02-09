package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This class is a button that is used to display pizza choice menu.
 */
public class PizzaButton extends JButton {

	private static final long serialVersionUID = 1L;
	AddOrderPanel orderPanel;

	public PizzaButton(AddOrderPanel orderPanel) {
		this.orderPanel = orderPanel;
	}

	/**
	 * Sets the properties of the button.
	 */
	public void add() {
		setForeground(Color.BLACK);
		setText("Pizza");
		setBackground(Color.green);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				PizzaChoiceFrame frame = new PizzaChoiceFrame(orderPanel,
						orderPanel.getMyMainFrameObject());
			}
		});
		this.setPreferredSize(new Dimension(140, 140));

	}

}
