public class Cards {
    private final String suit;
    private  int cardValue;
    private String suitAbstract;
    //Constructor
    public Cards(String suit,int value){
        this.suit=suit;
        cardValue=value;
        if(suit.contains("Spades"))
            cardValue+=14;
    }
    //We can display the cards with this method.
    public String toString(){
            return suit+" || ";
    }
    //--------------------GETTERS SETTERS---------------------
    //Gives the suit with value.(5 of Spades for example).
    public String getSuit(){
        return this.suit;
    }
    public int getCardValue(){
        return cardValue;
    }
    //Gives the suit without value.(Spades for example).
    public String getSuitAbstract(){
        return suitAbstract;
    }
    public void setSuitAbstract(String s){
        suitAbstract=s;
    }


}
