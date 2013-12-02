import java.util.ArrayList;

//Taylor Ryan
//CS110
//This is a class to store all of the information of a player playing war
public class Player 
{
	private ArrayList<Card> pile=new ArrayList<Card>();
	//private boolean auto=false;  //This is a boolean used to automate the player actions if
								// a computer player is selected
	
	//Constructors
	public Player()
	{
		
	}
	
	/*public Player(String s)
	{
		if (s.equals("CPU"))
		{
			auto=true;
		}
		auto=false;
	}*/
	
	//access & mutator methods
	public int getCardCount()
	{
		return pile.size();
	}

	//function methods
	public void recieveCard(Card c)
	{
		pile.add(c);
	}
	public Card getTopCard()
	{
		Card c=pile.get(0);
		pile.remove(0);
		return c;
	}
	
	
}
