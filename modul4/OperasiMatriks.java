package modul4;

import java.util.Scanner;

public class OperasiMatriks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] x = new int[2][2];
        int[][] y = new int[2][2];
        
        // Input matriks X
        System.out.println("Masukkan elemen matriks X:");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print("Baris " + (i+1) + ", Kolom " + (j+1) + ": ");
                x[i][j] = scanner.nextInt();
            }
        }
        
        // Input matriks Y
        System.out.println("\nMasukkan elemen matriks Y:");
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print("Baris " + (i+1) + ", Kolom " + (j+1) + ": ");
                y[i][j] = scanner.nextInt();
            }
        }
        
        // Menu operasi
        System.out.println("\nPilih operasi:");
        System.out.println("1. Perkalian");
        System.out.println("2. Pengurangan");
        System.out.print("Masukkan pilihan (1/2): ");
        int choice = scanner.nextInt();
        
        switch(choice) {
            case 1:
                multiplyMatrices(x, y);
                break;
            case 2:
                subtractMatrices(x, y);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
        scanner.close();
    }
    
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
    
    private static void subtractMatrices(int[][] x, int[][] y) {
        int[][] result = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                result[i][j] = x[i][j] - y[i][j];
            }
        }
        printResult(result);
    }
    
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