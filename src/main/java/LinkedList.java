public class LinkedList {
    Node head;
    Node tail;
    public LinkedList(){
        head=null;
        tail=null;
    }
    //will be used when creating the hand and deck
    public void addToTail(Node n){
        if(head==null){
            head=n;
        }
        else{
            tail.setNext(n);
        }
        tail=n;
    }
    //will be used while removing from hand.
    public void deleteHead(){

    }
    //will be used while removing from hand.
    public void deleteMiddle(){

    }
    //will be used while removing from both hand and deck.
    public void deleteFromTail(){
        if(tail==null&&head!=null){
            head=null;
        }
        else{
            tail=getPrevious(tail);
            tail.setNext(null);
        }
    }

    //The method that will choose 1 card from the hand and return that node(for bot players).
    //public Node search(Hand CardsInHand){


    //}
    // The method that will get the corresponding Node from the LinkedList according to Input from the player
      //public Node getInputParameter(Cards Card){

    //}
    public Node getPrevious(Node n){
        Node tmp=head;
        Node previous=null;
        while(tmp!=n){
            previous=tmp;
            tmp=tmp.getNext();
        }
        return previous;
    }
    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data.toString() + ",");
            tmp = tmp.next;
        }
    }
}
