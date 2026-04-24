public class BubbleSort {


   public static void bubblesort(int arr[]) {
       int n = arr.length;
       boolean swapped ;


       for( int i = 0 ; i < n - 1 ; i++){
           swapped = false ;
           for (int j = 0 ; j < n - 1 - i ; j++){
               if (arr[j] > arr[j + 1]){
               int temp = arr[j] ;
               arr[j] = arr[j + 1] ;
               arr[j + 1] = temp ;
               swapped = true ;


                   System.out.println("Swap ke-" + (i + 1) + "." + (j + 1) + ": ");
                   printArray(arr);
               }
           }


           if (!swapped) break;
       }
   }


   public static void printArray(int[] arr){
       for (int i = 0 ; i < arr.length ; i++){
           if (i < arr.length + 1){
               System.out.print(arr[i] + " ");
           }
       }
       System.out.println();
   }


   
   public static void main(String[] args) {
       int[] data = {5,3,7,8,4,1,6,2,10,9} ;


       System.out.println("-------------------------------------");
       System.out.println("Sebelum sorting : " );
       printArray(data);


       System.out.println("\nProses Bubble Sort : ");
       bubblesort(data);


       System.out.println("\nSetelah sorting : " );
       printArray(data);
   }
}
