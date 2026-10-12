package stackqueue;

/**
 * Class Queue mengimplementasikan antrian pelanggan dengan prinsip FIFO (First
 * In, First Out).
 * Operasi Enqueue menyisipkan pelanggan di bagian belakang (rear),
 * dan Dequeue melayani/mengeluarkan pelanggan dari bagian depan (front).
 */
public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    /**
     * Mengeluarkan dan mengembalikan data pelanggan terdepan (Dequeue).
     * 
     * @return Node pelanggan terdepan atau null jika antrian kosong
     */
    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node servedNode = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        servedNode.next = null;
        size--;
        return servedNode;
    }

    /**
     * Menampilkan daftar seluruh pelanggan yang sedang mengantri saat ini (dari
     * depan ke belakang).
     */
    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian saat ini kosong.");
            System.out.println("Total Pelanggan Mengantri: 0");
            return;
        }

        System.out.println("--- DAFTAR ANTRIAN SAAT INI (Depan -> Belakang) ---");
        Node current = front;
        int posisi = 1;
        while (current != null) {
            System.out.printf("%d. [No: %s] Nama: %s | Total Belanja: Rp %,.2f%n",
                    posisi, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            posisi++;
        }
        System.out.println("Total Pelanggan Mengantri: " + size);
    }

    /**
     * Memeriksa apakah antrian kosong
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Mengembalikan jumlah pelanggan yang sedang mengantri
     */
    public int getSize() {
        return size;
    }
}
