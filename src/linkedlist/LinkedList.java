package linkedlist;

/**
 * Class LinkedList mengelola sekumpulan Node buku menggunakan struktur Single
 * Linked List.
 * Mendukung operasi tambah data di akhir (append), hapus data terakhir (pop),
 * pencarian buku berdasarkan kode, dan menampilkan seluruh data buku.
 */
public class LinkedList {
    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku == null || kodeBuku.trim().isEmpty()) {
            System.out.println("Gagal: Kode buku tidak boleh kosong!");
            return false;
        }

        if (kodeBuku.trim().length() > 5) {
            System.out.println("Gagal: Kode buku maksimal 5 karakter!");
            return false;
        }

        Node newNode = new Node(kodeBuku.trim(), judul.trim(), penulis.trim());

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        count++;
        System.out.println("Data berhasil ditambahkan!");
        return true;
    }

    /**
     * Menghapus buku terakhir dari daftar (Pop).
     * Jika list kosong, menampilkan pesan "Tidak ada data untuk dihapus."
     */
    public void hapusBukuTerakhir() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            System.out.println("Buku dengan kode '" + head.kodeBuku + "' berhasil dihapus dari daftar!");
            head = null;
            count--;
            return;
        }

        // Jika terdapat lebih dari 1 node, telusuri hingga node kedua terakhir
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        System.out.println("Buku dengan kode '" + current.next.kodeBuku + "' berhasil dihapus dari daftar!");
        // Putus pointer ke node terakhir
        current.next = null;
        count--;
    }

    /**
     * Mencari buku berdasarkan kode buku.
     * 
     * @param kodeBuku Kode buku yang dicari
     * @return Node buku jika ditemukan, null jika tidak ditemukan
     */
    public Node cariBuku(String kodeBuku) {
        if (head == null || kodeBuku == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku.trim())) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Menampilkan seluruh data buku yang tersimpan secara berurutan.
     * Menampilkan total jumlah buku di akhir daftar.
     */
    public void tampilkanSemuaBuku() {
        if (head == null) {
            System.out.println("Daftar Buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: "
                    + current.penulis);
            current = current.next;
            no++;
        }
        System.out.println("Total Buku: " + count);
    }

    /**
     * Mendapatkan jumlah buku saat ini
     */
    public int getCount() {
        return count;
    }

    /**
     * Memeriksa apakah list kosong
     */
    public boolean isEmpty() {
        return head == null;
    }
}
