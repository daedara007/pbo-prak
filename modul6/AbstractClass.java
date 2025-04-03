// groupping modul6
package modul6;

// ini adalah abstract class RuangTigaDimensi dan akan digunakan oleh class lain
abstract class GeometriTigaDimensi {
    // ini method abstract untuk hitung volume dan akan digunakan oleh class lain
    abstract double volume();
}

// class balok yang mewarisi class GeometriTigaDimensi 
class Balok extends GeometriTigaDimensi {
    // attribute
    double panjang;
    double lebar;
    double tinggi;

    // Constructornya
    public Balok(double panjang, double lebar, double tinggi){
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Ini adalah method dari class GeometriTigaDimensi
    @Override
    double volume(){
        return panjang * lebar * tinggi;
    }
}

// Class bola yang mewarisi class GeometriTigaDimensi
class Bola extends GeometriTigaDimensi {
    // Attribute
    double jari;

    // Constructor
    public Bola (double jari){
        this.jari = jari;
    }

    // Ini adalah method dari class GeometriTigaDimensi
    @Override
    double volume(){
        return (4.0 / 3.0) * Math.PI * Math.pow(jari, 3);
    }
}

// Class utamanya
public class AbstractClass {
    public static void main(String[] args) {
        // Ini objek VBalok dari class Balok
        Balok VBalok = new Balok(10, 20, 30);

        // ini Objek VBola dari class Bola
        Bola VBola = new Bola(14);

        // output objek VBalok
        System.out.printf("%nVolume Baloknya adalah %.2f%n",
        VBalok.volume());

        // Output objek VBola
        System.out.printf("Volume Bolanya adalah %.2f%n",
        VBola.volume());
    }
}
