package sort;

/**
 * 最后一个父节点：length/2 - 1
 * 左子节点：2*index + 1
 */
public class HeapSort extends Sort {
    public HeapSort(int[] arr) {
        super(arr);
    }

    public void sort() {
        heapSort(arr);
    }

    private void heapSort(int[] arr) {
        // 第一次调整堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length - 1);
        }
        // 循环操作：头节点放后面，调整。
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            adjust(arr, 0, i - 1);
        }
    }

    private void adjust(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        // 最后一个父节点
        int curNode = begin;

        // 与后面节点比较，调整。直到最后一个父节点。
        while (curNode <= (end + 1) / 2 - 1) {
            int l = 2 * curNode + 1;
            int r = l + 1;
            int maxIndex = l;

            if (r <= end && arr[r] > arr[l]) {
                maxIndex = r;
            }

            if (arr[maxIndex] > arr[curNode]) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[curNode];
                arr[curNode] = temp;

                curNode = maxIndex;
            } else {
                break;
            }
        }
    }
}
