/**
 * @(#)DeckOfCardsMain.java
 *
 * DeckOfCardsMain application
 *
 * @author 
 * @version 1.00 2014/10/14
 */

import javax.swing.JFrame;

public class DeckOfCardsMain extends JFrame  
{
    
    public static void main(String[] args) 
    {
    	
    	Welcome displayWelcome = new Welcome();
    	displayWelcome.setVisible(true);
    	displayWelcome.setSize(250, 250);
    	displayWelcome.setResizable(false);
    	displayWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    	displayWelcome.setLocationRelativeTo(null);	
    }
}

