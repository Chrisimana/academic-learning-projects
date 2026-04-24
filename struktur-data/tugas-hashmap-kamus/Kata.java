package Kamus;

public class Kata {
    private String inggris ;
    private String indonesia ;
    private Aksi aksi ;

    public Kata(String inggris, String indonesia){
        this.inggris = inggris ;
        this.indonesia = indonesia ;
    }

    public Kata(String inggris, String indonesia, Aksi aksi){
        this.inggris = inggris ;
        this.indonesia = indonesia ;
        this.aksi = aksi ;
    }

    public String getIndonesia() {
        return indonesia;
    }

    public String getInggris() {
        return inggris;
    }

    @Override
    public String toString() {
        return inggris + " -> " + indonesia ;
    }

    public boolean hasActioon(){
        return aksi != null ;
    }

    public void runAksi(javax.swing.JFrame frame){
        if (aksi != null){
            aksi.eksekusi(frame);
        }
    }
}