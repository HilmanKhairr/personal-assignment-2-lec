package stackqueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrianKasir = new Queue();
        Stack riwayatTransaksi = new Stack();
        boolean running = true;

        while (running) {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            String inputPilihan = scanner.nextLine().trim();

            switch (inputPilihan) {
                case "1":
                    System.out.println("\n--- Tambah Antrian Pelanggan (Enqueue) ---");
                    
                    int jumlahPelanggan = 0;
                    int batasMinimal = (antrianKasir.getSize() < 5) ? (5 - antrianKasir.getSize()) : 1;

                    while (true) {
                        if (antrianKasir.getSize() < 5) {
                            System.out.print("Masukkan jumlah pelanggan yang ingin ditambahkan ke antrian (Minimal " + batasMinimal + " pelanggan): ");
                        } else {
                            System.out.print("Masukkan jumlah pelanggan yang ingin ditambahkan ke antrian: ");
                        }

                        String inputJumlah = scanner.nextLine().trim();
                        try {
                            jumlahPelanggan = Integer.parseInt(inputJumlah);
                            if (antrianKasir.getSize() < 5 && jumlahPelanggan < batasMinimal) {
                                System.out.println("Peringatan: Minimal " + batasMinimal + " pelanggan dalam antrian! Silakan ulangi.");
                            } else if (jumlahPelanggan <= 0) {
                                System.out.println("Jumlah pelanggan harus lebih dari 0! Silakan ulangi.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input tidak valid! Harap masukkan angka bulat yang benar.");
                        }
                    }

                    for (int i = 1; i <= jumlahPelanggan; i++) {
                        System.out.println("\n[Input Data Pelanggan ke-" + i + " dari " + jumlahPelanggan + "]");

                        String noAntrian = "";
                        while (true) {
                            System.out.print("Masukkan Nomor Antrian: ");
                            noAntrian = scanner.nextLine().trim();
                            if (noAntrian.isEmpty()) {
                                System.out.println("Nomor antrian tidak boleh kosong! Silakan ulangi.");
                            } else {
                                break;
                            }
                        }

                        String nama = "";
                        while (true) {
                            System.out.print("Masukkan Nama Pelanggan: ");
                            nama = scanner.nextLine().trim();
                            if (nama.isEmpty()) {
                                System.out.println("Nama pelanggan tidak boleh kosong! Silakan ulangi.");
                            } else {
                                break;
                            }
                        }

                        double total = 0;
                        while (true) {
                            System.out.print("Masukkan Total Belanja: ");
                            String strTotal = scanner.nextLine().trim();
                            try {
                                total = Double.parseDouble(strTotal);
                                if (total < 0) {
                                    System.out.println("Total belanja tidak boleh bernilai negatif! Silakan ulangi.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid! Harap masukkan angka nominal yang benar.");
                            }
                        }

                        antrianKasir.enqueue(noAntrian, nama, total);
                    }
                    break;

                case "2":
                    System.out.println("\n--- Layani Pelanggan (Dequeue & Push ke Stack) ---");
                    Node pelangganDilayani = antrianKasir.dequeue();
                    if (pelangganDilayani != null) {
                        System.out.println("Melayani pelanggan " + pelangganDilayani.nomorAntrian + " (" + pelangganDilayani.namaPelanggan + ")");
                        riwayatTransaksi.push(pelangganDilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    } else {
                        System.out.println("Tidak ada pelanggan dalam antrian untuk dilayani.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Antrian Pelanggan Saat Ini ---");
                    antrianKasir.tampilkanAntrian();
                    break;

                case "4":
                    System.out.println("\n--- Riwayat Transaksi Toko ---");
                    riwayatTransaksi.tampilkanRiwayat();
                    break;

                case "5":
                    System.out.println("\nTerima kasih telah menggunakan Sistem Kasir Toko!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1 - 5.");
                    break;
            }
        }

        scanner.close();
    }
}
