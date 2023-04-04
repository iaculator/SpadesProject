public class Cards {
    private final String suit;
    private final int cardValue;
    private String suitAbstract;

    public Cards(String suit,int value){
        this.suit=suit;
        cardValue=value;

    }
    //We can display the cards with this method.
    public String toString(){

            return suit+" || ";


    }
    //--------------------GETTERS---------------------
    public String getSuit(){
        return this.suit;
    }
    public int getCardValue(){
        return cardValue;
    }
    public String getSuitAbstract(){
        return suitAbstract;
    }
    public void setSuitAbstract(String s){
        suitAbstract=s;
    }


}
