// langsung class utama
public class Prosedural {
    public static void main(String[] args) {
        // ini adalah attribute untuk volume tabung
        double jari = 14;
        double tinggi = 1;

        // dan bagian ini tanpa membuat objek langsung menghitung volume tabung
        double volume = Math.PI * Math.pow(jari, 2) * tinggi;
        // output dari perhitungan di baris sebelumnya
        System.out.printf("Volume tabungnya adalah %.3f%n",
        volume);
    }
    
}
