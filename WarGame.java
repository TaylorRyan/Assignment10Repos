//Taylor Ryan
//CS110
//Final Assignment, War
//This is the main program to run the classic card game "war"

///*/////////////////////////////////////////////
//  The game is called War.
//	The cards are divided evenly between the two (or more???) players
//	Each turn consists of the players:
//  	Picking the top card off their pile
//      Flipping the card
//		comparing the results
//	The player with the higher rank takes the cards and adds them to their pile
//	The game is over when one player collects the whole deck
//	That player is then the winner
/////////////////////////////////////////////*///
public class WarGame 
{
	public static void main(String[] args)
	{
		boolean noWinner=true;  //This boolean will stay true while both players have cards
		
		Player p1=new Player();
		Player p2=new Player();
		Turn turn;
		int winner;
		Card c1=new Card();
		Card c2=new Card();
		
		//initialize deck
		Deck deck=new Deck();
		//shuffle deck
		deck.shuffle();
		//deal deck 
		dealDeck(deck,p1,p2);
		//turn phase
		noWinner=checkWinner(p1.getCardCount(),p2.getCardCount());
		while(noWinner)
		{
			//put card forward
			c1=p1.getTopCard();
			c2=p2.getTopCard();
			turn=new Turn(c1,c2);
			//flip card
			
			//show winner
			while(turn.inProgress())
			{		
				winner=turn.compareCards();
				/*This method will return either 0, 1 or 2, to indicate 
				 *the winning player
				 *If 2 is returned, it is either the computer or the seconds player
				 *If 1 is retruned, it is player one
				 *If 0 is returned, it is a war
				 */
				if(winner==1)
				{
					turn.giveWinnerCards(p1);
				}
				if(winner==2)
				{
					turn.giveWinnerCards(p2);
				}
				if(winner==0)
				{
					turn.war(p1,p2);
				}
				//noWinner=checkWinner(p1.getCardCount(),p2.getCardCount());
			}
			//reset play field
			
			p1.shufflePile();
			p2.shufflePile();
			noWinner=checkWinner(p1.getCardCount(),p2.getCardCount());
		}
		
	}
	
	public static boolean checkWinner(int p1,int p2)
	{

		if(p1==0||p2==0)
		{	
			return false;   //false returns the boolean that there is no longer "no winner"
		}
		return true;  //true returns that there is still cards in both players piles
						//so the game will continue
	}
	public static void dealDeck(Deck d,Player p1, Player p2)
	{
		for(int i=0;i<13;i++)
		{
			for(int j=0;j<4;j+=2)
			{
				p1.recieveCard(d.deal(i, j));
				p2.recieveCard(d.deal(i, j+1));
			}
		}
	}
}

