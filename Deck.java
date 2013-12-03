//Taylor Ryan
//CS110
//This is a class for a deck of cards

import java.util.Random;

public class Deck 
{
	final static private String SPADE="Spades";
	final static private String CLUB="Clubs";
	final static private String HEART="Hearts";
	final static private String DIAMOND="Diamonds";
	final static private String KING="King";
	final static private String QUEEN="Queen";
	final static private String JACK="Jack";
	final static private String ACE="Ace";
	final static private int NUM_RANKS=13;
	final static private int NUM_SUITS=4;
	final static private int NUM_CARDS=NUM_RANKS*NUM_SUITS;
	private String rank;
	private String suit;
	
	Card[][] cards=new Card[NUM_RANKS][NUM_SUITS];

	public Deck()
	{	
		for(int r=0;r<NUM_RANKS;r++)
		{
			rank=setRankString(r);
			for(int s=0;s<NUM_SUITS;s++)
			{
				suit=setSuitString(s);
				cards[r][s]=new Card(rank,suit);
			}
		}
	}
	public int getNumCards()
	{
		return NUM_CARDS;
	}
	public void shuffle()
	{
		Random rand=new Random();
		int rRank;
		int rSuit;
		Card placeHolder=new Card();
		for(int r=NUM_RANKS-1;r>=0;r--)
		{
			for(int s=NUM_SUITS-1;s>=0;s--)
			{
				rRank=rand.nextInt(r+1);
				rSuit=rand.nextInt(s+1);
				
				placeHolder.equals(cards[r][s]);
				cards[r][s].equals(cards[rRank][rSuit]);
				cards[rRank][rSuit].equals(placeHolder);
				
			}
		}
		
	}
	public Card deal(int x,int y)
	{
		return cards[x][y];
	}
	public static String setSuitString(int y)
	{
		if(y==0)
		{
			return SPADE;
		}
		if(y==1)
		{
			return CLUB;
		}
		if(y==2)
		{
			return HEART;
		}
			return DIAMOND;
		
	}
	public static String setRankString(int x)
	{
		x+=1;
		if(x!=1&&x!=11&&x!=12&&x!=13)
		{
			return Integer.toString(x);
		}
		if(x==11)
		{
			return JACK;
		}
		if(x==12)
		{
			return QUEEN;
		}
		if(x==13)
		{
			return KING;
		}
		return ACE;
	}
	
}
