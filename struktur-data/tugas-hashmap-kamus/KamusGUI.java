package Kamus;

import javax.swing.*;
import java.awt.*;

public class KamusGUI extends JFrame {
    Kamus kamus = new Kamus();

    JTextField tfInggrisTambah = new JTextField();
    JTextField tfIndoTambah = new JTextField();
    JButton btnTambah = new JButton("Tambah");
    JTextArea areaList = new JTextArea();
    JTextField tfCari = new JTextField();
    JButton btnTerjemah = new JButton("Terjemahkan");
    JTextArea areaHasil = new JTextArea();

    public KamusGUI() {
        setTitle("Kamus Sederhana");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== PANEL KANAN (TERJEMAHAN) =====
        JPanel panelKanan = new JPanel(new BorderLayout(5, 5));
        JPanel panelCari = new JPanel(new GridLayout(2, 1, 5, 5));
        panelCari.setBorder(BorderFactory.createTitledBorder("Inggris"));
        panelCari.add(tfCari);
        panelCari.add(btnTerjemah);
        panelKanan.add(panelCari, BorderLayout.NORTH);

        JPanel panelHasil = new JPanel(new BorderLayout());
        panelHasil.setBorder(BorderFactory.createTitledBorder("Terjemahan"));
        areaHasil.setEditable(false);
        panelHasil.add(new JScrollPane(areaHasil));
        panelKanan.add(panelHasil, BorderLayout.CENTER);
        add(panelKanan, BorderLayout.CENTER);

        tampilkanKamus();

        btnTambah.addActionListener(e -> {
            String en = tfInggrisTambah.getText();
            String id = tfIndoTambah.getText();

            if (!en.isEmpty() && !id.isEmpty()) {
                kamus.tambahKata(en, id);
                tampilkanKamus();
                tfInggrisTambah.setText("");
                tfIndoTambah.setText("");
            }
        });

        btnTerjemah.addActionListener(e -> {
            String kata = tfCari.getText().trim();
            Kata hasilkata = kamus.getKataObject(kata);

            if (hasilkata != null) {
                areaHasil.setText(hasilkata.getIndonesia());

                if (hasilkata.hasActioon()){
                    hasilkata.runAksi(this);
                }
            } else {
                areaHasil.setText("Kata tidak ditemukan");
            }
        });

        tfCari.addActionListener(e -> btnTerjemah.doClick());
        SwingUtilities.invokeLater(() -> tfCari.requestFocusInWindow());
    }
        private void tampilkanKamus () {
        areaList.setText(kamus.tampilkanSemua());
        }

        public static void main (String[]args){
            new KamusGUI().setVisible(true);
        }
    }