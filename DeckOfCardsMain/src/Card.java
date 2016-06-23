/**
 * @(#)Card.java
 *
 *
 * @author 
 * @version 1.00 2014/10/8
 */

//display image import
//import java.util.ArrayList;

public class Card 
{
	//instatiating variables
	private CardFace face;
	private CardSuit suit;
	private String cardImage;
	
	//three-arguments costructor
    public Card( CardSuit cardSuit,CardFace cardFace, CardImages images) 
    {
    	face = cardFace;
    	suit = cardSuit;
    	cardImage = images.getCardImages();
    	
    }// end of the three-arguments constructor
    
    //accessor for the CardSuit
    public CardSuit getCardSuit ()
    {
    	return suit;
    	
    }//end of the accessor for CardSuit
    
     //accessor for the CardSFace
    public CardFace getCardFace ()
    {
    	return face;
    	
    }//end of the accessor for CardFace
    
    //accessor for the CardImages
    public String getCardImages ()
    {
    	return cardImage;
    	
    }//end of the accessor for CardImages
  
}// end of class Card