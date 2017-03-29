import java.util.Random;

public class Deck {
	
private Card[] myCards;
private int numCards;


public Deck(){
	//call the other constructor, defing one deck without shuffling
	this(1, false);
}

public Deck(int numDecks, boolean shuffle){
	this.numCards = numDecks * 52;
	this.myCards = new Card[this.numCards];
	
	//init card index
	int c = 0;
	//for each deck
	for (int d = 0; d < numDecks; d++){
		// for each suit
		for(int s = 0; s < 4; s++){
			//for each number 
			for (int n = 1; n <= 13; n++ ){
				// add a new card to the deck
				this.myCards[c] = new Card(Suit.values()[s], n);
				c++;
				}
			}
		if(shuffle){
			this.shuffle();
		}
		}	
	}
 //shuflle deck randomly
public void shuffle(){
	// int random number generaotr
	Random rng = new Random();
	
	// temp card
	Card temp;
	
	int j;
	for(int i = 0; i < this.numCards; i++){
		
		//get a random card j to swap i's value	
		j = rng.nextInt(this.numCards);
		
		// swapping between arrays
		temp = this.myCards[i];
		this.myCards[i] = this.myCards[j];
		this.myCards[j] = temp;
		
		}
	}
public Card dealNextCard(){
	//get top card
	Card top = this.myCards[0];
	
	// shift all the cards to the left by one
	for(int c = 1; c < this.numCards; c++){
		this.myCards[c-1] = this.myCards[c];
	}
	this.myCards[this.numCards-1] = null;
	
	//decments the number of cards in our deck
	this.numCards--;
	
	return top;
	}
public void printDeck(int numToPrint){
	for(int c = 0; c < numToPrint; c++){
		System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
		}
	System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
	}
}
