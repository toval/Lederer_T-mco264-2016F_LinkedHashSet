package cardGame;

import java.util.Scanner;
import java.util.Stack;
public class IdiotsDelight{

//fields
public static Deck theDeck;
public static Stack<Card>[]stacks;
public static int qtyCards;

public IdiotsDelight()throws EmptyException{
theDeck = new Deck();
theDeck.shuffle();
//array of the 4 cards, put into one stack
stacks =(Stack<Card>[])new Stack[4];
//instantiate a stack for each element of stacks[]
qtyCards = theDeck.getSize();

for(int i = 0;i<stacks.length;i++){
stacks[i] = new Stack<Card>();
//deal out 4 cards
stacks[i].push(theDeck.deal());
}//end for

}//end constructor

public void display(){
	System.out.println("stack 1\t\tstack2\t\tstack3\t\tstack4\t\tCards left");
	for(int i = 0;i<stacks.length;i++){
		
if(!(stacks[i].isEmpty())){					
System.out.print(stacks[i].peek().getRank().getRankValue() + " " + stacks[i].peek().getSuit() + " \t ");				     
}//end if
else{
	System.out.print("-\t\t");
}
	}//end for
//display qty of the cards
System.out.println(qtyCards);
}
//case 1-popping 2 stacks, cuz rank matches
public static void discard(int locationCard1,int locationCard2){
//the peek returns a card, which enables me to access the getRank and then the getRankValue
	
	if(!(locationCard1 > 4 || locationCard1 < 1 || locationCard1 == locationCard2 
			|| locationCard2 >4 || locationCard2 <1 || 
			stacks[locationCard1 -1].isEmpty() 
			|| stacks[locationCard2 - 1 ].isEmpty())){
	if(stacks[locationCard1 -1].peek().getRank().getRankValue() 
			== stacks[locationCard2 -1].peek().getRank().getRankValue()){
//they are both equal, so pop both
	stacks[locationCard1 - 1].pop();
stacks[locationCard2 - 1].pop();
//decrement qty of cards by 2, cuz popped off 2 cards
qtyCards -= 2;
	}//end if
	}
}
//case 2-popping 1 stack, that of the lower rank, cuz was matching suit
public static void discard(int cardLowRank){

	if(!(cardLowRank > 4 || cardLowRank < 1 || 
			stacks[cardLowRank -1].isEmpty())){
	for(int i =0;i<stacks.length;i++){

		//checking if user entered incorrrect data, or tried to cheat, 
	//if he cheated, will just reprint the menu.
	if(!(stacks[i]).isEmpty()){
	//make sure that it doesn't pull the same one
	if(!(stacks[cardLowRank -1].equals(stacks[i]))){
		
		//make sure that the suits match
		if(stacks[cardLowRank -1].peek().getSuit()
		.equals(stacks[i].peek().getSuit())) {
		
	//found that it matches suits, now find the one with the lower rank
		if(stacks[cardLowRank -1].peek().getRank().getRankValue() < 
			stacks[i].peek().getRank().getRankValue()){
		//found the lower one so pop it off
		stacks[cardLowRank -1].pop();
		//decrement it
		qtyCards--;
		break;
		}//end if
	}//end if
		}
}//end if
	}
}//end for


}//end method
public boolean gameWon(){
	if(qtyCards == 0){
		//the stack and deck are both empty!winner!
		return true;
	}
	else{
		return false;
	}
}
public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);

try{
	
	IdiotsDelight game = new IdiotsDelight();
	while(!game.gameWon()){
	//letting the user decide when to deal out cards..
		game.display();
		int choice = getMenu();
	
	switch(choice){
	case 1:
		
		//Scanner keyboard = new Scanner(System.in);
		System.out.println("Indicate which piles to discard top card 1,2,3,4");
		int locationCard1 = keyboard.nextInt();
		int locationCard2 = keyboard.nextInt();
		
			
		discard(locationCard1,locationCard2);
	break;

	case 2:
		
	System.out.println("indicate the pile with lower rank");
	int cardLowRank = keyboard.nextInt();
	discard(cardLowRank);
		break;

	case 3:
		try{
		for(int i =0;i<stacks.length;i++){
		//deal out 4 cards
		stacks[i].push(theDeck.deal());
		}//end for
		}//end try
		catch(EmptyException e1){
			System.out.println(e1.getMessage());
			
		}
		
		
	break;

	}//end switch	
	}//end while loop
System.out.println("you have won! congrats:)");
} 

catch (EmptyException e) {	
	System.out.println(e.getMessage());


}//end catch


}//end main
public static int getMenu(){
Scanner keyboard = new Scanner(System.in);
System.out.println("1. If there are 2 cards with the same rank showing, "
		+ "discard both\n 2. If there are 2 cards of same suit shouing, "
		+ "discard one with lower rank\n 3. Deal 4 new cards");
int choice = keyboard.nextInt();
return choice;
}

}//end class