package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {

    /*
       a) Why are priorityQueue is used
       b) Build your own PriorityQueue
       c) Why do we required , Why max and min heap , Some Question around prirority Queue
       d) thread safe.


   ComparingNatureOrder.  maintain order in asec order
   ..
   if the two number same if have the insertion
    even if two name in cusom comparator it allow insertion

    work on method heapify.


    kth largest number ..


   post insertion if you see the qs, it will not show the proper


     */


    public static void main(String[] args) {

        // default of pq

        CustomPriorityQueue custom = new CustomPriorityQueue();
        custom.add(12);
        custom.add(11);
        custom.add(13);
        custom.add(9);

        System.out.println(custom.peek());





    }
}
