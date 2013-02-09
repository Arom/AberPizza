package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

/**
 * This class returns a order history frame loading the XML file and showing all
 * the orders by date.
 * 
 */
public class OrderHistoryFrame extends JFrame implements ActionListener {
	Date displayedDate = new Date();

	private static final long serialVersionUID = 1L;
	JEditorPane pane;
	JPanel panel, orderPanel;
	JScrollPane scroll;
	MainFrame frame;
	JLabel totalForDay, totalOrders;
	JButton show, previous, next;

	public OrderHistoryFrame(MainFrame frame) {

		this.frame = frame;
		setSize(new Dimension(650, 850));
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		totalForDay = new JLabel(
				"Total for this day:                           "
						+ frame.getTill().getTotalForDay().toString());
		totalOrders = new JLabel("Total orders for this day:                  "
				+ frame.getTill().getOrders().size());
		totalForDay.setFont(new Font("Helvetica", Font.BOLD, 30));
		totalOrders.setFont(new Font("Helvetica", Font.BOLD, 30));
		show = new JButton("Show Today");
		previous = new JButton("Previous");
		next = new JButton("Next");
		next.addActionListener(this);

		pane = new JEditorPane("text/html", loadHistory(new Date()));
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));

		panel.add(totalForDay);
		panel.add(totalOrders);
		panel.add(show);
		panel.add(previous);
		panel.add(next);
		previous.addActionListener(this);
		show.addActionListener(this);
		scroll = new JScrollPane(pane);
		pane.setEditable(false);
		scroll.setPreferredSize(new Dimension(0, 600));
		add(panel, BorderLayout.NORTH);
		add(scroll, BorderLayout.SOUTH);

	}

	@SuppressWarnings("deprecation")
	/**
	 * Loads the order history for the given date.
	 * @param date
	 * @return HTML string
	 */
	public String loadHistory(Date date) {
		ArrayList<Order> orderList = new ArrayList<Order>();

		for (Order o : frame.getTill().getOrders()) {
			if (o.getDate().getYear() == date.getYear()
					&& o.getDate().getMonth() == date.getMonth()
					&& o.getDate().getDate() == date.getDate()) {
				orderList.add(o);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Order o : orderList) {
			sb.append(o.getReceipt() + "</br>");
		}
		return sb.toString();

	}

	@Override
	/**
	 * Action listeners for buttons, allowing to show previous/next/current day order history.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Previous")) {
			displayedDate
					.setTime(displayedDate.getTime() - 1000 * 60 * 60 * 24);
			pane.setText(loadHistory(displayedDate));

		} else if (arg0.getActionCommand().equals("Next")) {
			displayedDate
					.setTime(displayedDate.getTime() + 1000 * 60 * 60 * 24);
			pane.setText(loadHistory(displayedDate));
		} else if (arg0.getActionCommand().equals("Show Today")) {
			pane.setText(loadHistory(new Date()));
		}

	}

}
