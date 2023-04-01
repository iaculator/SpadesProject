public class Player {
    //a Hand will be implemented here.
    private int playerScore,bid;
    private String playerType;
    Player(Hand h,  String playerType){

    }

    public void Play(){

    }
    //This method will be called in Game and it will call PlayerPlay or BotPlay depending on the playerType.
    public void PlayerPlay(){

    }
    //In this method hand of bot will be displayed on the screen and bot will play a card it's hand.
    public void BotPlay(){

    }
    //--------------GETTERS SETTERS----------------
    public int getPlayerScore(){
        return playerScore;
    }
    public void setPlayerScore(int score){
        playerScore=score;
    }
    public int getBid(){
        return bid;
    }
    public void setBid(int b){
        bid=b;
    }

}
