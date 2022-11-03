package sort;

/**
 * 第一个遍历，存储排好序的值
 * 第二个遍历，执行冒泡动作选出极值
 */
public class BubblingSort extends Sort {

    public BubblingSort(int[] arr) {
        super(arr);
    }

    public void sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
