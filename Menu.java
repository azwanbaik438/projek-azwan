package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**Kelas yang menangani manajemen menu dan harga.
 * <p>
 * Refactoring yang dilakukan:
 * <ul>
 *  <li>Menghapus kode terkait proses pemesanan dari kelas `Main` dan memindahkannya ke kelas ini (Move Class).
 *  <li>Menambahkan metode `addMenuItems()`, `displayMenu()`, dan `showMenu()` untuk memecah fungsionalitas menjadi lebih modular (Extract Method).
 *  <li>Mengeluarkan beberapa ekspresi yang berulang ke variabel yang lebih deskriptif untuk membuat kode lebih mudah dibaca (Extract Variable).
 */

public class Menu {
    private ArrayList<String> menuItems = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();

    /** Refactoring: Item menu dipisah ke dalam metode addMenuItems() (Extract Method)
    */
    public Menu() {
        addMenuItems();
    }

    /** Refactoring: Memecah kode penambahan item ke metode terpisah (Extract Method).
     */
    private void addMenuItems() {
        menuItems.add("Nasi Goreng");
        menuItems.add("Mie Rebus");
        menuItems.add("Teh Manis");
        prices.add(15000);
        prices.add(12000);
        prices.add(5000);
    }

    /**Menampilkan daftar menu dan menangani proses pemesanan.
     * <p>Refactoring:
     * <li>Extract Method: Memindahkan fungsionalitas menampilkan menu dan pemrosesan pesanan.
     * <li>Extract Variable: Memperjelas ekspresi yang kompleks dengan variabel yang deskriptif.
     * @param scanner Scanner untuk input pengguna
     * @param order   Objek Order untuk memproses pesanan
     */
    public void showMenu(Scanner scanner, Order order) {
        boolean isOrdering = true;

        while (isOrdering) {
            displayMenu();
            System.out.print("\nPilih nomor menu (0 untuk selesai): ");
            int choice = scanner.nextInt();
            isOrdering = order.processOrder(choice, menuItems, prices);
        }

        order.showOrderSummary();  // Menampilkan ringkasan pesanan setelah selesai
    }

    /** Refactoring: Memecah kode yang menampilkan menu ke metode terpisah (Extract Method).
     */
    private void displayMenu() {
        System.out.println("\nMenu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i) + " - Rp " + prices.get(i));
        }
    }
}
