// Ini adalah class untuk tabung
class Tabung {
    // Ini adalah attribute tabung
    double Jari;
    double Tinggi;

    // Ini adalah Constructor tabung
    public Tabung(double Jari, double Tinggi) {
        this.Jari = Jari;
        this.Tinggi = Tinggi;
    }

    // Ini adalah method untuk perhitungan luas tabung
    public double HitungLuasTabung(){
        return 2 * Math.PI * Jari * (Jari + Tinggi);
    }
    
}

// ini adalah class persegi panjang
class PersegiPanjang {
    // ini adalah attribute persegi panjang
    double Panjang;
    double Lebar;

    // ini adalah constructor persegi panjang
    public PersegiPanjang(double Panjang, double Lebar){
        this.Panjang = Panjang;
        this.Lebar = Lebar;
    }

    // ini adalah method untuk perhitungan luas persegi panjang
    public double HitungLuasPersegiPanjang() {
        return Panjang * Lebar;
    }
}

// ini adalah class trapesium
class Trapesium {
    // ini adalah attribute trapesium
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    // ini adalah constructor trapesium
    public Trapesium(double Tinggi, double SisiAtas, double SisiBawah) {
        this.Tinggi = Tinggi;
        this.SisiAtas = SisiAtas;
        this.SisiBawah = SisiBawah;
    }

    // ini adalah method untuk perhitungan luas trapesium
    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah)/2 * Tinggi);
    }
}

// ini adalah class utamanya
public class HitungLuas {
    public static void main(String[] args) {
        // ini untuk membuat objek baru untuk menghitung luas tabung
        Tabung T1 = new Tabung(14,1);
        // ini adalah hasil output dari objeknya
        System.out.printf("Luas Permukaan Tabungnya adalah: %.3f%n",
        T1.HitungLuasTabung());

        // ini untuk membuat objek baru untuk menghitung luas persegi panjang
        PersegiPanjang P1 = new PersegiPanjang(10, 5);
        // ini adalah hasil output dari objeknya
        System.out.printf ("Luas Persegi Panjangnya adalah: %.2f%n",
        P1.HitungLuasPersegiPanjang());

        // ini untuk membuat objek baru untuk menghitung luas trapesium
        Trapesium TR1 = new Trapesium(10, 5, 8);
        // adalah hasil output dari objeknya
        System.out.printf ("Luas Trapesiumnya adalah: %.2f%n",
        TR1.HitungLuasTrapesium());
    }
}