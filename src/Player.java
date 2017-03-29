
public class Player {

	private String name;
	
	private Card[] hand = new Card[10];
	
	private int numCards;
	
	public Player (String aName){
		this.name = aName;
		
		//set players hand to empty
		this.emptyHand();
	}
	
	public void emptyHand(){
		for(int c=0; c <10; c++){
			this.hand[c] = null;
		}
		this.numCards = 0;
	}
	
	public boolean addCard(Card aCard){
		// print error 
		if (this.numCards == 10){
			System.err.printf("%s's hand already has 10 cards;" + "cannot add another\n", this.name);
			System.exit(1);
		}
		//add new card in next slot
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return(this.getHandSum() <= 21);
	}
	
	public int getHandSum(){
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		//calc each cards contribution
		for(int c = 0; c < this.numCards; c++){
			
			cardNum = this.hand[c].getNumber();
			if(cardNum == 1){
				numAces++;
				handSum += 11;
			}
			else if (cardNum > 10){
				handSum += 10;
			}
			else{
				handSum += cardNum;
			}
		}
		// if we have aces and our sum is > 21, set some all to 1
		while( handSum > 21 && numAces > 0){
			handSum -= 10;
			numAces--;
		}
		return handSum;
	}
	public void printHand(boolean showFirstCard){
		System.out.printf("%s's cards:\n", this.name);
		for( int c =0; c < this.numCards; c++){
			if (c == 0 && !showFirstCard){
				System.out.println( "   [hidden]");
			} else{
				System.out.printf(" %s\n", this.hand[c].toString());
			}
		}
	}
}
