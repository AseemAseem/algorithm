import sort.PriorityQueueSort;
import sort.Sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 3, 2};
        Sort sort = new PriorityQueueSort(arr);
        sort.print();
    }
}
