import java.util.Random;
import java.util.Scanner;
public class Player {
    //a Hand will be implemented here.
    private int playerScore,bid,toursWon;
    private String playerType,playerName;
    Scanner sc=new Scanner(System.in);
    Player(Hand h,  String playerType, String playerName){
        this.playerType=playerType;
        this.playerName=playerName;
        playerScore=0;
        toursWon=0;
    }

    public void Play(){
        if(playerType=="human")
            PlayerPlay();
        else{
            BotPlay();
        }

    }
    //This method will be called in Game, and it will call PlayerPlay or BotPlay depending on the playerType.
    public void PlayerPlay(){


    }
    //In this method hand of bot will be displayed on the screen and bot will play a card it's hand.
    public void BotPlay(){

    }
    //Bid of each player will be taken in this method and setBid method from Player Class will be used.
    public void takeBids(){

        if(playerType=="human"){
            System.out.println("Enter your bid.");
            int bidInput= sc.nextInt();
            bid=bidInput;
            System.out.println("Your bid is "+bid);
        }
        else{
            Random rand=new Random();
            int max=8;//I have limited the bot bid wth 8 otherwise game wouldn't be realistic.
            int randInInterval=rand.nextInt(max);
            bid=randInInterval;
            System.out.println(playerName+"'s bid is "+bid);


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
    public int getToursWon(){
        return getToursWon();
    }
    public void IncToursWon(){
        toursWon++;
    }

}
