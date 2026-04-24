// Import librarys
import java.awt.*; // Komponen GUI
import java.awt.event.ActionEvent; // Layout dan warna
import java.awt.event.ActionListener; // Event handling
import javax.swing.*; // Event listener

// Class utama 
public class Kalkulator extends JFrame implements ActionListener {

    // Deklarasi variabel
    private JTextField display;  // Menampilkan input dan hasil
    private double firstNumber = 0; // Menyimpan angka pertama
    private String operation = ""; // Menyimpan operasi yang dipilih
    private boolean startNewInput = true; // Menandai input baru

    // Konstruktor class
    public Kalkulator() {

        // Mengatur judul tampilan
        setTitle("Kalkulator");

        // Mengatur ukuran tampilan
        setSize(350, 500);

        // Menutup aplikasi saat tampilan ditutup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur tampilan agar berada di tengah layar
        setLocationRelativeTo(null);

        // Mengatur layout tampilan
        setLayout(new BorderLayout());

        // Membuat dan mengkonfigurasi display
        display = new JTextField();

        // Mengatur font dan ukuran
        display.setFont(new Font("Arial", Font.PLAIN, 32));

        // Mengatur teks agar rata kanan
        display.setHorizontalAlignment(JTextField.RIGHT);

        // Mengatur agar tidak bisa diedit
        display.setEditable(false);

        // Mengatur warna latar belakang dan teks
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();

        // Mengatur layout panel tombol
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        // Daftar tombol
        String[] buttons = {
            "C", "⌫", "%", "√",
            "x²", "x³", "mod", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };

        // Membuat tombol dan menambahkan ke panel
        for (String text : buttons) {

            // Membuat tombol dengan teks
            JButton button = new JButton(text);

            // Mengatur ukuran dan warna tombol
            button.setFont(new Font("Arial", Font.PLAIN, 18));

            // Mengatur untuk menangani klik tombol
            button.addActionListener(this);
            
            // Warna khusus untuk tombol operasi
            if (text.matches("[C⌫%√x²x³mod/+\\-*=.+/-]")) {

            // Mengatur warna latar belakang untuk tombol operasi
                button.setBackground(new Color(220, 220, 220));
            } else {
                button.setBackground(Color.WHITE);
            }
            
            // Tambahkan tombol ke panel
            buttonPanel.add(button);
        }

        // Menambahkan panel tombol ke tampilan 
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Metode untuk menangani aksi tombol
    @Override
    public void actionPerformed(ActionEvent e) {

        // Mendapatkan teks dari tombol yang diklik
        String command = e.getActionCommand();
        
        // Menangani input angka dan titik desimal
        if (command.matches("[0-9]")) {

            // Memastikan ada input yang valid
            if (startNewInput) {

                // Mengatur tampilan untuk input baru
                display.setText("");

                // Menandai bahwa input baru dimulai
                startNewInput = false;
            }

            // Menambahkan angka ke tampilan
            display.setText(display.getText() + command);
        } 

        // Menangani input titik desimal
        else if (command.equals(".")) {

            // Memastikan ada input yang valid
            if (startNewInput) {

                // Mengatur tampilan untuk input baru
                display.setText("0.");

                // Menandai bahwa input baru dimulai
                startNewInput = false;

                // Mengatur ulang angka pertama dan operasi
            } else if (!display.getText().contains(".")) {

                // Menambahkan titik desimal ke tampilan
                display.setText(display.getText() + ".");
            }
        }
        
        // Menangani input +/- untuk mengubah tanda
        else if (command.equals("+/-")) {

            // Memastikan ada input yang valid
            if (!display.getText().isEmpty()) {

                // Mengubah tanda angka di tampilan
                double value = Double.parseDouble(display.getText());

                // Mengubah tanda angka
                value = -value;

                // Mengatur ulang tampilan dengan angka yang telah diubah
                display.setText(String.valueOf(value));
            }
        }

        // Menangani tombol C untuk menghapus input
        else if (command.equals("C")) {

            // Mengatur ulang tampilan dan variabel
            display.setText("");

            // Mengatur ulang angka pertama dan operasi
            firstNumber = 0;
            operation = "";

            // Menandai bahwa input baru dimulai
            startNewInput = true;
        }

        // Menangani tombol ⌫ untuk menghapus karakter terakhir
        else if (command.equals("⌫")) {

            // Mengambil teks saat ini dari tampilan
            String currentText = display.getText();

            // Menghapus karakter terakhir dari teks
            if (!currentText.isEmpty()) {

                // Mengatur ulang tampilan dengan teks yang telah dihapus
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        }

        // Menangani operasi matematika
        else if (command.matches("[+\\-*/mod]")) {

            // Memastikan ada input yang valid
            if (!display.getText().isEmpty()) {

                // Mengambil angka pertama dari input
                firstNumber = Double.parseDouble(display.getText());

                // Mengatur operasi berdasarkan tombol yang diklik
                operation = command;

                // Mengatur ulang tampilan untuk input baru
                startNewInput = true;
            }
        }

        // Menangani operasi khusus seperti %, √, x², x³
        else if (command.matches("[%√x²x³]")) {

            // Memastikan ada input yang valid
            if (!display.getText().isEmpty()) {

                // Mengambil angka dari input
                double value = Double.parseDouble(display.getText());

                // Mengatur ulang tampilan untuk input baru
                switch (command) {

                    // Menghitung persentase
                    case "%":
                        value = value / 100;
                        break;

                    // Menghitung akar kuadrat
                    case "√":
                        value = Math.sqrt(value);
                        break;

                    // Menghitung akar pangkat 2
                    case "x²":
                        value = Math.pow(value, 2);
                        break;

                    // Menghitung akar pangkat 3
                    case "x³":
                        value = Math.pow(value, 3);
                        break;
                }

                // Menampilkan hasil
                display.setText(String.valueOf(value));

                // Mengatur ulang variabel untuk input baru
                startNewInput = true;
            }
        }

        // Menangani operasi pembagian dengan mod
        else if (command.equals("mod")) {

            // Memastikan ada input yang valid
            if (!display.getText().isEmpty()) {

                // Mengambil angka pertama dari input
                firstNumber = Double.parseDouble(display.getText());

                // Mengatur operasi ke modulus
                operation = "mod";

                // Mengatur ulang tampilan untuk input baru
                startNewInput = true;
            }
        }

        // Menangani tombol = untuk menghitung hasil
        else if (command.equals("=")) {

            // Memastikan ada operasi dan input yang valid
            if (!operation.isEmpty() && !display.getText().isEmpty()) {

                // Mengambil angka kedua dari input
                double secondNumber = Double.parseDouble(display.getText());

                // Variabel untuk menyimpan hasil
                double result = 0;
                
                // Menghitung hasil berdasarkan operasi yang dipilih
                switch (operation) {

                    // Penanganan operasi penjumlahan
                    case "+": 
                        result = firstNumber + secondNumber;
                        break;

                    // Penanganan operasi pengurangan
                    case "-":
                        result = firstNumber - secondNumber;
                        break;

                    // Penanganan operasi perkalian
                    case "*":
                        result = firstNumber * secondNumber;
                        break;

                    // Penanganan operasi pembagian
                    case "/":
                        result = firstNumber / secondNumber;
                        break;

                    // Penanganan operasi modulus
                    case "mod":
                        result = firstNumber % secondNumber;
                        break;
                }
                
                // Menampilkan hasil
                display.setText(String.valueOf(result));

                // Mengatur ulang variabel untuk input baru
                operation = "";

                // Mengatur ulang angka pertama
                startNewInput = true;
            }
        }
    }

    // Metode utama untuk menjalankan aplikasi kalkulator
    public static void main(String[] args) {

        // Menjalankan aplikasi di thread utama Swing
        SwingUtilities.invokeLater(() -> {

            // Membuat instance kalkulator dan menampilkannya
            Kalkulator kalkulator = new Kalkulator();

            // Mengatur tampilan agar terlihat
            kalkulator.setVisible(true);
        });
    }
}