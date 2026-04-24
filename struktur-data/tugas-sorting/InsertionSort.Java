import com.sun.jdi.PathSearchingVirtualMachine;


public class InsertionSort {
   public static void insertionsort(int[] arr){
       int n = arr.length;


       for (int i = 0 ; i < n ; i++){
           int key = arr[i];
           int j = i - 1 ;


           while (j >= 0 && arr[j] > key){
               arr[j + 1] = arr[j];
               j--;
           }


           arr[j + 1] = key;


           System.out.println("Pass ke- " + i + ": ");
           printarray(arr);
       }
   }


   public static void printarray(int [] arr){
       for (int i = 0 ; i < arr.length ; i++){
           System.out.print(arr[i] + " ");
       }
       System.out.println();
   }


   public static void main(String[] args) {
       int[] data = {21, 27, 25, 30, 22, 28, 24, 29, 23, 26};


       System.out.println("Sebelum sorting : ");
       printarray(data);


       System.out.println("Proses insertion sort");
       insertionsort(data) ;


       System.out.println("Sesudah sorting : ");
       printarray(data);
   }
}
