package LRU;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*



 */

public class RankBasedCache<K, V extends Rank> implements Cache<K, V> {

    Map<K, Node> map;
    Queue<Node<K, V>> pq;
    int totalSize;

    RankBasedCache(int size) {
        this.totalSize = size;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>(new Comparator<Node<K, V>>() {
            @Override
            public int compare(Node<K, V> o1, Node<K, V> o2) {
                return o1.rank - o2.rank;
            }
        });
    }

    @Override
    public V get(K key) {
        if (map.get(key) != null) {
            return (V) map.get(key).val;
        }

        return null;

    }

    @Override
    public void put(K key, V val) {

        Node node = new Node(key, val, val.rank);
        if (map.size() >= totalSize) {
            Node<K, V> poll = pq.poll();
            map.remove(poll.key);
        }
        map.put(key, node);
        pq.add(node);


    }

    @Override
    public Node<K, V> gethead() {
        return null;
    }

    @Override
    public Node<K, V> getTail() {
        return null;
    }
}
