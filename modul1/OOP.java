class Tabung {
    double jari;
    double tinggi;

    public Tabung (double jari, double tinggi){
        this.jari = jari;
        this.tinggi = tinggi;
    }

    public double HitungVolumeTabung() {
        return Math.PI * jari * jari * tinggi;
    }
}

public class OOP {
    public static void main(String[] args) {
        Tabung v1 = new Tabung(14,1);
        System.out.printf ("Volume tabungnya adalah %.3f%n",
        v1.HitungVolumeTabung());
    }
}