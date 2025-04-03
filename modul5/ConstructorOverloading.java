// groupping modul5
package modul5;

// class mahasiswa
class Mhs {
    // attribute
    String nama;
    int nim;
    String jurusan;
    String fakultas;
    double ips;
    double ipk;

    // Constructor 1 lengkap semua attributenya
    public Mhs(String nama, int nim, String jurusan, String fakultas, double ips, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
        this.ips = ips;
        this.ipk = ipk;
    }

    // Constructor 2 attribute tidak ada
    public Mhs(String nama, int nim, String jurusan, String fakultas){
        this(nama,nim,jurusan,fakultas,0.0,0.0);
    }

    //method untuk nampilin identitas
    public void tampilkanIdentitas(){
        System.out.println("\n----------------------------");
        System.out.println("Identitas Mahasiswa:");
        System.out.println("Nama          : " + nama);
        System.out.println("NIM           : " + nim);
        System.out.println("Jurusan       : " + jurusan);
        System.out.println("Fakultas      : " + fakultas);
        System.out.println("IP Semester   : " + ips);
        System.out.println("IP Kumulatif  : " + ipk);
        System.out.println("----------------------------\n");
    }

}

//class utamanya
public class ConstructorOverloading {
    public static void main(String[] args) {
        // objek mahasiswa1 dengan semua attributenya ada
        Mhs mahasiswa1 = new Mhs(
            "Burhan", 
            24241001, 
            "teknik sastra mesin", 
            "Fakultas Teknik",
            2.9,
            1.9);

        // objek mahasiswa2 tanpa attribute ipk dan ips
        Mhs mahasiswa2 = new Mhs(
            "Mamang",
            25242001,
            "Teknik Gambar", 
            "Fakultas Seni");

        // buat manggil method
        mahasiswa1.tampilkanIdentitas();
        mahasiswa2.tampilkanIdentitas();
    }

}