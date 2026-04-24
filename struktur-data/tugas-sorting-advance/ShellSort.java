public class ShellSort {
   public static void shellsort(int arr[]){
       int n = arr.length;


       // gap pertama setengah panjang array
       int[] gaps = {n/2, n/3, n/1};


       for (int gap : gaps){
           if (gap <= 0){
               continue;
           }
           System.out.println("\n ==== Gap sekarang : " + gap + " ===== ");


           for (int i = gap ; i < n ; i++){
               int temp = arr[i];
               int j = i ;


               System.out.print("Membandingkan dan menggeser elemen : ");
               printsubarray(arr, 0, n- 1);
               System.out.println();


               while (j >= gap && arr[j-gap] > temp){
                   arr[j] = arr[j - gap];
                   j -= gap;
               }
               arr[j] = temp ;


               System.out.print("Setelah penyisipan : ");
               printsubarray(arr, 0 , n-1);
               System.out.println();
           }


           System.out.println("Hasil sementara setelah gap " + gap + " :");
           printsubarray(arr, 0 , n-1);
           System.out.println();
       }
   }


   public static void printarr(int arr[]){
       for (int num : arr){
           System.out.print(num + " ");
       }
       System.out.println();
   }


   public static void printsubarray(int arr[], int kiri, int kanan){
       System.out.print("[");
       for (int i = kiri ; i <= kanan ; i++){
           System.out.print(arr[i]);
           if (i < kanan){
               System.out.print(", ");
           }
       }
       System.out.print("]");
   }


   public static void main(String[] args) {
       int[] data = {4, 5, 7, 2, 8, 9, 1, 3, 6, 10};


       System.out.println("Sebelum sorting : ");
       printarr(data);


       System.out.println("\n Proses shell sort : ");
       shellsort(data);


       System.out.println("\n Sesudah sorting : ");
       printarr(data);
   }
}           
