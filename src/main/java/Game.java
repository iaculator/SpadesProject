import java.util.Random;
import java.util.Scanner;

public class Game {
    Deck d=new Deck();
    Hand playerhand=new Hand(d);
    Hand bothand0=new Hand(d);
    Hand bothand1=new Hand(d);
    Hand bothand2=new Hand(d);
    Player humanPlayer=new Player(playerhand,"human");
    Player bot0=new Player(bothand0,"bot");
    Player bot1=new Player(bothand1,"bot");
    Player bot2=new Player(bothand2,"bot");

    Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
       //Deck will be implemented.
       // Players will be implemented.
        //Hands will be implemented.
        //CardsOnTable will be implemented.
        StartGame();





    }
    // The method that will start tour by shuffling and distributing the cards with methods in Deck Class and other necessary loops etc and takeBids method will be called.
    // displayAllHands method will be called in method.

    public  static void StartGame(){


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

    }
    public void distrubuteHands(Hand h){

    }

}
