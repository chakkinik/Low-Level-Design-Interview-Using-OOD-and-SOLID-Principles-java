package LRU;

import java.util.HashMap;
import java.util.Map;

public class LruCache<K, V> implements Cache<K, V> {

    private final Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;
    private final int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null; // Key not found
        }
        Node<K, V> node = map.get(key);
        moveToHead(node); // Mark as recently used
        return node.val;
    }

    @Override
    public void put(K key, V val) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.val = val; // Update value
            moveToHead(node);
        } else {
            if (map.size() >= capacity) {
                evictTail(); // Evict least recently used item
            }
            Node<K, V> newNode = new Node<>(key, val);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void addToHead(Node<K, V> node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head; // If the list was empty
        }
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // If node is the head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // If node is the tail
        }
    }

    private void evictTail() {
        if (tail == null) return;

        map.remove(tail.key);
        removeNode(tail);
    }

    @Override
    public Node<K, V> gethead() {
        return head;
    }

    @Override
    public Node<K, V> getTail() {
        return tail;
    }
}
