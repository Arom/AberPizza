package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * This class implements a menu for the main frame.
 */
public class Menu extends JMenuBar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JMenu file, admin;
	JMenuItem quit, orderHistory;
	MainFrame frame;
	public	Menu(MainFrame frame){
		this.frame = frame;
		file = new JMenu("File");
		admin = new JMenu("Admin");
		quit = new JMenuItem("Quit");
		orderHistory = new JMenuItem("Order History");
		add(file);
		file.add(quit);
		add(admin);
		admin.add(orderHistory);
		quit.addActionListener(this);
		orderHistory.addActionListener(this);
		
		
		
	}
	@Override
	/**
	 * Quit quits the program.
	 * Order history opens up a OrderHistoryFrame.
	 */
	public void actionPerformed(ActionEvent arg0) {
	if(arg0.getActionCommand().equals("Quit")){
		frame.getTill().save();
		System.exit(0);
	}
	if(arg0.getActionCommand().equals("Order History")){
		@SuppressWarnings("unused")
		OrderHistoryFrame frame = new OrderHistoryFrame(this.frame);
	}
		
	}
}
