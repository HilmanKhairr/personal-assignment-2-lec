package stackqueue;

/**
 * Class Stack mengimplementasikan riwayat transaksi menggunakan prinsip LIFO (Last In, First Out).
 * Transaksi pelanggan yang paling baru dilayani akan berada di posisi teratas (Top).
 */
public class Stack {
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Memasukkan data transaksi pelanggan yang baru dilayani ke puncak Stack (Push).
     * @param pelanggan Node data pelanggan yang telah dilayani
     */
    public void push(Node pelanggan) {
        if (pelanggan == null) return;

        pelanggan.next = top;
        top = pelanggan;
        size++;
    }

    /**
     * Mengambil dan menghapus data transaksi teratas dari Stack (Pop).
     * @return Node transaksi teratas atau null jika stack kosong
     */
    public Node pop() {
        if (isEmpty()) {
            return null;
        }

        Node poppedNode = top;
        top = top.next;
        poppedNode.next = null;
        size--;
        return poppedNode;
    }

    /**
     * Menampilkan riwayat seluruh transaksi dari yang paling baru hingga terlama (LIFO).
     */
    public void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("Riwayat transaksi masih kosong.");
            System.out.println("Total Transaksi: 0");
            return;
        }

        System.out.println("--- RIWAYAT TRANSAKSI KASIR (Terbaru -> Lama) ---");
        Node current = top;
        int no = 1;
        double grandTotal = 0;

        while (current != null) {
            System.out.printf("%d. [No: %s] Nama: %s | Total Belanja: Rp %,.2f%n",
                    no, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            grandTotal += current.totalBelanja;
            current = current.next;
            no++;
        }

        System.out.println("Total Transaksi Diselesaikan: " + size);
        System.out.printf("Akumulasi Nilai Transaksi: Rp %,.2f%n", grandTotal);
    }

    /**
     * Memeriksa apakah stack riwayat kosong
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Mengembalikan jumlah transaksi yang telah dicatat
     */
    public int getSize() {
        return size;
    }
}
