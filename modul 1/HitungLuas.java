class Tabung {
    double Jari;
    double Tinggi;

    public Tabung(double Jari, double Tinggi) {
        this.Jari = Jari;
        this.Tinggi = Tinggi;
    }

    public double HitungLuasTabung(){
        return 2 * Math.PI * Jari * (Jari + Tinggi);
    }
    
}

class PersegiPanjang {
    double Panjang;
    double Lebar;

    public PersegiPanjang(double Panjang, double Lebar){
        this.Panjang = Panjang;
        this.Lebar = Lebar;
    }

    public double HitungLuasPersegiPanjang() {
        return Panjang * Lebar;
    }
}

class Trapesium {
    double Tinggi;
    double SisiAtas;
    double SisiBawah;

    public Trapesium(double Tinggi, double SisiAtas, double SisiBawah) {
        this.Tinggi = Tinggi;
        this.SisiAtas = SisiAtas;
        this.SisiBawah = SisiBawah;
    }

    public double HitungLuasTrapesium() {
        return ((SisiAtas + SisiBawah)/2 * Tinggi);
    }
}

public class HitungLuas {
    public static void main(String[] args) {
        Tabung T1 = new Tabung(14,1);
        System.out.printf("Luas Permukaan Tabungnya adalah: %.3f%n",
        T1.HitungLuasTabung());

        PersegiPanjang P1 = new PersegiPanjang(10, 5);
        System.out.printf ("Luas Persegi Panjangnya adalah: %.2f%n",
        P1.HitungLuasPersegiPanjang());

        Trapesium TR1 = new Trapesium(10, 5, 8);
        System.out.printf ("Luas Trapesiumnya adalah: %.2f",
        TR1.HitungLuasTrapesium());
    }
}