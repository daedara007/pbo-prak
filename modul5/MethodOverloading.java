// groupping modul5
package modul5;

// ini class mahasiswa
class Mahasiswa {
    // ini attribute
    private String nama;
    private String nim;
    private String jurusan;
    private String fakultas;

    // constructor
    public Mahasiswa(String nama, String nim, String jurusan, String fakultas) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    // method overloading 1 nampilin identitas mahasiswa
    public void TampilkanInfo() {
        System.out.println("=======================");
        System.out.println("Identitas Mahasiswa:");
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Fakultas: " + fakultas);
        System.out.println("=======================\n");
    }

    // method overloading 2 buat namipilin prestasi akademik
    public void TampilkanInfo(double ips, double ipk, String beasiswa){
        System.out.println("=======================");
        System.out.println("Prestasi Akademik:");
        System.out.println("Nama            : " + nama);
        System.out.println("IP Semester     : " + ips);
        System.out.println("IP Kumulatif    : " + ipk);
        System.out.println("Riwayat Beasiswa: " + beasiswa);
        System.out.println("=======================");
    }

}

// class utamanya
public class MethodOverloading {
    public static void main(String[] args) {
        // objek 1 dengan method overloading 1
        Mahasiswa mahasiswa1 = new Mahasiswa(
            "Udin",
            "232410150",
            "Teknik Hayalan",
            "Fakultas Dream"
        );
    
    // buat panggil method overloading 1
    mahasiswa1.TampilkanInfo();
    // method overloading 2
    mahasiswa1.TampilkanInfo(3.2,3.6,"Beasiswa gratispol");
    }
    
}
