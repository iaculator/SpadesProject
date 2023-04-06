public class Node {
    private Cards data;
    private Node next;
    //Constructor
    public Node(Cards data){
        this.data=data;
        next=null;
    }
    //getter setters
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

