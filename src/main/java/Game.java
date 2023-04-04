import java.util.Random;
import java.util.Scanner;

public class Game {


    Scanner sc=new Scanner(System.in);

       //Deck will be implemented.
       // Players will be implemented.
        //Hands will be implemented.
        //CardsOnTable will be implemented.
        Deck d=new Deck();
        Hand bothand0=new Hand(d);
        Player bot0=new Player(bothand0,"bot","Bot0");
        Hand playerhand=new Hand(d);
        Player humanPlayer=new Player(playerhand,"human","You");
        Hand bothand1=new Hand(d);
        Player bot1=new Player(bothand1,"bot","Bot1");
        Hand bothand2=new Hand(d);
        Player bot2=new Player(bothand2,"bot","Bot2");
        CardsOnTable cardsonTable=new CardsOnTable();
        private String firstCard;
        Cards card;



        int b0CardValue,hCardValue,b1CardValue,b2CardValue;
        public Game(){
            StartGame();
        }







    // The method that will start tour by shuffling and distributing the cards with methods in Deck Class and other necessary loops etc and takeBids method will be called.
    // displayAllHands method will be called in method.

    public  void StartGame(){
            System.out.println("-----------------------------------BIDS-----------------------------------");
        TakeBids();
        //displayAllHands();

        //Just added this as an option.
        while(1<2){
            System.out.println("Do you want to see all the hands?(answer with yes/no)");
            String s=sc.nextLine();
            if(s.equals("yes")){
                displayAllHands();
                break;
            }
            if(s.equals("no")){
                break;
            }
            else{
                System.out.println("Wrong input! Please write yes/no");
                continue;
            }
        }
        System.out.println("-------------------------------------GAME-------------------------------------");
    for(int i=0;i<13;i++){
            if(i==0) {
                FirstCard();
                bothand0.getHandLinkedList().print();
                System.out.println("----------------------------------------------------");
            }
            else {
                //cardsonTable.getTableLinkedList().print();
               b0CardValue= bot0.Play(cardsonTable,firstCard);
                bothand0.getHandLinkedList().print();
                //System.out.println(firstCard);
                System.out.println("Bot0 Played:hığ? "+cardsonTable.getLastPlayedCard());
                System.out.println("----------------------------------------------------");
            }

           b1CardValue= bot1.Play(cardsonTable,firstCard);
            bothand1.getHandLinkedList().print();

            System.out.println("Bot1 Played: " +cardsonTable.getLastPlayedCard());
            System.out.println("----------------------------------------------------");

          b2CardValue= bot2.Play(cardsonTable,firstCard);
            bothand2.getHandLinkedList().print();
            System.out.println("Bot2 Played: "+cardsonTable.getLastPlayedCard());
        System.out.println("----------------------------------------------------");
            //playerhand.getHandLinkedList().print();
           hCardValue= humanPlayer.Play(cardsonTable,firstCard);
            System.out.println("--------------------CARDS ON TABLE--------------------");
            cardsonTable.getTableLinkedList().print();
            Player playerWon=findthePlayerWithGreatestCard();
            if(playerWon==humanPlayer)
                System.out.println("You have won this round.");
            else{
                System.out.println(playerWon.getPlayerName()+" won the round");
            }




        }


    }



    //The method that will work when all the cards has been played then arrangePoints and checkPoints methods will be called.
    public void EndOfTour(){

    }
    // The method that will end the game when a player reaches at least 500 points at the end of tour.
    public void EndOfGame(){

    }
    //Player points will be arranged at the end of each tour.
    public void arrangePoints(Hand h){

        cardsonTable.deleteFromTable();
    }
    //This method will check whether someone reached 500 points and if yes, EndOfGame method will be called.
    public void checkPoints(){

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
    public void compareCardsOnTable(){

    }
    public void TakeBids(){
            humanPlayer.takeBids();
            bot0.takeBids();
            bot1.takeBids();
            bot2.takeBids();
    }
    public void FirstCard(){
          firstCard=bothand0.FirstCard(cardsonTable);

    }
    public Player findthePlayerWithGreatestCard(){
       int max=   Math.max(Math.max(b0CardValue,b1CardValue),Math.max(b2CardValue,hCardValue));
        cardsonTable.deleteFromTable();

                if(max==b0CardValue){
                    bot0.IncToursWon();
                    return bot0;
                }


                if(max==b1CardValue){
                    bot1.IncToursWon();
                    return bot1;
                }

                if(max==b2CardValue){
                    bot2.IncToursWon();
                    return bot2;
                }

                if(max==hCardValue){
                    humanPlayer.IncToursWon();
                    return humanPlayer;
                }
                else{
                    return null;
                }


    }



}
