package modul2;

import java.util.Scanner;

class Lingkaran1 {
    double Jari;

    public Lingkaran1(Scanner input) {
        System.out.print("Masukkan jari-jari lingkarannya: ");
        Jari = input.nextDouble();
    }

    public double HitungKelilingLingkaran() {
        return 2 * Math.PI * Jari;
    }

}

class Trapesium1 {
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    public Trapesium1(Scanner input) {
        System.out.print("Masukkan sisi atas: ");
        SisiAtas = input.nextDouble();

        System.out.print ("Masukkan sisi bawah: ");
        SisiBawah = input.nextDouble();

        System.out.print ("Masukkan tinggi: ");
        Tinggi = input.nextDouble();
    }

    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah)/2 * Tinggi);
    }
}

class Prisma1{
    double LuasAlas;
    double TinggiSegitiga;
    double KelilingSegitiga;

    public Prisma1(Scanner input) {
        System.out.print("Masukkan Luas Alas: ");
        LuasAlas = input.nextDouble();
        
        System.out.print("Masukkan Tinggi Segitiga: ");
        TinggiSegitiga = input.nextDouble();

        System.out.print("Masukkan Keliling Segitiga: ");
        KelilingSegitiga = input.nextDouble();
    }

    public double HitungLuasPrisma() {
        return 2 * LuasAlas + TinggiSegitiga * KelilingSegitiga;
    }
}

public class ScannerInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("..::Hitung keliling lingkaran::..");
        Lingkaran1 Keliling = new Lingkaran1(input);
        System.out.printf("Keliling lingkarannya adalah: %.3f%n%n",
        Keliling.HitungKelilingLingkaran());

        System.out.println("..::Hitung Luas Trapesium::..");
        Trapesium1 LuasT = new Trapesium1(input);
        System.out.printf("Luas trapesiumnya adalah: %.2f%n%n",
        LuasT.HitungLuasTrapesium());

        System.out.println("..::Hitung Luas Prisma::..");
        Prisma1 LuasP = new Prisma1(input);
        System.out.printf("Luas prismanya adalah: %.2f%n",
        LuasP.HitungLuasPrisma());

        input.close();

    }
}