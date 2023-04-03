import java.util.Random;
import java.util.Scanner;

public class Game {


    Scanner sc=new Scanner(System.in);

       //Deck will be implemented.
       // Players will be implemented.
        //Hands will be implemented.
        //CardsOnTable will be implemented.
        Deck d=new Deck();
        Hand playerhand=new Hand(d);
        Player humanPlayer=new Player(playerhand,"human","You");
        Hand bothand0=new Hand(d);
        Player bot0=new Player(bothand0,"bot","Bot0");
        Hand bothand1=new Hand(d);
        Player bot1=new Player(bothand1,"bot","Bot1");
        Hand bothand2=new Hand(d);
        Player bot2=new Player(bothand2,"bot","Bot2");




        public Game(){
            StartGame();
        }







    // The method that will start tour by shuffling and distributing the cards with methods in Deck Class and other necessary loops etc and takeBids method will be called.
    // displayAllHands method will be called in method.

    public  void StartGame(){
        TakeBids();
        //displayAllHands();

        while(1<2){
            System.out.println("Do you want to see all hands?(answer with yes/no)");
            String s=sc.nextLine();
            if(s=="yes"){
                displayAllHands();
                break;
            }
            else if(s=="no"){
                break;
            }
            else if(s!="yes"&&s!="no"){
                System.out.println(s);
                System.out.println("Wrong input");
                continue;
            }
        }



    for(int i=0;i<13;i++){
        humanPlayer.Play();
        bot0.Play();
        bot1.Play();
        bot2.Play();
    }

    }

    //The method that will work when all the cards has been played then arrangePoints and checkPoints methods will be called.
    public void EndOfTour(){

    }
    // The method that will end the game when a player reaches at least 500 points at the end of tour.
    public void EndOfGame(){

    }
    //Player points will be arranged at the end of each tour.
    public void arrangePoints(){

    }
    //This method will check whether someone reached 500 points and if yes, EndOfGame method will be called.
    public void checkPoints(){

    }
    //In this method all hands will be displayed
    public void displayAllHands(){
            System.out.println("Your Hand is ");
            playerhand.getHandLinkedList().print();
            System.out.println("Bot0's hand is ");
            bothand0.getHandLinkedList().print();
            System.out.println("Bot1's hand is ");
            bothand1.getHandLinkedList().print();
            System.out.println("Bot2's hand is ");
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


}
