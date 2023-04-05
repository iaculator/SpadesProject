public class CardsOnTable {
    private LinkedList Table=new LinkedList();
    //Method will add Cards to table.
    Deck d;
    public CardsOnTable(Deck d){
        this.d=d;
    }
    public void deleteFromTable(){
        for(int i=0;i<4;i++){
            d.getDeckLinkedList().addToTail(Table.getTail());
            Table.deleteFromTail();
        }
    }
    public void addCard(Cards c){
        Node tmp=new Node(c);
        Table.addToTail(tmp);
        //System.out.print("Cards Added ::::::: ");
    }

    public String getLastPlayedCard(){
        return Table.LastCardPlayedOnTable().getData().getSuit();
    }
    //GETTER
   public LinkedList getTableLinkedList(){
        return Table;
   }
}
