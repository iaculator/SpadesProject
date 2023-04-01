public class Node {
    Cards data;
    Node next;
    public Node(Cards data){
        this.data=data;
        next=null;
    }
    public Node(){

    }
    // Method that will be used to see the data;
    public String toString(){
        return data.toString();
    }
    public Cards getData(){
        return data;
    }
    public void setData(Cards data){
       this.data=data;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node n){
        next=n;
    }
}

