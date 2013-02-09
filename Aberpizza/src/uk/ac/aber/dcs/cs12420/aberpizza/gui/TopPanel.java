
package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
/**
 * This is the top panel of the main frame, holding buttons for menu selection and adding a new customer, as well as displaying the customer name.
 */
public class TopPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	AddOrderButton addOrder;
    PizzaButton addPizza ;
    DrinkButton addDrink ;;
    SideButton addSide ;
    JLabel customer;
    MainFrame frame;
    
    TopPanel(AddOrderPanel orderPanel,MainFrame frame){
    	this.frame = frame;
    	addPizza = new PizzaButton(orderPanel);
    	addDrink = new DrinkButton(orderPanel);
    	addSide = new SideButton(orderPanel);
    	addOrder = new AddOrderButton(this);
      this.setPreferredSize(new Dimension(200,150));
        customer = new JLabel("Customer Name: ");   
        customer.setFont(new Font("Helvetica",Font.BOLD,30));
        customer.setForeground(Color.white);
        this.setBackground(Color.gray);
       addPizza.add();
       add(addPizza);
        addDrink.add();
        this.add(addDrink);
        addSide.add();
        add(addSide);
        addOrder.add();    
        this.add(addOrder);
        add(customer);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
              
        
    }
    /**
     * Method to disable the top buttons.
     */
    public void disableButtons(){
    	addPizza.setEnabled(false);
		addDrink.setEnabled(false);
		addSide.setEnabled(false);
		frame.rightPanel.payButton.setEnabled(false);

    }
    /**
     * Turns buttons on and off when the order is null.
     */
    public void switchButtons(){
    	
    	if(frame.getCurrentOrder()==null){
    		addPizza.setEnabled(false);
    		addDrink.setEnabled(false);
    		addSide.setEnabled(false);
    		frame.rightPanel.payButton.setEnabled(false);
    
    	}else{
    		addPizza.setEnabled(true);
    		addDrink.setEnabled(true);
    		addSide.setEnabled(true);
    		frame.rightPanel.payButton.setEnabled(true);
    	}
    }
    /**
     * Adds a customer name to the order and the label.
     * @param name
     */
    public void addCustomer(String name){
    	customer.setText("Customer Name: "+name);
    	frame.setCurrentOrder(new Order());
    	frame.getCurrentOrder().setCustomerName(customer.getText());
    }
    /**
     * Returns customer JLabel
     * @return JLabel customer
     */
	public JLabel getCustomer() {
		return customer;
	}
}
