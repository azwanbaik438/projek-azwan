package org.example;

import java.util.ArrayList;

/**Kelas yang menangani proses pemesanan dan perhitungan total harga.
 * <p>Refactoring yang dilakukan:
 * <ul>
 * <li>Fungsi terkait pemesanan dipindahkan dari kelas `Main` ke kelas ini (Move Class).
 * <li>Proses order dipisahkan menjadi beberapa metode seperti `processOrder()` dan `showOrderSummary()` (Extract Method).
 * <li>Penghapusan metode yang hanya digunakan sekali dan dapat di-inline ke dalam pemanggilan (Inline Method).
 */

public class Order {
    private ArrayList<String> orderedItems = new ArrayList<>();
    private int totalPrice = 0;

    /**Memproses pesanan berdasarkan pilihan pengguna.
     * <p>Refactoring:
     * <li>Kode pemrosesan pesanan dipindahkan dari `Main`(Move Class).
     * <li>Metode `processOrder()` dibuat untuk memecah fungsionalitas(Extract Method).
     * @param choice     Nomor pilihan menu yang dipilih pengguna
     * @param menuItems  Daftar item pada menu
     * @param prices     Daftar harga sesuai menu
     * @return true jika masih memesan, false jika pemesanan selesai
     */
    public boolean processOrder(int choice, ArrayList<String> menuItems, ArrayList<Integer> prices) {
        if (choice == 0) {
            return false; // Menghentikan pemesanan
        } else if (choice > 0 && choice <= menuItems.size()) {
            String orderedItem = menuItems.get(choice - 1);
            orderedItems.add(orderedItem);
            totalPrice += prices.get(choice - 1);
            System.out.println(orderedItem + " telah ditambahkan ke pesanan.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        return true;
    }
    /**Menampilkan ringkasan pesanan dan total harga.
     * <p>Refactoring:
     * <li>Fungsi ini dipisahkan dari kode pemesanan untuk modularitas yang lebih baik(Extract Method).
     */
    public void showOrderSummary() {
        System.out.println("\nRingkasan Pesanan:");
        for (String item : orderedItems) {
            System.out.println("- " + item);
        }
        System.out.println("Total harga: Rp " + totalPrice);
    }
}
