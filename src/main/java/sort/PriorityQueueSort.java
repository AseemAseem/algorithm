package sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSort extends Sort{
    public PriorityQueueSort(int[] arr) {
        super(arr);
    }

    public void sort() {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = queue.poll();
        }
    }
}
