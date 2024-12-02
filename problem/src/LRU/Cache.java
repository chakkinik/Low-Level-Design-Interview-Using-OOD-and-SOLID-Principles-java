package LRU;

public interface Cache<K, V> {

    public V get(K key);

    public void put(K key, V val);

    public Node<K,V> gethead();

    public Node<K,V> getTail();

}
