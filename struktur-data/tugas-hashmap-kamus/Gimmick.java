package Kamus;                               // Menyatakan bahwa file ini berada dalam package/folder bernama "Kamus"

import javax.swing.*;                       // Mengimpor semua kelas dan komponen GUI dari library javax.swing
import java.awt.*;                          // Mengimpor kelas-kelas untuk Abstract Window Toolkit (manajemen layout, event, dll)
import java.awt.event.ActionEvent;          // Mengimpor class ActionEvent untuk menangani event aksi
import java.awt.event.ActionListener;       // Mengimpor interface ActionListener untuk menangani event
import java.util.Random;                    // Mengimpor class Random untuk menghasilkan angka acak

public class Gimmick {                      // Mendefinisikan kelas Gimmick yang berisi efek-efek visual khusus

    public static void showCat(JFrame frame) { // Method static untuk menampilkan gambar kucing
        try {                                // Blok try-catch untuk menangani error loading gambar
            // Coba beberapa lokasi yang mungkin
            String[] possiblePaths = {       // Array yang berisi kemungkinan lokasi file gambar
                    "cat.png",               // Lokasi 1: di folder yang sama dengan project
                    System.getProperty("user.dir") + "/cat.png"  // Lokasi 2: absolute path dari direktori kerja
            };

            ImageIcon catIcon = null;        // Deklarasi variabel untuk menyimpan gambar

            // Coba semua path yang mungkin
            for (String path : possiblePaths) { // Loop melalui semua kemungkinan path
                catIcon = new ImageIcon(path);  // Coba load gambar dari path
                if (catIcon.getIconWidth() > 0) { // Jika gambar berhasil diload (lebar > 0)
                    System.out.println("Gambar ditemukan di: " + path); // Tampilkan info di console
                    break;                       // Keluar dari loop jika gambar ditemukan
                }
            }

            // Jika masih tidak ditemukan
            if (catIcon == null || catIcon.getIconWidth() <= 0) { // Jika gambar tidak ditemukan
                System.out.println("Current directory: " + System.getProperty("user.dir")); // Tampilkan direktori saat ini
                throw new Exception("File cat.png tidak ditemukan. Cek path: " + System.getProperty("user.dir")); // Lempar exception
            }

            // Skala gambar jika terlalu besar
            Image image = catIcon.getImage();                    // Ambil objek Image dari ImageIcon
            Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Skala gambar ke 300x300
            catIcon = new ImageIcon(scaledImage);               // Buat ImageIcon baru dari gambar yang sudah discale

            // Buat dialog untuk menampilkan gambar
            JDialog catDialog = new JDialog(frame, "Meow! Ini Kucing", true); // Buat JDialog modal dengan judul
            catDialog.setSize(400, 400);                         // Atur ukuran dialog
            catDialog.setLocationRelativeTo(frame);              // Posisikan dialog di tengah frame induk

            // Panel untuk gambar
            JPanel panel = new JPanel(new BorderLayout());       // Buat panel dengan BorderLayout

            // Label untuk gambar
            JLabel catLabel = new JLabel(catIcon);               // Buat JLabel untuk menampilkan gambar
            catLabel.setHorizontalAlignment(SwingConstants.CENTER); // Atur alignment gambar ke tengah
            panel.add(catLabel, BorderLayout.CENTER);            // Tambahkan label ke tengah panel

            // Label teks
            JLabel textLabel = new JLabel("Cat = Kucing!", SwingConstants.CENTER); // Buat label teks
            textLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Atur font label teks
            panel.add(textLabel, BorderLayout.NORTH);            // Tambahkan label teks ke atas panel

            // Tombol close
            JButton closeButton = new JButton("Tutup");          // Buat tombol "Tutup"
            closeButton.addActionListener(e -> catDialog.dispose()); // Tambahkan event listener untuk menutup dialog
            panel.add(closeButton, BorderLayout.SOUTH);          // Tambahkan tombol ke bawah panel

            catDialog.add(panel);                                // Tambahkan panel ke dialog
            catDialog.setVisible(true);                          // Tampilkan dialog

        } catch (Exception e) {                                  // Tangkap exception jika terjadi error
            e.printStackTrace();                                 // Cetak stack trace error ke console
            // Fallback dengan pesan error yang lebih informatif
            JOptionPane.showMessageDialog(frame,                // Tampilkan dialog pesan error
                    "Meow! Cat = Kucing!\n" +                    // Pesan pertama
                            "Gambar cat.png tidak ditemukan.\n" + // Pesan kedua
                            "Pastikan file ada di: " + System.getProperty("user.dir"), // Pesan ketiga dengan path
                    "Kucing",                                    // Judul dialog
                    JOptionPane.WARNING_MESSAGE);               // Tipe icon warning
        }
    }


