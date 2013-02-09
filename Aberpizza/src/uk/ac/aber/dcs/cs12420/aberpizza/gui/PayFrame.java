package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * This class is the frame that is displayed when the Pay button is clicked.
 */
public class PayFrame extends JFrame implements CaretListener, ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel tender, change;
	JTextField t, c;
	JButton pay;
	JLabel x;
	RightPanel panel;

	public PayFrame(RightPanel panel) {

		this.panel = panel;
		this.setTitle("Payment");
		this.setSize(new Dimension(600, 500));
		this.setLayout(new GridLayout(3, 2));
		setVisible(true);
		tender = new JLabel("Tendered: ");
		tender.setFont(new Font("Helvetica", Font.BOLD, 40));
		change = new JLabel("Change");
		change.setFont(new Font("Helvetica", Font.BOLD, 40));
		t = new JTextField();
		t.setFont(new Font("Helvetica", Font.BOLD, 40));
		c = new JTextField();
		c.setFont(new Font("Helvetica", Font.BOLD, 40));
		c.setEditable(false);
		x = new JLabel();
		pay = new JButton("Pay");
		pay.addActionListener(this);
		t.addCaretListener(this);
		add(tender);
		add(t);
		add(change);
		add(c);
		add(x);
		add(pay);

	}
	/**
	 * Compares the tendered amount to the subtotal value.
	 * @return boolean
	 * @throws NumberFormatException
	 */
	public boolean comparePrice() throws NumberFormatException {
		BigDecimal tendered;
		BigDecimal price;
		tendered = new BigDecimal(t.getText());
		price = panel.getFrame().getCurrentOrder().getSubtotal();
		if (tendered.compareTo(price) == -1) {
			return false;
		} else
			return true;
	}

	@Override
	/**
	 * Enables and disables the pay button while comparing the tendered amount to the subtotal.
	 */
	public void caretUpdate(CaretEvent arg0) {
		try {
			if (comparePrice() == false) {
				pay.setEnabled(false);
				x.setText("Amount to be tendered is not high enough");
			} else {
				x.setText("");
				BigDecimal tendered;
				BigDecimal price;
				tendered = new BigDecimal(t.getText());
				price = panel.getFrame().getCurrentOrder().getSubtotal();
				c.setText(tendered.subtract(price).toString());
				pay.setEnabled(true);
			}
		} catch (NumberFormatException e) {
			pay.setEnabled(false);
		}

	}
	/**
	 * Generates the receipt shown after the pay button has been clicked, including the details of the order.
	 * @return
	 */
	public JPanel generateReceipt() {
		JPanel panel = new JPanel();
		JEditorPane pane = new JEditorPane("text/html", this.panel.getFrame()
				.getCurrentOrder().getReceipt());
		panel.add(pane);

		return panel;
	}

	@Override
	/**
	 * Creates a new order, enables buttons and resets the customer name.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Pay")) {
			panel.getFrame().getCurrentOrder().setDate(new Date());
			panel.getFrame().getCurrentOrder()
					.setTendered(new BigDecimal(t.getText()));
			JOptionPane.showMessageDialog(this, generateReceipt());
			panel.getFrame().getTill()
					.addOrder(panel.getFrame().getCurrentOrder());
			panel.getFrame().getOrderPanel().resetOrder();
			panel.getSub().setText("");
			panel.getPayButton().setEnabled(false);
			panel.getFrame().getTopPanel().disableButtons();

			dispose();

		}

	}
}
