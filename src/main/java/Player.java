import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Player {
    //a Hand will be implemented here.
    private Hand h;
    private int playerScore,bid,toursWon,cardValueOnTable;
    private String playerType,playerName;
    //Constructor takes hand the type of player and player name as parameters.
    Player(Hand h,  String playerType, String playerName){
        this.h=h;
        this.playerType=playerType;
        this.playerName=playerName;
        playerScore=0;
        toursWon=0;
    }
    //This method will be called in Game, and it will call PlayerPlay or BotPlay depending on the playerType.
    public int Play(CardsOnTable tableLinkedList,String firstCard){
        if(playerType=="human")
             return PlayerPlay(tableLinkedList,firstCard);
        else{
            return BotPlay(tableLinkedList,firstCard);
        }

    }
    //Takes input from player checks if input is valid then calls necessary function from hand class.
    public int PlayerPlay(CardsOnTable tableLinkedList,String firstCard){
        boolean a=true;
        int m=0;
        while(a==true){
            Scanner sc=new Scanner(System.in);
            m++;
            System.out.print("Your current hand is: ");
            h.getHandLinkedList().print();
            System.out.println("");
            System.out.print("Which card do you want to play?(Enter card name exactly such as Jack of Spades):");
            String cardToPlay=sc.nextLine();
            if(h.CheckInput(cardToPlay,tableLinkedList,firstCard)){
                a=false;
            }
            else{
                if(cardToPlay.isEmpty()){
                    System.out.println("You didn't enter anything. Please try again.");
                }else{
                    System.out.println("Illegal card to play. Please try again.");
                }
                continue;
            }
        }
        return h.getHumanCardValueOnTable();
    }
    //In this method bot plays a card by calling BotPlayCard function in hand class and returns the value of the card played to be used while checking rounds winner in Game class. displaying bot's hand moved to game class.
    public int BotPlay(CardsOnTable tableLinkedList,String firstCard){
                Node n=h.BotPlayCard(tableLinkedList,firstCard,playerName);
                cardValueOnTable=n.getData().getCardValue();
                h.getHandLinkedList().deleteMiddle(n);
                 return getCardValueOnTable();
    }
    //Bid of players will be taken in this method, the bid player make will be displayed and will make necessary exception handlings.(taking input from player and choosing a random valid number for bots).
    public void takeBids(){
        int bidInput=0;
        if(playerType=="human"){
            System.out.print("Your hand is: ");
            h.getHandLinkedList().print();
            while(1<2){
                Scanner scx=new Scanner(System.in);
                try {
                    System.out.print("-Enter your bid:");
                    bidInput= scx.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input! Please try again.");
                    continue;
                }
                if(bidInput>13||bidInput<0){
                    System.out.println("That bid is out of range please enter a bid between 0 and 13.");
                    continue;
                }
                else{
                    break;
                }
            }
            bid=bidInput;
            if(bid==0){
                System.out.println("-Your bid is Nill.");
            }
            else{
                System.out.println("-Your bid is "+bid+".");
            }

        }
        else{
            Random rand=new Random();
            int max=8;//I have limited the bot bid wth 8 otherwise game wouldn't be realistic.
            int randInInterval=rand.nextInt(0,max);
            bid=randInInterval;
            if(bid==0){
                System.out.println("-"+playerName+"'s bid is Nill.");
            }
            else{
                System.out.println("-"+playerName+"'s bid is "+bid+".");
            }

        }
    }
    //--------------GETTERS SETTERS----------------
    public int getPlayerScore(){
        return playerScore;
    }
    public void setPlayerScore(int score){
        playerScore+=score;
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
    //increases the toursWon
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
    public void resetToursWon(){
        toursWon=0;
    }
    public int getExtraRoundsWon(){
        return toursWon-bid;
    }
    public boolean checkAboveBid(){
        if(toursWon-bid>0)
            return true;
        else{
            return false;
        }
    }

}
