class tabung {
    public double jari;
    public double tinggi; 

    public tabung(double jari,double tinggi) {
        this.jari = jari;
        this.tinggi = tinggi;
    }
    public static double hitungluas(double jari, double tinggi) {
        return 2*Math.PI*jari*(jari+tinggi);
    }
}

public class main {
    public static void main(String[] args) {
        System.out.println("Luas tabungnya adalah "+new tabung(10,20));
    }
}