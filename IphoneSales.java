import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class iPhoneSales extends Sales {
    private List<String> salesItems;
    private List<Integer> idItems;

    public iPhoneSales() {
        salesItems = new ArrayList<>();
        idItems = new ArrayList<>();
    }

    public List<String> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<String> salesItems) {
        this.salesItems = salesItems;
    }

    public List<Integer> getIdItems() {
        return idItems;
    }

    public void setIdItems(List<Integer> idItems) {
        this.idItems = idItems;
    }

    @Override
    void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID penjualan: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Membersihkan new line
        } catch (InputMismatchException e) {
            System.out.println("ID harus berupa angka.");
            return;
        }

        if (idItems.contains(id)) {
            System.out.println("ID penjualan sudah ada.");
            return;
        }

        System.out.print("Masukkan nama iPhone yang dijual: ");
        String item = scanner.nextLine();

        idItems.add(id);
        salesItems.add(item);

        System.out.println("Penjualan iPhone berhasil ditambahkan.");
    }

    @Override
    void read() {
        if (salesItems.isEmpty()) {
            System.out.println("Tidak ada penjualan iPhone.");
        } else {
            System.out.println("===Daftar Penjualan iPhone:===");
            for (int i = 0; i < salesItems.size(); i++) {
                System.out.println("ID: " + idItems.get(i) + ".  " + salesItems.get(i));
            }
            System.out.println("==============================");
        }
    }

    @Override
    void update() {
        if (salesItems.isEmpty()) {
            System.out.println("Tidak ada penjualan iPhone untuk diperbarui.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan ID penjualan yang akan diperbarui: ");
            int currentId;
            try {
                currentId = scanner.nextInt();
                scanner.nextLine(); // Membersihkan new line
            } catch (InputMismatchException e) {
                System.out.println("ID harus berupa angka.");
                return;
            }

            int index = idItems.indexOf(currentId);

            if (index >= 0) {
                System.out.print("Masukkan nama iPhone yang baru: ");
                String newItem = scanner.nextLine();
                salesItems.set(index, newItem);
                System.out.println("Penjualan iPhone berhasil diperbarui.");
            } else {
                System.out.println("Penjualan iPhone tidak ditemukan.");
            }
        }
    }

    @Override
    void delete() {
        if (salesItems.isEmpty()) {
            System.out.println("Tidak ada penjualan iPhone untuk dihapus.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan ID penjualan iPhone yang akan dihapus: ");
            int itemId;
            try {
                itemId = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ID harus berupa angka.");
                return;
            }

            int index = idItems.indexOf(itemId);

            if (index >= 0) {
                int removedId = idItems.remove(index);
                String removedItem = salesItems.remove(index);
                System.out.println("Penjualan iPhone dengan ID " + removedId + " (" + removedItem + ") berhasil dihapus.");
            } else {
                System.out.println("Penjualan iPhone dengan ID tersebut tidak ditemukan.");
            }
        }
    }

    @Override
    void printNota() {
        if (salesItems.isEmpty()) {
            System.out.println("Tidak ada penjualan iPhone untuk dicetak nota.");
        } else {
            System.out.println("=== PENJUALAN IPHONE ===");
            for (int i = 0; i < salesItems.size(); i++) {
                System.out.println("ID: " + idItems.get(i) + ". Nama: " + salesItems.get(i));
            }
            System.out.println("========================");
        }
    }
}
