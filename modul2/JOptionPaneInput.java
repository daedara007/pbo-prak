package modul2;

import javax.swing.JOptionPane;

class Lingkaran3 {
    double Jari;

    public Lingkaran3() {
        String inputStr = JOptionPane.showInputDialog(
                null,
                "Masukkan jari-jari lingkarannya:",
                "Hitung Keliling Lingkaran",
                JOptionPane.QUESTION_MESSAGE
        );
        Jari = Double.parseDouble(inputStr);
    }

    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }
}

class Trapesium3 {
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    public Trapesium3() {
        SisiAtas = getInput("Masukkan sisi atas:", "Hitung Luas Trapesium");
        SisiBawah = getInput("Masukkan sisi bawah:", "Hitung Luas Trapesium");
        Tinggi = getInput("Masukkan tinggi:", "Hitung Luas Trapesium");
    }

    private double getInput(String message, String title) {
        String inputStr = JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
        );
        return Double.parseDouble(inputStr);
    }

    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah) / 2 * Tinggi);
    }
}

class Prisma3 {
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    public Prisma3() {
        LuasAlas = getInput("Masukkan Luas Alas:", "Hitung Luas Prisma");
        TinggiSegitiga = getInput("Masukkan Tinggi Segitiga:", "Hitung Luas Prisma");
        KelilingSegitiga = getInput("Masukkan Keliling Segitiga:", "Hitung Luas Prisma");
    }

    private double getInput(String message, String title) {
        String inputStr = JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
        );
        return Double.parseDouble(inputStr);
    }

    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

public class JOptionPaneInput {
    public static void main(String[] args) {
        // Menghitung Keliling Lingkaran
        JOptionPane.showMessageDialog(null, "..::Hitung Keliling Lingkaran::..");
        Lingkaran3 keliling = new Lingkaran3();
        double hasilKeliling = keliling.HitungKelilingLingkaran();
        JOptionPane.showMessageDialog(
                null,
                String.format("Keliling lingkarannya adalah: %.3f", hasilKeliling)
        );

        // Menghitung Luas Trapesium
        JOptionPane.showMessageDialog(null, "..::Hitung Luas Trapesium::..");
        Trapesium3 luasT = new Trapesium3();
        double hasilLuasT = luasT.HitungLuasTrapesium();
        JOptionPane.showMessageDialog(
                null,
                String.format("Luas trapesiumnya adalah: %.2f", hasilLuasT)
        );

        // Menghitung Luas Prisma
        JOptionPane.showMessageDialog(null, "..::Hitung Luas Prisma::..");
        Prisma3 luasP = new Prisma3();
        double hasilLuasP = luasP.HitungLuasPrisma();
        JOptionPane.showMessageDialog(
                null,
                String.format("Luas prismanya adalah: %.2f", hasilLuasP)
        );
    }
}