package stackqueue;

/**
 * Class Node merepresentasikan data simpul pelanggan di dalam sistem kasir
 * toko.
 * Node ini digunakan baik pada struktur Queue (antrian berjalan) maupun Stack
 * (riwayat transaksi).
 */
public class Node {
    public String nomorAntrian;
    public String namaPelanggan;
    public double totalBelanja;

    public Node next;

    public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
