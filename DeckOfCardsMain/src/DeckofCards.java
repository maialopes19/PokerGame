/**
 * @(#)DeckofCards.java
 *
 *
 * @author 
 * @version 1.00 2014/10/19
 */

//importing utilities classes
import java.util.ArrayList;
import java.util.Collections;
public class DeckofCards
 {
 	//instatiating variables
 	
	protected ArrayList<Card> deckofCards;
	protected Card [] myCards;
	CardFace face;
	private int hand1;
	private int hand2;
	
	
	//Constructor for DeckOfCards
    public DeckofCards() 
    {
    		//myHand = new Hand1();
    	
    		deckofCards = new ArrayList<Card>();
    		
	    	//Variable for cardImage Indexes
	    	int image = 0;
	    	
	    	for (int count = 0; count < 4; count ++)
	    	{
	    		for (int index = 0; index < 13; index ++)
	    		{
	    			
	    			Card cards = new Card(CardSuit.values()[count],CardFace.values()[index], CardImages.values()[image]);
	    			deckofCards.add(cards);
	    			image++;
	    			
	    		}//end of the inner Loop
	    		
	    	}//end of the outer loop
    	
    }//end of cosntructor for DeckOfCards
    
    //accessor for DeckOfCards
    public ArrayList<Card> getDeckofCards ()
    {
    	return deckofCards;
    	
    	
    }//end of the accessor deckOfCards
    
    //=====================================================================Ranking Hand1===========================================================================
    
     //======================================================================A pair===============================================================================
    
    public boolean isOnePair()
    {
    	
    	if (isFourOfKind()==false && isThreeOfAKind() == false &&  isTwoPair() == false && isStraightFlush() == false && isStraight() == false)
    	{
    		for (int i = 0; i < 5; i++)
    		{
    			for (int x = i + 1; x < 5; x++)
    			{
    			
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace())
    				{
    				return true;
    				}			
    			}
    		}	
    	}
    
    	
    	return false;
    }
    

    //======================================================================Two pairs===========================================================================
    
    public boolean isTwoPair()
    {
    		
    	//test to make sure its not a 4 of a kind, if 4 of a kind then end
    	if (isFourOfKind() == false && isThreeOfAKind() == false && isStraightFlush() == false && isStraight() == false)
    	{
    		int pair = 0;
    	
    		//loops trought to look for matches
    	
    		for (int i = 0; i < 4; i++)
    		{
    			for (int x = i + 1; x < 5; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace())
    				{
    					pair ++; 
    				
    					for (int y = 0; y < 5; y ++)
    					{
    						for (int j = y + 1; j < 5; j++)
    						{
    							if (getDeckofCards().get(y).getCardFace() == getDeckofCards().get(j).getCardFace())		
    							{
    								if (getDeckofCards().get(i).getCardFace()!= getDeckofCards().get(y).getCardFace())
    								{
    									pair ++;
    									
    									if (pair == 2)
    									{
    										return true;
    									}		
    								}	
    							}
    						}
    					}						
    				}
    			}
    		
    		}	
    	}
    	
    	return false; 
    	
    }
    //===============================================================Three of a Kind===========================================================================
    
    public boolean isThreeOfAKind()
    {		
    	if (isFourOfKind() == false && isStraight() == false &&  isStraightFlush() == false)
    	{
    		int count = 1;
    		for (int i = 0; i < 5; i++)
    		{
    			for (int x = i + 1; x < 5; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 5; a++)
    					{
    						if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(a).getCardFace())
    						{
    							return true;
    						}	
    					} 								
    				}
    			}
    		}		
    	}
    	return false;
    }
    //==================================================================Straight Cards===========================================================================
    public boolean isStraight ()
    {
    	for (int x = 0; x < 5; x ++ )
    	{
			for (int i= 2; i < 10; i++)
			{
				if (getDeckofCards().get(x).getCardFace() == face.getFace(i) && getDeckofCards().get(x +1).getCardFace() == face.getFace(i)
					&& getDeckofCards().get(x + 2).getCardFace() == face.getFace(i) && getDeckofCards().get(x + 3).getCardFace() == face.getFace(i)
					&& getDeckofCards().get(x + 4).getCardFace() == face.getFace(i))
    			{
    				return true;
    			}
			}
    	}
    	return false;
    }
   
     //================================================================A Flush===================================================================================
    
    public boolean isFlush ()
    {
    	//runs throught the cards to check if every Card has a higher Suit than the one before it
    	for (int i = 0; i <= 5; i ++ )	
    	{
    		if (getDeckofCards().get(i).getCardSuit() != getDeckofCards().get(i+1).getCardSuit())
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }	
    
     //==============================================================Straight Flush==============================================================================
    public boolean isStraightFlush ()
    {
    	//if there's a staight and a flush present
    	if (isStraight() == true && isFlush() == true )
    	{
    		return true;
    	}
    	
    	return false;
    }
    
     //================================================================Royal Flush===============================================================================
    
    public boolean isRoyalFlush ()
    {
    	//to be a royalFlush the cards must be a flush and a straight with the lowest card being ten
    	if (isStraight() == false && isFlush() == false)
    	{
			for (int x = 0; x < 5; x++)
			{
				if (getDeckofCards().get(x).getCardFace() == face.getFace(10) && getDeckofCards().get(x+1).getCardFace() == face.getFace(11)
					&& getDeckofCards().get(x+2).getCardFace() == face.getFace(12) && getDeckofCards().get(x + 1).getCardFace() == face.getFace(13)
					&& getDeckofCards().get(x + 4).getCardFace() == face.getFace(14))
    			return true;	
			}
    	}   
    	return false;
    }
    
     //===============================================================Four of a Kind===========================================================================
    public boolean isFourOfKind ()
    {
    	//runs throw through the hands for exact 4 matches
    	if (isStraight() == false &&  isStraightFlush() == false)
    	{
    		for (int i = 0; i < 5; i++)
    		{
    			for (int x = i + 1; x < 5; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 5; a++)
    					{
    						if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(a).getCardFace() )
    						{	for (int b = a + 1; b < 5; b++)
    							{
    								if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(b).getCardFace() )
									return true;
    							}		
    						}					
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    //=====================================================================Ranking Hand2===========================================================================
    
    //======================================================================A pair=================================================================================
    
    public boolean isOnePair2()
    {
    		
    	
    	if (isFourOfKind2()==false && isThreeOfAKind2() == false &&  isTwoPair2() == false && isStraightFlush2() == false && isStraight2() == false)
    	{
    		for (int i = 5; i < 10; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    			
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace())
    				{
    				return true;
    				}			
    			}
    		}	
    	}
    
    	
    	return false;
    }
    

    //======================================================================Two pairs===========================================================================
    
    public boolean isTwoPair2()
    {
    		
    	//test to make sure its not a 4 of a kind, if 4 of a kind then end
    	if (isFourOfKind2() == false && isThreeOfAKind2() == false && isStraightFlush2() == false && isStraight2() == false)
    	{
    		int pair = 0;
    	
    		//loops trought to look for matches
    	
    		for (int i = 5; i < 9; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace())
    				{
    					pair ++; 
    				
    					for (int y = 5; y < 10; y ++)
    					{
    						for (int j = y + 1; j < 10; j++)
    						{
    							if (getDeckofCards().get(y).getCardFace() == getDeckofCards().get(j).getCardFace())		
    							{
    								if (getDeckofCards().get(i).getCardFace()!= getDeckofCards().get(y).getCardFace())
    								{
    									pair ++;
    									
    									if (pair == 2)
    									{
    										return true;
    									}		
    								}	
    							}
    						}
    					}						
    				}
    			}
    		
    		}	
    	}
    	
    	return false; 
    	
    }
    //===============================================================Three of a Kind===========================================================================
    
    public boolean isThreeOfAKind2()
    {   	
    	if (isFourOfKind2() == false && isStraight2() == false &&  isStraightFlush2() == false)
    	{
    		for (int i = 5; i < 10; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 10; a++)
    					{
    						if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(a).getCardFace())
    						{
    							return true;
    						}	
    					}
    				}				
    			}
    		}
    	}
    	return false;
    }
    //==================================================================Straight Cards===========================================================================
    public boolean isStraight2()
    {
    	for (int x = 5; x < 10; x ++ )
    	{
			for (int i= 2; i < 10; i++)
			{
				if (getDeckofCards().get(x).getCardFace() == face.getFace(i) && getDeckofCards().get(x +1).getCardFace() == face.getFace(i)
					&& getDeckofCards().get(x + 2).getCardFace() == face.getFace(i) && getDeckofCards().get(x + 3).getCardFace() == face.getFace(i)
					&& getDeckofCards().get(x + 4).getCardFace() == face.getFace(i))
    			{
    				return true;
    			}
			}
    	}
    	return false;
    }
   
     //================================================================A Flush===================================================================================
    
    public boolean isFlush2 ()
    {
    	//runs throught the cards to check if every Card has a higher Face than the one before it with the same suit
    	for (int i = 5; i <= 10; i ++ )	
    	{
    		if (getDeckofCards().get(i).getCardSuit() != getDeckofCards().get(i+1).getCardSuit())
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }	
    
     //==============================================================Straight Flush==============================================================================
    public boolean isStraightFlush2()
    {
    	//if there's a staight and a flush present
    	if (isStraight2() == true && isFlush2() == true )
    	{
    		return true;
    	}
    	
    	return false;
    }
    
     //================================================================Royal Flush===============================================================================
    
    public boolean isRoyalFlush2 ()
    {
    
    	//to be a royalFlush the cards must be a flush and a straight with the lowest card being ten
    	if (isStraight2() == false && isFlush2() == false)
    	{
    		for (int x = 5; x < 10; x++)
			{
				if (getDeckofCards().get(x).getCardFace() == face.getFace(10) && getDeckofCards().get(x+1).getCardFace() == face.getFace(11)
					&& getDeckofCards().get(x+2).getCardFace() == face.getFace(12) && getDeckofCards().get(x + 1).getCardFace() == face.getFace(13)
					&& getDeckofCards().get(x + 4).getCardFace() == face.getFace(14))
    			return true;	
			}  
    	return false;
    		
    	}
    		
    	return false;
    }
    
     //===============================================================Four of a Kind===========================================================================
    public boolean isFourOfKind2 ()
    {
    	//runs throw through the hands for exact 4 matches
    	if (isStraight2() == false &&  isStraightFlush2() == false)
    	{
    		for (int i = 5; i < 10; i++)
    		{
    			for (int x = i + 1; x < 10; x++)
    			{
    				if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(x).getCardFace() )
    				{
    					for (int a = x + 1; a < 10; a++)
    					{
    						if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(a).getCardFace() )
    						{	for (int b = a + 1; b < 10; b++)
    							{
    								if (getDeckofCards().get(i).getCardFace() == getDeckofCards().get(b).getCardFace() )
									return true;
    							}		
    						}					
    					}
    				}
    			}
    		}
    	}
    	return false;
    }  		
}


 