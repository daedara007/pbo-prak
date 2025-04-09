// Groupping modul9
package modul9;

// import java swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// class utama kalkulator simple
public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    // Buat inisiasi GUInya
    public SimpleCalculator() {
        initUI();
    }

    // Settingan guinya
    private void initUI() {
        // setup untuk layarnya
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 25));

        // setup panel tombolnya
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        // struktur tombolnya
        String[] labels = {
            "C", "%", "mod", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=", "x²",
            "x³", "√", "", ""
        };

        // perulangan untuk munculin tombolnya
        for (String text : labels) {
            if (text.isEmpty()) {
                panel.add(new JLabel());
            } else {
                JButton btn = new JButton(text);
                btn.setFont(new Font("Arial", Font.PLAIN, 15));
                btn.addActionListener(this);
                panel.add(btn);
            }
        }

        // buat atur bordernya
        setLayout(new BorderLayout(5, 5));
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // buat bagian titlenya
        setTitle("Kalkulator Sederhana");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // method atau action untuk setiap tombol
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            // jika tombol c ditekan
            if (cmd.equals("C")) {
                display.setText("0");
                firstNumber = 0;
                operator = "";
                startNewNumber = true;

            // jika tombol % ditekan
            } else if (cmd.equals("%")) {
                double value = Double.parseDouble(display.getText());
                value /= 100;
                display.setText(formatNumber(value));

            // jika tombol pangkat ditekan
            } else if (cmd.equals("x²")) {
                double value = Double.parseDouble(display.getText());
                value = Math.pow(value, 2);
                display.setText(formatNumber(value));

            // jika tombol pangkat 3 ditekan
            } else if (cmd.equals("x³")) {
                double value = Double.parseDouble(display.getText());
                value = Math.pow(value, 3);
                display.setText(formatNumber(value));

            // jika tombol akar ditekan
            } else if (cmd.equals("√")) {
                double value = Double.parseDouble(display.getText());
                value = Math.sqrt(value);
                display.setText(formatNumber(value));

            // jika tombol + ditekan
            } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") || cmd.equals("mod")) {
                firstNumber = Double.parseDouble(display.getText());
                operator = cmd;
                startNewNumber = true;

            // jika tombol = ditekan
            } else if (cmd.equals("=")) {
                if (!operator.isEmpty()) {
                    double second = Double.parseDouble(display.getText());
                    double result = 0;
                    switch (operator) {
                        // untuk operator tambah
                        case "+": result = firstNumber + second; break;
                        // untuk operator kurang
                        case "-": result = firstNumber - second; break;
                        // untuk operator kali
                        case "*": result = firstNumber * second; break;
                        // untuk operator bagi
                        case "/": result = firstNumber / second; break;
                        // untuk operator mod
                        case "mod": result = firstNumber % second; break;
                    }
                    display.setText(formatNumber(result));
                    operator = "";
                    startNewNumber = true;
                }

            } else {
                // Untuk angka desimal
                if (startNewNumber) {
                    display.setText(cmd);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + cmd);
                }
            }
        // exception handling untuk format error
        } catch (NumberFormatException ex) {
            display.setText("Error");
            startNewNumber = true;
        }
    }

    // untuk menentukan format tampilan angka
    private String formatNumber(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.valueOf(value);
        }
    }

    // method yang akan dijalanin untuk membuat objek SimpleCalculator dan
    // Menjalankan kalkulatornya
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calc = new SimpleCalculator();
            calc.setVisible(true);
        });
    }
}