package sort;

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
