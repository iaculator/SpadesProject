import java.util.Random;
import java.util.Scanner;
public class Player {
    //a Hand will be implemented here.
    Hand h;
    private int playerScore,bid,toursWon,cardValueOnTable;
    private String playerType,playerName;
    Scanner sc=new Scanner(System.in);
    Player(Hand h,  String playerType, String playerName){
        this.h=h;
        this.playerType=playerType;
        this.playerName=playerName;
        playerScore=0;
        toursWon=0;
    }

    public int Play(CardsOnTable tableLinkedList,String firstCard){
        if(playerType=="human")
             return PlayerPlay(tableLinkedList,firstCard);
        else{
            return BotPlay(tableLinkedList,firstCard);
        }

    }
    //This method will be called in Game, and it will call PlayerPlay or BotPlay depending on the playerType.
    public int PlayerPlay(CardsOnTable tableLinkedList,String firstCard){
        boolean a=true;
        int m=0;
        while(a==true){
            m++;
            System.out.println("Your current hand is: ");
            h.getHandLinkedList().print();
            System.out.println("Which card do you want to play?");
            String cardToPlay=sc.nextLine();
            //System.out.println(cardToPlay+"e");
            if(h.CheckInput(cardToPlay,tableLinkedList,firstCard)){
                a=false;
            }

            else{

                if(m==1)
                    //I added this statement due to some bug in my code that i couldn't find its reason but this statement solves it.
                   sc.nextLine();
                if(cardToPlay.isEmpty()){
                    System.out.println("You didn't enter anything. Please try again.");
                }else{
                    System.out.println("You can't play that card Please try again.");
                }
                continue;
            }
        }



        return h.getHumanCardValueOnTable();




    }
    //In this method hand of bot will be displayed on the screen and bot will play a card it's hand.
    public int BotPlay(CardsOnTable tableLinkedList,String firstCard){

                Node n=h.BotPlayCard(tableLinkedList,firstCard,playerName);

                cardValueOnTable=n.getData().getCardValue();
               // h.getHandLinkedList().print();
                h.getHandLinkedList().deleteMiddle(n);
                //System.out.println(cardValueOnTable);
                 return getCardValueOnTable();
    }
    //Bid of each player will be taken in this method and setBid method from Player Class will be used.
    public void takeBids(){

        if(playerType=="human"){
            System.out.println("-Enter your bid.");
            int bidInput= sc.nextInt();
            bid=bidInput;
            System.out.println("-Your bid is "+bid);
        }
        else{
            Random rand=new Random();
            int max=8;//I have limited the bot bid wth 8 otherwise game wouldn't be realistic.
            int randInInterval=rand.nextInt(2,max);
            bid=randInInterval;
            System.out.println("-"+playerName+"'s bid is "+bid);


        }


    }
    public void setFirstCard(){

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
    public int getCardValueOnTable(){
        return cardValueOnTable;
    }
    public void setCardValueOnTable(int i){
        cardValueOnTable=i;
    }
    public String getPlayerName(){
        return playerName;
    }
    public int getRoundstoWonLeft(){
        return (bid-toursWon);
    }
    public int getExtraRoundsWon(){
        return toursWon-bid;
    }
    public boolean checkAboveBid(){
        if(toursWon>bid)
            return true;
        else{
            return false;
        }
    }

}
