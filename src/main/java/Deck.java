public class Deck {
    private LinkedList cardsInDeck=new LinkedList();
    private String suit="";
    private int nume;




    //Constructor
    public Deck(){
    nume=0;
    createDeck();
    }
        //the functions that simply creates the deck by adding necessary cards to linkedList.
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
                    if(i<11)
                        s=i+" of ";
                    switch(i){
                        case 11:s="Jack of ";
                            break;
                        case 12:s="Queen of ";
                            break;
                        case 13:s="King of ";
                            break;
                        case 14:s="Ace of ";
                            break;
                    }
                    suit=s+tmp;
                    Cards c=new Cards(suit,i);
                    c.setSuitAbstract(tmp);
                    Node n=new Node(c);
                    cardsInDeck.addToTail(n);
                    nume++;
                }
            }
        }
        //___________Getters and other necessary functions to increase and decrease number of elements in the linked list of deck.
        public LinkedList getDeckLinkedList(){
            return cardsInDeck;
        }
        public int getNume(){
            return nume;
        }
        public void IncNume(){
            this.nume++;
        }
        public void decreaseNume(){
            nume--;
        }

}
