public class CardsOnTable {
    private LinkedList Table=new LinkedList();
    //Method will add Cards to table.
    public CardsOnTable(){

    }
    public void deleteFromTable(){
        for(int i=0;i<4;i++){
            Table.deleteFromTail();
        }
    }
    public void addCard(Cards c){
        Node tmp=new Node(c);
        Table.addToTail(tmp);
        System.out.print("Cards Added ::::::: ");
        Table.print();
    }

    public String getLastPlayedCard(){
        return Table.LastCardPlayedOnTable().getData().getSuit();
    }
    //GETTER
   public LinkedList getTableLinkedList(){
        return Table;
   }
}
