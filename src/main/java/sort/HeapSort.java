package sort;

/**
 * 公式：最后一个父节点：length/2 - 1 左子节点：2*index + 1
 * 构造大顶堆时每次调整结束的位置都是length-1的位置
 * 调整时结束位置是范围内最后一个父节点的位置
 * 一定要注意，调整时右子节点不一定会存在
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

    // 从当前节点往下调整
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
