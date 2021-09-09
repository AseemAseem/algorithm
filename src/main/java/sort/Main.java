package sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 4, 3};
        Sort sort = new SelectorSort(arr);
        sort.print();
    }
}
