package org.example;

import java.util.Scanner;


/**Kelas utama untuk menangani login dan alur program utama.
 * <ul>Refactoring yang dilakukan:
 *  <li>Menghapus kode terkait menu dan pemesanan yang sebelumnya ada di kelas ini, dan memindahkannya ke kelas `Menu` dan `Order` (Move Class).
 *  <li>Mengganti langsung pengecekan password dan username tanpa variabel perantara (Inline Variabel).
 */

public class Main {
    private static String username = "admin";
    private static String password = "123";

    /**Refactoring:
     * <li> Menghapus variabel perantara dan langsung mengecek input pengguna (Inline Variable).
     * <li> Menu dan Order dipisahkan ke kelas berbeda (Move Class).
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil!");

            Menu menu = new Menu();
            Order order = new Order();

            menu.showMenu(scanner, order);
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}
