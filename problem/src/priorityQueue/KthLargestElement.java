package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    int k;
    int[] arr;
    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    KthLargestElement(int[] arr, int k){
        this.k=k;
        for(int e:arr){
            pq.add(e);
        }

    }


    int add(int e){

        return  0;
    }

    public static void main(String[] args) {
        int[] arr={10,9};

       // System.out.println(findKthLargest(arr,3));

    }
}
