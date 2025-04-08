import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DataMahasiswa extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameField, nimField, facultyField, universityField, interestField, addressField, phoneField;
    private JComboBox<String> majorField;

    public DataMahasiswa() {
        super("Data Mahasiswa");

        // Panel formulir
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Nama:"));
        nameField = new JTextField(20);
        formPanel.add(nameField);

        formPanel.add(new JLabel("NIM:"));
        nimField = new JTextField(20);
        formPanel.add(nimField);

        formPanel.add(new JLabel("Jurusan:"));
        majorField = new JComboBox<>(new String[]{"Informatika", "Sistem Informasi", "Teknik Elektro", "Teknik Lingkungan", "Teknik Sipil", "Arsitektur"});
        formPanel.add(majorField);

        formPanel.add(new JLabel("Alamat:"));
        addressField = new JTextField(20);
        formPanel.add(addressField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField(20);
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Fakultas:"));
        facultyField = new JTextField(20);
        formPanel.add(facultyField);

        formPanel.add(new JLabel("Universitas:"));
        universityField = new JTextField(20);
        formPanel.add(universityField);

        formPanel.add(new JLabel("Bidang Peminatan:"));
        interestField = new JTextField(20);
        formPanel.add(interestField);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Tentukan ukuran preferensi untuk semua tombol
        Dimension buttonSize = new Dimension(90, 30);

        // Buat tombol dan atur ukurannya
        JButton addButton = new JButton("Tambah");
        addButton.setPreferredSize(buttonSize);

        JButton editButton = new JButton("Edit");
        editButton.setPreferredSize(buttonSize);

        JButton deleteButton = new JButton("Hapus");
        deleteButton.setPreferredSize(buttonSize);

        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(buttonSize);

        // Tambahkan tombol ke panel dengan jarak antar tombol
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Jarak 10 piksel
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(clearButton);

        // Panel atas (formulir + tombol)
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(formPanel, BorderLayout.CENTER);
        upperPanel.add(buttonPanel, BorderLayout.EAST);

        // Tambahkan judul "Data Mahasiswa"
        JLabel titleLabel = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        upperPanel.add(titleLabel, BorderLayout.NORTH);

        // Inisialisasi tabel
        String[] columnNames = {"No", "Nama", "NIM", "Jurusan", "Alamat", "No Handphone", "Fakultas", "Universitas", "Bidang Peminatan"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tata letak utama
        setLayout(new BorderLayout());
        add(upperPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);


        // Listener untuk seleksi baris tabel
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                nameField.setText(table.getValueAt(selectedRow, 1).toString());
                nimField.setText(table.getValueAt(selectedRow, 2).toString());
                majorField.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
                addressField.setText(table.getValueAt(selectedRow, 4).toString());
                phoneField.setText(table.getValueAt(selectedRow, 5).toString());
                facultyField.setText(table.getValueAt(selectedRow, 6).toString());
                universityField.setText(table.getValueAt(selectedRow, 7).toString());
                interestField.setText(table.getValueAt(selectedRow, 8).toString());
            }
        });

        // Listener untuk tombol
        addButton.addActionListener(e -> addData());
        editButton.addActionListener(e -> editData());
        deleteButton.addActionListener(e -> deleteData());
        clearButton.addActionListener(e -> clearForm());

        // Muat data awal
        loadTableData();

        // Pengaturan frame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Koneksi ke database
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Mahasiswa";
        String user = "root";
        String pass = "";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, user, pass);
    }

    // Memuat data ke tabel
    private void loadTableData() {
        model.setRowCount(0);
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM table_mhs")) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("no"),
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan"),
                    rs.getString("alamat"),
                    rs.getString("no_telpon"),
                    rs.getString("fakultas"),
                    rs.getString("universitas"),
                    rs.getString("bidang_peminatan")
                    
                    
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Menambah data
    private void addData() {
        String sql = "INSERT INTO table_mhs (nama, nim, jurusan, alamat, no_telpon, fakultas, universitas, bidang_peminatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, nimField.getText());
            pstmt.setString(3, (String) majorField.getSelectedItem());
            pstmt.setString(4, addressField.getText());
            pstmt.setString(5, phoneField.getText());
            pstmt.setString(6, facultyField.getText());
            pstmt.setString(7, universityField.getText());
            pstmt.setString(8, interestField.getText());
            
            
            pstmt.executeUpdate();
            loadTableData();
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error menambah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mengedit data
    private void editData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) table.getValueAt(selectedRow, 0);
        String sql = "UPDATE table_mhs SET nama=?, nim=?, jurusan=?, alamat=?, no_telpon=?, fakultas=?, universitas=?, bidang_peminatan=? WHERE no=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nameField.getText());
            pstmt.setString(2, nimField.getText());
            pstmt.setString(3, (String) majorField.getSelectedItem());
            pstmt.setString(4, addressField.getText());
            pstmt.setString(5, phoneField.getText());
            pstmt.setString(6, facultyField.getText());
            pstmt.setString(7, universityField.getText());
            pstmt.setString(8, interestField.getText());
            pstmt.setInt(9, id);
            pstmt.executeUpdate();
            loadTableData();
            clearForm();
            JOptionPane.showMessageDialog(this, "Data berhasil diedit!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error mengedit data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Menghapus data
    private void deleteData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) table.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM table_mhs WHERE no=?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                loadTableData();
                clearForm();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Membersihkan formulir
    private void clearForm() {
        nameField.setText("");
        nimField.setText("");
        majorField.setSelectedItem(0);
        facultyField.setText("");
        universityField.setText("");
        interestField.setText("");
        addressField.setText("");
        phoneField.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataMahasiswa());
    }
}