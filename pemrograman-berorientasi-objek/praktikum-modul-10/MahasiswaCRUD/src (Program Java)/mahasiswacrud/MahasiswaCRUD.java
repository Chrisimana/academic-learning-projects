package mahasiswacrud;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MahasiswaCRUD extends JFrame {
    private JTextField txtNama, txtNim, txtAlamat, txtTelpon, txtFakultas, txtUniversitas, txtBidang;
    private JComboBox<String> cbJurusan;
    private JTable table;
    private JButton btnTambah, btnEdit, btnHapus, btnClear;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver tidak ditemukan!");
            e.printStackTrace();
            return;
        }
        
        SwingUtilities.invokeLater(() -> {
            MahasiswaCRUD app = new MahasiswaCRUD();
            app.setVisible(true);
        });
    }

    public MahasiswaCRUD() {
        initComponents();
        createDatabaseAndTable();
        loadTable();
    }

    private void initComponents() {
        setTitle("Aplikasi CRUD Mahasiswa");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        addLabelAndTextField(panel, "Nama:", 20, 20, txtNama = new JTextField(), 130, 20, 200);
        addLabelAndTextField(panel, "NIM:", 20, 50, txtNim = new JTextField(), 130, 50, 200);
        
        JLabel lblJurusan = new JLabel("Jurusan:");
        lblJurusan.setBounds(20, 80, 100, 20);
        panel.add(lblJurusan);
        
        cbJurusan = new JComboBox<>(new String[]{"Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Manajemen", "Akuntansi"});
        cbJurusan.setBounds(130, 80, 200, 20);
        panel.add(cbJurusan);
        
        addLabelAndTextField(panel, "Alamat:", 20, 110, txtAlamat = new JTextField(), 130, 110, 200);
        addLabelAndTextField(panel, "No. Telpon:", 20, 140, txtTelpon = new JTextField(), 130, 140, 200);
        addLabelAndTextField(panel, "Fakultas:", 20, 170, txtFakultas = new JTextField(), 130, 170, 200);
        addLabelAndTextField(panel, "Universitas:", 20, 200, txtUniversitas = new JTextField(), 130, 200, 200);
        addLabelAndTextField(panel, "Bidang Peminatan:", 350, 20, txtBidang = new JTextField(), 470, 20, 200);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 250, 850, 300);
        panel.add(scrollPane);

        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(350, 80, 100, 30);
        btnTambah.addActionListener(this::tambahAction);
        panel.add(btnTambah);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(350, 120, 100, 30);
        btnEdit.addActionListener(this::editAction);
        panel.add(btnEdit);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(350, 160, 100, 30);
        btnHapus.addActionListener(this::hapusAction);
        panel.add(btnHapus);

        btnClear = new JButton("Clear");
        btnClear.setBounds(350, 200, 100, 30);
        btnClear.addActionListener(e -> kosong());
        panel.add(btnClear);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    txtNama.setText(table.getValueAt(row, 1).toString());
                    txtNim.setText(table.getValueAt(row, 2).toString());
                    cbJurusan.setSelectedItem(table.getValueAt(row, 3).toString());
                    txtAlamat.setText(table.getValueAt(row, 4).toString());
                    txtTelpon.setText(table.getValueAt(row, 5).toString());
                    txtFakultas.setText(table.getValueAt(row, 6).toString());
                    txtUniversitas.setText(table.getValueAt(row, 7).toString());
                    txtBidang.setText(table.getValueAt(row, 8).toString());
                }
            }
        });

        add(panel);
    }

    private void addLabelAndTextField(JPanel panel, String labelText, int lblX, int lblY, 
                                     JTextField textField, int txtX, int txtY, int txtWidth) {
        JLabel label = new JLabel(labelText);
        label.setBounds(lblX, lblY, 100, 20);
        panel.add(label);
        
        textField.setBounds(txtX, txtY, txtWidth, 20);
        panel.add(textField);
    }

    private void createDatabaseAndTable() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "")) {
            Statement stmt = conn.createStatement();
            
            // Buat database jika belum ada
            stmt.execute("CREATE DATABASE IF NOT EXISTS Mahasiswa");
            
            // Gunakan database
            stmt.execute("USE Mahasiswa");
            
            // Buat tabel jika belum ada
            stmt.execute("CREATE TABLE IF NOT EXISTS table_mhs (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nama VARCHAR(100), " +
                "nim VARCHAR(20) UNIQUE, " +
                "jurusan VARCHAR(50), " +
                "alamat TEXT, " +
                "no_telpon VARCHAR(15), " +
                "fakultas VARCHAR(50), " +
                "universitas VARCHAR(50), " +
                "bidang_peminatan VARCHAR(50))");
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error membuat database/tabel: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/Mahasiswa";
            String user = "root";
            String pass = "";
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new SQLException("Koneksi gagal: " + e.getMessage());
        }
    }

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        model.addColumn("Alamat");
        model.addColumn("Telpon");
        model.addColumn("Fakultas");
        model.addColumn("Universitas");
        model.addColumn("Bidang Peminatan");
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM table_mhs")) {
            
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan"),
                    rs.getString("alamat"),
                    rs.getString("no_telpon"),
                    rs.getString("fakultas"),
                    rs.getString("universitas"),
                    rs.getString("bidang_peminatan")
                });
            }
            
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error memuat data: " + e.getMessage());
        }
    }

    private void tambahAction(ActionEvent evt) {
        if (txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM tidak boleh kosong!");
            return;
        }
        
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO table_mhs (nama, nim, jurusan, alamat, no_telpon, fakultas, universitas, bidang_peminatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtNim.getText());
            pst.setString(3, cbJurusan.getSelectedItem().toString());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtTelpon.getText());
            pst.setString(6, txtFakultas.getText());
            pst.setString(7, txtUniversitas.getText());
            pst.setString(8, txtBidang.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            
            loadTable();
            kosong();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Error: NIM sudah terdaftar!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void editAction(ActionEvent evt) {
        if (txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan di edit dari tabel!");
            return;
        }
        
        try (Connection conn = getConnection()) {
            String sql = "UPDATE table_mhs SET nama=?, jurusan=?, alamat=?, no_telpon=?, fakultas=?, universitas=?, bidang_peminatan=? WHERE nim=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNama.getText());
            pst.setString(2, cbJurusan.getSelectedItem().toString());
            pst.setString(3, txtAlamat.getText());
            pst.setString(4, txtTelpon.getText());
            pst.setString(5, txtFakultas.getText());
            pst.setString(6, txtUniversitas.getText());
            pst.setString(7, txtBidang.getText());
            pst.setString(8, txtNim.getText());
            
            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
                loadTable();
                kosong();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void hapusAction(ActionEvent evt) {
        if (txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus dari tabel!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Yakin ingin menghapus data dengan NIM " + txtNim.getText() + "?", 
            "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = getConnection()) {
                String sql = "DELETE FROM table_mhs WHERE nim=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, txtNim.getText());
                
                int deleted = pst.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                    loadTable();
                    kosong();
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void kosong() {
        txtNama.setText("");
        txtNim.setText("");
        cbJurusan.setSelectedIndex(0);
        txtAlamat.setText("");
        txtTelpon.setText("");
        txtFakultas.setText("");
        txtUniversitas.setText("");
        txtBidang.setText("");
    }
}