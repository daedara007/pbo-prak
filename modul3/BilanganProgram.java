// groupping modul3
package modul3;

// untuk import scanner
import java.util.Scanner;

// class utamanya
public class BilanganProgram {
    public static void main(String[] args) {
        // untuk membuat objek input dari scanner
        Scanner input = new Scanner(System.in);
        
        // menampilkan pesan pilihan operasi
        System.out.println("Pilih operasi:");
        System.out.println("a. Cari bilangan prima 1-1000");
        System.out.println("b. Cari bilangan ganjil/genap 1-1000");
        System.out.print("Masukkan pilihan (a/b): ");
        // untuk menerima input dan membuat hasil input menjadi huruf kecil
        char choice = input.next().toLowerCase().charAt(0);

        // menampilkan pesan pilihan jenis loop
        System.out.println("\nPilih jenis loop:");
        System.out.println("1. For-loop");
        System.out.println("2. While-loop");
        System.out.println("3. Do-while-loop");
        System.out.print("Masukkan pilihan (1/2/3): ");
        // untuk menerima input
        int loopType = input.nextInt();

        System.out.println();

        // percabangan jika memilih operasi bilangan prima
        if(choice == 'a') {
            // jika memilih for
            if(loopType == 1) printPrimaFor();
            // jika memilih while
            else if(loopType == 2) printPrimaWhile();
            // jika memilih dowhile
            else if(loopType == 3) printPrimaDoWhile();
            // ini jika input tidak valid
            else System.out.println("Pilihan loop tidak valid");
        } 
        // percabangan jika memilih operasi ganjil dan genap
        else if(choice == 'b') {
            // jika memilih for
            if(loopType == 1) printGanjilGenapFor();
            // jika memilih while
            else if(loopType == 2) printGanjilGenapWhile();
            // jika memililh dowhile
            else if(loopType == 3) printGanjilGenapDoWhile();
            // jika input tidak valid
            else System.out.println("Pilihan loop tidak valid");
        } 
        // jika pilihan operasi tidak valid
        else {
            System.out.println("Pilihan operasi tidak valid");
        }
        
        // berfungsi untuk menutup input
        input.close();
    }

    // Fungsi untuk bilangan prima dengan for-loop
    static void printPrimaFor() {
        System.out.println("Bilangan prima (for-loop):");
        for(int n = 2; n <= 1000; n++) {
            boolean isPrime = true;
            for(int i = 2; i * i <= n; i++) {
                if(n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) System.out.print(n + " ");
        }
    }

    // Fungsi untuk bilangan prima dengan while-loop
    static void printPrimaWhile() {
        System.out.println("Bilangan prima (while-loop):");
        int n = 2;
        while(n <= 1000) {
            boolean isPrime = true;
            int i = 2;
            while(i * i <= n) {
                if(n % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
            if(isPrime) System.out.print(n + " ");
            n++;
        }
    }

    // Fungsi untuk bilangan prima dengan do-while-loop
    static void printPrimaDoWhile() {
        System.out.println("Bilangan prima (do-while-loop):");
        int n = 2;
        do {
            boolean isPrime = true;
            int i = 2;
            do {
                if(i > 1 && i * i <= n && n % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            } while(i * i <= n);
            if(isPrime) System.out.print(n + " ");
            n++;
        } while(n <= 1000);
    }

    // Fungsi untuk ganjil/genap dengan for-loop
    static void printGanjilGenapFor() {
        System.out.println("Bilangan ganjil (for-loop):");
        for(int i = 1; i <= 1000; i += 2) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n\nBilangan genap (for-loop):");
        for(int i = 2; i <= 1000; i += 2) {
            System.out.print(i + " ");
        }
    }

    // Fungsi untuk ganjil/genap dengan while-loop
    static void printGanjilGenapWhile() {
        System.out.println("Bilangan ganjil (while-loop):");
        int i = 1;
        while(i <= 1000) {
            System.out.print(i + " ");
            i += 2;
        }
        
        System.out.println("\n\nBilangan genap (while-loop):");
        i = 2;
        while(i <= 1000) {
            System.out.print(i + " ");
            i += 2;
        }
    }

    // Fungsi untuk ganjil/genap dengan do-while-loop
    static void printGanjilGenapDoWhile() {
        System.out.println("Bilangan ganjil (do-while-loop):");
        int i = 1;
        do {
            System.out.print(i + " ");
            i += 2;
        } while(i <= 1000);
        
        System.out.println("\n\nBilangan genap (do-while-loop):");
        i = 2;
        do {
            System.out.print(i + " ");
            i += 2;
        } while(i <= 1000);
    }
}