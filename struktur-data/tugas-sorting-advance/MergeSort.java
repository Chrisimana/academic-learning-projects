public class MergeSort {
   public static void mergesort(int arr[], int baris_kiri, int baris_kanan, int level){
       if (baris_kiri < baris_kanan){
           int nilai_tengah = (baris_kiri + baris_kanan) / 2 ;


           // proses pembagian
           printindent(level);
           System.out.print("Level " + level + " => Membagi : ");
           printsubarray(arr, baris_kiri, baris_kanan);
           System.out.println(); // untuk baris baru


           // bagi dua baris
           mergesort(arr, baris_kiri, nilai_tengah, level + 1);
           mergesort(arr, nilai_tengah + 1, baris_kanan, level + 1);


           // mengabungkan dua barisan
           merge(arr, baris_kiri, nilai_tengah, baris_kanan);


           printindent(level);
           System.out.print("Level " + level + " => Menggabungkan : ");
           printsubarray(arr, baris_kiri, baris_kanan);
           System.out.println("\n"); // spasi antar proses
       }
   }


   public static void merge(int arr[], int baris_kiri, int nilai_tengah, int baris_kanan){
       int baris_pertama = nilai_tengah - baris_kiri + 1 ; // panjang baris kiri
       int baris_kedua = baris_kanan - nilai_tengah ; // panjang baris kanan


       // Array sementara
       int A[] = new int[baris_pertama] ;
       int B[] = new int[baris_kedua] ;


       // Salinan data ke array sementara
       for (int i = 0 ; i < baris_pertama ; i++ ){
           A[i] = arr[baris_kiri + i] ;
       }


       for (int j = 0 ; j < baris_kedua ; j++ ){
           B[j] = arr[nilai_tengah + 1 + j] ;
       }


       // Menggabungkan kedua array sementara
       int i = 0, j = 0 ;
       int k = baris_kiri ;


       while (i < baris_pertama && j < baris_kedua){
           if (A[i] <= B[j]){
               arr[k] = A[i] ;
               i++ ;
           } else {
               arr[k] = B[j] ;
               j++ ;
           }
           k++ ;
       }


       // Untuk mengambil sisa element jika ada
       while (i < baris_pertama){
           arr[k] = A[i] ;
           i++ ;
           k++ ;
       }


       while (j < baris_kedua){
           arr[k] = B[j] ;
           j++ ;
           k++ ;
       }
   }


   public static void printarr(int arr[]){
       for (int num : arr ){
           System.out.print(num + " ");
       }
       System.out.println();
   }


   public static void printsubarray(int arr[], int baris_kiri, int baris_kanan){
       System.out.print("[");
       for (int i = baris_kiri ; i <= baris_kanan ; i++){
           System.out.print(arr[i]);
           if (i < baris_kanan){
               System.out.print(", ");
           }
       }
       System.out.print("]");
   }


   public static void printindent(int level){
       for (int i = 0 ; i < level ; i ++){
           System.out.print(" "); //tiga spasi per level
       }
   }


   public static void main(String[] args) {
       int[] data = {4,5,7,2,8,9,1,3,6,10};


       System.out.println("Sebelum sorting:");
       printarr(data);


       System.out.println("\nProses Merge Sort:");
       mergesort(data, 0, data.length - 1, 0);


       System.out.println("\nSesudah sorting:");
       printarr(data);
   }
}
