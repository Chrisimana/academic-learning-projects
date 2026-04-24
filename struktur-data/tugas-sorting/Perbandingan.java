import java.util.Random;

public class Perbandingan {


   public static void BubbleSort(int [] arr){
       int n = arr.length;
       boolean swapped ;


       for (int i = 0 ; i < n - 1 ; i++ ){
           swapped = false ;
           for (int j = 0 ; j < n - 1 -i ; j++ ){
               if (arr[j] > arr[j + 1]){
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp ;
                   swapped = true ;
               }
           }
           if (!swapped) break;
       }
   }


   public static void SelectionSort(int [] arr){
       int n = arr.length;


       for (int i = 0 ; i < n - 1 ; i ++ ){
           int miniIndenx = i ;
           for (int j = i + 1 ; j < n ; j ++ ){
               if (arr[j] < arr[miniIndenx]){
                   miniIndenx = j ;
               }
           }
           if (miniIndenx != i ){
               int temp = arr[miniIndenx];
               arr[miniIndenx] = arr[i] ;
               arr[i] = temp ;
           }
       }
   }


   public static void InsertionSort(int [] arr){
       int n = arr.length;


       for (int i = 0 ; i < n ; i++ ){
           int key = arr[i];
           int j = i - 1 ;




           while (j >= 0 && arr[j] > key){
               arr[j + 1] = arr[j];
               j-- ;
           }
           arr[j + 1] = key ;
       }
   }


   public static int[] copyArray(int[] arr){
       int[] newarr = new int[arr.length];
       System.arraycopy(arr, 0, newarr, 0 , arr.length);
       return newarr ;
   }


   public static void main(String[] args) {
       int n = 100000 ;
       int[] data = new int[n] ;


       Random rand = new Random();
       for (int i = 0 ; i < n ; i++ ){
           data[i] = rand.nextInt(100000);
       }


       //Bubblesort
       int[] BubbleData = copyArray(data);
       long start = System.nanoTime();
       BubbleSort(BubbleData);
       long end = System.nanoTime();
       double Bubbleduration = (end - start) / 1_000_000_000.0 ;


       System.out.println("Bubblesort selesai mengurutkan " + n + " data");
       System.out.println("Waktu selesai : " + Bubbleduration + " detik");


       System.out.println("------------------------------------------");


       //SelectionSort
       int[] SelectionData = copyArray(data);
       start = System.nanoTime() ;
       SelectionSort(SelectionData);
       end = System.nanoTime() ;
       double Selectionduration = (end - start) / 1_000_000_000.0 ;


       System.out.println("Selectionsort selesai mengurutkan " + n + " data");
       System.out.println("Waktu selesai : " + Selectionduration + " detik");


       System.out.println("------------------------------------------");


       int[] InsertionData = copyArray(data);
       start = System.nanoTime() ;
       InsertionSort(InsertionData);
       end = System.nanoTime() ;
       double Insertionduration = (end - start) / 1_000_000_000.0 ;


       System.out.println("Insertionsort selesai mengurutkan " + n + " data");
       System.out.println("Waktu selesai : " + Insertionduration + " detik");
   }
}