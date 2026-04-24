package Kamus;

public class DDDD {

    protected Node root ;

    public DDDD(){
        root = null ;
    }

    // ------------- add --------------------
    public boolean add(char key, Object value) {
        Node newNode = new Node(key, value) ;

        if (root == null){
            newNode.setRed(false);
            root = newNode ;
            return true ;
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

    // -------- Search ----------
    public Object search(char key) {
        return findValue(root, key);
    }

    // --------- findvalue --------
    private Object findValue(Node current, char key){
        if (current == null){
            return null ;
        }

        if (key == current.getKey()) {
            return current.getValue() ;
        } else if (key < current.getKey()) {
            return findValue(current.getLeft(), key) ;
        } else {
            return findValue(current.getRight(), key) ;
        }
    }
}