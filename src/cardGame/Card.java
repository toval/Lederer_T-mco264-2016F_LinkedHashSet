package cardGame;

public class Card{

private Rank rank;
private Suit suit;
private Color color;


public Card(Rank rank,Suit suit,Color color){
this.rank = rank;
this.suit = suit;
this.color = color;
}

public Rank getRank(){
return this.rank;
}
public Suit getSuit(){
return this.suit;
}
public Color getColor(){
return this.color;
}
public String toString(){
StringBuilder data = new StringBuilder();
data.append(rank);
data.append(" ");
data.append(suit);
data.append(" ");
data.append(color);
data.append(" ");
return data.toString();

}
}//end class