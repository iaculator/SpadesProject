public class Cards {
    private final String suit;
    private final int cardValue;

    public Cards(String suit,int value){
        this.suit=suit;
        cardValue=value;

    }
    //We can display the cards with this method.
    public String toString(){
        if(cardValue<11)
        return suit+cardValue;
        else
            return suit;
    }
    //--------------------GETTERS---------------------
    public String getSuit(){
        return this.suit;
    }
    public int getCardValue(){
        return cardValue;
    }

}
