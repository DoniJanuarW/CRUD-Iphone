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

    //Revisi Menambah Method overloading untuk create() yang menerima ID dan nama item sebagai parameter
    public void create(int id, String item) {
        if (idItems.contains(id)) {
            System.out.println("ID penjualan sudah ada.");
            return;
        }

        idItems.add(id);
        salesItems.add(item);

        System.out.println("Penjualan iPhone berhasil ditambahkan.");
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

        System.out.print("Masukkan nama iPhone yang dijual: ");
        String item = scanner.nextLine();

        create(id, item); // Memanggil create() yang di-overload dengan memberikan nilai ID dan nama item dari input pengguna
    }

    // ... Metode lainnya ...

}
