//Taylor Ryan
//CS110
//This is a class that contains all of the elements that are performed during one turn
//of the game War
public class Turn 
{
	private Card p1Card;
	private Card p2Card;
	
	public Turn(Card p1, Card p2)
	{
		p1Card=p1;
		p2Card=p2;
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
	public void giveWinnerCards(Player p)
	{
		p.recieveCard(p1Card);
		p.recieveCard(p2Card);
	}
	
	
}
