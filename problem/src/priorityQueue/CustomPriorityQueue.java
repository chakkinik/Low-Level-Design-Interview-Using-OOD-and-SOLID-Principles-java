package priorityQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.swap;


/*
 Basic principle of staff enginerr
 a) How to product quality enhance
 b) How to product recommendation

 */

public class CustomPriorityQueue implements Queue<Integer> {

    private int index;

    private int parentIndex;

    PriorityNode node;

    List<Integer> heap;

    CustomPriorityQueue(){
        this.heap = new ArrayList<>();
        index=0;
        parentIndex=0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer e) {
        heap.add(e);
        heapify(heap.size()-1);
        return false;
    }

    private void heapify(int index) {
        // what you have to check  min heap.
         // the min val on top

        if(index>0){
            int parentIndex=  index/2;

            if(heap.get(index)< heap.get(parentIndex)){
                swapHeapVal(index,parentIndex);
            }

            heapify(parentIndex);

        }







    }

    private void swapHeapVal(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer remove() {
        return 0;
    }

    @Override
    public Integer poll() {
        return 0;
    }

    @Override
    public Integer element() {
        return 0;
    }

    @Override
    public Integer peek() {
        return heap.get(0);
    }
}
