public class Node {
   private Node left ;
   private Node right ;
   private int key ;
   private Node parent ;
   private boolean red ;


   public Node(int key){
       this.key = key ;
       this.left = null ;
       this.right = null ;
       this.parent = null ;
       this.red = true;
   }


   private static final String RED = "\u001B[31m";
   private static final String BLACK = "\u001B[37m";
   private static final String RESET = "\u001B[0m";




   // ---------------------Setter---------------------------
   public void setRed(boolean red) {
       this.red = red;
   }
   public void setParent(Node parent) {
       this.parent = parent;
   }
   public void setLeft(Node left) {
       this.left = left;
   }
   public void setRight(Node right) {
       this.right = right;
   }


   // -----------------------Getter---------------------------
   public Node getRight() {
       return right;
   }
   public Node getLeft() {
       return left;
   }
   public int getKey() {
       return key;
   }
   public Node getParent() {
       return parent;
   }
   public boolean isRed(){
       return red ;
   }


   public String getColoredKey() {
       return (isRed() ? RED : BLACK) + key + RESET;
   }
}
