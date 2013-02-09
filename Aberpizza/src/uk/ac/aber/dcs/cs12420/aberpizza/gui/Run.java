package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.Graphics2D;
import java.awt.SplashScreen;

/**
 * 
 * @author Christopher Krzysztof Ilkow(cki@aber.ac.uk)
 * @version 1.0 04/05/2012 Purpose: A till for Aber Pizza shop. Software
 *          Development assignment 2.
 * 
 *          This class creates an object of the MainFrame class, displaying a
 *          frame and starting the program.
 * @return Main program frame.
 */
public class Run {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		splash();
		@SuppressWarnings("unused")
		MainFrame frame = new MainFrame();
	}


	public static void splash(){   //Class to handle splash screen
		   final SplashScreen splash = SplashScreen.getSplashScreen();
	        if (splash == null) {
	            System.out.println("SplashScreen.getSplashScreen() returned null");  //if splash not found then display message
	            
	            return;
	        }
	        Graphics2D g = splash.createGraphics();
	        if (g == null) {
	            System.out.println("g is null");
	            return;
	        }
}
}
