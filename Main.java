import java.util.Scanner;
import iPhoneSales;
public class Main {
    public static void main(String[] args) {
        // Class & Object - Membuat objek iPhoneSales
        iPhoneSales sales = new iPhoneSales();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Penjualan iPhone");
            System.out.println("2. Lihat Penjualan iPhone");
            System.out.println("3. Perbarui Penjualan iPhone");
            System.out.println("4. Hapus Penjualan iPhone");
            System.out.println("5. Cetak Penjualan iPhone");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sales.create(); // Memanggil method create() pada objek sales
                    break;
                case 2:
                    sales.read(); // Memanggil method read() pada objek sales
                    break;
                case 3:
                    sales.update(); // Memanggil method update() pada objek sales
                    break;
                case 4:
                    sales.delete(); // Memanggil method delete() pada objek sales
                    break;
                case 5:
                    sales.printNota(); // Memanggil method printNota() pada objek sales
                    break;
                case 6:
                    isRunning = false; // Menghentikan program
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Terima kasih telah menggunakan program CRUD penjualan iPhone.");
    }
}
