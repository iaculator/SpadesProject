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
        int a=0;
        Node tmp = head;
        while (tmp != null) {
            a++;
            System.out.print(tmp.data.toString());

            tmp = tmp.next;
        }
        System.out.println(a);
    }
    public Node checkinputFromPlayer(String s,String firstCard){
        Node tmp = head;
        Node tmp2=head;
        while (tmp2 != null) {
            if(tmp2.data.getSuit().contains(firstCard)){
                break;
            }
            tmp2 = tmp2.next;
        }


        while (tmp != null) {
            if(s.contains(tmp.data.getSuit())){

                break;
            }
            tmp = tmp.next;

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
    public Node pickFirstCard(int x){
        Node tmp=head;
        for(int i=0;i<x;i++){
            tmp=tmp.next;
            //I wrote this in order to avoid getting null pointer exception
            if(tmp==null)
                tmp=getPrevious(tmp);

        }
        //System.out.println(" Thetmp);
        //tmp.setNext(null);
        return tmp;

    }
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
    public Node otherSearch(){
        Node tmp = head, MaxCardx=null;
        int max = 0, currentValue,NodesAftereMaxCard=0;
        while (tmp != null) {
            Node MaxCard = null;
            currentValue = tmp.getData().getCardValue();
            //System.out.println(currentValue);
            if (max > currentValue) {
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
        System.out.println("NodesAfterMaxCard "+NodesAftereMaxCard);
        for(int i=0;i<=NodesAftereMaxCard-1;i++){
            MaxCardx=(tmp);
            tmp=getPrevious(tmp);
        }
        //System.out.println(MaxCardx);
            return MaxCardx;
    }
    public Node LastCardPlayedOnTable(){
        Node tmp=head;
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
        }
        return tmp;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
}
