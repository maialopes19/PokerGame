/**
 * @(#)PokerGame.java
 *
 *
 * @author 
 * @version 1.00 2014/10/14
 */
 
//importing lang classes
import java.lang.Boolean; 
import java.lang.Enum;

//importing util classes
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

//importing swing classes
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

//importing awt classes
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokerGame extends JFrame implements ActionListener
{
	//Instantiating Variables
	private int p1Points = 0;
	private int CPPoints = 0;
	protected String name;
	 
	//instatiating JPanel variables
	private JPanel titlePanel;
	private JPanel buttonsPanel;
	public JPanel player1Panel;
	private JPanel CPUPanel;
	private JPanel p1PointsPanel;
	private JPanel CPPointsPanel; //CP - Computer
	
	//instatiating JButton variables
	private JButton shuffleButton;
	private JButton dealButton;
	private JButton compareButton;
	private JButton playAgainButton;
	private JButton closeButton;
	private JButton showHand1;
	
	//instatiating JLabel variabels
	private JLabel player1Points;
	private JLabel CPPointsLabel;
	private JLabel backgroundLabel;
	private JLabel background2Label;
	private JLabel playerShowCard01;

	//Card array for backCards
	public JLabel [] cards = new JLabel[10];
	
	//instatiating the DeckofCards Class
	DeckofCards myDeck;

	
    public PokerGame() 
    {
    //--------------------------------------------------GUI CONSTRUCTION----------------------------------------------------//
    	super ("Poker Game");
     	
     	setDesign ();	// Using the Windows Touch and feel   	
    	
    	setLayout (null); // setting up the expicit layout
    	
		//Creating an Input name for the player
        name = JOptionPane.showInputDialog("Please insert your name");
        //if the cancel button is pressed then it should exit
        if (name == null)
        {
        	String closeMessage = String.format("       Please Come Again!");
			JOptionPane.showMessageDialog(null,closeMessage);
			System.exit(0);
        }

        //=====================================================Creating and addint the panels=================================================================
    	
    	//Creating and adding the Player1 Panel 
    	player1Panel = new JPanel (new GridLayout (1,4));
    	add(player1Panel);
    	TitledBorder player1Border = BorderFactory.createTitledBorder(name); //Creating a title border for the panel
    	player1Border.setTitleColor(Color.WHITE);//Setting up the color for the font on the panel to white
    	player1Panel.setBounds(1,1,799,250);
    	player1Panel.setBorder(player1Border);
    	player1Panel.setBackground(Color.BLACK);
    	
    	//creating and adding the Computer Panel 
    	CPUPanel = new JPanel (new GridLayout (1,4));
    	add (CPUPanel);
    	CPUPanel.setBounds(1,440,799, 250);
    	TitledBorder CPUBorder = BorderFactory.createTitledBorder("CPU");//Creating a title border for the panel
    	CPUPanel.setBorder(CPUBorder);
    	CPUBorder.setTitleColor(Color.WHITE);//Setting up the color for the font on the panel to white
    	CPUPanel.setBackground(Color.BLACK);
    	
    	//creating and adding the p1PointsPanel 
    	p1PointsPanel = new JPanel(new GridLayout (1,1));
    	p1PointsPanel.setBounds (810, 1, 160, 120 );
    	add (p1PointsPanel);
    	p1PointsPanel.setBorder(player1Border);
    	player1Border.setTitleColor(Color.WHITE);//Setting up the color for the font on the panel to white
    	p1PointsPanel.setBackground(Color.black);
    	p1PointsPanel.setForeground(Color.WHITE);
    	
    	//creating and adding the p2PointsPanel 
    	CPPointsPanel = new JPanel(new GridLayout (1,1));
    	CPPointsPanel.setBounds (810,568, 160, 120 );
    	add (CPPointsPanel);
    	CPPointsPanel.setBorder(CPUBorder);
    	CPUBorder.setTitleColor(Color.WHITE);//Setting up the color for the font on the panel to white
    	CPPointsPanel.setBackground(Color.black);
    	CPPointsPanel.setForeground(Color.WHITE);
    	
    	//==========================================================Creating and Adding the Buttons===========================================================
    	
    	//Creating and adding the shuffleButton to the buttonPanel
    	shuffleButton = new JButton ("Shuffle");
    	shuffleButton.setBounds(815, 256, 150, 30);
    	add(shuffleButton);
    	
    	//Creating and adding the dealButton to the buttonPanel
    	dealButton = new JButton ("Deal");
    	dealButton.setBounds(815, 294, 150,30);
    	add(dealButton);
    	
    	//Creating and adding the compareButton to the buttonPanel
    	compareButton = new JButton ("Compare");
    	compareButton.setBounds(815, 332, 150, 30);
    	add(compareButton);
    	
    	//Creating and adding the clearButton to the buttonPanel
    	playAgainButton = new JButton ("Play Again");
    	playAgainButton.setBounds(815, 370, 150, 30);
    	add(playAgainButton);
    	
    	//Creating and adding the closeButton to the buttonPanel
    	closeButton = new JButton ("Exit");
    	closeButton.setBounds(815, 408, 150, 30);
    	add(closeButton);
    	
    	//Creating and adding the showHand1 Button
    	showHand1 = new JButton ("Show Hand");
    	showHand1.setBounds(815, 125, 150, 30);
    	add(showHand1);

    		
    	//==========================================================Creating and adding the Labels=========================================================
    	
    	//creating and adding the player1Label in the p1PointsPanel
    	player1Points = new JLabel("Points",JLabel.CENTER);
    	p1PointsPanel.add(player1Points);
    	player1Points.setForeground(Color.WHITE);
    	
    	//creating and adding the player2Label in the p2PointsPanel
    	CPPointsLabel = new JLabel("Points",JLabel.CENTER);
    	CPPointsPanel.add(CPPointsLabel);
    	CPPointsLabel.setForeground(Color.WHITE);
   		
   		//Creating and adding an Image as the Background
   		Icon pic = new ImageIcon (getClass().getResource("Poker.jpg"));
   		backgroundLabel = new JLabel (pic);
   		add (backgroundLabel);
    	backgroundLabel.setBounds(0,50, 800, 730);
    	
    	//Creating and adding an Image as the Background
    	Icon pic2 = new ImageIcon (getClass().getResource("Poker2.jpg"));
    	background2Label = new JLabel(pic2);
    	add (background2Label);
    	background2Label.setBounds(0,1,1000,730);
    	
    	//----------------------------------------IMPLEMENTATION OF THE ALGORITHM----------------------------------------------------------------//
    	
    	//Creating classes object
    	myDeck = new DeckofCards();
    	
    	CardFace face;
    	
    	//Disable the Deal, Compare and PlayAgain Button
    	shuffleButton.setEnabled(true);
		dealButton.setEnabled(false);
		showHand1.setEnabled(false);
		compareButton.setEnabled(false);
		playAgainButton.setEnabled(false);
		closeButton.setEnabled(true);
		
    	
    //	ButtonHandler handler = new ButtonHandler();
    	
    	shuffleButton.addActionListener(this);
    	dealButton.addActionListener(this);
    	compareButton.addActionListener(this);
    	playAgainButton.addActionListener(this);
    	showHand1.addActionListener(this);
    	closeButton.addActionListener(this);
    	
    }
    //====================================================Implementation of the Comparison Method===============================================================
    public final int compareTo (CardFace o)
   	{
   		//It will check wich hand is better between 2 hands with one Pair
   		if (myDeck.isOnePair() == true && myDeck.isOnePair2() == true)
   		{
   			for (int i = 0; i < 5; i++)
   			{
   				for (int x = i + 1; x < 5; x++)
   				{
   					if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(x).getCardFace())
   					{
   						for (int b = 5; b < 10; b++)
   						{
   							if (o == myDeck.getDeckofCards().get(b).getCardFace())
   							{	
   								if (myDeck.getDeckofCards().get(i).getCardFace().compareTo (o) < 0)
   									return 1;
   									
   									else if ( myDeck.getDeckofCards().get(i).getCardFace().compareTo(o) == 0)
   										return 0;
   									
   									else if (myDeck.getDeckofCards().get(i).getCardFace().compareTo(o) > 0)
   										return -1;
   							}
   						}
   					}
   				}
   			}
   				
   		}
   		//It will check wich hand is better between 2 hands with two Pairs
   		else if (myDeck.isTwoPair() == true && myDeck.isTwoPair2() == true)
   		{
   		
   			int pair = 0;
   			for (int a = 0; a <5; a++ )
   			{
   				for (int b =1 + a ; b <5; b++ )
   				{
   					if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(b).getCardFace())
   					{
   						for (int c = 5; c < 10; c++)
   						{
   							for (int d = c + 1; d < 10; d++)
   							{
   								if (o == myDeck.getDeckofCards().get(d).getCardFace())
   								{
   									if (myDeck.getDeckofCards().get(a).getCardFace() == o)
   									{
   										if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) > 0)
   										return 1;
   									
   										else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) < 0)
   										return -1;
   								
   										else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) == 0)
   										{
   											if (o != myDeck.getDeckofCards().get(d).getCardFace())
   											{
   												for (int e =0; e <5; e++ )
   												{
   													if (myDeck.getDeckofCards().get(e).getCardFace() != myDeck.getDeckofCards().get(a).getCardFace() )
   														{
   														for (int f = 0 + e; f < 5; f++)
   														{
   															if (myDeck.getDeckofCards().get(e).getCardFace() == myDeck.getDeckofCards().get(f).getCardFace())
   															{
   																for (int g = 5; g < 10; g++ )
   																{
   																	if (o == myDeck.getDeckofCards().get(g).getCardFace())
   																	{
   																		if ( o == myDeck.getDeckofCards().get(f).getCardFace())
   																		{
   																			if (myDeck.getDeckofCards().get(e).getCardFace().compareTo (o) > 0)
   																			return 1;
   																			else if (myDeck.getDeckofCards().get(e).getCardFace().compareTo (o) < 0)
   																			return -1;
   																			else if (myDeck.getDeckofCards().get(e).getCardFace().compareTo (o) == 0)
   																			return 0;
   																		}	
   																	}
   																}
   															}	
   														}
   													}	
   												}
   											}
   										}
   									}
   								}
   							}
   						}
   					}
   				}
   			}	
   		}
   		//It will check wich hand is better between 2 hands with Three of a Kind
   		else if (myDeck.isThreeOfAKind() == true && myDeck.isThreeOfAKind2() == true)
   		{
   			for (int i = 5; i < 10; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    				if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 10; a++)
    					{
    						if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(a).getCardFace())
    							{
    							 for (int c = 5; c < 10; c++ )
    								{
    									for (int d = c + 1; d < 10; d++)
    									{
    										if (o == myDeck.getDeckofCards().get(d).getCardFace())
    										{
    											if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) > 0)
    											return 1;
    											else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) < 0)
    											return -1;
    											else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) == 0)
    											return 0;
    										}
    									}
    								}
    							}	
    					}
	
    				}
    			}				
    		}
    			
   		}
   		//It will check wich hand is better between 2 hands with Four of a Kind
   		else if (myDeck.isFourOfKind() == true && myDeck.isFourOfKind2() == true)
   		{
    		for (int a = 0; a < 5; a++)
    		{
    			for (int b = a + 1; b < 5; b++)
    			{
    				if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(b).getCardFace() )
    				{
    					for (int c = a + 1; c < 5; c++)
    					{
    						if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(c).getCardFace() )
    						{	
    							for (int d = 5; d < 10; d++)
    							{
    								for (int e = d + 1; e < 10; e++)
    								{
    									if (o == myDeck.getDeckofCards().get(e).getCardFace() )
    									{
    										for (int f = e + 1; f < 10; f++)
    										{
    											if (o == myDeck.getDeckofCards().get(f).getCardFace() )
    											{	
    												if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) > 0)
    												return 1;
    												else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) < 0)
    												return -1;
    												else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) == 0)
    												return 0;
    											}
    										}
    									}
    								}	
    							}
    						}				
    					}
    				}	
   				}
    		}
   		}
   		//it will check the faces of each hand to see which is better in a flush
   		else if (myDeck.isFlush() == true && myDeck.isFlush2() == true)
   		{
   			for (int a = 0; a < 5; a++)
   			{
   				if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) > 0)
    			return 1;
    			else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) < 0)
    			return -1;
    			else if (myDeck.getDeckofCards().get(a).getCardFace().compareTo (o) == 0)
    			return 0;
   			}
   		}
   		
   		/*else if ()
   		{
   			
   		}*/
   		return 0;
   	}
		
	public String comparison ()
	{
		//I will heck the winer in case there's 1 Pair
		if (myDeck.isOnePair() == true && myDeck.isOnePair2() == true)
		{
			for (int i = 0; i < 5; i++)
   			{
   				for (int x = i + 1; x < 5; x++)
   				{
   					if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(x).getCardFace())
   					{
   						for (int a = 5; a < 10; a++)
   						{	
   							for (int b = a+ 1; b < 10; b++)
							{
								if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(b).getCardFace())
								{
									if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == -1)
									{
										p1Points = p1Points + 5;
										player1Points.setText(" " + p1Points);
										return name + " Won with a higher ' One Pair ' ";
									}
									else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 1)
									{
										CPPoints = CPPoints + 5;
										CPPointsLabel.setText(" " + CPPoints);
    									return  " The Computer Won with a higher ' One Pair ' ";
									}
										else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 0)
										return "Its a Tie";
						
								}
							}
   						}
   					}
   				}
   			}
		
		}
		//It will heck the winer in case there's Two Pairs
		else if (myDeck.isTwoPair() == true && myDeck.isTwoPair2() == true)
		{
			int pair = 0;
   			for (int a = 0; a <5; a++ )
   			{
   				for (int b =1 + a ; b <5; b++ )
   				{
   					if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(b).getCardFace())
   					{
   						for (int c = 5; c < 10; c++)
   						{
   							for (int d = c + 1; d < 10; d++)
   							{
   								if (myDeck.getDeckofCards().get(c).getCardFace() == myDeck.getDeckofCards().get(d).getCardFace())
   								{
   									if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(c).getCardFace())
   									{
										if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == 1)
										{
											p1Points = p1Points + 10;
											player1Points.setText(" " + p1Points);
											return name + "Won with a higher ' Two Pairs ' ";
										}
										else if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == -1)
										{
											CPPoints = CPPoints + 10;
											CPPointsLabel.setText(" " + CPPoints);
    										return  "The Computer Won with a higher ' Two Pairs ' ";
										}
										else if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == 0)
										return "Its a Tie";
									}
								}
   							}
   						}
   					}
   				}
   			}
		}
		//I will heck the winer in case there's a Three of a Kind
		else if (myDeck.isThreeOfAKind() == true && myDeck.isThreeOfAKind2() == true)
		{
   			for (int i = 5; i < 10; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    				if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 10; a++)
    					{
    						if (myDeck.getDeckofCards().get(i).getCardFace() == myDeck.getDeckofCards().get(a).getCardFace())
    						{
    							for (int c = 5; c < 10; c++ )
    							{
    								for (int d = c + 1; d < 10; d++)
    								{
    									if (myDeck.getDeckofCards().get(c).getCardFace() == myDeck.getDeckofCards().get(d).getCardFace())
    									{
    										for (int e = c + 1; e < 10; e++)
    										{
    											if (myDeck.getDeckofCards().get(c).getCardFace() == myDeck.getDeckofCards().get(e).getCardFace())
    											{
    												if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == 1)
													{
														p1Points = p1Points + 15;
														player1Points.setText(" " + p1Points);
														return name + " Won with a higher ' Three of a Kind ' ";
													}
													else if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == -1)
													{
														CPPoints = CPPoints + 15;
														CPPointsLabel.setText(" " + CPPoints);
    													return  "The Computer Won with a higher ' Three of a Kind  ' ";
													}
													else if (compareTo(myDeck.getDeckofCards().get(c).getCardFace()) == 0)
													return "Its a Tie";
    											}
    										}
										}
									}
    							}
    						}
    					}
    				}
    			}
    		}
		}
		//I will heck the winer in case there's a Four of a Kind
		else if (myDeck.isFourOfKind() == true && myDeck.isFourOfKind2() == true)
		{
			int count1 = 1;
			int count2 = 1;
			for (int a = 0; a < 5; a++)
			{
				for (int b = a + 1; b < 5; b++)
				{
					if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(b).getCardFace())
					{
						count1 ++;
						if (count1 == 4)
						{
							for (int c = 5; c < 10; c++)
							{
								for (int d = c + 1; d < 10; d++ )
								{
									if (myDeck.getDeckofCards().get(d).getCardFace() == myDeck.getDeckofCards().get(c).getCardFace())
									{
										count2 ++;
										if (count2 == 4)
										{
											if (myDeck.getDeckofCards().get(a).getCardFace() == myDeck.getDeckofCards().get(c).getCardFace())
											{
												if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 1)
												{
													p1Points = p1Points + 20;
													player1Points.setText(" " + p1Points);
													return name + " Won with a higher ' Four of a Kind ' ";
												}
												else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == -1)
												{
													CPPoints = CPPoints + 20;
													CPPointsLabel.setText(" " + CPPoints);
								    				return  "The Computer Won with a higher ' Four of a Kind ' ";
												}					
												else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 0)
												return "Its a Tie";
											}
										}
									}
								}
							}
						}
					}	
				}
			}
    	}
			//It will check the winner in case there's a Flush on both hands;
			else if (myDeck.isFlush() == true && myDeck.isFlush2() == true)
			{
				for (int a = 5; a < 10; a++)
				{
					if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 1)
					{
						p1Points = p1Points + 25;
						player1Points.setText(" " + p1Points);
						return name + " Won with a higher ' A Flush ' ";
					}
					else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == -1)
					{
						CPPoints = CPPoints + 25;
						CPPointsLabel.setText(" " + CPPoints);
    					return  "The Computer Won with a higher ' A Flush ' ";
					}
					
					else if (compareTo(myDeck.getDeckofCards().get(a).getCardFace()) == 0)
					return "Its a Tie";
				}
			}
			//=====================================================Two Pairs and One Pair====================================================================	 
			else if (myDeck.isTwoPair2() == true && myDeck.isOnePair() == true)
			{
				CPPoints = CPPoints + 10;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer won with ' Two Pairs '";	
			}
			
			else if (myDeck.isTwoPair() == true && myDeck.isOnePair2() == true)
			{
				p1Points = p1Points + 10;
				player1Points.setText(" " + p1Points);
				return name + " won with ' Two Pairs '";
			}
		//======================================================Three of a Kind and a Lowe Ranking============================================================	
			else if (myDeck.isThreeOfAKind2() == true && (myDeck.isOnePair() == true || myDeck.isTwoPair2() == true) )
			{
				CPPoints = CPPoints + 15;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with ' Three of a Kind '";
			}
			
			else if (myDeck.isThreeOfAKind() == true && (myDeck.isOnePair2() == true || myDeck.isTwoPair2() == true))
			{
				p1Points = p1Points + 15;
				player1Points.setText(" " + p1Points);
				return name + " Won with ' Three of a Kind '";
			}
		//=======================================================Four of a Kind and a lower Ranking============================================================
			
			else if (myDeck.isFourOfKind() == true && (myDeck.isThreeOfAKind2() == true || myDeck.isOnePair2() == true || myDeck.isTwoPair2() == true) )
			{
				p1Points = p1Points + 20;
				player1Points.setText(" " + p1Points);
				return name + " Won with ' Four of a Kind'";
			}
			else if (myDeck.isFourOfKind2() == true && (myDeck.isThreeOfAKind() == true || myDeck.isOnePair() == true || myDeck.isTwoPair() == true) )
			{
				CPPoints = CPPoints + 20;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with ' Four of a Kind'";
			}
			//In Case there's a pair in Hand1 and no match Hand2
			else if (myDeck.isOnePair() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 5;
				player1Points.setText(" " + p1Points);
				return name + " Won with ' One Pair '";	
			}
			//In Case there's a pair in Hand2 and no match Hand1	
			else if (myDeck.isOnePair2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 5;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with a ' One Pair '";
			}
			//=========================================In Case there's twoPair in Hand1 and no match Hand2====================================================
			else if (myDeck.isTwoPair() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 10;
				player1Points.setText(" " + p1Points);
				return name + " Won with  ' Two Pairs '";
			}
				
			//=========================================In Case there's twoPair in Hand2 and no match Hand1====================================================	
			else if (myDeck.isTwoPair2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 10;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with  ' Two Pairs '";
			}

			//======================================In Case there's a three of a kind in Hand1 and no match Hand2=============================================
			else if (myDeck.isThreeOfAKind() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 15;
				player1Points.setText(" " + p1Points);
				return name + " Won with ' Three of a Kind '";
			}

			//======================================In Case there's a three of a kind in Hand2 and no match Hand1=============================================	
			else if (myDeck.isThreeOfAKind2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 15;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with ' Three of a Kind '";
			}
			//======================================In Case there's a Four of a kind in Hand1 and no match Hand2=============================================
			else if (myDeck.isFourOfKind() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 20;
				player1Points.setText(" " + p1Points);
				return name + " Won with ' Four of a Kind '";
			}
			//======================================In Case there's a Four of a kind in Hand2 and no match Hand1=============================================	
			else if (myDeck.isFourOfKind2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 20;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with ' Four of a Kind '";	
			}
			//============================================In Case there's a Flush in Hand1 and no match Hand2================================================
			else if (myDeck.isFlush() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 25;
				player1Points.setText(" " + p1Points);
				return name + " Won with a ' Flush '";
			}

			//============================================In Case there's a Flush in Hand2 and no match Hand1================================================	
			else if (myDeck.isFlush2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 25;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer Won with a ' Flush '";	
			}
			//======================================In Case there's a Straight in Hand1 and no match Hand2==================================================
			else if (myDeck.isStraight() == true && (myDeck.isThreeOfAKind2() == false || myDeck.isOnePair2() == false || myDeck.isTwoPair2() == false
					|| myDeck.isFourOfKind2() == false || myDeck.isFlush2() == false || myDeck.isRoyalFlush2() == false || myDeck.isStraight2() == false
					|| myDeck.isStraightFlush2()== false))
			{
				p1Points = p1Points + 30;
				player1Points.setText(" " + p1Points);
   				return name + " Won with a ' Straight '";
			}
			//======================================In Case there's a Straight in Hand2 and no match Hand1===================================================	
			else if (myDeck.isStraight2() == true && (myDeck.isThreeOfAKind() == false || myDeck.isOnePair() == false || myDeck.isTwoPair() == false
					|| myDeck.isFourOfKind() == false || myDeck.isFlush() == false || myDeck.isRoyalFlush() == false || myDeck.isStraight() == false
					|| myDeck.isStraightFlush()== false))
			{
				CPPoints = CPPoints + 30;
				CPPointsLabel.setText(" " + CPPoints);
				return "The Computer with a ' Straight '";
			}

			
			return "There is no match";		
		}
	
	//handle button event 
	public void actionPerformed (ActionEvent event)
	{
		
		//===============================================================Shuffle Button========================================================================
		if (event.getSource() == shuffleButton)
		{
			
			Collections.shuffle(myDeck.getDeckofCards());
		   
		   //Desabling the shuffle Button and enabling the Deal Button
			shuffleButton.setEnabled(false);
			dealButton.setEnabled(true);
			showHand1.setEnabled(false);
			compareButton.setEnabled(false);
			playAgainButton.setEnabled(false);
			closeButton.setEnabled(true);
		}
		
		//==================================================================Deal Button========================================================================
		else if (event.getSource() == dealButton )
		{
			
			player1Panel.removeAll();//remove all the cards for player 1 before adding new ones
			for (int i = 0; i < 5; i++ )// a for loop to deal the cards for player 1
			{
				player1Panel.setVisible(false);
				Icon player1Cards = new ImageIcon (getClass().getResource("cback.gif"));
				cards [i] = new JLabel (player1Cards,SwingConstants.CENTER);
				player1Panel.add(cards[i]);
				player1Panel.setVisible(true);//setVisible False and afterwards true just to refresh the panel so that it can show the cards
			}
			
			CPUPanel.removeAll();//remove all the cards for player 1 before adding new ones
			for (int i = 5; i < 10; i++ )// a for loop to deal the cards for player 1
			{
				CPUPanel.setVisible(false);
				Icon player2Cards = new ImageIcon (getClass().getResource("cback.gif"));
				cards [i] = new JLabel (player2Cards,SwingConstants.CENTER);
				CPUPanel.add(cards[i]);
				CPUPanel.setVisible(true);//setVisible False and afterwards true just to refresh the panel so that it can show the cards
			}
						
			//Desabling the Deal Button and enabling the showHand1 Button
			shuffleButton.setEnabled(false);
			dealButton.setEnabled(false);
			showHand1.setEnabled(true);
			compareButton.setEnabled(false);
			playAgainButton.setEnabled(false);
			closeButton.setEnabled(true);
				
		}
		//=================================================================Close Button=======================================================================
		else if (event.getSource() == showHand1)
		{

			player1Panel.removeAll();//remove all the cards for player 1 before adding new ones
			for (int i = 0; i < 5; i++ )// a for loop to deal the cards for player 1
			{
				player1Panel.setVisible(false);
				Icon player1Cards = new ImageIcon (getClass().getResource(myDeck.getDeckofCards().get(i).getCardImages()));
				cards [i] = new JLabel (player1Cards,SwingConstants.CENTER);
				player1Panel.add(cards[i]);
				player1Panel.setVisible(true);//setVisible False and afterwards true just to refresh the panel so that it can show the cards
			}

			//Desabling the Deal Button and enabling the showHand1 Button
			shuffleButton.setEnabled(false);
			dealButton.setEnabled(false);
			showHand1.setEnabled(false);
			compareButton.setEnabled(true);
			playAgainButton.setEnabled(false);
			closeButton.setEnabled(true);
		}
		else if (event.getSource() == compareButton)
		{
			CPUPanel.removeAll();//remove all the cards for player 2 before adding new ones
			for (int i = 5; i < 10; i++ )// a for loop to deal the cards for player 2
			{
				CPUPanel.setVisible(false);
				Icon player2Cards = new ImageIcon (getClass().getResource(myDeck.getDeckofCards().get(i).getCardImages()));
				cards [i] = new JLabel (player2Cards,SwingConstants.CENTER);
				CPUPanel.add(cards[i]);
				CPUPanel.setVisible(true);//setVisible False and afterwards true just to refresh the panel so that it can show the cards
			}
			
			//Desabling the Deal Button and enabling the showHand1 Button
			shuffleButton.setEnabled(false);
			dealButton.setEnabled(false);
			showHand1.setEnabled(false);
			compareButton.setEnabled(true);
			playAgainButton.setEnabled(false);
			closeButton.setEnabled(true);
			JOptionPane.showMessageDialog(null,comparison());
			
			//Desabling the Compare Button and enabling the Play Again Button
			shuffleButton.setEnabled(false);
			dealButton.setEnabled(false);
			compareButton.setEnabled(false);
			playAgainButton.setEnabled(true);
			closeButton.setEnabled(true);
			
		}
		//==============================================================Play Again Button=====================================================================
		else if (event.getSource() == playAgainButton)
		{
			//Desabling the PlayAgain Button and enabling the Shuffle Button
			shuffleButton.setEnabled(true);
			dealButton.setEnabled(false);
			compareButton.setEnabled(false);
			playAgainButton.setEnabled(false);
			closeButton.setEnabled(true);
			
			//Refreshing the panels
			player1Panel.removeAll();
			player1Panel.setVisible(false);
			player1Panel.setVisible(true);
			CPUPanel.removeAll();
			CPUPanel.setVisible(false);
			CPUPanel.setVisible(true);
		}
		//=================================================================Close Button=======================================================================
		else if (event.getSource() == closeButton)
		{
			String message = String.format("Thank You For Playing The Game. \n\n          Please Come Again");
			JOptionPane.showMessageDialog(null,message);
			System.exit(0);
		}
			
	}
	
	public void setDesign () //Setting the Feel and touch command using windows
	{
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	
		}
		catch (Exception e)
		{
			
		}
	}
    
}