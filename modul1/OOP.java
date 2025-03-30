class Tabung1 {
    double jari;
    double tinggi;

    public Tabung1(double jari, double tinggi){
        this.jari = jari;
        this.tinggi = tinggi;
    }

    public double VolumeTabung() {
        return Math.PI * Math.pow(jari, 2) * tinggi;
    }
}

public class OOP {
    public static void main(String[] args) {
        Tabung1 v1 = new Tabung1(14,1);
        System.out.printf ("Volume tabungnya adalah %.3f%n",
        v1.VolumeTabung());
    }
}