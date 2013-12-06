import java.util.ArrayList;
import java.util.Collections;

//Taylor Ryan
//CS110
//This is a class to store all of the information of a player playing war
public class Player 
{
	private ArrayList<Card> pile=new ArrayList<Card>();
	
	//Constructors
	public Player()
	{
		
	}
	
	//access & mutator methods
	public int getCardCount()
	{
		return pile.size();
	}

	//function methods
	public void shufflePile()
	{
		Collections.shuffle(pile);
	}
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
