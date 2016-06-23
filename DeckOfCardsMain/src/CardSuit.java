/**
 * @(#)CardSuit.java
 *
 *
 * @author 
 * @version 1.00 2014/10/19
 */


public enum CardSuit 
{
	HEART(1), DIAMONDS(2), CLUBS(3), SPADES(4);
	
	//instatiating Variables
	private int cardSuit;
	
	//one-argument constructor 
	private CardSuit (int suit)
	{
		cardSuit = suit;		
	} //end of one argument constructor
	
	//accessor for CardSuit
	public int getCardSuit ()
	{
		return cardSuit;
	}//end of the accessor for the CardSuit 
	
	
	
	public static CardSuit getSuit (int ordinal)
	{
		switch (ordinal)
		{
			case 1: return HEART;
			case 2: return DIAMONDS;
			case 3: return CLUBS;
			case 4: return SPADES;
			
			default : throw new RuntimeException("Invalid Suit Ordinal" + ordinal );
		}
	}
    
}
