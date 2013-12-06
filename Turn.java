import java.util.ArrayList;

//Taylor Ryan
//CS110
//This is a class that contains all of the elements that are performed during one turn
//of the game War
public class Turn 
{
	private ArrayList<Card> winnings=new ArrayList<Card>();
	private Card p1Card;
	private Card p2Card;
	private boolean turnInProgress;   
	final private boolean TURN_OVER=false;
	
	public Turn()
	{
		
	}
	public Turn(Card p1, Card p2)
	{
		p1Card=p1;
		p2Card=p2;
		winnings.add(p1);
		winnings.add(p2);
		turnInProgress=true;
	}
	public int compareCards()
	{
		
		
		if(p1Card.getValue()>p2Card.getValue())
		{
			return 1;
		}
		if(p1Card.getValue()<p2Card.getValue())
		{
			return 2;
		}
		return 0;
	}
	public Card getP1Card()
	{
		return p1Card;
	}
	public Card getP2Card()
	{
		return p2Card;
	}
	public void war(Player p1, Player p2)
	{
		try
		{
			winnings.add(p1.getTopCard());
			winnings.add(p2.getTopCard());
			p1Card=p1.getTopCard();
			p2Card=p2.getTopCard();
			winnings.add(p1Card);
			winnings.add(p2Card);
		}
		catch(IndexOutOfBoundsException e)
		{
			if(p1.getCardCount()==0)
			{
				turnInProgress=TURN_OVER;
				this.giveWinnerCards(p2);
			}
			if(p2.getCardCount()==0)
			{
				turnInProgress=TURN_OVER;
				this.giveWinnerCards(p1);
			}
		}
	}
	public void giveWinnerCards(Player p)
	{
		for(int x=0;x<winnings.size();x++)
		{
			p.recieveCard(winnings.get(x));
		}
		turnInProgress=TURN_OVER;
	}
	public boolean inProgress()
	{
		return turnInProgress;
	}

}
