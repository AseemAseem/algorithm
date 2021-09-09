package subject;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * output top 3 element
 */
public class PriorityTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 2};
        int top = 3;

        test(top, arr);
    }

    public static void test(int top, int[] arr) {
        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            while (queue.size() > top) {
                queue.poll();
            }
        }
        System.out.println();
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
