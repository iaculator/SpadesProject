public class LinkedList {
    private Node head;
    private Node tail;
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



            if(head==null)
                tail=null;
            else
            head=head.getNext();


    }
    //will be used while removing from hand.
    public void deleteMiddle(Node n){
        Node previous;
        previous=getPrevious(n);
        if(previous==null){
            deleteHead();
        }
        else{
            if(n.getNext()==null){
                deleteFromTail();
            }
            else{
                previous.setNext(n.getNext());
            }
        }


    }
    //will be used while removing from both hand and deck.
    public void deleteFromTail(){
            tail = getPrevious(tail);
            if (tail != null){
                tail.setNext(null);
            } else {
                head = null;
            }
    }
    //Gives the previous Node.
    public Node getPrevious(Node n){
        Node tmp=head;
        Node previous=null;
        while(tmp!=n){
            previous=tmp;
            tmp=tmp.getNext();
        }
        return previous;
    }
    //prints the LinkedList
    public void print() {
        lineArrangement();
        int a=0;
        Node tmp = head;
        while (tmp != null) {
            if(a%6==0){
                System.out.println("");
                lineArrangement();
            }
            System.out.print(tmp.getData().toString()+" ");
            tmp = tmp.getNext();
            a++;
        }
        System.out.println("("+a+" cards)");
    }
    // a function being used for line arrangements.
    public void lineArrangement(){
        for(int i=0;i<15;i++){
            System.out.print(" ");
        }
    }
    //The function checks if the input player entered exists in Players hand if yes returns that node.
    public Node checkinputFromPlayer(String s,String firstCard){
        Node tmp = head;
        Node tmp2=head;
        while (tmp2 != null) {
            if(tmp2.getData().getSuit().contains(firstCard)){
                break;
            }
            tmp2 = tmp2.getNext();
        }
        while (tmp != null) {
            if(s.contains(tmp.getData().getSuit())){

                break;
            }
            tmp = tmp.getNext();

        }
        if(tmp==null){
            return null;
        }
        else{
            if(tmp2!=null&&tmp.getData().getSuit().contains(firstCard)==false){
                return null;
            }
            else{
                return tmp;
            }
        }
    }
    // The function that picks the first card.
    public Node pickFirstCard(int x){
        Node tmp=head;
        for(int i=0;i<x;i++){
            tmp=tmp.getNext();
            //I wrote this in order to avoid getting null pointer exception
            if(tmp==null)
                tmp=getPrevious(tmp);

        }
            if(tmp.getData().getSuitAbstract().equals("Spades"))
                return null;
            else{
                return tmp;
            }

    }

    //this function is being used when bots playing checks if there are any cards with the same suit as first played card and returns the one with largest value.
    public Node ExactSearch(String suit) {
        Node tmp = head, MaxCardx=null;
        int max = 0, currentValue,NodesAftereMaxCard=0;
        while (tmp != null) {
            Node MaxCard=null;
            if (suit.contains(tmp.getData().getSuitAbstract())) {
                //System.out.println(suit.contains(tmp.getData().getSuitAbstract()));
                currentValue = tmp.getData().getCardValue();
                //System.out.println(currentValue);
                if (max < currentValue) {
                    max = currentValue;
                    NodesAftereMaxCard=0;
                }
                else{
                    NodesAftereMaxCard++;
                }
            }
            else{
                NodesAftereMaxCard++;
            }
            tmp = tmp.getNext();
            if(tmp==null){
                tmp=getPrevious(tmp);
                break;
            }
        }
        for(int i=0;i<=NodesAftereMaxCard;i++){
            MaxCardx=(tmp);
            tmp=getPrevious(tmp);
        }
        //System.out.println(MaxCardx);
        if (MaxCardx != null)
            return MaxCardx;
        //--------------------------------------------------------------------------------
        else {

                return TrumpSearch();
        }
    }
    // this function checks if any trump exists in this bots hand and returns the largest one if yes.
    public Node TrumpSearch(){
        Node tmp = head, MaxCardx=null;
        int max = 0, currentValue,NodesAftereMaxCard=0;
        while (tmp != null) {
            Node MaxCard=null;
            if (tmp.getData().getSuitAbstract().contains("Spades")) {
                //System.out.println(suit.contains(tmp.getData().getSuitAbstract()));
                currentValue = tmp.getData().getCardValue();
                //System.out.println(currentValue);
                if (max < currentValue) {
                    max = currentValue;
                    NodesAftereMaxCard=0;
                }
                else{
                    NodesAftereMaxCard++;
                }
            }
            else{
                NodesAftereMaxCard++;
            }
            tmp = tmp.getNext();
            if(tmp==null){
                tmp=getPrevious(tmp);
                break;
            }
        }
        for(int i=0;i<=NodesAftereMaxCard;i++){
            MaxCardx=(tmp);
            tmp=getPrevious(tmp);
        }
        //System.out.println(MaxCardx);
        if (MaxCardx != null)
            return MaxCardx;
        else{
            return otherSearch();
        }
    }
    //this function returns the node with largest card value.
    public Node otherSearch(){
        Node tmp = head, MaxCardx=null;
        int max = 0, currentValue,NodesAftereMaxCard=0;
        while (tmp != null) {
            Node MaxCard = null;
            currentValue = tmp.getData().getCardValue();
            if (max < currentValue) {
                max = currentValue;
                NodesAftereMaxCard = 0;
            } else {
                NodesAftereMaxCard++;
            }
            tmp = tmp.getNext();
            if (tmp == null) {
                tmp = getPrevious(tmp);
                break;
            }
        }
        for(int i=0;i<=NodesAftereMaxCard;i++){
            MaxCardx=(tmp);
            tmp=getPrevious(tmp);
        }
            return MaxCardx;
    }
    public Node LastCardPlayedOnTable(){
        Node tmp=head;
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
        }
        return tmp;
    }
    // ----------GETTERS----------
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
}
