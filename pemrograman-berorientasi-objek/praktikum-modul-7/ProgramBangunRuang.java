import java.util.Scanner;

// Class untuk semua bangun ruang
class BangunRuang {
    double volume; // Variabel untuk menyimpan volume
    
    // Method untuk menghitung volume
    void hitungVolume() {
        System.out.println("Menghitung volume bangun ruang");
    }
    
    // Method untuk menampilkan volume
    void tampilVolume() {
        System.out.println("Volume: " + volume);
    }
}

// Class Kubus
class Kubus extends BangunRuang {
    double sisi; // Panjang sisi kubus
    
    // Konstruktor untuk inisialisasi sisi
    Kubus(double s) {
        sisi = s;
    }
    
    // Override method untuk kubus
    @Override
    void hitungVolume() {
        volume = sisi * sisi * sisi; // Rumus volume kubus
    }
}

// Class Balok
class Balok extends BangunRuang {
    double panjang, lebar, tinggi; // Dimensi balok
    
    // Konstruktor untuk inisialisasi dimensi balok
    Balok(double p, double l, double t) {
        panjang = p;
        lebar = l;
        tinggi = t;
    }
    
    // Override method untuk balok
    @Override
    void hitungVolume() {
        volume = panjang * lebar * tinggi; // Rumus volume balok
    }
}

// Class Tabung
class Tabung extends BangunRuang {
    double jariJari, tinggi; // Jari-jari dan tinggi tabung
    
    // Konstruktor untuk inisialisasi tabung
    Tabung(double r, double t) {
        jariJari = r;
        tinggi = t;
    }
    
    // Override method untuk tabung
    @Override
    void hitungVolume() {
        volume = Math.PI * jariJari * jariJari * tinggi; // Rumus volume tabung
    }
}

// Class Kerucut
class Kerucut extends BangunRuang {
    double jariJari, tinggi; // Jari-jari dan tinggi kerucut
    
    // Konstruktor untuk inisialisasi kerucut
    Kerucut(double r, double t) {
        jariJari = r;
        tinggi = t;
    }
    
    // Override method untuk kerucut
    @Override
    void hitungVolume() {
        volume = (1.0/3) * Math.PI * jariJari * jariJari * tinggi; // Rumus volume kerucut
    }
}

// Class Limas 
class Limas extends BangunRuang {
    double panjangAlas, lebarAlas, tinggi; // Dimensi limas
    
    // Konstruktor untuk inisialisasi limas
    Limas(double p, double l, double t) {
        panjangAlas = p;
        lebarAlas = l;
        tinggi = t;
    }
    
    // Override method hitungVolume untuk limas
    @Override
    void hitungVolume() {
        volume = (1.0/3) * panjangAlas * lebarAlas * tinggi; // Rumus volume limas
    }
}

// Class Prisma
class Prisma extends BangunRuang {
    double luasAlas, tinggi; // Luas alas dan tinggi prisma
    
    // Konstruktor untuk inisialisasi prisma
    Prisma(double la, double t) {
        luasAlas = la;
        tinggi = t;
    }
    
    // Override method hitungVolume untuk prisma
    @Override
    void hitungVolume() {
        volume = luasAlas * tinggi; // Rumus volume prisma
    }
}

// Class Bola
class Bola extends BangunRuang {
    double jariJari; // Jari-jari bola
    
    // Konstruktor untuk inisialisasi bola
    Bola(double r) {
        jariJari = r;
    }
    
    // Override method hitungVolume untuk bola
    @Override
    void hitungVolume() {
        volume = (4.0/3) * Math.PI * jariJari * jariJari * jariJari; // Rumus volume bola
    }
}

// Class Utama
public class ProgramBangunRuang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk input
        
        // Membuat objek bangun ruang dengan nilai variabel yang berbeda
        Kubus kubus = new Kubus(10);
        Balok balok = new Balok(6, 4, 9);
        Tabung tabung = new Tabung(8, 18);
        Kerucut kerucut = new Kerucut(4, 8);
        Limas limas = new Limas(5, 5, 10);
        Prisma prisma = new Prisma(10, 7);
        Bola bola = new Bola(5);
        
        // Menghitung volume masing-masing bangun ruang
        kubus.hitungVolume();
        balok.hitungVolume();
        tabung.hitungVolume();
        kerucut.hitungVolume();
        limas.hitungVolume();
        prisma.hitungVolume();
        bola.hitungVolume();
        
        // Menampilkan hasil perhitungan volume
        System.out.println("Kubus");
        kubus.tampilVolume();
        
        System.out.println("\nBalok");
        balok.tampilVolume();
        
        System.out.println("\nTabung");
        tabung.tampilVolume();
        
        System.out.println("\nKerucut");
        kerucut.tampilVolume();
        
        System.out.println("\nLimas");
        limas.tampilVolume();
        
        System.out.println("\nPrisma");
        prisma.tampilVolume();
        
        System.out.println("\nBola");
        bola.tampilVolume();
    }
}