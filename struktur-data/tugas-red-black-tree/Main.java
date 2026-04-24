import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       RBT rbtt = new RBT();


       while (true) {
           System.out.println("\n ===== RBT =====");
           System.out.println("Data : 57, 12, 5, 89, 34, 76, 43, 98, 61, 27 ");
           System.out.println("1. Masukkan Angka ");
           System.out.println("2. Tampilkan Tree ");
           System.out.println("3. Pre Order ");
           System.out.println("4. In Order ");
           System.out.println("5. Post Order ");
           System.out.println("6. Exit ");
           System.out.println("Pilih : ");


           int pilihan = sc.nextInt();
           sc.nextLine();


           switch (pilihan) {


               case 1: {
                   System.out.print("Masukkan angka : ");
                   while (true) {
                       System.out.print("Input angka: ");
                       System.out.println(" 0 untuk keluar : ");
                       int num = sc.nextInt();
                       sc.nextLine(); // clear buffer


                       if (num == 0) {
                           System.out.println("Selesai input.");
                           break;
                       }
                       boolean success = rbtt.add(num);
                       if (success) {
                           System.out.println("Add: " + num + " berhasil");
                       } else {
                           System.out.println("Add: " + num + " gagal (duplicate)");
                       }
                   }
                   break;
               }


               case 2:{
                   System.out.println("\n Tree saat ini : ");
                   rbtt.printTree();
                   break;
               }


               case 3:{
                   System.out.println("Pre Order : ");
                   rbtt.preOrder();
                   System.out.println();
                   break;
               }


               case 4:{
                   System.out.println("In Order : ");
                   rbtt.inOrder();
                   System.out.println();
                   break;
               }


               case 5:{
                   System.out.println("Post Order : ");
                   rbtt.postOrder();
                   System.out.println();
                   break;
               }


               case 6:{
                   System.out.println("Keluar program... ");
                   return;
               }
               default:
                   System.out.println("Pilihan tidak valid");
           }
       }
   }
}