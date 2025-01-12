package LRU;

public interface Cache<K, V> {

    public V get(K key);

    public void put(K key, V val);

    default Node<K,V> gethead(){
        return null;
    }

    default Node<K,V> getTail(){
        return null;
    }

}
