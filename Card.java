import javax.swing.ImageIcon;

//Taylor Ryan
//CS110
//Final homework, Card class to represent 1/52 cards of a Deck
public class Card 
{
	final static private String KING="King";
	final static private String QUEEN="Queen";
	final static private String JACK="Jack";
	final static private String ACE="Ace";
	private String name;
	private String suit;
	private int value=-99;
	private String rank;
	private String picAddress;
	private ImageIcon pic;
	private final String RefStringToJPG="/Users/tr/Desktop/Java programs/Assignment10/res/";
	
	
	public Card()
	{
		
	}
	public Card(int r,String s)
	{
		suit=s;
		rank=setRankString(r);
		name=rank+" of "+suit;
		setValue(r);
		setPicAddress(rank,s);
		setImageIcon();
		
		
	}
	public String getPicAddress()
	{
		return picAddress;
	}
	public void setPicAddress(String r, String s)
	{
		
		boolean ifTen=false;
		char rankLetter=r.charAt(0);
		try{
		if(r.charAt(1)=='0')
		{
			ifTen=true;
		}}
		catch(StringIndexOutOfBoundsException e)
		{
			ifTen=false;
		}
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
			if(ifTen)
			{
				picAddress="10"+suitLetter+".jpg";
			}
			else
			{
				picAddress=rankString+suitLetter+".jpg";
			}
			
		}
		
	}
	public void setImageIcon()
	{
		pic=new ImageIcon(RefStringToJPG+picAddress);
	}
	public ImageIcon getImage()
	{
		return pic;
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
	public static String setRankString(int x)
	{
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
	public void equals(Card c)
	{
		suit=c.getSuit();
		rank=c.getRank();
		value=c.getValue();
		name=c.getName();
		picAddress=c.getPicAddress();
		pic=c.getImage();
	}
	public String toString()
	{
		return name+"\n"+picAddress;
	}
}

