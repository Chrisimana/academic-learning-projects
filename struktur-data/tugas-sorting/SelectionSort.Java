public class SelectionSort {
   public static void selectionSort(int [] arr){
       int n = arr.length;


       for(int i = 0 ; i < n - 1 ; i++){
           int miniindex = i ;


           for (int j = i + 1 ; j < n ; j++){
               if (arr[j] < arr[miniindex]){
                   miniindex = j ;
               }
           }


           if (miniindex != i ){
               int temp = arr[miniindex];
               arr[miniindex] = arr[i] ;
               arr[i] = temp ;


               System.out.println("swap ke-" + (i + 1) + ": " );
               printArray(arr);
           }
       }
   }


   public static void  printArray(int [] arr){
       for (int i = 0 ; i < arr.length ; i++){
           System.out.print(arr[i] + " ");
       }
       System.out.println();
   }


   public static void main(String[] args) {
       int[] data = {13, 19, 11, 17, 14, 20, 12, 18, 15, 16} ;


       System.out.println("Sebelum sorting : ");
       printArray(data);


       System.out.println("Proses Selection Sort : ");
       selectionSort(data);


       System.out.println("Sesudah sorting  ");
       printArray(data);
   }
}