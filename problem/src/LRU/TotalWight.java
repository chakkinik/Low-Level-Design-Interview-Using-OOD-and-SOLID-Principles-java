package LRU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TotalWight {

    public static int take(List<Integer> chocolates, int d) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all chocolates to the max heap
        for (int weight : chocolates) {
            maxHeap.add(weight);
        }

        // Perform d operations
        for (int i = 0; i < d; i++) {
            if (!maxHeap.isEmpty()) {
                // Remove the heaviest chocolate
                int heaviest = maxHeap.poll();
                // Calculate the remaining weight after eating half
                int remainingWeight = heaviest / 2; // floor division
                // Put the remaining weight back into the heap
                if (remainingWeight > 0) {
                    maxHeap.add(remainingWeight);
                }
            }
        }

        // Calculate the sum of the remaining chocolates
        int totalWeight = 0;
        while (!maxHeap.isEmpty()) {
            totalWeight += maxHeap.poll();
        }

        return totalWeight;

    }

    public static void main(String[] args) {

        List<Integer> list =Arrays.asList(30,20,25);


        int take = take(list, 4);
        //
        System.out.println(take);


    }
}
