// groupping modul7
package modul7;

// Class induknya
class AlatMusik {
    protected String nama;
    protected String jenis;

    // Constructor classnya
    public AlatMusik(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    // Method yang akan di‑override oleh subclass
    public void tampilkanJenis(){
        System.out.println("Cek alat musiknya");
    }
}

// Subclass untuk setiap jenis alat musik
// Subclass Piano
class Piano extends AlatMusik {
    public Piano() {
        super("Piano", "Senar, Perkusi, dan harmonis");
    }

    // methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Subclass Biola
class Biola extends AlatMusik {
    public Biola() {
        super("Biola", "Senar, Melodis");
    }

    // Methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Subclass Gitar
class Gitar extends AlatMusik {
    public Gitar() {
        super("Gitar", "Senar, Melodis");
    }

    // Methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Subclass Drum
class Drum extends AlatMusik {
    public Drum() {
        super("Drum", "Perkusi");
    }

    // Methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Subclass Saxophone
class Saxophone extends AlatMusik {
    public Saxophone() {
        super("Saxophone", "Tiup, Melodis");
    }

    // Methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Subclass Trumpet
class Trumpet extends AlatMusik {
    public Trumpet() {
        super("Trumpet","Tiup");
    }

    // Methodnya
    @Override
    public void tampilkanJenis() {
        System.out.println("Alat musik: " + nama);
        System.out.println("Jenis alat musik: " + jenis);
        System.out.println();
    }
}

// Kelas utama untuk jalanin polymorphism
public class Polymorphism {
    public static void main(String[] args) {
        AlatMusik[] daftarAlat = {
            new Piano(),
            new Biola(),
            new Gitar(),
            new Drum(),
            new Saxophone(),
            new Trumpet()
        };

        for (AlatMusik alat : daftarAlat) {
            alat.tampilkanJenis(); // Polimorfisme terjadi di sini
        }
    }
}