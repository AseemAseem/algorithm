package sort;

/**
 * 左右指针不断互相换数据，直至都处于同一个位置
 * 一定是右指针先找数据，否则若左指针先找，极限情况下，第一次查找到的极值就是位于右指针位置，此时再进行mid值的交换会导致排序失败
 * 本地都交换完后，一定要把参考值换到当前指针结束的位置，这里就是中间值要在的位置了。
 *
 */
public class QuickSort extends Sort {
    public QuickSort(int[] arr) {
        super(arr);
    }

    public void sort() {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = arr[begin];
        int l = begin;
        int r = end;
        while (r > l) {
            while (r > l) {
                if (arr[r] < mid) {
                    break;
                } else {
                    r--;
                }
            }

            while (r > l) {
                if (arr[l] > mid) {
                    break;
                } else {
                    l++;
                }
            }
            // 交换
            if (r > l) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            } else {
                // 结束
                break;
            }
        }
        // mid值交换到l的位置
        int temp = arr[begin];
        arr[begin] = arr[l];
        arr[l] = temp;

        // 递归其他位置
        quickSort(arr, begin, l - 1);
        quickSort(arr, l + 1, end);
    }
}
