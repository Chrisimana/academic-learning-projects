public class Main {
    public static void main(String[] args) {
        Stack fiks = new Stack() ;


        // pop saat kosong
        if (fiks.hasPop()){
            System.out.println("pop : " + fiks.pop());
        } else {
            System.out.println("Tidak bisa pop : kosong");
        }


        //push
        fiks.Push(11);
        fiks.Push(24);
        fiks.Push(10);
        fiks.Push(20);


        System.out.println("------------swap----------------");
        //swap
        System.out.println("Sebelum swap ");
        fiks.PrintStack();


        fiks.swap(10, 24);
        System.out.println("Sesudah swap ");
        fiks.PrintStack();




        System.out.println("---------------------pop----------------------");
        // pop


        System.out.println("Pop : " + fiks.pop());
        System.out.println("Pop : " + fiks.pop());
        System.out.println("Pop : " + fiks.pop());
        System.out.println("Pop : " + fiks.pop());


        System.out.println("Stack sudah kosong");
    }
}
