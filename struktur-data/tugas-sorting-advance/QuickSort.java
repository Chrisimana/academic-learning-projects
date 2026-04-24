public class QuickSort {
   public static void quicksort(int arr[], int min, int max){
       if (min < max){
           int nilaitengah = arr[max]; // nilai pivot
           int i = min - 1 ;


           for (int j = min ; j < max ; j++){
               if (arr[j] < nilaitengah){
                   i++ ;
                   int temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp ;
               }
           }


           int temp = arr[i + 1]; // Untuk menempatkan pivot pada posisi yang benar
           arr[i + 1] = arr[max];
           arr[max] = temp;


           int pi = i + 1 ;


           System.out.println("Pivot berada di : " + nilaitengah);
           printarr(arr);


           quicksort(arr, min, pi - 1);
           quicksort(arr, pi + 1, max);
       }
   }


   public static void printarr(int arr[]){
       for (int num : arr ){
           System.out.print(num + " ");
       }
       System.out.println();
   }


   public static void main(String[] args) {
       int[] data = {13, 19, 11, 17, 14, 20, 12, 18, 15, 16};


       System.out.println("Sebelum sorting:");
       printarr(data);


       System.out.print("\nProses Quick Sort:");
       quicksort(data, 0, data.length - 1);


       System.out.println("\nSesudah sorting:");
       printarr(data);
   }
}