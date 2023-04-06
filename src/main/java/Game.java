import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc=new Scanner(System.in);
       //Deck will be implemented.
       // Players will be implemented.
        //Hands will be implemented.
        //CardsOnTable will be implemented.
        private Deck d=new Deck();
        private Hand bothand0=new Hand(d);
        private Player bot0=new Player(bothand0,"bot","Bot0");
        private Hand playerhand=new Hand(d);
        private Player humanPlayer=new Player(playerhand,"human","You");
        private Hand bothand1=new Hand(d);
        private Player bot1=new Player(bothand1,"bot","Bot1");
        private Hand bothand2=new Hand(d);
        private Player bot2=new Player(bothand2,"bot","Bot2");
        private CardsOnTable cardsonTable=new CardsOnTable();
        private String firstCard;
        private Cards card;
        private boolean gameOver=false;
        private int b0CardValue,hCardValue,b1CardValue,b2CardValue,tourCount;
        //Constructor, Calls directly the StarGame function and starts the game.
        public Game(){
            StartGame();
        }

    // The method that will start tour by shuffling and distributing the cards with methods in Deck Class and other necessary loops etc and takeBids method will be called.
    // displayAllHands method will be called in method.
    //(shuffling and distrubuting is being made in Hand class with addCard method!!!)
    public  void StartGame(){
            tourCount++;
        System.out.println("--------------------------------------------------------------"+"TOUR "+(tourCount)+"--------------------------------------------------------------");
        System.out.println("-Spades is the trump.");
        String s;
        //Just added this as an extra you can play by seeing only your hand or by seeing all players hand.
        while(1<2){
            System.out.print("Do you want to see all the hands?(answer with yes/no):");
            s=sc.nextLine();
            if(s.equals("yes")){
                displayAllHands();
                System.out.println("");
                break;
            }
            if(s.equals("no")){
                System.out.println("");
                break;
            }
            else{
                System.out.println("Wrong input! Please write yes/no");
                continue;
            }
        }
        System.out.println("-----------------------------------BIDS-----------------------------------");
        //Taking the bids from players
        TakeBids();
        //In this loop players play their cards in order.
        for(int i=0;i<13;i++){
             int a=i+1;
            System.out.println("-------------------------------------------------"+"ROUND "+(a)+"-------------------------------------------------");
            // At first round which is when i=0 bot0 will play a random card and after that, players will play if they have cards with the same suit as first played card.
                if(i==0) {
                    FirstCard();
                    if(s.equals("yes")){
                        System.out.print("Bot 0's hand is: ");
                        bothand0.getHandLinkedList().print();
                    }
                    System.out.println("----------------------------------------------------------------------------------");
                }
                else {
                   b0CardValue= bot0.Play(cardsonTable,firstCard);
                   if(s.equals("yes")){
                       System.out.print("Bot 0's hand is: ");
                       bothand0.getHandLinkedList().print();
                   }
                    System.out.println("----------------------------------------------------------------------------------");
                }
               b1CardValue= bot1.Play(cardsonTable,firstCard);
                if(s.equals("yes")){
                    System.out.print("Bot 1's hand is: ");
                    bothand1.getHandLinkedList().print();
                }
                System.out.println("----------------------------------------------------------------------------------");
              b2CardValue= bot2.Play(cardsonTable,firstCard);
                if(s.equals("yes")){
                    System.out.print("Bot 2's hand is: ");
                    bothand2.getHandLinkedList().print();
                }
            System.out.println("----------------------------------------------------------------------------------");
                System.out.print("----------------------------------------CARDS ON TABLE----------------------------------------");
                cardsonTable.getTableLinkedList().print();
            System.out.println("----------------------------------------------------------------------------------------------");
               hCardValue= humanPlayer.Play(cardsonTable,firstCard);
                System.out.println("");
                Player playerWon=findthePlayerWithGreatestCard();
                if(playerWon==humanPlayer){
                    System.out.println("You have won this round.");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                else{
                    System.out.println(playerWon.getPlayerName()+" won the round");
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                displayRoundsToWon();
        }
        EndOfTour();
    }



    //The method that will work when all the cards has been played then arrangePoints method will be called. İf someone reached 500 point it will cal EndOfGame method else it will also create a new deck and call StartGame function
    public void EndOfTour(){
        System.out.println("------------------------------------POINTS------------------------------------");
        arrangePoints(bot0);
        arrangePoints(bot1);
        arrangePoints(bot2);
        arrangePoints(humanPlayer);
        if(gameOver){
            EndOfGame();
        }
        else{
            Deck d1=new Deck();
            d=d1;
            bothand0.addCard(d);
            bothand1.addCard(d);
            bothand2.addCard(d);
            playerhand.addCard(d);
            bot0.resetToursWon();
            bot1.resetToursWon();
            bot2.resetToursWon();
            humanPlayer.resetToursWon();
            StartGame();
        }


    }
    // The method that will be called at the end of game if a player reaches at least 500 points at the end of tour.
    public void EndOfGame(){

    }
    //Player points will be arranged at the end of each tour also calls checkPoint function.
    public void arrangePoints(Player p){
            int point;
        if(p.getBid()==0){
            if(p.checkAboveBid())
                point=-100;
            else{
                point=+100;
            }
        }
        else{
            if(p.checkAboveBid()){
                point=p.getBid()*10+p.getExtraRoundsWon();
            }
            else{
                point=-(p.getBid()*10);
            }
        }
        p.setPlayerScore(point);
        System.out.println(p.getPlayerName()+": "+p.getPlayerScore());
        checkPoints(p);
    }
    //This method will check whether someone reached 500 points and if yes, it will return true.
    public void checkPoints(Player p){
        if(p.getPlayerScore()>=500){
            System.out.println(p.getPlayerName()+" won the game with "+p.getPlayerScore());
            if(p.getPlayerName().equals("You"))
                System.out.print(" Congratulations!");
            gameOver=true;
        }
    }
    //In this method all hands will be displayed
    public void displayAllHands(){
            System.out.println("-----------------------------------YOUR HAND----------------------------------- ");
            playerhand.getHandLinkedList().print();
            System.out.println("-----------------------------------BOT0'S HAND-----------------------------------");
            bothand0.getHandLinkedList().print();
            System.out.println("-----------------------------------BOT1'S HAND-----------------------------------");
            bothand1.getHandLinkedList().print();
            System.out.println("-----------------------------------BOT2'S HAND-----------------------------------");
            bothand2.getHandLinkedList().print();
    }
    //the function calls the takeBids function in Player class for each player
    public void TakeBids(){
            humanPlayer.takeBids();
            bot0.takeBids();
            bot1.takeBids();
            bot2.takeBids();
    }
    // the function that assigns the firstCard String the suit of the first card and firstCard is being used at play functions in Player class as parameter to be used for the logic of the game
    public void FirstCard(){
            firstCard=bothand0.FirstCard(cardsonTable);
            bot0.setCardValueOnTable(bothand0.getHumanCardValueOnTable());
            b0CardValue=bot0.getCardValueOnTable();
    }
// Simply displays the current situation of the rounds player need to win to reach their bid and displays the extra rounds they won if they won more rounds than their bids.
    public void displayRoundsToWon(){
            if(bot0.checkAboveBid()){
                System.out.println("Bot0 won extra +"+bot0.getExtraRoundsWon()+" rounds.");
            }
            else{
                System.out.println("Bot0 must win "+ bot0.getRoundstoWonLeft()+" rounds to reach the bid.");
            }
            if(bot1.checkAboveBid()){
                System.out.println("Bot1 won extra +"+bot1.getExtraRoundsWon()+" rounds.");
             }
            else{
                System.out.println("Bot1 must win "+ bot1.getRoundstoWonLeft()+" rounds to reach the bid.");
            }
            if(bot2.checkAboveBid()){
                System.out.println("Bot2 won extra +"+bot2.getExtraRoundsWon()+" rounds.");
            }
            else{
                System.out.println("Bot2 must win "+ bot2.getRoundstoWonLeft()+" rounds to reach the bid.");
            }
            if(humanPlayer.checkAboveBid()){
                System.out.println("You won extra +"+humanPlayer.getExtraRoundsWon()+" rounds.");
            }
            else{
                System.out.println("You must win "+ humanPlayer.getRoundstoWonLeft()+" rounds to reach the bid.");
            }
    }
    // finds the player with the maximum value and decides the winner of the round and returns that player.
    public Player findthePlayerWithGreatestCard(){
       int max=   Math.max(Math.max(b0CardValue,b1CardValue),Math.max(b2CardValue,hCardValue));
        cardsonTable.deleteFromTable();
                if(max==b0CardValue){
                    bot0.IncToursWon();
                    return bot0;
                }
                else if(max==b1CardValue){
                    bot1.IncToursWon();
                    return bot1;
                }
                else if(max==b2CardValue){
                    bot2.IncToursWon();
                    return bot2;
                }
                else  if(max==hCardValue){
                    humanPlayer.IncToursWon();
                    return humanPlayer;
                }
                else{
                  return null;
                }
    }
}
