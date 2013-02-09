package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This panel is the right panel of the frame, containing pay button and
 * subtotal/tendered labels.
 */
public class RightPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton payButton = new JButton();
	JLabel subtotal, disc;
	private JTextField sub, dis;
	MainFrame frame;

	public RightPanel(MainFrame frame) {
		this.frame = frame;
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(payButton, BorderLayout.EAST);
		payButton.setText("Pay");

		payButton.setFont(new Font("Helvetica", Font.BOLD, 50));
		payButton.setForeground(Color.red);
		payButton.addActionListener(this);
		setPreferredSize(new Dimension(100, 120));
		setBackground(Color.yellow);
		setLayout(new GridLayout(5, 2));
		subtotal = new JLabel("Subtotal: ");
		disc = new JLabel("Discount: ");
		sub = new JTextField();
		dis = new JTextField();
		add(disc);
		add(dis);
		dis.setHorizontalAlignment(SwingConstants.CENTER);
		subtotal.setFont(new Font("Helvetica", Font.BOLD, 50));
		disc.setHorizontalAlignment(SwingConstants.CENTER);
		disc.setFont(new Font("Helvetica", Font.BOLD, 50));
		dis.setEditable(false);
		dis.setFont(new Font("Helvetica", Font.BOLD, 50));
		dis.setSize(new Dimension(200, 50));
		add(subtotal);
		add(sub);
		subtotal.setHorizontalAlignment(SwingConstants.CENTER);
		sub.setHorizontalAlignment(SwingConstants.CENTER);
		sub.setFont(new Font("Helvetica", Font.BOLD, 50));
		sub.setEditable(false);
		sub.setSize(new Dimension(100, 50));

	}

	/**
	 * Gets the subtotal text field
	 * 
	 * @return JTextField sub
	 */
	public JTextField getSub() {
		return sub;
	}

	/**
	 * Gets the text field containing the discount value.
	 * 
	 * @return JTextField dis
	 */
	public JTextField getDis() {
		return dis;
	}

	@Override
	/**
	 * Displays the PayFrame
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Pay")) {

			@SuppressWarnings("unused")
			PayFrame framePay = new PayFrame(this);

		}

	}

	/**
	 * Gets the main frame
	 * 
	 * @return MainFrame
	 */
	public MainFrame getFrame() {
		return frame;
	}

	/**
	 * Gets the pay button
	 * 
	 * @return PayButton
	 */
	public JButton getPayButton() {
		return payButton;
	}

}
