package linkedlist;

/**
 * Class Node merepresentasikan simpul tunggal dalam Single Linked List.
 * Setiap node menyimpan atribut buku serta referensi pointer ke node
 * berikutnya.
 */
public class Node {
    public String kodeBuku;
    public String judul;
    public String penulis;

    public Node next;

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
