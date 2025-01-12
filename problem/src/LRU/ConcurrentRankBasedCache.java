package LRU;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class ConcurrentRankBasedCache<K, V extends Rank> implements Cache<K, V> {


    /*



        Concepts
        mulithreading .. get and put
        concurrentQueue
        Concurrent hashmap
        method like putifabsent how it behave with concurrent hashmap.

     */


    Map<K, V> map = new ConcurrentHashMap<>();
    private final PriorityBlockingQueue<Node<K, V>> queue;

    int size;

    ConcurrentRankBasedCache(int size) {
        this.size = size;
        // this is using comparator...

        queue = new PriorityBlockingQueue<>(size, Comparator.comparingInt(o -> o.rank));

    }


    @Override
    public synchronized V get(K key) {
        return map.get(key);
    }

    /*

        a) T1, T2  tried to put the record

     */

    @Override
    public void put(K key, V val) {

        //t1
        if (map.size() < size) {
            map.putIfAbsent(key, val);
            queue.add(new Node<>(key,val, val.rank));
            return;
        }

        synchronized (queue) {
            if (map.putIfAbsent(key, val) == null) {
                Node<K, V> evicted = queue.poll();
                if (evicted != null) {
                    map.remove(evicted.key);
                }
                queue.offer(new Node<>(key, val, val.rank));
            }
        }


    }

    public Node<K,V> gethead(){
        System.out.println(map);
       // System.out.println(queue);
        return null;
    }


}
