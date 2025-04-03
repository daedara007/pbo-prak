// ini adalah class tabung
class Tabung1 {
    // ini adalah attribute yang dibutuhkan untuk volume tabung
    double jari;
    double tinggi;

    // ini adalah constructornya
    public Tabung1(double jari, double tinggi){
        this.jari = jari;
        this.tinggi = tinggi;
    }

    // ini adalah method untuk menghitung volume tabung
    public double VolumeTabung() {
        return Math.PI * Math.pow(jari, 2) * tinggi;
    }
}

// ini adalah class utamanya
public class OOP {
    public static void main(String[] args) {
        // ini untuk membuat objek baru untuk tabung
        Tabung1 v1 = new Tabung1(14,1);
        // ini adalah hasil output dari objeknya
        System.out.printf ("Volume tabungnya adalah %.3f%n",
        v1.VolumeTabung());
    }
}