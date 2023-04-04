import java.util.Random;

public class Hand {
    private int nume,humanCardValueOnTable;
    private LinkedList cardsInHand=new LinkedList();

    //A player will be implemented here.
    public Hand(Deck d){
        nume=0;
        addCard(d);

    }
    //random 13 cards from Deck will be added to cardsInHand Linked List.
    public void addCard(Deck d){
        int a=0;


        while(a<13){
            Random rand=new Random();
            int max=d.getNume();
            //System.out.println(max);
            int randInInterval=rand.nextInt(max);
           // System.out.println(d.getDeckLinkedList().getHead().getData());
            Node tmp = d.getDeckLinkedList().getHead();
            //System.out.println(randInInterval);
            for(int i=0;i<randInInterval;i++ ){
                if(tmp.getNext()!=null){
                    tmp = tmp.next;
                }


            }
            Node tmp1=tmp;
            d.getDeckLinkedList().deleteMiddle(tmp1);
            tmp.setNext(null);
            cardsInHand.addToTail(tmp);

            d.decreaseNume();
            a++;
            nume++;
            }
        //d.getDeckLinkedList().print();
        //cardsInHand.print();
        //System.out.println(nume);
        }



    //The card that player played will be deleted from the Hand LinkedList.
    public void HumanPlayCard(Node card,CardsOnTable table){
        humanCardValueOnTable=card.getData().getCardValue();
        Cards c =new Cards(card.getData().getSuit(),humanCardValueOnTable);
        table.addCard(c);


    }
    public Node BotPlayCard(CardsOnTable table,String s){

        Node n=cardsInHand.ExactSearch(s);
        getHandLinkedList().print();;
        Node tmp=n;
        Cards c=new Cards(n.getData().getSuit(),n.getData().getCardValue());
        //n.setNext(null);
        //tmp.setNext(null);
        table.addCard(c);
        getHandLinkedList().print();;
        return tmp;
    }
    public String FirstCard(CardsOnTable table){
        Random rand=new Random();
        int x=rand.nextInt(2,14);
        Node n=cardsInHand.pickFirstCard(x);
        Cards firstCard =n.getData();
        String suitOfFirstCard=firstCard.getSuit();
        System.out.println("Bot0 Played: "+suitOfFirstCard);
        getHandLinkedList().deleteMiddle(n);
        table.addCard(firstCard);

        return suitOfFirstCard;
    }
    public boolean CheckInput(String s,CardsOnTable table){
        Node n=cardsInHand.checkinputFromPlayer(s);
        if(n==null){
            return false;
        }else{
            getHandLinkedList().deleteMiddle(n);
            n.setNext(null);
           return true;
        }

    }
    //will be used to display the current hand
    //public String toString(){

    //}
    //With this method we will be able to make changes on LinkedList from Player class
    public LinkedList getHandLinkedList(){
        return cardsInHand;
    }
    public int getNume(){
        return nume;
    }
    public int getHumanCardValueOnTable(){
        return humanCardValueOnTable;
    }
}
