// untuk groupping modul2
package modul2;

// untuk mengimport scanner
import java.util.Scanner;

// class Lingkaran1
class Lingkaran1 {
    // attribute class Lingkaran1
    double Jari;

    // ini adalah constructor
    public Lingkaran1(Scanner input) {
        // untuk memberi pesan saat input
        System.out.print("Masukkan jari-jari lingkarannya: ");
        // ini adalah input scannernya
        Jari = input.nextDouble();
    }

    // ini adalah methodnya
    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }

}

// ini adalah class Trapesium1
class Trapesium1 {
    //ini adalah attributenya
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    // ini adalah constructornya
    public Trapesium1(Scanner input) {
        // ini adalah bagian input scannernya
        System.out.print("Masukkan sisi atas: ");
        SisiAtas = input.nextDouble();

        // ini adalah bagian input scannernya
        System.out.print ("Masukkan sisi bawah: ");
        SisiBawah = input.nextDouble();

        // ini adalah bagian input scannernya
        System.out.print ("Masukkan tinggi: ");
        Tinggi = input.nextDouble();
    }

    // ini adalah methodnya
    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah)/2 * Tinggi);
    }
}

// ini adalah class Prisma1
class Prisma1{
    // ini adalah attributenya
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    // ini adalah constructornya
    public Prisma1(Scanner input) {
        // ini adalah bagian inputnya
        System.out.print("Masukkan Luas Alas: ");
        LuasAlas = input.nextDouble();
        
        System.out.print("Masukkan Tinggi Segitiga: ");
        TinggiSegitiga = input.nextDouble();

        System.out.print("Masukkan Keliling Segitiga: ");
        KelilingSegitiga = input.nextDouble();
    }

    // ini adalah methodnya
    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

// ini adalah class utamanya
public class ScannerInput {
    public static void main(String[] args) {
        // ini berfungsi untuk membuat objek input yang berfungsi untuk membaca hasil input
        Scanner input = new Scanner(System.in);

        // ini adalah objek Keleling untuk menghitung keliling lingkaran
        System.out.println("..::Hitung keliling lingkaran::..");
        Lingkaran1 Keliling = new Lingkaran1(input);
        System.out.printf("Keliling lingkarannya adalah: %.3f%n%n",
        Keliling.HitungKelilingLingkaran());

        // ini adalah objek LuasT untuk menghitung keliling lingkaran
        System.out.println("..::Hitung Luas Trapesium::..");
        Trapesium1 LuasT = new Trapesium1(input);
        System.out.printf("Luas trapesiumnya adalah: %.2f%n%n",
        LuasT.HitungLuasTrapesium());

        // ini adalah objek LuasP untuk menghitung luas prisma
        System.out.println("..::Hitung Luas Prisma::..");
        Prisma1 LuasP = new Prisma1(input);
        System.out.printf("Luas prismanya adalah: %.2f%n",
        LuasP.HitungLuasPrisma());

        // Berfungsi untuk menutup objek input
        input.close();

    }
}