public class BinarySearchTree {
   private Node root ;


   public BinarySearchTree(){
       root = null ;
   }


   public Node getRoot() {
       return root;
   }


   public void insert(int key){
       Node newNode = new Node(key) ;


       if (root == null){
           root = newNode ;
           return;
       }


       Node current = root ;
       Node parent = null ;


       while (current != null){
           parent = current ;


           if (key < current.getKey()){
               current = current.getLeft() ;
           }
           else if (key > current.getKey()) {
               current = current.getRight() ;
           }
           else {
               return;
           }
       }


       if (key < parent.getKey()){
           parent.setLeft(newNode);
       } else {
           parent.setRight(newNode);
       }
   }


   public void preorder(Node node){
       if (node == null){
           return;
       }


       System.out.print(node.getKey() + " ");
       preorder(node.getLeft());
       preorder(node.getRight());
   }


   public void inorder(Node node){
       if (node == null){
           return;
       }


       inorder(node.getLeft());
       System.out.print(node.getKey() + " ");
       inorder(node.getRight());
   }


   public void postorder(Node node){
       if (node == null){
           return;
       }


       postorder(node.getLeft());
       postorder(node.getRight());
       System.out.print(node.getKey() + " ");
   }


   // Visualisasi Search Tree
  
   public void printTree(){
       printTree(root, "", true);
   }


   private void printTree(Node node, String prefix, boolean isTail){
       if (node == null){
           return;
       }


       if (node.getRight() != null){
           printTree(node.getRight(), prefix + (isTail ? "│   " : "    "), false);
       }


       System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.getKey() + (node == root ? " (root)" : ""));


       if (node.getLeft() != null){
           printTree(node.getLeft(), prefix + (isTail ? "    " : "│   "), true);
       }
   }
}


class Main{
   public static void main(String[] args) {
       BinarySearchTree tree = new BinarySearchTree() ;


       int[] data = {30, 44, 29, 21, 50, 67, 11, 4, 24, 65, 7, 47};
       for (int i = 0 ; i < data.length ; i++){
           tree.insert(data[i]);
       }


       System.out.println("\n Visualisasi Search Tree : ");
       tree.printTree();


       System.out.print("\n Pre order : ");
       tree.preorder(tree.getRoot());


       System.out.print("\n In order : ");
       tree.inorder(tree.getRoot());


       System.out.print("\n Post order : ");
       tree.postorder(tree.getRoot());
   }
}