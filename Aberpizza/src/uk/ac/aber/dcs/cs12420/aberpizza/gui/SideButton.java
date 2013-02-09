package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * This class is the button that displays the side items choice frame.
 */
public class SideButton extends JButton {

	private static final long serialVersionUID = 1L;
	AddOrderPanel orderPanel;

	public SideButton(AddOrderPanel orderPanel) {
		this.orderPanel = orderPanel;

	}
	/**
	 * This method sets the properties of the button.
	 */
	public void add() {

		setForeground(Color.BLACK);
		setText("Sides");
		setBackground(Color.green);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SidesFrame frame = new SidesFrame(orderPanel,
						orderPanel.getMyMainFrameObject());
			}
		});
		this.setPreferredSize(new Dimension(140, 140));
	}

}
