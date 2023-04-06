import java.util.Random;

public class Hand {
    private int nume,humanCardValueOnTable;
    private LinkedList cardsInHand=new LinkedList();
    //Constructor, takes deck as parameter for add card method.
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
            int randInInterval=rand.nextInt(max);
            Node tmp = d.getDeckLinkedList().getHead();
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
        }
    //The card that player played will be deleted from the Hand LinkedList(is being done in the PLayer class version).
    //the card human played is being added to table.
    public void HumanPlayCard(Node card,CardsOnTable table){
        humanCardValueOnTable=card.getData().getCardValue();
        Cards c =new Cards(card.getData().getSuit(),humanCardValueOnTable);
        table.addCard(c);
    }
    //Bot plays the card with maximum value in game rules and adding that card to table and return that cards node
    public Node BotPlayCard(CardsOnTable table,String s,String playerName){
        Node n=cardsInHand.ExactSearch(s);
        Node tmp=n;
        Cards c=new Cards(n.getData().getSuit(),n.getData().getCardValue());
        table.addCard(c);
        System.out.println(playerName+ " played: "+ n.getData().getSuit() );
        return tmp;
    }
    //Plays a random card in bot0's hand except spades(since it's the trump)and add it to table than returns that card's suit.
    public String FirstCard(CardsOnTable table){
        Random rand=new Random();
        Node n;
        while(1<2){
            int x=rand.nextInt(1,14);
             n=cardsInHand.pickFirstCard(x);
            if(n==null){
                continue;
            }
            else{
                break;
            }
        }
            Cards firstCard =n.getData();
            String suitOfFirstCard=firstCard.getSuitAbstract();
            System.out.println("Bot0 Played: "+firstCard.getSuit());
            getHandLinkedList().deleteMiddle(n);
            table.addCard(firstCard);
            humanCardValueOnTable= firstCard.getCardValue();
        return suitOfFirstCard;
    }
    // The function that checks if the input of player exists in hand linked list and if it can be playable.
    public boolean CheckInput(String s,CardsOnTable table,String firstCard){
        Node n=cardsInHand.checkinputFromPlayer(s,firstCard);
        if(n==null){
            return false;
        }else{
            getHandLinkedList().deleteMiddle(n);
            HumanPlayCard(n,table);
           return true;
        }
    }
    // Getters
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
