/**
 * @(#)Welcome.java
 *
 *
 * @author 
 * @version 1.00 2014/10/14
 */

//importing swing classes
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

//importing awt classes
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener
{
	//instatiating JButton Variables
    private JButton playButton;
    private JButton closeButton;
    	
    //instatiating JLabel Variables
    private JLabel backgroundLabel;

    public Welcome() 
    {
    	
    	super ("Welcome");
    	
    	setLayout(null);
    	setDesign ();
    	
    	//Creating and adding the playButton on the Frame
    	playButton = new JButton ("Play");
    	add (playButton);
    	playButton.setBounds(75, 120, 100, 20);
    	
    	//Creating and adding the ExitButton on the Frame
    	closeButton = new JButton ("Close");
    	add (closeButton);
    	closeButton.setBounds(75, 148, 100, 20);
    	
    	//Creating and adding an Image as the Background
    	Icon pic = new ImageIcon (getClass().getResource("Poker4.jpg"));
   		backgroundLabel = new JLabel (pic);
   		add (backgroundLabel);
    	backgroundLabel.setBounds(0, 0, 250, 250);
    	
    	//Creating a buttonHandler
    	playButton.addActionListener(this);
    	closeButton.addActionListener(this);
    	
    }
    public void actionPerformed (ActionEvent event)
    {
    	if (event.getSource() == playButton)
    	{
    		//Creating an Object of PokerGame Class
    		PokerGame displayPokerGame = new PokerGame ();
    		
    		displayPokerGame.setVisible(true);
    		displayPokerGame.setResizable(false);
    		displayPokerGame.setSize(1000,730);
    		displayPokerGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		displayPokerGame.setLocationRelativeTo(null);
    		
    		dispose();//Disposes of the welcome Class
    	}
    	else if (event.getSource() == closeButton)
    	{
    		String message = String.format("       Please Come Again!");
			JOptionPane.showMessageDialog(null,message);
			System.exit(0);
    	}
    }
    
    
    public void setDesign ()
	{
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	
				
			//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		}
			catch (Exception e)
		{
			
		}
	}
    
    
}