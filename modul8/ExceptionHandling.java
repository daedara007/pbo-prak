package modul8;

public class ExceptionHandling {
    public static void main(String[] args) {
        // ArithmeticException
        try {
            int a = 10;
            int b = 0;
            System.out.println("Hasil pembagian: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException tertangkap: " + e.getMessage());
        }

        System.out.println(); // separator

        // IndexOutOfBoundsException
        int[] angka = {1, 2, 3};
        try {
            // Mencoba akses indeks ke-5, padahal array hanya punya 3 elemen (0..2)
            System.out.println("Elemen ke-5: " + angka[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException tertangkap: " + e.getMessage());
        }
    }
}
