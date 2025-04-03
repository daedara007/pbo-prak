// untuk groupping modul2
package modul2;

// untuk mengimport BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Class Lingkaran2
class Lingkaran2 {
    // attributenya
    double Jari;

    // Constructor
    public Lingkaran2(BufferedReader reader) throws IOException {
        // ini adalah input bufferedreadernya
        System.out.print("Masukkan jari-jari lingkarannya: ");
        Jari = Double.parseDouble(reader.readLine());
    }

    // ini adalah methodnya
    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }
}

// Class Trapesium2
class Trapesium2 {
    // attribute
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    // constructor
    public Trapesium2(BufferedReader reader) throws IOException {
        // Input bufferedreadernya
        System.out.print("Masukkan sisi atas: ");
        SisiAtas = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan sisi bawah: ");
        SisiBawah = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan tinggi: ");
        Tinggi = Double.parseDouble(reader.readLine());
    }

    // methodnya
    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah) / 2 * Tinggi);
    }
}

//class Prisma2
class Prisma2 {
    // attribbute
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    // constructor
    public Prisma2(BufferedReader reader) throws IOException {
        // adalah input bufferedreader nya
        System.out.print("Masukkan Luas Alas: ");
        LuasAlas = Double.parseDouble(reader.readLine());
        
        System.out.print("Masukkan Tinggi Segitiga: ");
        TinggiSegitiga = Double.parseDouble(reader.readLine());

        System.out.print("Masukkan Keliling Segitiga: ");
        KelilingSegitiga = Double.parseDouble(reader.readLine());
    }

    // ini adalah methodnya
    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

// class utamanya untuk membuat objek
public class BufferedReaderInput {
    public static void main(String[] args) throws IOException {
        // ini untuk membuat objek isr sebagai InputStreamReader
        InputStreamReader isr = new InputStreamReader(System.in);
        // ini untujk membuat objek reader sebagai BufferedReader
        BufferedReader reader = new BufferedReader(isr);

        // ini adalah objek Keliling untuk class lingkaran
        System.out.println("..::Hitung keliling lingkaran::..");
        Lingkaran2 Keliling = new Lingkaran2(reader);
        System.out.printf("Keliling lingkarannya adalah: %.3f%n%n", Keliling.HitungKelilingLingkaran());

        // ini adalah objek LuasT untuk class Trapesium
        System.out.println("..::Hitung Luas Trapesium::..");
        Trapesium2 LuasT = new Trapesium2(reader);
        System.out.printf("Luas trapesiumnya adalah: %.2f%n%n", LuasT.HitungLuasTrapesium());

        // ini adalah objek LuasP untuk class Prisma
        System.out.println("..::Hitung Luas Prisma::..");
        Prisma2 LuasP = new Prisma2(reader);
        System.out.printf("Luas prismanya adalah: %.2f%n", LuasP.HitungLuasPrisma());

        // untuk menutup objek reader
        reader.close();
    }
}