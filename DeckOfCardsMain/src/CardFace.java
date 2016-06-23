/**
 * @(#)CardFace.java
 *
 *
 * @author 
 * @version 1.00 2014/10/19
 */


public enum CardFace 
{
     DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
     JACK(11), QUEEN(12), KING(13),ACE(14);
    
    //Instatiating variables
    private int cardFace;
    
    //one-argument constructor
    private CardFace(int face)
    {
    	cardFace = face;
    }//end of one argument constructor
    
    //accessor for cardFace
    public int getCardFace ()
    {
    	return cardFace;
    }//end of the accessor for CardFace
   
   public static CardFace getFace (int ordinal)
   {
   		switch (ordinal)
   		{
   			case 2: return DEUCE;
   			case 3: return THREE;
   			case 4: return FOUR;
   			case 5: return FIVE;
   			case 6: return SIX;
   			case 7: return SEVEN;
   			case 8: return EIGHT;
   			case 9: return NINE;
   			case 10: return TEN;
   			case 11: return JACK;
   			case 12: return QUEEN;
   			case 13: return KING;
   			case 14: return ACE;
   			
   			default: throw new RuntimeException ("Invalid Face Ordinal" + ordinal);
   		}
   }
    
    	
    
}// end of the enum Class CardFace
