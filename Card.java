//Taylor Ryan
//CS110
//Final homework, Card class to represent 1/52 cards of a Deck
public class Card 
{
	private String name;
	private String suit;
	private int value=-99;
	private String rank;
	private String picAddress;
	
	public Card()
	{
		
	}
	public Card(String r,String s)
	{
		suit=s;
		rank=r;
		setValue(r);
		setPicAddress(r,s);
		name=rank+" of "+suit;
	}
	public String getPicAddress()
	{
		return picAddress;
	}
	public void setPicAddress(String r, String s)
	{
		char rankLetter=r.charAt(0);
		char suitLetter=s.charAt(0);
		boolean faceCard=false;
		String ifFaceCard="";
		suitLetter+=32;
		String rankString=""+rankLetter;
		if(rankLetter=='A'||rankLetter=='J'||rankLetter=='Q'||rankLetter=='K')
		{
			ifFaceCard=r.toLowerCase();
			faceCard=true;
		}
		if(faceCard)
		{
			picAddress=ifFaceCard+suitLetter+".jpg";
		}
		else
		{
			picAddress=rankString+suitLetter+".jpg";
		}
	}
	public String getSuit()
	{
		return suit;
	}
	public String getName()
	{
		return name;
	}
	public void setValue(int n)
	{
		value=n;
	}
	public void setValue(String r)
	{
		try
		{
			value=Integer.parseInt(r);
		}
		catch(NumberFormatException e)
		{
			boolean check=true;
			if(r.equalsIgnoreCase("king"))
			{
				value=13;
				check=false;
			}
			if(r.equalsIgnoreCase("queen"))
			{
				value=12;
				check=false;
			}
			if(r.equalsIgnoreCase("jack"))
			{
				value=11;
				check=false;
			}
			if(r.equalsIgnoreCase("ace"))
			{
				value=1;
				check=false;
			}
			if(check)
			{
				System.out.println("not a valid rank");
			}
		}
	}
	public String getRank()
	{
		return rank;
	}
	public int getValue()
	{
		if(value!=1)
		{
			return value;
		}
		return 14; 		//this is to prevent the ace from being concidered a low card
	}
	public void equals(Card c)
	{
		suit=c.getSuit();
		rank=c.getRank();
		value=c.getValue();
		name=c.getName();
		
	}
	public String toString()
	{
		return name;
	}
}

