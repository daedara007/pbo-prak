package modul2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Lingkaran2 {
    double Jari;

    public Lingkaran2(BufferedReader reader) throws IOException {
        System.out.print("Masukkan jari-jari lingkarannya: ");
        Jari = Double.parseDouble(reader.readLine());
    }

    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }
}

class Trapesium2 {
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    public Trapesium2(BufferedReader reader) throws IOException {
        System.out.print("Masukkan sisi atas: ");
        SisiAtas = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan sisi bawah: ");
        SisiBawah = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan tinggi: ");
        Tinggi = Double.parseDouble(reader.readLine());
    }

    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah) / 2 * Tinggi);
    }
}

class Prisma2 {
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    public Prisma2(BufferedReader reader) throws IOException {
        System.out.print("Masukkan Luas Alas: ");
        LuasAlas = Double.parseDouble(reader.readLine());
        
        System.out.print("Masukkan Tinggi Segitiga: ");
        TinggiSegitiga = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan Keliling Segitiga: ");
        KelilingSegitiga = Double.parseDouble(reader.readLine());
    }

    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

public class BufferedReaderInput {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        System.out.println("..::Hitung keliling lingkaran::..");
        Lingkaran2 Keliling = new Lingkaran2(reader);
        System.out.printf("Keliling lingkarannya adalah: %.3f%n%n", Keliling.HitungKelilingLingkaran());

        System.out.println("..::Hitung Luas Trapesium::..");
        Trapesium2 LuasT = new Trapesium2(reader);
        System.out.printf("Luas trapesiumnya adalah: %.2f%n%n", LuasT.HitungLuasTrapesium());

        System.out.println("..::Hitung Luas Prisma::..");
        Prisma2 LuasP = new Prisma2(reader);
        System.out.printf("Luas prismanya adalah: %.2f%n", LuasP.HitungLuasPrisma());

        reader.close();
    }
}