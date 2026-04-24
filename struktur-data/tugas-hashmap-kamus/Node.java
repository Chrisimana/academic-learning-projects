package Kamus;

public class Node {
    private char key ;
    private Object value ;
    private Node left ;
    private Node right ;
    private Node parent ;
    private boolean red ;

    public Node (char key, Object value){
        this.key = key ;
        this.value = value ;
        this.left = null ;
        this.right = null ;
        this.parent = null ;
        this.red = true ;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isRed(){
        return red ;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public char getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }
}