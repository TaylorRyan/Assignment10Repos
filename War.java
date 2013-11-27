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
public class War 
{
	public static void main(String[] args)
	{
		boolean noWinner=true;  //This boolean will stay true while both players have cards
		Player p1=new Player();
		Player comp=new Player("CPU");
		Deck deck=new Deck();
		deck.shuffle();
		
		//initialize deck
		
		//shuffle deck
		
		//deal deck 
		
		//turn phase
		while(noWinner)
		{
			//put card forward
			//flip card
			//show winner
			//reset play field
			noWinner=checkWinner(p1.getCardCount(),comp.getCardCount());
		}
	}
	public static boolean checkWinner(int p1,int p2)
	{
		if(p1==0||p2==0)
		{
			return false;
		}
		return true;
	}
}

