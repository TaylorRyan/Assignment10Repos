//Taylor Ryan
//Trying to teach myself how to make a gui by reading chapter 12

import javax.swing.*;
import java.awt.event.*;
//import java.text.DecimalFormat;

public class WarGameGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private final String RefStringToJPG="/Users/tr/Desktop/Java programs/Assignment10/res/";
	private JPanel panel;
	private JLabel display;
	private JLabel card1;				//this is the label that will contain the card image for p1
	private JLabel card2;				//  ||         ||          ||       ||        ||         p2
	private JLabel deck1Card;
	private JLabel deck2Card;
	private JLabel labelPlayerOne;
	private JLabel labelPlayerTwo;
	private JLabel warCard1;
	private JLabel warCard2;
	private JLabel warCardFaceDown1;
	private JLabel warCardFaceDown2;
	private JButton fight;
	private JButton war;
	private JButton reset;
	private JButton start;
	private Card p1Card;
	private Turn turn;
	private Card p2Card;
	
	private boolean going=false;

	
	private ImageIcon imageBack=new ImageIcon(RefStringToJPG+"back.jpg");
	private boolean cardForward=false;
	private boolean faceUp=false;
	private Deck deck;
	private Player p1;
	private Player p2;
	
	//private DecimalFormat formatter=new DecimalFormat("#,##0.0000");
	
	private class Events implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==start)
			{
				deck=new Deck();
				p1=new Player();
				p2=new Player();
				deck.shuffle();
				dealDeck(deck,p1,p2);
				p1Card=p1.getTopCard();
				p2Card=p2.getTopCard();
				turn=new Turn(p1Card,p2Card);
				start.setVisible(false);
				fight.setVisible(true);
			}
			if(e.getSource()==reset)
			{
				
				giveCardsToWinner(turn,p1,p2);
				System.out.println(p1.getCardCount()+p2.getCardCount());
				warCard1.setVisible(false);
				warCard2.setVisible(false);
				warCardFaceDown1.setVisible(false);
				warCardFaceDown2.setVisible(false);
				if(p1.getCardCount()==0||p2.getCardCount()==0)
				{
					labelPlayerOne.setText("Player 1 has "+p1.getCardCount()+" cards");
					labelPlayerTwo.setText("Player 2 has "+p2.getCardCount()+" cards");
					card1.setIcon(null);
					card2.setIcon(null);
					cardForward=false;
					faceUp=false;
					if(p1.getCardCount()==0)
					{
						display=new JLabel("The winner is player 2");
					}
					if(p2.getCardCount()==0)
					{						
						display=new JLabel("The winner is player 1");
					}
					panel.add(display);
					
					reset.setVisible(false);
					fight.setVisible(false);
					start.setVisible(false);
					war.setVisible(false);
					going=false;
				}
				else
				{
					
					card1.setVisible(true);
					card2.setVisible(true);
					card1.setIcon(null);
					card2.setIcon(null);
					cardForward=false;
					faceUp=false;
					labelPlayerOne.setText("Player 1 has "+p1.getCardCount()+" cards");
					labelPlayerTwo.setText("Player 2 has "+p2.getCardCount()+" cards");
					p1Card=p1.getTopCard();
					p2Card=p2.getTopCard();
					turn=new Turn(p1Card,p2Card);
					reset.setVisible(false);
					fight.setVisible(true);
				}
			}
			if(e.getSource()==fight)
			{
				warCard1.setVisible(false);
				warCard2.setVisible(false);
				warCardFaceDown1.setVisible(false);
				warCardFaceDown2.setVisible(false);
				card1.setVisible(true);
				card2.setVisible(true);
				if(cardForward&&!faceUp)
				{
					card1.setIcon(turn.getP1Card().getImage());
					card2.setIcon(turn.getP2Card().getImage());
					faceUp=true;
				}
				if(!cardForward&&turn.inProgress())
				{
					card1.setIcon(imageBack);
					card2.setIcon(imageBack);
					cardForward=true;
				}
				if(cardForward&&faceUp)
				{
					if(turn.compareCards()==0)
					{
						war.setVisible(true);
					}
					else
					{
						reset.setVisible(true);
					}
					fight.setVisible(false);
				}
				
			}
			if(e.getSource()==war)
			{
				System.out.println("war");
				turn.war(p1,p2);
				p1Card.equals(turn.getP1Card());
				p2Card.equals(turn.getP2Card());
				card1.setVisible(false);
				card2.setVisible(false);
				warCard1.setVisible(true);
				warCard2.setVisible(true);
				warCardFaceDown1.setVisible(true);
				warCardFaceDown2.setVisible(true);
				warCard1.setIcon(turn.getP1Card().getImage());
				warCard2.setIcon(turn.getP2Card().getImage());
				if(turn.compareCards()!=0)
				{
					war.setVisible(false);
					reset.setVisible(true);	
				}
				
			}
		}
	}
	public WarGameGUI()
	{
		
		setTitle("War");
		going=true;
		this.setBounds(100, 100, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
		while(going)
		{
			while(start.isVisible())
			{
				start.doClick();
			}
			while(fight.isVisible())
			{
				fight.doClick();
			}
			while(war.isVisible())
			{
				war.doClick();
			}
			while(reset.isVisible())
			{
				reset.doClick();
			}
		}
	}
	public static void main(String[] args)
	{
		new WarGameGUI();
	}
	
	public void buildPanel()
	{
		//set .jpg file to imageicon
		
		//set imageicon to a label
		card1=new JLabel();
		card2=new JLabel();
		warCard1=new JLabel();
		warCard2=new JLabel();
		warCardFaceDown1=new JLabel();
		warCardFaceDown2=new JLabel();
		reset=new JButton("Reset");
		fight=new JButton("Flip");
		war=new JButton("War");
		start=new JButton("Start");
		fight.addActionListener(new Events());
		war.addActionListener(new Events());
		reset.addActionListener(new Events());
		start.addActionListener(new Events());
		panel=new JPanel();
		fight.setVisible(false);
		war.setVisible(false);
		reset.setVisible(false);
		warCard1.setVisible(false);
		warCard2.setVisible(false);
		labelPlayerOne=new JLabel("Player 1 has 26 cards");
		labelPlayerTwo=new JLabel("Player 2 has 26 cards");
		deck1Card=new JLabel(imageBack);
		deck2Card=new JLabel(imageBack);
		warCardFaceDown1=new JLabel(imageBack);
		warCardFaceDown2=new JLabel(imageBack);
		warCardFaceDown1.setVisible(false);
		warCardFaceDown2.setVisible(false);
		
		//add picture label to the panel
		panel.add(labelPlayerOne);
		panel.add(deck1Card);
		panel.add(labelPlayerTwo);
		panel.add(deck2Card);
		panel.add(fight);
		panel.add(start);
		panel.add(reset);
		panel.add(war);
		panel.add(card1);
		panel.add(warCardFaceDown1);
		panel.add(warCard1);
		panel.add(warCard2);
		panel.add(warCardFaceDown2);		
		panel.add(card2);
	}
	public static boolean equal(int one, int two)
	{
		if(one==two)
		{
			return true;
		}
		return false;
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
	public static void giveCardsToWinner(Turn turn,Player p1, Player p2)
	{
		if(turn.compareCards()==1)
		{
			turn.giveWinnerCards(p1);
			p1.shufflePile();
		}
		if(turn.compareCards()==2)
		{
			turn.giveWinnerCards(p2);
			p2.shufflePile();
		}
	}
	public static boolean theFirstWins(int one, int two)
	{
		if(one>two)
		{
			return true;
		}
		return false;
	}
}
