package modul7;

// Class induknya
class BangunRuang {
    // method induknya mengembalikan nilai 0 sebagai defaultnya
    public double volume() {
        return 0.0;
    };
}

// SubClass Kubus
class Kubus extends BangunRuang {
    private double sisi;
    public Kubus(double sisi) {
        this.sisi = sisi;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return Math.pow(sisi, 3);
    }
}

// SubClass Balok
class Balok extends BangunRuang {
    private double panjang, lebar, tinggi;
    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar   = lebar;
        this.tinggi  = tinggi;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return panjang * lebar * tinggi;
    }
}

// SubClass Tabung
class Tabung extends BangunRuang {
    private double jari, tinggi;
    public Tabung(double jari, double tinggi) {
        this.jari   = jari;
        this.tinggi = tinggi;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return Math.PI * Math.pow(jari, 2) * tinggi;
    }
}

// SubClass Kerucut
class Kerucut extends BangunRuang {
    private double jari, tinggi;
    public Kerucut(double jari, double tinggi) {
        this.jari   = jari;
        this.tinggi = tinggi;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return (1.0/3.0) * Math.PI * jari * jari * tinggi;
    }
}

// SubClass Limas
class Limas extends BangunRuang {
    private double sisiAlas, tinggi;
    public Limas(double sisiAlas, double tinggi) {
        this.sisiAlas = sisiAlas;
        this.tinggi   = tinggi;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        double luasAlas = sisiAlas * sisiAlas;
        return (1.0/3.0) * luasAlas * tinggi;
    }
}

// SubClass prisma
class Prisma extends BangunRuang {
    private double LuasAlas, TinggiPrisma;
    public Prisma(double LuasAlas, double TinggiPrisma) {
        this.LuasAlas     = LuasAlas;
        this.TinggiPrisma = TinggiPrisma;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return LuasAlas * TinggiPrisma;
    }
}

// SubClass Bola
class Bola extends BangunRuang {
    private double jari;
    public Bola(double jari) {
        this.jari = jari;
    }
    // method yang diwarisi dari class induknya
    @Override
    public double volume() {
        return (4.0/3.0) * Math.PI * Math.pow(jari, 3);
    }
}

// Class utama
public class InheritanceClass {
    public static void main(String[] args) {
        // inisiasi objek masing masing class
        Kubus   kubus   = new Kubus(4);          // sisi = 4
        Balok   balok   = new Balok(2, 3, 4);    // p=2, l=3, t=4
        Tabung  tabung  = new Tabung(3, 5);      // r=3, t=5
        Kerucut kerucut = new Kerucut(3, 5);     // r=3, t=5
        Limas   limas   = new Limas(4, 6);       // sisi alas=4, tinggi=6 (limas segiempat)
        Prisma  prisma  = new Prisma(6, 10);     // luas alas=6, tinggi prisma=10
        Bola    bola    = new Bola(7);           // r=7

        // Tampilkan volume masing‑masing objek
        System.out.printf("Volume Kubus   = %.2f%n", kubus.volume());
        System.out.printf("Volume Balok   = %.2f%n", balok.volume());
        System.out.printf("Volume Tabung  = %.2f%n", tabung.volume());
        System.out.printf("Volume Kerucut = %.2f%n", kerucut.volume());
        System.out.printf("Volume Limas   = %.2f%n", limas.volume());
        System.out.printf("Volume Prisma  = %.2f%n", prisma.volume());
        System.out.printf("Volume Bola    = %.2f%n", bola.volume());
    }
}