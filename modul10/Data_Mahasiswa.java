package modul10;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Data_Mahasiswa extends JFrame {
    private JTextField txtNama, txtNim, txtAlamat, txtNoHp;
    private JComboBox<String> cbJurusan;
    private JButton btnTambah, btnEdit, btnHapus, btnClear;
    private JTable tableMahasiswa;
    private DefaultTableModel model;
    private Connection conn;

    public Data_Mahasiswa() {
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        connectDatabase();
        loadData();
        setSize(700, 450);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Panel for form inputs
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(new TitledBorder("Data Mahasiswa"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Row 1: Nama
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        txtNama = new JTextField(20);
        panelForm.add(txtNama, gbc);
        gbc.gridx = 2;
        btnTambah = new JButton("Tambah");
        panelForm.add(btnTambah, gbc);

        // Row 2: NIM
        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1;
        txtNim = new JTextField(20);
        panelForm.add(txtNim, gbc);
        gbc.gridx = 2;
        btnEdit = new JButton("Edit");
        panelForm.add(btnEdit, gbc);

        // Row 3: Jurusan
        gbc.gridx = 0; gbc.gridy = 2;
        panelForm.add(new JLabel("Jurusan:"), gbc);
        gbc.gridx = 1;
        cbJurusan = new JComboBox<>(new String[]{"Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Manajemen"});
        panelForm.add(cbJurusan, gbc);
        gbc.gridx = 2;
        btnHapus = new JButton("Hapus");
        panelForm.add(btnHapus, gbc);

        // Row 4: Alamat
        gbc.gridx = 0; gbc.gridy = 3;
        panelForm.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        txtAlamat = new JTextField(20);
        panelForm.add(txtAlamat, gbc);
        gbc.gridx = 2;
        btnClear = new JButton("Clear");
        panelForm.add(btnClear, gbc);

        // Row 5: No Handphone
        gbc.gridx = 0; gbc.gridy = 4;
        panelForm.add(new JLabel("No Handphone:"), gbc);
        gbc.gridx = 1;
        txtNoHp = new JTextField(20);
        panelForm.add(txtNoHp, gbc);

        // Table for data
        model = new DefaultTableModel(new Object[]{"Nama", "NIM", "Jurusan", "Alamat", "No Handphone"}, 0);
        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);

        // Layout main frame
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event handlers
        btnTambah.addActionListener(e -> tambahData());
        btnEdit.addActionListener(e -> editData());
        btnHapus.addActionListener(e -> hapusData());
        btnClear.addActionListener(e -> clearFields());
        tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                if (row >= 0) {
                    txtNama.setText(model.getValueAt(row, 0).toString());
                    txtNim.setText(model.getValueAt(row, 1).toString());
                    cbJurusan.setSelectedItem(model.getValueAt(row, 2).toString());
                    txtAlamat.setText(model.getValueAt(row, 3).toString());
                    txtNoHp.setText(model.getValueAt(row, 4).toString());
                }
            }
        });
    }

    private void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_Mahasiswa?serverTimezone=UTC",
                "root", "0209"
            );
        } catch (ClassNotFoundException cnf) {
            JOptionPane.showMessageDialog(this, "Driver tidak ditemukan: " + cnf.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal koneksi: " + ex.getMessage());
        }
    }

    private void loadData() {
        model.setRowCount(0);
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM mahasiswa")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan"),
                    rs.getString("alamat"),
                    rs.getString("no_hp")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error load data: " + ex.getMessage());
        }
    }

    private void tambahData() {
        String sql = "INSERT INTO mahasiswa(nama,nim,jurusan,alamat,no_hp) VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtNim.getText());
            pst.setString(3, cbJurusan.getSelectedItem().toString());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtNoHp.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambah");
            loadData();
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error tambah data: " + ex.getMessage());
        }
    }

    private void editData() {
        String sql = "UPDATE mahasiswa SET nama=?, jurusan=?, alamat=?, no_hp=? WHERE nim=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtNama.getText());
            pst.setString(2, cbJurusan.getSelectedItem().toString());
            pst.setString(3, txtAlamat.getText());
            pst.setString(4, txtNoHp.getText());
            pst.setString(5, txtNim.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            loadData();
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error edit data: " + ex.getMessage());
        }
    }

    private void hapusData() {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtNim.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            loadData();
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error hapus data: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtNama.setText("");
        txtNim.setText("");
        cbJurusan.setSelectedIndex(0);
        txtAlamat.setText("");
        txtNoHp.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Data_Mahasiswa().setVisible(true);
        });
    }
}
