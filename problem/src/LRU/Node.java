package LRU;

public class Node<K, V> {

    K key;
    V val;
    Node next;
    Node prev;
    int rank;


    Node(K key, V val) {
        this.key = key;
        this.val = val;
        next = prev = null;
    }

    Node(K key, V val, int rank) {
        this.key = key;
        this.val = val;
        next = prev = null;
        this.rank = rank;
    }


}
