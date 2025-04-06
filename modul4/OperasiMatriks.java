// groupping modul4
package modul4;

// untuk import scanner
import java.util.Scanner;

// class utamanya
public class OperasiMatriks {
    public static void main(String[] args) {
        // objek scanner sebagai input matriks
        Scanner scanner = new Scanner(System.in);
        // deklarasi matriksnya
        int[][] x = new int[2][2];
        int[][] y = new int[2][2];
        
        // untuk input matriks X
        System.out.println("Masukkan elemen matriks X:");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print("Baris " + (i+1) + ", Kolom " + (j+1) + ": ");
                x[i][j] = scanner.nextInt();
            }
        }
        
        // untuk input matriks Y
        System.out.println("\nMasukkan elemen matriks Y:");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print("Baris " + (i+1) + ", Kolom " + (j+1) + ": ");
                y[i][j] = scanner.nextInt();
            }
        }
        
        // Pilihan operasi matriks yanng mau dipilih
        System.out.println("\nPilih operasi:");
        System.out.println("1. Perkalian");
        System.out.println("2. Pengurangan");
        System.out.print("Masukkan pilihan (1/2): ");
        int choice = scanner.nextInt();
        
        // switch case untuk pilihan sebelumnya
        switch(choice) {
            // jika memilih perkalian
            case 1:
                multiplyMatrices(x, y);
                break;
            // jika memilih pengurangan
            case 2:
                subtractMatrices(x, y);
                break;
            // jika pilihan tidak valid
            default:
                System.out.println("Pilihan tidak valid!");
        }
        // objek scanner di close karena tidak digunakan lagi
        scanner.close();
    }
    
    // method untuk perkalian matriks
    private static void multiplyMatrices(int[][] x, int[][] y) {
        int[][] result = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for(int k = 0; k < 2; k++) {
                    result[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        printResult(result);
    }
    
    // method untuk pengurangan matriks
    private static void subtractMatrices(int[][] x, int[][] y) {
        int[][] result = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                result[i][j] = x[i][j] - y[i][j];
            }
        }
        printResult(result);
    }
    
    // method untuk menampilkan hasil operasi matriks
    private static void printResult(int[][] result) {
        System.out.println("\nHasil operasi:");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}