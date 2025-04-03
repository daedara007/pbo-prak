// groupping modul2
package modul2;

// import joptionpane
import javax.swing.JOptionPane;

// class lingkaran
class Lingkaran3 {
    // attribute
    double Jari;

    // constructornya
    public Lingkaran3() {
        // ini untuk menampilkan pesan masukkan jari-jari lingkaran
        String inputStr = JOptionPane.showInputDialog(
                null,
                "Masukkan jari-jari lingkarannya:",
                "Hitung Keliling Lingkaran",
                JOptionPane.QUESTION_MESSAGE
        );
        // ini adalah input joptionpanenya
        Jari = Double.parseDouble(inputStr);
    }

    // ini adalah methodnya
    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }
}

// ini adalah class trapesium
class Trapesium3 {
    // attribute
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    // ini adalah constructor
    public Trapesium3() {
        SisiAtas = getInput("Masukkan sisi atas:", "Hitung Luas Trapesium");
        SisiBawah = getInput("Masukkan sisi bawah:", "Hitung Luas Trapesium");
        Tinggi = getInput("Masukkan tinggi:", "Hitung Luas Trapesium");
    }

    // ini adalah method getInput yang akan dipanggil oleh constructor
    private double getInput(String message, String title) {
        String inputStr = JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
        );
        return Double.parseDouble(inputStr);
    }

    // in adalah method utamanya
    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah) / 2 * Tinggi);
    }
}

// class prisma
class Prisma3 {
    // attribute
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    // constructor
    public Prisma3() {
        LuasAlas = getInput("Masukkan Luas Alas:", "Hitung Luas Prisma");
        TinggiSegitiga = getInput("Masukkan Tinggi Segitiga:", "Hitung Luas Prisma");
        KelilingSegitiga = getInput("Masukkan Keliling Segitiga:", "Hitung Luas Prisma");
    }

    // method getInput yang akan dipanggil oleh constructor
    private double getInput(String message, String title) {
        String inputStr = JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
        );
        return Double.parseDouble(inputStr);
    }

    // ini adalah method utamanya
    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

// ini adalah class utamanya
public class JOptionPaneInput {
    public static void main(String[] args) {
        // Ini menampilkan pesan untuk Hitung Keliling Lingkaran dalam gui joptionpane
        JOptionPane.showMessageDialog(null, "..::Hitung Keliling Lingkaran::..");
        // ini untuk membuat objek keliling untuk class lingkaran
        Lingkaran3 keliling = new Lingkaran3();
        double hasilKeliling = keliling.HitungKelilingLingkaran();
        // untuk menampilkan hasil perhitungannya
        JOptionPane.showMessageDialog(
                null,
                String.format("Keliling lingkarannya adalah: %.3f", hasilKeliling)
        );

        // Ini menampilkan pesan untuk Hitung Luas Trapesium dalam gui joptionpane
        JOptionPane.showMessageDialog(null, "..::Hitung Luas Trapesium::..");
        // ini untuk membuat objek LuasT untuk class Trapesium
        Trapesium3 luasT = new Trapesium3();
        double hasilLuasT = luasT.HitungLuasTrapesium();
        // Untuk menampilkan hasil perhitungannya
        JOptionPane.showMessageDialog(
                null,
                String.format("Luas trapesiumnya adalah: %.2f", hasilLuasT)
        );

        // Ini menampilkan pesan untuk Hitung Luas Prisma dalam gui joptionpane
        JOptionPane.showMessageDialog(null, "..::Hitung Luas Prisma::..");
        // ini untuk membuat objek LuasP
        Prisma3 luasP = new Prisma3();
        double hasilLuasP = luasP.HitungLuasPrisma();
        // ini untuk menampilkan hasil perhitungannya
        JOptionPane.showMessageDialog(
                null,
                String.format("Luas prismanya adalah: %.2f", hasilLuasP)
        );
    }
}