import java.util.Random;
import java.util.Scanner;
public class Player {
    //a Hand will be implemented here.
    private int playerScore,bid;
    private String playerType;
    Scanner sc=new Scanner(System.in);
    Player(Hand h,  String playerType){

    }

    public void Play(){
        if(playerType=="human")
            PlayerPlay();
        else{
            BotPlay();
        }

    }
    //This method will be called in Game and it will call PlayerPlay or BotPlay depending on the playerType.
    public void PlayerPlay(){

    }
    //In this method hand of bot will be displayed on the screen and bot will play a card it's hand.
    public void BotPlay(){

    }
    //Bid of each player will be taken in this method and setBid method from Player Class will be used.
    public void takeBids(){

        if(playerType=="human"){
            System.out.println("Enter your bid");
            int bidInput= sc.nextInt();
            bid=bidInput;
        }
        else{
            Random rand=new Random();
            int max=8;//I have limited the bot bid wth 8 otherwise game wouldn't be realistic.
            int randInInterval=rand.nextInt(max);
            bid=randInInterval;
        }


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
