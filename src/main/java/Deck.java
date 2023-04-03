public class Deck {

    private LinkedList cardsInDeck=new LinkedList();
    private String suit="";
    private int nume;




    public Deck(){
    nume=0;
    createDeck();
    }

    // total of 52 cards will be shuffled Randomly
    public void shuffleDeck(){

    }
    // In this method cards that are already been shuffled will be distributed to hand as 13 cards for each hand.
    public void distributeCards(Hand h){

    }
        public void createDeck(){
            for(int t=0;t<4;t++){

                switch (t){
                    case 0: suit="Clubs";
                        break;
                    case 1: suit="Diamonds";
                        break;
                    case 2: suit="Hearts";
                        break;
                    case 3: suit="Spades";
                        break;
                }
                String tmp=suit;
                suit=tmp;
                for(int i=2;i<=14;i++){
                    String s="";
                    switch(i){
                        case 11:s=" "+"Jack";
                            break;
                        case 12:s=" "+"Queen";
                            break;
                        case 13:s=" "+"King";
                            break;
                        case 14:s=" "+"Ace";
                            break;
                    }
                    suit=tmp+ s;

                    Cards c=new Cards(suit,i);
                    Node n=new Node(c);
                    cardsInDeck.addToTail(n);
                    nume++;

                }

            }
            //cardsInDeck.print();
            //System.out.println(nume);


        }
        public LinkedList getDeckLinkedList(){
            return cardsInDeck;
        }
        public int getNume(){
            return nume;
        }
        public void setNume(int nume){
            this.nume=nume;
        }
        public void decreaseNume(){
            nume--;
        }

}
