// groupping modul6
package modul6;

// Kelas Biodata dengan atribut privat
class Biodata {
    private String nama;
    private String nim;
    private String jurusan;
    private String fakultas;
    private String universitas;
    private String alamat;
    private String email;
    private String pekerjaan;
    private String hobi;
    private String keahlian;
    private String karya;

    // Konstruktor untuk menginisialisasi biodata
    public Biodata(String nama, String nim, String jurusan, String fakultas,
                   String universitas, String alamat, String email, String pekerjaan,
                   String hobi, String keahlian, String karya) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
        this.universitas = universitas;
        this.alamat = alamat;
        this.email = email;
        this.pekerjaan = pekerjaan;
        this.hobi = hobi;
        this.keahlian = keahlian;
        this.karya = karya;
    }

    // Getter dan Setter untuk masing-masing atribut
    // gettter untuk nama
    public String getNama() {
        return nama;
    }
    // setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // getter untuk nim
    public String getNim() {
        return nim;
    }
    // setter untuk nim
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    //getter untuk jurusan
    public String getJurusan() {
        return jurusan;
    }
    //setter untuk jurusan
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    // getter untuk fakultas
    public String getFakultas() {
        return fakultas;
    }
    // setter untuk fakultas
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    

    // getter untuk universitas
    public String getUniversitas() {
        return universitas;
    }
    // setter untuk universitas
    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }
    

    // getter untuk alamat
    public String getAlamat() {
        return alamat;
    }
    // setter untuk alamat
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    // getter untuk email
    public String getEmail() {
        return email;
    }
    // setter untuk email
    public void setEmail(String email) {
        this.email = email;
    }
    
    // getter untuk pekerjaan
    public String getPekerjaan() {
        return pekerjaan;
    }
    // setter untuk pekerjaan
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    
    // getter untuk hobi
    public String getHobi() {
        return hobi;
    }
    // setter untuk hobi
    public void setHobi(String hobi) {
        this.hobi = hobi;
    }
    
    // getter untuk keahlian
    public String getKeahlian() {
        return keahlian;
    }
    // setter untuk keahlian
    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }
    

    // getter untu karya
    public String getKarya() {
        return karya;
    }
    // setter untuk karya
    public void setKarya(String karya) {
        this.karya = karya;
    }

    // Metode untuk menampilkan biodata
    public void tampilkanBiodata() {
        System.out.println("Nama         : " + getNama());
        System.out.println("NIM          : " + getNim());
        System.out.println("Jurusan      : " + getJurusan());
        System.out.println("Fakultas     : " + getFakultas());
        System.out.println("Universitas  : " + getUniversitas());
        System.out.println("Alamat       : " + getAlamat());
        System.out.println("Email        : " + getEmail());
        System.out.println("Pekerjaan    : " + getPekerjaan());
        System.out.println("Hobi         : " + getHobi());
        System.out.println("Keahlian     : " + getKeahlian());
        System.out.println("Karya        : " + getKarya());
    }
}

// Class utamanya
public class EncapsulationClass {
    public static void main(String[] args) {
        // Membuat objek Biodata dengan data saya
        Biodata biodataSaya = new Biodata(
            "Kevin Jonathan Wijaya",
            "11241040",
            "Informatika",
            "FSTI",
            "Institut Teknologi Kalimantan",
            "Jl pattimura no 62 rt 48",
            "11241040@student.itk.ac.id",
            "Mahasiswa",
            "Game, Musik",
            "Computer Network, DevOps",
            "None"
        );

        // Menampilkan biodata
        biodataSaya.tampilkanBiodata();
    }
}
