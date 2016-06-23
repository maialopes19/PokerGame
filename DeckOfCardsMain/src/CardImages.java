/**
 * @(#)CardImages.java
 *
 *
 * @author 
 * @version 1.00 2014/10/19
 */


public enum CardImages 
{
 	//======================================Cards with the heart suit==============================================================
 	HEART2 ("0.gif"),HEART3 ("1.gif"),HEART4 ("2.gif"),HEART5 ("3.gif"),HEART6 ("4.gif"),
 	HEART7 ("5.gif"),HEART8 ("6.gif"),HEART9 ("7.gif"),HEART10 ("8.gif"),HEART11 ("9.gif"),HEART12 ("10.gif"),
 	HEART13 ("11.gif"),HEART14 ("12.gif"),
 	
 	//======================================Cards with the Diamond Suit============================================================  
    DIAMOND2("13.gif"),DIAMOND3("14.gif"),DIAMOND4("15.gif"),DIAMOND5("16.gif"),DIAMOND6("17.gif"),
    DIAMOND7("18.gif"),DIAMOND8("19.gif"),DIAMOND9("20.gif"),DIAMOND10("21.gif"),DIAMOND11("22.gif"),DIAMOND12("23.gif"),
    DIAMOND13("24.gif"),DIAMOND14("25.gif"),
    
    //======================================Cards with the Clubes Suit============================================================ 
    CLUBES2("26.gif"),CLUBES3("27.gif"),CLUBES4("28.gif"),CLUBES5("29.gif"),CLUBES6("30.gif"),
    CLUBES7("31.gif"),CLUBES8("32.gif"),CLUBES9("33.gif"),CLUBES10("34.gif"),CLUBES11("35.gif"),CLUBES12("36.gif"),
    CLUBES13("37.gif"),CLUBES1("38.gif"),
    
    //======================================Cards with the Spades Suit============================================================ 
    SPADES32("39.gif"),SPADES3("40.gif"),SPADES4("41.gif"),SPADES5("42.gif"),SPADES6("43.gif"),
    SPADES7("44.gif"),SPADES8("45.gif"),SPADES9("46.gif"),SPADES10("47.gif"),SPADES11("48.gif"),SPADES12("49.gif"),
    SPADES13("50.gif"),SPADES1("51.gif");
    
    //instatiating variables
    private String cardImage;
    
    //one-argument Constructor for CardImage
    private CardImages (String images)
    {
    	cardImage = images;	
    }//end of the one-argument Constructor
    
    //accessor CardImage
    public String getCardImages ()
    {
    	return cardImage;
    }//end of the accessor
}
