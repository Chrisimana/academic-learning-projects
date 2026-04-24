// Class Utama
public class ExceptionHandling {

    // Method untuk demonstrasi ArithmeticException
    public static void bagiDuaAngka(int pembilang, int penyebut) {

        // Menangani pembagian dengan nol
        try {

            // Pembagian dua angka
            int hasil = pembilang / penyebut;

            // Menampilkan hasil pembagian
            System.out.println("Hasil pembagian: " + hasil);

        // Menangkap ArithmeticException jika terjadi pembagian dengan nol
        } catch (ArithmeticException e) {

            // Menampilkan pesan kesalahan
            System.out.println("Terjadi ArithmeticException: " + e.getMessage());

            // Menampilkan pesan untuk pembagian dengan nol
            System.out.println("Pembagian dengan nol tidak diperbolehkan!");
        }
    }

    // Method untuk demonstrasi IndexOutOfBoundsException
    public static void aksesElemenArray(int[] array, int index) {

        // Menangani akses elemen array di luar batas
        try {

            // Mengakses elemen array pada indeks tertentu
            System.out.println("Elemen array pada indeks " + index + ": " + array[index]);

        // Menangkap IndexOutOfBoundsException jika terjadi akses di luar batas
        } catch (IndexOutOfBoundsException e) {

            // Menampilkan pesan kesalahan
            System.out.println("Terjadi IndexOutOfBoundsException: " + e.getMessage());

            // Menampilkan pesan untuk akses di luar batas
            System.out.println("Indeks yang diminta di luar batas array!");
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {

        // Menampilkan pesan
        System.out.println("ArithmeticException");

        // Kasus normal
        bagiDuaAngka(10, 2);

        // Kasus error (pembagian dengan nol)
        bagiDuaAngka(10, 0);
        
        // Menampilkan pesan
        System.out.println("\nIndexOutOfBoundsException");

        // Membuat array contoh
        int[] contohArray = {1, 2, 3, 4, 5};

        // Kasus normal
        aksesElemenArray(contohArray, 2);
        
        // Kasus error (indeks di luar batas)
        aksesElemenArray(contohArray, 10);
    }
}