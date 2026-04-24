public class Node {
    private int value ;
    private Node Next ;


    public Node(int value){
        this.value = value ;
        this.Next = null ;
    }


    public void setNext(Node Next){
        this.Next = Next ;
    }


    public Node getNext() {
        return Next;
    }


    public int getValue() {
        return value;
    }
}
