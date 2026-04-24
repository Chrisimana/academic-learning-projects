public class Stack {
    private Node First ;


    public Stack(){
        First = null;
    }


    //Untuk melihat apakah sudah kosong
    public boolean IsEmpty(){
        return First == null ;
    }


    // Untuk mengecek apakah masih bisa di diambil jika masih maka true
    public boolean hasPop(){
        return !IsEmpty() ; // bisa pop kalau tidak kosong
    }


    // Untuk memasukan Node dari atas
    public void Push(int value){
        Node NewNode = new Node(value);
        NewNode.setNext(First); // Node baru untuk menunjuk ke Node lama
        First = NewNode ; // Untuk memasukan node baru dari atas
    }


    // Untuk mengeluarkan nilai
    public int pop(){
        if (IsEmpty()){
            System.out.println("Stack kosong, tidak bisa pop");
            return -1 ;
        }
        int value = First.getValue() ;
        First = First.getNext(); // geser first ke node berikutnya
        return value ;
    }


    // Untuk melihat nilai
    public int Peek(){
        if (IsEmpty()){
            System.out.println("Stack kosong");
            return -1 ;
      }
        return First.getValue();
    }


    // Untuk menukar nilai
    public void swap(int variabel1, int variabel2){
        if (variabel1 == variabel2){
            System.out.println("Tidak bisa ditukar jika variabel sama" + variabel1);
            return ;
        }


        Node prev1 = null ;
        Node prev2 = null ;
        Node node1 = First ;
        Node node2 = First ;


        //Cari node 1
        while (node1 != null && node1.getValue() != variabel1){
            prev1 = node1 ;
            node1 = node1.getNext() ;
        }


        //Cari node 2
        while (node2 != null && node2.getValue() != variabel2){
            prev2 = node2 ;
            node2 = node2.getNext() ;
        }


        //Jika node kosong
        if (node1 == null || node2 == null){
            System.out.println("Node tidak ditemukan swap gagal");
            return;
        }


        //Tukar pointer
        if (prev1 != null){
            prev1.setNext(node2);
        } else {
            First = node2 ;
        }


        if (prev2 != null){
            prev2.setNext(node1);
        } else {
            First = node1 ;
        }


        //Tukar next
        Node temp = node1.getNext() ;
        node1.setNext(node2.getNext()) ;
        node2.setNext(temp);


        System.out.println("Swap berhasil : " + variabel1 + " < = > " + variabel2);
    }


    // print stack
    public void PrintStack(){
        Node current = First ;
        while (current != null){
            System.out.println(current.getValue() + " ");
            current = current.getNext() ;
        }
        System.out.println();
    }
}
