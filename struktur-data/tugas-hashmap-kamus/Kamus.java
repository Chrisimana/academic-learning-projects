package Kamus;

import javax.swing.*;
import java.util.ArrayList;

public class Kamus extends DDDD {

    public Kamus(){
        super();
        inisialisasiKamus();
    }

    // ---- Inisialisasi Data Awal ----
    private void inisialisasiKamus(){
        tambahKata("book", "buku");
        tambahKata("bad", "buruk");
        tambahKata("blue", "biru");
        tambahKata("computer", "komputer");
        tambahKata("dog", "anjing");
        tambahKata("water", "air");
        tambahKata("food", "makanan");
        tambahKata("Air", "Angin");
        tambahKata("Laugh", "Ketawa");
        tambahKata("Kiss", "Cium");

        tambahkataspesial("cat", "kucing", frame -> {
            Gimmick.showCat(frame);
        });

        tambahkataspesial("Calculator" , "Kalkulator", frame -> {
            SwingUtilities.invokeLater(() -> new Kalkulator().setVisible(true));
        });
        tambahkataspesial("Note" , "Catatatan", frame -> {
            SwingUtilities.invokeLater(() -> new Notepad().setVisible(true));
        } );
        tambahkataspesial("Erase", "Hapus", frame -> {
            Gimmick.erase(frame);
        });
        tambahkataspesial("Fall", "Jatuh", frame -> {
            Gimmick.fall(frame);
        });
        tambahkataspesial("Shake","Bergetar", frame -> {
            Gimmick.Shake(frame);
        });
    }

    public void tambahKata(String english, String indonesia){
        char key = english.toLowerCase().charAt(0) ;

        Object obj = search(key) ;
        ArrayList<Kata> list ;

        if (obj == null){
            list = new ArrayList<>() ;
            add(key, list);
        } else {
            list = (ArrayList<Kata>) obj ;
        }

        list.add(new Kata(english, indonesia)) ;
    }

    public void  tambahkataspesial(String inggris, String indonesia, Aksi aksi){
        char key = inggris.toLowerCase().charAt(0) ;
        Object obj = search(key) ;
        ArrayList<Kata> list ;

        if (obj == null){
            list = new ArrayList<>();
            add(key, list);
        } else {
            list = (ArrayList<Kata>) obj ;
        }

        list.add(new Kata(inggris, indonesia, aksi));
    }

    public Kata getKataObject(String kataInput){
        if (kataInput == null || kataInput.trim().isEmpty()){
            return null ;
        }

        String kata = kataInput.toLowerCase();
        char key = kata.charAt(0) ;
        Object obj = search(key) ;

        if (obj == null){
            return null ;
        }

        ArrayList<Kata> list = (ArrayList<Kata>) obj ;

        for (Kata k : list){
            if (k.getInggris().equalsIgnoreCase(kataInput)){
                return k ;
            }
        }
        return null ;
    }

    // ---- Terjemahan ----
    public String terjemahan(String kata){
        if (kata == null || kata.trim().isEmpty()){
            return "Input Kosong" ;
        }

        kata = kata.toLowerCase() ;
        char key = kata.charAt(0) ;

        Object obj = search(key) ;
        if (obj == null){
            return "Kata tidak ditemukan" ;
        }

        ArrayList<Kata> list = (ArrayList<Kata>) obj ;

        for (Kata k : list){
            if (k.getInggris().equalsIgnoreCase(kata)){
                return k.getIndonesia();
            }
        }
        return "Kata tidak ditemukan " ;
    }

    public String tampilkanSemua(){
        StringBuilder sb = new StringBuilder();
        tampilInOrder(root, sb);
        return sb.toString();
    }

    private void tampilInOrder(Node node, StringBuilder sb){
        if (node != null) {
            tampilInOrder(node.getLeft(), sb);

            ArrayList<Kata> list = (ArrayList<Kata>) node.getValue();
            for (Kata k : list) {
                sb.append(k.toString()).append("\n");
            }
            tampilInOrder(node.getRight(), sb);
        }
    }
}
