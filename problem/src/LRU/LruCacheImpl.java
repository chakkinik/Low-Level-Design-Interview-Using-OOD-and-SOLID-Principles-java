package LRU;


import java.util.HashMap;
import java.util.Map;

/*

 DFS ..

 base /.. 45 45+ 12 =58..
  base ..



while put.

if head is null , create node add to head

if head is not null and tail is null

create node add to head
and make old head as tail

if both not null

then add to head
where you create node as head
head next to old head
old head prev is new head



similary in get

if get is tail
tail prev make it new tail

node which we get add to head.






 */

public class LruCacheImpl<K, V> implements Cache<K, V> {


    Map<K, Node<K, V>> map = new HashMap<>();
    public Node<K, V> head;
    public Node<K, V> tail;
    int size;

    LruCacheImpl(int capacity) {
        this.size = capacity;
    }

    @Override
    public V get(K key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            if(node.equals(tail)){
                removeTail();

            }
            // remove the node and move to head
            addNodeHead(node);
            return (V) node.val;
        }

        return null;
    }

    private void removeTail() {
        //make new tail
        Node temp =   tail.prev;
        temp.next=null;
        tail=temp;
    }


    @Override
    public void put(K key, V val) {
        // if the first element
        // here logic
        Node node = new Node(key, val);

        if (head == null) {

            head = node;


        } else if (head != null && tail == null) {

            addNodeHead(node);
            tail = head.next;
            tail.prev = head;

        } else {
            addNodeHead(node);

        }

        map.put(key, node);


    }


    private void addNodeHead(Node node) {
        Node temp = head;

        node.next = temp;
        temp.prev = node;
        head = node;

    }

    private void removeNode(Node node) {
        if (node == null) return;
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            return;

        }

        prev.next = next;
    }

    @Override
    public Node<K, V> gethead() {
        return this.head;
    }

    @Override
    public Node<K, V> getTail() {
        return this.tail;
    }
}
