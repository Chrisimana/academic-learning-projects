public class RBT {
   private Node root;


   public RBT() {
       this.root = null;
   }


   // ----------- Add ---------------
   public boolean add(int key) {
       Node newNode = new Node(key);
       newNode.setRed(true);


       if (root == null) {
           root = newNode;
           root.setRed(false);
           return true;
       }


       Node current = root;
       Node parent = null;


       while (current != null) {
           parent = current;


           if (key < current.getKey()) {
               current = current.getLeft();
           } else if (key > current.getKey()) {
               current = current.getRight();
           } else {
               return false; // Duplicate
           }
       }


       newNode.setParent(parent);
       if (key < parent.getKey()) {
           parent.setLeft(newNode);
       } else {
           parent.setRight(newNode);
       }


       fixAdd(newNode);
       return true;
   }


   // ----------- Rotate to Left  ---------------
   private void rotateToLeft(Node current) {


       if (current == null){
           return;
       }


       Node rightChild = current.getRight();


       if (rightChild == null) {
           return;
       }


       current.setRight(rightChild.getLeft());
       if (rightChild.getLeft() != null) {
           rightChild.getLeft().setParent(current);
       }


       rightChild.setParent(current.getParent());


       if (current.getParent() == null) {
           root = rightChild;
       } else if (current == current.getParent().getLeft()) {
           current.getParent().setLeft(rightChild);
       } else {
           current.getParent().setRight(rightChild);
       }


       rightChild.setLeft(current);
       current.setParent(rightChild);
   }


   // ----------- Rotate to Right  ---------------
   private void rotateToRight(Node current) {


       if (current == null){
           return;
       }


       Node leftChild = current.getLeft();


       if (leftChild == null) {
           return;
       }


       current.setLeft(leftChild.getRight());
       if (leftChild.getRight() != null) {
           leftChild.getRight().setParent(current);
       }


       leftChild.setParent(current.getParent());


       if (current.getParent() == null) {
           root = leftChild;
       } else if (current == current.getParent().getRight()) {
           current.getParent().setRight(leftChild);
       } else {
           current.getParent().setLeft(leftChild);
       }


       leftChild.setRight(current);
       current.setParent(leftChild);
   }


   // ----------- Fix Add  ---------------
   private void fixAdd(Node node) {
       while (node != root && node.getParent().isRed()) {
           Node parent = node.getParent();
           Node grandparent = parent.getParent();


           if (grandparent == null) break;


           if (parent == grandparent.getLeft()) {
               Node uncle = grandparent.getRight();


               // Case 1: Uncle merah
               if (uncle != null && uncle.isRed()) {
                   parent.setRed(false);
                   uncle.setRed(false);
                   grandparent.setRed(true);
                   node = grandparent;
               } else {
                   // Case 2: Bentuk menyerong (left-right)
                   if (node == parent.getRight()) {
                       rotateToLeft(parent);
                       node = parent;
                       parent = node.getParent();
                   }
                   // Case 3: Bentuk lurus (left-left)
                   parent.setRed(false);
                   grandparent.setRed(true);
                   rotateToRight(grandparent);
                   break; // Keluar setelah rotasi
               }
           } else {
               // Mirror case
               Node uncle = grandparent.getLeft();


               if (uncle != null && uncle.isRed()) {
                   parent.setRed(false);
                   uncle.setRed(false);
                   grandparent.setRed(true);
                   node = grandparent;
               } else {
                   // Case 2: Bentuk menyerong (right-left)
                   if (node == parent.getLeft()) {
                       rotateToRight(parent);
                       node = parent;
                       parent = node.getParent();
                   }
                   // Case 3: Bentuk lurus (right-right)
                   parent.setRed(false);
                   grandparent.setRed(true);
                   rotateToLeft(grandparent);
                   break; // Keluar setelah rotasi
               }
           }
       }
       root.setRed(false);
   }


   // ----------- Print Tree ---------------
   private void printTree(Node node, String prefix, boolean isTail) {
       if (node == null) {
           return;
       }


       if (node.getRight() != null) {
           printTree(node.getRight(), prefix + (isTail ? "│   " : "    "), false);
       }


       String red = "\u001B[31m";
       String black = "\u001B[30m";
       String reset = "\u001B[0m";


       String color = node.isRed() ? red : black;
       String colorName = node.isRed() ? "MERAH" : "HITAM";


       System.out.println(
               prefix +
                       (isTail ? "└── " : "┌── ") +
                       color + node.getKey() + reset +
                       (node == root ? " (root)" : "") +
                       " [" + color + colorName + reset + "]"
       );


       if (node.getLeft() != null) {
           printTree(node.getLeft(), prefix + (isTail ? "    " : "│   "), true);
       }
   }


   public void printTree() {
       printTree(root, "", true);
   }


   private void preorder(Node node){
       if (node == null){
           return;
       }


       System.out.print(node.getColoredKey() + " ");
       preorder(node.getLeft());
       preorder(node.getRight());
   }


   public void preOrder(){
       preorder(root);
   }


   private void inorder(Node node){
       if (node == null){
           return;
       }


       inorder(node.getLeft());
       System.out.print(node.getColoredKey() + " ");
       inorder(node.getRight());
   }


   public void inOrder(){
       inorder(root);
   }


   private void postorder(Node node){
       if (node == null){
           return;
       }


       postorder(node.getLeft());
       postorder(node.getRight());
       System.out.print(node.getColoredKey() + " ");
   }


   public void postOrder(){
       postorder(root);
   }
}
