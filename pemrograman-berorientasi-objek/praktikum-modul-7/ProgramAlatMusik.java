// Class semua alat musik
class AlatMusik {
    String suara() {
        return "Suara alat musik";
    }
}

// Class Piano
class Piano extends AlatMusik {

    // Override method suara untuk piano
    @Override
    String suara() {
        return "Piano - ting ting ting ting";
    }
}

// Class Biola
class Biola extends AlatMusik {

    // Override method suara untuk biola
    @Override
    String suara() {
        return "Biola - ngiing ngiing ngiing";
    }
}

// Class Gitar
class Gitar extends AlatMusik {

    // Override method suara untuk gitar
    @Override
    String suara() {
        return "Gitar - jreng jreng jreng";
    }
}

// Class Drum
class Drum extends AlatMusik {

    // Override method suara untuk drum
    @Override
    String suara() {
        return "Drum - dug dug dug dug";
    }
}

// Class Saxophone 
class Saxophone extends AlatMusik {

    // Override method suara untuk saxophone
    @Override
    String suara() {
        return "Saxophone - tuuuut tuuuut  tuuuut";
    }
}

// Class Trumpet 
class Trumpet extends AlatMusik {

    // Override method suara untuk trumpet
    @Override
    String suara() {
        return "Trumpet - tuuu tuuu tuuu";
    }
}

// Class utama 
public class ProgramAlatMusik {
    public static void main(String[] args) {

        // Membuat array untuk menampung alat musik
        AlatMusik[] alatMusik = new AlatMusik[6];
        
        // Mengisi array dengan objek alat musik
        alatMusik[0] = new Piano();
        alatMusik[1] = new Biola();
        alatMusik[2] = new Gitar();
        alatMusik[3] = new Drum();
        alatMusik[4] = new Saxophone();
        alatMusik[5] = new Trumpet();
        
        // Menampilkan suara berbagai alat musik
        System.out.println("Suara berbagai alat musik:");

        // Loop melalui array dan panggil method suara() untuk setiap alat musik
        for (int i = 0; i < alatMusik.length; i++) {
            System.out.println("Alat musik " + (i+1) + ": " + alatMusik[i].suara());
        }
    }
}