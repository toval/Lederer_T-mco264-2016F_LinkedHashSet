package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

	//fields
	public ArrayList<Card>cards;
	public Rank rank;
	public Suit suit;
	public Color color;
	//constructor
	public Deck(){
	//52 cards
	cards = new ArrayList<Card>(51);
	
	for(int i =0;i< 13;i++){
	cards.add(new Card(rank.values()[i],suit.HEARTS,color.RED));
	cards.add(new Card(rank.values()[i],suit.DIAMONDS,color.RED));
	cards.add(new Card(rank.values()[i],suit.SPADES,color.BLACK));
	cards.add(new Card(rank.values()[i],suit.CLUBS,color.BLACK));
	}
	}//end constructor

	public void shuffle(){
		//invoking the random class
	Random shuffle = new Random(System.currentTimeMillis());
	//holding the number that was just generated
	for(int i =0;i<cards.size();i++){
	int numGenerated = shuffle.nextInt(51); 
    //holding data at current position
	Card temp = cards.get(i);
	//putting the randomNum into index
	Card t = cards.get(numGenerated);
	cards.set(i,t);
	//putting index card into the random
	//doing a switch
	cards.set(numGenerated,temp);
	
	}//end for	 
	}
	
	public Card deal()throws EmptyException{
		//removing the cards from the arrayList of cards and putting it into the stack
		if(!isEmpty()){
			//peek and store the card, so that can return it
			//removing the next card from the deck
			return cards.remove(cards.size()-1);
			//return peek;
			
		}
			else{

			throw new EmptyException();
			}	
	}
	public boolean isEmpty(){
	if(cards.size() == 0)
	return true;
	//otherwise
	return false;
	}
	public int getSize(){
		return cards.size();
	}
	}//end class