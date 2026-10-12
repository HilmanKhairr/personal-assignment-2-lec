package linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList perpustakaan = new LinkedList();
        boolean running = true;

        while (running) {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            String inputPilihan = scanner.nextLine().trim();

            switch (inputPilihan) {
                case "1":
                    System.out.println("\n--- Tambah Buku ---");
                    
                    int jumlahBuku = 0;
                    int batasMinimal = (perpustakaan.getCount() < 5) ? (5 - perpustakaan.getCount()) : 1;

                    while (true) {
                        if (perpustakaan.getCount() < 5) {
                            System.out.print("Masukkan jumlah buku yang ingin ditambahkan (Minimal " + batasMinimal + " buku): ");
                        } else {
                            System.out.print("Masukkan jumlah buku yang ingin ditambahkan: ");
                        }

                        String inputJumlah = scanner.nextLine().trim();
                        try {
                            jumlahBuku = Integer.parseInt(inputJumlah);
                            if (perpustakaan.getCount() < 5 && jumlahBuku < batasMinimal) {
                                System.out.println("Peringatan: Jumlah data minimal " + batasMinimal + " buku! Silakan ulangi.");
                            } else if (jumlahBuku <= 0) {
                                System.out.println("Jumlah buku harus lebih dari 0! Silakan ulangi.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input tidak valid! Harap masukkan angka bulat yang benar.");
                        }
                    }

                    for (int i = 1; i <= jumlahBuku; i++) {
                        System.out.println("\n[Input Data Buku ke-" + i + " dari " + jumlahBuku + "]");

                        String kode = "";
                        while (true) {
                            System.out.print("Masukkan Kode Buku: ");
                            kode = scanner.nextLine().trim();
                            if (kode.isEmpty()) {
                                System.out.println("Kode buku tidak boleh kosong! Silakan ulangi.");
                            } else if (kode.length() > 5) {
                                System.out.println("Peringatan: Kode buku maksimal 5 karakter! Silakan ulangi.");
                            } else {
                                break;
                            }
                        }

                        String judul = "";
                        while (true) {
                            System.out.print("Masukkan Judul: ");
                            judul = scanner.nextLine().trim();
                            if (judul.isEmpty()) {
                                System.out.println("Judul buku tidak boleh kosong! Silakan ulangi.");
                            } else {
                                break;
                            }
                        }

                        String penulis = "";
                        while (true) {
                            System.out.print("Masukkan Penulis: ");
                            penulis = scanner.nextLine().trim();
                            if (penulis.isEmpty()) {
                                System.out.println("Penulis tidak boleh kosong! Silakan ulangi.");
                            } else {
                                break;
                            }
                        }

                        perpustakaan.tambahBuku(kode, judul, penulis);
                    }
                    break;

                case "2":
                    System.out.println("\n--- Hapus Buku Terakhir ---");
                    perpustakaan.hapusBukuTerakhir();
                    break;

                case "3":
                    System.out.println("\n--- Cari Buku ---");
                    String cariKode = "";
                    while (true) {
                        System.out.print("Masukkan Kode Buku: ");
                        cariKode = scanner.nextLine().trim();
                        if (cariKode.isEmpty()) {
                            System.out.println("Kode buku tidak boleh kosong! Silakan ulangi.");
                        } else {
                            break;
                        }
                    }
                    Node hasil = perpustakaan.cariBuku(cariKode);

                    if (hasil != null) {
                        System.out.println("Buku Ditemukan!");
                        System.out.println("Kode: " + hasil.kodeBuku + " | Judul: " + hasil.judul + " | Penulis: " + hasil.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case "4":
                    System.out.println("\n--- Daftar Semua Buku ---");
                    perpustakaan.tampilkanSemuaBuku();
                    break;

                case "5":
                    System.out.println("\nTerima kasih telah menggunakan Sistem Data Buku Perpustakaan!");
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
