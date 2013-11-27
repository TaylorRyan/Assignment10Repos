//Taylor Ryan
//CS110
//This is a class to store all of the information of a player playing war
public class Player 
{
	private int cardCount;
	private Card[] pile=new Card[26];
	private boolean auto=false;  //This is a boolean used to automate the player actions if
								// a computer player is selected
	public Player()
	{
		
	}
	
	public Player(String s)
	{
		if (s.equals("CPU"))
		{
			auto=true;
		}
		auto=false;
	}
	public void recieveCard(Card c)
	{
		int i=0;
		while(i<pile.length)
		{
			try
			{
				System.out.println(pile[i]);
			}
			catch(IndexOutOfBoundsException e)
			{
				pile[i]=c;
			}
			i++;
		}
	}
	public int getCardCount()
	{
		return cardCount;
	}
}
