package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;

/**
 * This class is a main frame of the program called by the Run class.
 * 
 * @return Main application GUI.
 */
public class MainFrame extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	RightPanel rightPanel = new RightPanel(this);
	AddOrderPanel orderPanel = new AddOrderPanel(this);
	TopPanel topPanel = new TopPanel(orderPanel, this);
	Menu menu = new Menu(this);
	Order currentOrder = null;
	Till till = new Till();

	public MainFrame() {
		this.addWindowListener(this);
		this.setTitle("AberPizzaTill");
		setVisible(true);
		this.setSize(new Dimension(1180, 800));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.add(rightPanel);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(orderPanel, BorderLayout.WEST);
		this.setBackground(Color.yellow);
		this.setJMenuBar(menu);
		topPanel.switchButtons();
		till = Till.load();

	}

	/**
	 * @return Returns the current order for the day.
	 */
	public Order getCurrentOrder() {
		return currentOrder;
	}

	/**
	 * Sets current order
	 */
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	/**
	 * Updates the price as the items are added/removed.
	 * 
	 * @return Returns a string to the panel.
	 * 
	 */
	public void updatePrice() {
		rightPanel.getSub().setText("" + currentOrder.getSubtotal());
		rightPanel.getDis().setText("" + currentOrder.getDiscount());
		validate();
		repaint();
	}

	/**
	 * Returns current till object. 
	 * @return till
	 */
	public Till getTill() {
		return till;
	}
	/**
	 * For XML.
	 * @param till
	 */
	public void setTill(Till till) {
		this.till = till;
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 * Methods implemented for window listener.
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		till.save();
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * Returns order panel.
	 * @return OrderPanel
	 */
	public AddOrderPanel getOrderPanel() {
		return orderPanel;
	}
	/**
	 * Returns top panel.
	 * @return TopPanel
	 */
	public TopPanel getTopPanel() {
		return topPanel;
	}

}