    public static void erase(JFrame frame){                      // Method untuk menghapus semua komponen dari frame
        frame.getContentPane().removeAll();                      // Hapus semua komponen dari content pane frame
        frame.revalidate();                                      // Validasi ulang struktur komponen frame
        frame.repaint();                                         // Gambar ulang frame

        frame.setTitle("Kamus kosong");                         // Ubah judul frame
        JOptionPane.showMessageDialog(frame, "Semua tampilan dihapus"); // Tampilkan pesan konfirmasi
    }

    public static void fall(JFrame frame){                      // Method untuk membuat efek komponen jatuh
        Container contetPane = frame.getContentPane();          // Ambil content pane dari frame
        Component[] component = contetPane.getComponents();     // Ambil semua komponen dalam content pane

        for (Component comp : component){                       // Loop melalui semua komponen
            comp.setBounds(comp.getBounds());                   // Atur bounds komponen (posisi dan ukuran)
        }

        contetPane.setLayout(null);                             // Hapus layout manager (gunakan absolute positioning)

        Timer timer = new Timer(10, new ActionListener() {      // Buat Timer dengan delay 10ms
            int velocity = 5;                                   // Kecepatan jatuh (pixel per interval)
            @Override
            public void actionPerformed(ActionEvent e) {        // Method yang dipanggil setiap interval timer
                boolean layar = false ;                          // Flag untuk mengecek apakah masih ada komponen di layar
                int screenHeight = frame.getHeight();            // Ambil tinggi frame

                for (Component comp : component){                // Loop melalui semua komponen
                    int x = comp.getX();                         // Ambil posisi X komponen
                    int y = comp.getY();                         // Ambil posisi Y komponen

                    if (y < screenHeight){                       // Jika komponen masih di dalam layar
                        comp.setLocation(x, y + velocity);       // Geser komponen ke bawah sejauh velocity
                        layar = true ;                           // Set flag menjadi true
                    }
                }
                frame.repaint();                                 // Gambar ulang frame
                if (!layar){                                     // Jika tidak ada komponen yang masih di layar
                    ((Timer)e.getSource()).stop();               // Hentikan timer
                }
            }
        });
        timer.start();                                          // Mulai timer
    }

    public static void Shake(JFrame frame){                    // Method untuk membuat efek frame bergetar
        final Point origin = frame.getLocation();              // Simpan posisi awal frame
        final Random random = new Random();                    // Buat objek Random untuk angka acak
        final int startTime = (int) System.currentTimeMillis(); // Simpan waktu mulai

        Timer timer = new Timer(40, new ActionListener() {     // Buat Timer dengan delay 40ms
            int count = 0 ;                                    // Counter untuk menghitung iterasi
            @Override
            public void actionPerformed(ActionEvent e) {       // Method yang dipanggil setiap interval timer
                int xOffset = random.nextInt(20) - 10;         // Generate offset X acak antara -10 sampai 10
                int yoffset = random.nextInt(20) - 10;         // Generate offset Y acak antara -10 sampai 10

                frame.setLocation(origin.x + xOffset, origin.y + yoffset); // Geser frame dengan offset acak

                if (count > 30){                               // Jika sudah lebih dari 30 iterasi
                    frame.setLocation(origin);                 // Kembalikan frame ke posisi awal
                    ((Timer)e.getSource()).stop();             // Hentikan timer
                }
            }
        });
        timer.start();                                         // Mulai timer
    }
}